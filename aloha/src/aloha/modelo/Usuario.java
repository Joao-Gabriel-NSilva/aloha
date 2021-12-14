package aloha.modelo;

public class Usuario {

	private String PrimeiroNome;
	private String sobrenome;
	private String telefone;
	private String email;
	private String senha;

	public String getPrimeiroNome() {
		return PrimeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		PrimeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
