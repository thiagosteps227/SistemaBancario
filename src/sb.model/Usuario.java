package sb.model;

import java.io.Serializable;

public class Usuario implements Serializable{
  
	private static final long serialVersionUID = 1L;
    private String nome;
    private String tipoPessoa;
    private String numDoc;
    private String score;
    
    public Usuario(String nome, String tipoPessoa, String numDoc, String score) {
    	this.nome = nome;
    	this.tipoPessoa = tipoPessoa;
    	this.numDoc = numDoc;
    	this.score = score;
    }
    
        
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipoPessoa() {
        return tipoPessoa;
    }
    public void setTipo_pessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;

    }
    public String getNumDoc() {
        return numDoc;
    }
    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    } 
     
    public String getScore() { 
        return score;
    } 
    public void setScore(String string) { 
        this.score = string;
    } 

}
