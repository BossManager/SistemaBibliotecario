package DAO.entidades;

public class Funcionario extends Leitor{
	
	private String login;
	private String senha;
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}
	
}
