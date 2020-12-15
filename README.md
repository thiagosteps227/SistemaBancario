# SistemaBancario
Desafio Sistema Bancario 

src / sb.controller >>> CadastroServlet.java

src / sb.model >>> Conta.java, 
                   ContaDAO.java, 
                   ContaTest.java,
                   Usuario.java,
                   UsuarioDAO.java,
                   UsuarioTest.java
                   
WebContent / lib >>> jsp-api-2.2.jar
                     jstl-1.2.jar
                     mysql-connector-java-8.0.13.jar
                     servlet-api-2.5.jar
                     
WebContent >>> index.jsp,
               CadastroPronto.jsp,
               ListarContas.jsp,
               ListarUsuarios.jsp


Tabelas criadas no MySQL:

CREATE TABLE usuario ( nome VARCHAR(40),
					          tipoPessoa VARCHAR (10),
                    numDoc VARCHAR (14),
                    score VARCHAR(2),
                    PRIMARY KEY (numDoc));
                    
CREATE TABLE conta ( numero VARCHAR(10), agencia VARCHAR(10), tipoConta VARCHAR(20), limite VARCHAR (10),
		                 cartao VARCHAR(10),
		                 nomeTitular VARCHAR(40));
