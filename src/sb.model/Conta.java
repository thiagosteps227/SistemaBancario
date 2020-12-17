package sb.model;

public class Conta {
	
	private String numero;
	private String agencia;
	private String tipoConta;
	private String nomeTitular;
	private String limite;
	private String cartao;
	
	
	public Conta() {
		
	}
	public Conta(String numero, String agencia, String tipoConta, String limite, String cartao, String nomeTitular) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipoConta = tipoConta;
		this.limite = limite;
		this.cartao = cartao;
		this.nomeTitular = nomeTitular;
	}
	

	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public String getLimite() {
		return limite;
	}
	public void setLimite(String limite) {
		this.limite = limite;
	}
	
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	

}
