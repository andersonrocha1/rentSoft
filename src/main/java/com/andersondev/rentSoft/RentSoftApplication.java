package com.andersondev.rentSoft;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.andersondev.rentSoft.model.LocatarioModel;
import com.andersondev.rentSoft.model.ImovelModel;
import com.andersondev.rentSoft.enums.TipoConta;
import com.andersondev.rentSoft.model.Conta;
import com.andersondev.rentSoft.repositories.LocatarioRepository;



@SpringBootApplication
public class RentSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentSoftApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner initDatabase(LocatarioRepository locatarioRepository) {
		return args -> {
			
			locatarioRepository.deleteAll();
			
			LocatarioModel locatario = new LocatarioModel();
			
			locatario.setNome("Arthur Costa");
			locatario.setCpf("44444444444444");
			
			ImovelModel imovel = new ImovelModel();
			
			imovel.setNome("RESIDENCIA 01");
			imovel.setEndereco("fRANCISCA PAULA BONADIMAN, 391, SANTA BÁRBARA");
			imovel.setNumeroQuartos(3);
			imovel.setPrecoAluguel(BigDecimal.valueOf(350,00));
			imovel.setLocatarioAluga(locatario);
			
			locatario.getImoveis().add(imovel);
			
			Conta conta = new Conta();
	
			conta.setTipoConta(TipoConta.AGUA);
			conta.setDataVencimento(LocalDate.of(2023, 7, 15));
			conta.setValor(BigDecimal.valueOf(40,00));
			conta.setLocatario(locatario);
			locatario.getContas().add(conta);
			
			
			locatarioRepository.save(locatario);
			
		};
	}

}
