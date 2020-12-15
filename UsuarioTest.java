package sb.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	Usuario usuario;
	
	@BeforeEach 
	public void setUp() {
		usuario = new Usuario("usuario","PF","123456789","1" );
	}
	
	@Test
	void testUsuarioConstructor() {
		assertEquals("usuario", usuario.getNome());
		assertEquals("PF", usuario.getTipoPessoa());
		assertEquals("123456789", usuario.getNumDoc());
		assertEquals("1", usuario.getScore());
		
	}
	
	@Test
	void testTrocadeNome() {
		usuario.setNome("outrousuario");
		assertEquals("outrousuario", usuario.getNome());
		
	}
	
	@Test
	void testTrocaTipoPessoa() {
		usuario.setTipo_pessoa("PJ");
		assertEquals("PJ", usuario.getTipoPessoa());
		
	}
	
	@Test
	void testTrocaNumDocumento() {
		usuario.setNumDoc("987654321");
		assertEquals("987654321", usuario.getNumDoc());
		
	}
	
	@Test
	void testTrocadeScore() {
		usuario.setScore("2");
		assertEquals("2", usuario.getScore());
		
	}
	
	

}
