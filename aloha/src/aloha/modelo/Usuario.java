package aloha.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Usuario {

	private String primeiroNome;
	private String sobrenome;
	private String telefone;
	private String email;
	private String senha;
	private List<String> gostos = new ArrayList<>();

	public Usuario() {

	}

	public Usuario(String primeiroNome, String sobrenome, String telefone, String email, String senha, String gostos) {
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;

		if (!gostos.isEmpty()) {
			for (String a : gostos.split(",")) {
				this.gostos.add(a);
			}
		}
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		primeiroNome = primeiroNome.trim();

		if (primeiroNome.equals("Primeiro nome") | primeiroNome.isEmpty()) {
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

		if (sobrenome.equals("Sobrenome") | sobrenome.isEmpty()) {
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

		if (telefone.isEmpty()) {
			throw new RuntimeException("Informe se telefone!");
		} else if (telefone.length() < 11 | telefone.length() > 11) {
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

	public static void salvaCadastro(Usuario usuario) {
		String gostos = "";
		if (!usuario.getGostos().isEmpty()) {
			for (int i = 0; i < usuario.getGostos().size(); i++) {
				if (gostos.isEmpty()) {
					gostos = gostos + usuario.getGostos().get(i);
				} else {
					gostos = gostos + "," + usuario.getGostos().get(i);
				}
			}
		} else {
			gostos = "";
		}

		try (FileWriter writer = new FileWriter("dados/cadastros.csv", true)) {
			try (PrintWriter saida = new PrintWriter(writer, true)) {
				saida.println(usuario.getEmail() + ";" + usuario.getSenha() + ";" + usuario.getPrimeiroNome() + ";"
						+ usuario.getSobrenome() + ";" + usuario.getTelefone() + ";" + gostos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Usuario fazLogin(String email, String senha) throws FileNotFoundException {
		Map<String, String> listaLogins = new HashMap<>();
		Map<String, Usuario> usuarios = new HashMap<>();

		Scanner scanner = new Scanner(new File("dados/cadastros.csv"), "UTF-8");

		while (scanner.hasNext()) {
			String linha = scanner.nextLine();
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useDelimiter(";");

			String emailCadastro = linhaScanner.next();
			String senhaCadastro = linhaScanner.next();
			String nomeCadastro = linhaScanner.next();
			String sobrenomeCadastro = linhaScanner.next();
			String telefoneCadastro = linhaScanner.next();
			String gostosCadastro = linhaScanner.next();

			listaLogins.put(emailCadastro, senhaCadastro);
			usuarios.put(emailCadastro, new Usuario(nomeCadastro, sobrenomeCadastro, telefoneCadastro, emailCadastro,
					senhaCadastro, gostosCadastro));
			linhaScanner.close();

		}
		scanner.close();

		if (listaLogins.containsKey(email) & listaLogins.get(email).equals(senha)) {
			return usuarios.get(email);
		} else {
			throw new RuntimeException("Email ou senha incorreto!");
		}
	}

}
