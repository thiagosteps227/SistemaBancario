package sb.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sb.model.Usuario;
import sb.model.*;


@WebServlet("/register")
public class CadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDao;
    private ContaDAO contaDao;
    

    public void init() {
        usuarioDao = new UsuarioDAO();
        contaDao = new ContaDAO();
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	String nome = request.getParameter("nome");
		String tipoPessoa = request.getParameter("tipoPessoa").toUpperCase();
		String numDoc = request.getParameter("numDoc");
		String score = request.getParameter("score");
		String agencia = request.getParameter("agencia");

		//instanciando usuário e conta
		Usuario usuario = new Usuario(nome, tipoPessoa, numDoc, score);
        Conta conta = new Conta();
		
		
		String limite = "";
		String cartao = "";
		
		//estabelecendo número randômico de conta
		Random gerador = new Random();
		int random = 0 ;
		for (int i = 0; i<5; i++) {
			   random = (int) (gerador.nextDouble() * 1000000);
			 
		}
		String numero = String.valueOf(random);	
		conta.setNumero(numero);
		
			
		//estabelecendo conta corrente ou empresaral de acordo com PF ou PJ 
		if (tipoPessoa.equals("PF")) {
			conta.setTipoConta("Corrente");
		} else {
			conta.setTipoConta("Empresarial");
		}
		//estabelecendo limites de conta e cartão com parametrização do score
		int numScore = Integer.parseInt(score);
		
		if (numScore == 0 || numScore == 1) {
			limite = "desabilitado";
			
    		}else if (numScore >= 2  && numScore <= 5) {
    			limite = "1000";
    			cartao = "200";
    		} else if (numScore >= 6 && numScore <= 8) {
    			limite = "2000";
    			cartao = "2000";
			} else if (numScore == 9 ) {
				limite = "5000";
				cartao = "15000";
		}
		
		conta.setLimite(limite);
		conta.setCartao(cartao);
		conta.setAgencia(agencia);
		
		conta.setNomeTitular(usuario.getNome());
		
		//registrando conta no banco de dados
		try {
			contaDao.registerConta(conta);
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		//registrando usuario no banco de dados
        try {
            usuarioDao.registerUsuario(usuario);
            
        } catch (Exception e) {
           
            e.printStackTrace();
        }   
        
        //JSP com mensagem de cadastro realizado
        response.sendRedirect("CadastroPronto.jsp");
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		//parâmetro identificador do GET que está sendo chamado no index.
    		String type = request.getParameter("formType");
    		
    		if (type.equals("conta")) {
    			try {
    				
    				listConta(request, response);
    				
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		} else {	
    		try {
    			
    			listUser(request, response);
    			
    		} catch (Exception e) {
   				
   				e.printStackTrace();
   			}
    			
   		}
    		
    		
    		
    		
    }
    	        
    private void listUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    
            	List < Usuario > listUser = usuarioDao.selectAllUsers();
            	
            	request.setAttribute("listUser", listUser);
            	RequestDispatcher dispatcher = request.getRequestDispatcher("ListarUsuarios.jsp");
            	dispatcher.forward(request, response);
            	
    			}
    	        
    private void listConta(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        
    	List < Conta > listConta = contaDao.selectAllContas();
    	
    	request.setAttribute("listConta", listConta);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("ListarContas.jsp");
    	dispatcher.forward(request, response);
    	
		}
}