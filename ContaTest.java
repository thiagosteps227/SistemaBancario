package sb.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ContaTest {
	Conta conta;
	
	@BeforeEach 
	public void setUp() {
		conta = new Conta("123456","1234","Corrente","1000","1000","titular" );
	}
	
	@Test
	void testContaConstructor() {
		assertEquals("123456", conta.getNumero());
		assertEquals("1234", conta.getAgencia());
		assertEquals("Corrente", conta.getTipoConta());
		assertEquals("1000", conta.getLimite());
		assertEquals("1000", conta.getCartao());
		assertEquals("titular", conta.getNomeTitular());
	}
	
	@Test
	void testTrocadeNumero() {
		conta.setNumero("654321");
		assertEquals("654321", conta.getNumero());
		
	}
	
	@Test
	void testTrocadeAgencia() {
		conta.setAgencia("4321");
		assertEquals("4321", conta.getAgencia());
		
	}
	
	@Test
	void testTrocaTipoConta() {
		conta.setTipoConta("Empresarial");
		assertEquals("Empresarial", conta.getTipoConta());
		
	}
	
	@Test
	void testTrocadeLimite() {
		conta.setLimite("2000");
		assertEquals("2000", conta.getLimite());
		
	}
	
	@Test
	void testTrocaLimiteCartao() {
		conta.setCartao("3000");
		assertEquals("3000", conta.getCartao());
		
	}
	
	@Test
	void testTrocadeNomeTitular() {
		conta.setNomeTitular("outrotitular");
		assertEquals("outrotitular", conta.getNomeTitular());
		
	}

}
