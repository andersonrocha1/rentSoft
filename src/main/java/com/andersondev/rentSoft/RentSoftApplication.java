package com.andersondev.rentSoft;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.andersondev.rentSoft.model.LocatarioModel;
import com.andersondev.rentSoft.model.ImovelModel;
import com.andersondev.rentSoft.enums.TipoConta;
import com.andersondev.rentSoft.model.ContratoAluguel;
import com.andersondev.rentSoft.model.Conta;
import com.andersondev.rentSoft.repositories.ContratoAluguelRepository;
import com.andersondev.rentSoft.repositories.LocatarioRepository;



@SpringBootApplication
public class RentSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentSoftApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner initDatabase(LocatarioRepository locatarioRepository, ContratoAluguelRepository contratoRepsository) {
		return args -> {
			
			locatarioRepository.deleteAll();
			
			LocatarioModel locatario = new LocatarioModel();
			
			locatario.setNome(" Brasil Lima");
			locatario.setCpf("44444444444444");
			
			LocatarioModel locatario1 = new LocatarioModel();
			
			locatario1.setNome("Valéria Machado");
			locatario1.setCpf("999999999999999999");
			
			ImovelModel imovel = new ImovelModel();
			
			imovel.setNome("RESIDENCIA 01");
			imovel.setEndereco("RUA: BRASIL, 541, VITÓRIA/ES");
			imovel.setNumeroQuartos(3);
			imovel.setPrecoAluguel(BigDecimal.valueOf(350,00));
			imovel.setLocatarioAluga(locatario);
			
			
			ImovelModel imovel1 = new ImovelModel();
			
			imovel1.setNome("RESIDENCIA 02");
			imovel1.setEndereco("RUA: DIVINÓPOLIS, 51, VILA VELHA/ES");
			imovel1.setNumeroQuartos(5);
			imovel1.setPrecoAluguel(BigDecimal.valueOf(450,00));
			imovel1.setLocatarioAluga(locatario1);
	
			
			locatario.getImoveis().add(imovel);
			locatario1.getImoveis().add(imovel1);

			
			Conta conta = new Conta();
	
			conta.setTipoConta(TipoConta.AGUA);
			conta.setDataVencimento(LocalDate.of(2023, 7, 15));
			conta.setValor(BigDecimal.valueOf(40,00));
			conta.setLocatario(locatario);
			
			Conta conta1 = new Conta();
			
			conta1.setTipoConta(TipoConta.ENERGIA);
			conta1.setDataVencimento(LocalDate.of(2023, 7, 10));
			conta1.setValor(BigDecimal.valueOf(120,00));
			conta1.setLocatario(locatario);

			
			locatario.getContas().add(conta);
			locatario.getContas().add(conta1);
			
		
			locatarioRepository.saveAll(Arrays.asList(locatario, locatario1));
			
			
			ContratoAluguel contrato = new ContratoAluguel();
			contrato.setDataInicio(LocalDate.now());
			contrato.setDataFinal(LocalDate.of(2024, 11, 9));
			contrato.setImovel(imovel);
			contrato.setLocatarioContrata(locatario);
			contrato.setDeposito(BigDecimal.valueOf(350.00));
			contrato.setValorMensal(BigDecimal.valueOf(350.00));
			
		
			ContratoAluguel contrato1 = new ContratoAluguel();
			contrato1.setDataInicio(LocalDate.now());
			contrato1.setDataFinal(LocalDate.of(2024, 11, 9));
			contrato1.setImovel(imovel1);
			contrato1.setLocatarioContrata(locatario1);
			contrato1.setDeposito(BigDecimal.valueOf(450.00));
			contrato1.setValorMensal(BigDecimal.valueOf(450.00));
		
			contratoRepsository.saveAll(Arrays.asList(contrato, contrato1));
			
		
			
			
			
		};
	}

}
