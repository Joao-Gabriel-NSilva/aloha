package aloha.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String primeiroNome;
	private String sobrenome;
	private String telefone;
	private String email;
	private String senha;
	private List<String> gostos = new ArrayList<>();

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		primeiroNome = primeiroNome.trim();
		
		if(primeiroNome.equals("Primeiro nome") | primeiroNome.isEmpty()) {
			throw new RuntimeException("Informe seu nome!");
		} 
		
		verificaNumeroNoNome(primeiroNome);
		verificaCaracterEspecial(primeiroNome);
		
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		sobrenome = sobrenome.trim();
		
		if(sobrenome.equals("Sobrenome") | sobrenome.isEmpty()) {
			throw new RuntimeException("Informe seu sobrenome!");
		} 
		
		verificaNumeroNoNome(sobrenome);
		verificaCaracterEspecial(sobrenome);
		
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		telefone = telefone.trim();
		
		if(telefone.isEmpty()) {
			throw new RuntimeException("Informe se telefone!");
		} else if(telefone.length() < 11 | telefone.length() > 11 ) {
			throw new RuntimeException("Número inválido!");
		}
		verificaCaracterEspecial(telefone);
		
		for (String i : telefone.split("")) {
			try {
				Integer.parseInt(i);
			} catch (NumberFormatException ex) {
				throw new RuntimeException("Não coloque letras no telefone!");
			}
		}
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		email = email.trim();
		String dominio = email.substring(email.indexOf("@"));
		
		if(email.isEmpty()) {
			throw new RuntimeException("Informe seu email!");
		} else if(dominio.equals("@gmail.com") | dominio.equals("@hotmail.com") | dominio.equals("@outlook.com") |
				dominio.equals("@yahoo.com")) {
			
		}
		
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public boolean setSenha(String senha, String senhaConfirmacao) {
		senha = senha.trim();
		senhaConfirmacao = senhaConfirmacao.trim();
		
		if(senha.isEmpty()) {
			throw new RuntimeException("Crie uma senha!");
		} else if(senha.length() < 8) {
			throw new RuntimeException("A senha deve ter pelo menos 8 digitos!");
		} else if(senhaConfirmacao.isEmpty()) {
			throw new RuntimeException("Confirme a senha!");
		} else if (!(senha.equals(senhaConfirmacao))) {
			throw new RuntimeException("Senha de confirmação incorreta!");
		}
		
		this.senha = senha;
		return true;
	}
	
	public List<String> getGostos() {
		return gostos;
	}

	private void verificaNumeroNoNome(String string) {
		for (String i : string.split("")) {
			try {
				Integer.parseInt(i);
				throw new RuntimeException("Não coloque números no nome!");
			} catch (NumberFormatException ex) {
			}
		}
	}

	private void verificaCaracterEspecial(String stringNome) {
		String caracteresEspeciais = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		for (int i = 0; i < stringNome.length(); i++) {
			char ch = stringNome.charAt(i);
			if (caracteresEspeciais.contains(Character.toString(ch))) {
				throw new RuntimeException("Não coloque caracteres especiais!");
			} 
		}
	}

}
