package aloha.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import aloha.views.cadastro.CrieASenha;

@Entity
public class Usuario {

	private String nome;
	private String apelido;
	@Id
	private String arrouba;
	private String telefone;
	private String email;
	private String senha;
	@ElementCollection
	private List<String> gostos = new ArrayList<>();
	private Date dataDeNascimento;

	public Usuario() {

	}

	public Usuario(String nome, String telefone, String email, String senha, String gostos, String apelido,
			String arrouba) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.apelido = apelido;
		this.arrouba = arrouba;

		if (!gostos.isEmpty()) {
			for (String a : gostos.split(",")) {
				this.gostos.add(a);
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		nome = nome.trim();

		if (nome.equals("Primeiro nome") | nome.isEmpty()) {
			throw new RuntimeException("Informe seu nome!");
		}

		verificaSeHaNumero(nome);
		verificaSeHaCaracterEspecial(nome);

		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		telefone = telefone.trim();

		if (telefone.isEmpty()) {
			throw new RuntimeException("Informe se telefone!");
		} else if (telefone.length() < 11 | telefone.length() > 11) {
			throw new RuntimeException("Número inválido!");
		}
		verificaSeHaCaracterEspecial(telefone);

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

		if (email.isEmpty()) {
			throw new RuntimeException("Informe seu email!");
		} else if (dominio.equals("@gmail.com") | dominio.equals("@hotmail.com") | dominio.equals("@outlook.com")
				| dominio.equals("@yahoo.com")) {

		}

		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public boolean setSenha(String senha, String senhaConfirmacao) {
		senha = senha.trim();
		senhaConfirmacao = senhaConfirmacao.trim();

		if (senha.isEmpty()) {
			throw new RuntimeException("Crie uma senha!");
		} else if (senha.length() < 8) {
			throw new RuntimeException("A senha deve ter pelo menos 8 digitos!");
		} else if (senhaConfirmacao.isEmpty()) {
			throw new RuntimeException("Confirme a senha!");
		} else if (!(senha.equals(senhaConfirmacao))) {
			throw new RuntimeException("Senha de confirmação incorreta!");
		}

		this.senha = senha;
		return true;
	}

	public boolean setSenha(String senha) {
		boolean maiuscula = false;
		boolean minuscula = false;
		boolean numero = false;
		
		if (verificaSeHaMaiuscula(senha)) {
			CrieASenha.setLblMaiusculaIcone(true);
			maiuscula = true;
		} else {
			CrieASenha.setLblMaiusculaIcone(false);
		}
		
		if (verificaSeHaMinuscula(senha)) {
			CrieASenha.setLblMinusculaIcone(true);
			minuscula = true;
		} else {
			CrieASenha.setLblMinusculaIcone(false);
		}
		
		if (verificaSeHaNumero(senha)) {
			CrieASenha.setLblNumeroIcone(true);
			numero = true;
		} else {
			CrieASenha.setLblNumeroIcone(false);
		}
		
		if(maiuscula & minuscula & numero) {
			return true;
		}
		
		return false;
	}

	public List<String> getGostos() {
		return gostos;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		apelido = apelido.trim();

		if (apelido.equals("Apelido") | apelido.isEmpty()) {
			throw new RuntimeException("Informe seu apelido!");
		}

		if (verificaSeHaNumero(apelido)) {
			throw new RuntimeException("Não coloque números!");
		} else if (verificaSeHaCaracterEspecial(apelido)) {
			throw new RuntimeException("Não coloque caracteres especiais!");
		}

		this.apelido = apelido;
	}

	public String getArrouba() {
		return arrouba;
	}

	public void setArrouba(String arrouba) {
		if (arrouba.equals("@") | arrouba.isEmpty()) {
			throw new RuntimeException("Informe seu nome de usuário!");
		}

		this.arrouba = (arrouba.startsWith("@") ? arrouba : "@" + arrouba);
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	private boolean verificaSeHaNumero(String string) {
		if(string.isEmpty()) {
			return false;
		} else {
			for (String i : string.split("")) {
				try {
					Integer.parseInt(i);
					return true;
				} catch (NumberFormatException ex) {
				}
			}
		}
		return false;
	}
	
	private boolean verificaSeHaMinuscula(String senha) {
		if(senha.isEmpty()) {
			return false;
		} else {
			for (String i : senha.split("")) {
				if(!verificaSeHaNumero(i) & i.equals(i.toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean verificaSeHaMaiuscula(String senha) {
		if(senha.isEmpty()) {
			return false;
		} else {
			for (String i : senha.split("")) {
				if(!verificaSeHaNumero(i) & i.equals(i.toUpperCase())) {
					return true;
				}
			}
			
		}
		return false;
	}

	private boolean verificaSeHaCaracterEspecial(String string) {
		String caracteresEspeciais = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (caracteresEspeciais.contains(Character.toString(ch))) {
				return true;

			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", apelido=" + apelido + ", arrouba=" + arrouba + ", telefone=" + telefone
				+ ", email=" + email + ", senha=" + senha + ", gostos=" + gostos + ", dataDeNascimento="
				+ dataDeNascimento + "]";
	}
}
