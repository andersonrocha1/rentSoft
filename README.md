# Criando o Back-End de um gerenciador de aluguéis

## Índice
- <a href="#introducao">Resumo do Projeto</a>
- <a href="#tecnologiasutilizadas">Tecnologias Utilizadas</a>
- <a href="#bancosutilizados">Banco de Dados</a>
- <a href="#padroesutilizados">Padrões do Projeto</a>
- <a href="#contatos">Contatos</a>


##   Resumo do Projeto
   

   
    
    O sistema Rest de gestão de aluguéis é uma solução completa e eficiente para gerenciar o processo de aluguel de imóveis. Ele foi desenvolvido com a divisão em camadas e a utilização de padrões como o Mapper e DTO, visando garantir a organização, a manutenibilidade e a escalabilidade do sistema.

    A arquitetura em camadas permite separar as responsabilidades do sistema em diferentes níveis, facilitando o desenvolvimento e a evolução do código. As camadas geralmente incluem a camada de apresentação, a camada de negócios e a camada de acesso a dados. No caso do sistema de gestão de aluguéis, podemos ter uma camada de controle que recebe as requisições dos clientes, uma camada de serviços que implementa a lógica de negócios e uma camada de acesso a dados que interage com o banco de dados.

    Além disso, o padrão Mapper é utilizado para mapear objetos de domínio para objetos de transferência de dados (DTO) e vice-versa. Isso ajuda a separar as preocupações entre a lógica de negócios e a comunicação com o banco de dados. O Mapper realiza a conversão dos dados entre os diferentes formatos, permitindo uma maior flexibilidade e facilidade na manipulação dos dados.

    O uso de DTOs também contribui para a padronização e a segurança do sistema. Os DTOs são objetos que encapsulam os dados que serão enviados ou recebidos pela camada de apresentação. Eles evitam a exposição direta dos objetos de domínio, permitindo um controle mais preciso sobre quais informações são acessíveis externamente. Além disso, os DTOs podem ser utilizados para definir contratos de comunicação, facilitando a integração com outros sistemas e serviços.

    Em resumo, o sistema Rest de gestão de aluguéis, com sua divisão em camadas e a utilização dos padrões Mapper e DTO, oferece uma solução robusta e padronizada para o gerenciamento de aluguéis. Essas abordagens contribuem para a organização do código, a manutenibilidade do sistema e a segurança das informações.
    
    
  

##   Tecnologias Utilizadas

  - [x] Java
  - [x] SQL
  - [x] Spring Boot

## Banco de Dados

  - [x] Banco de dados H2 - Testes
  - [x] Banco de dados Postgres  


## Padrões do projeto

- API REST

    ### Padrão Rest

        • Cliente/servidor com HTTP 
        • Interface uniforme, formato padronizado (*)
        • Cache
        • Sistema em camadas

    ### Padronização

        GET https://meusistema.com/produtos
        GET https://meusistema.com/produtos/5
        POST https://meusistema.com/produtos         
        { ... }
        PUT https://meusistema.com/produtos/5
        { ... }
        DELETE https://meusistema.com/produtos/5    

## Padrão Camadas

![Camadas](https://user-images.githubusercontent.com/23089093/239023317-bf27fd4c-82b4-4a77-887d-3e88dd0d1511.png)






## Contatos

* Links    
<a href= "https://www.linkedin.com/in/anderson-rocha-228231222/">Linkedin : Anderson</a>


