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

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

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

		verificaNumeroNoNome(nome);
		verificaCaracterEspecial(nome);

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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		apelido = apelido.trim();

		if (apelido.equals("Apelido") | apelido.isEmpty()) {
			throw new RuntimeException("Informe seu apelido!");
		}

		verificaNumeroNoNome(apelido);
		verificaCaracterEspecial(apelido);

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

	private void verificaNumeroNoNome(String string) {
		for (String i : string.split("")) {
			try {
				Integer.parseInt(i);
				throw new RuntimeException("Não coloque números!");
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
				saida.println(usuario.getArrouba() + ";" + usuario.getSenha() + ";" + usuario.getEmail() + ";"
						+ usuario.getApelido() + ";" + usuario.getNome() + ";" + usuario.getTelefone() + ";" + gostos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Usuario fazLogin(String arrouba, String senha) throws FileNotFoundException {
		Map<String, String> listaLogins = new HashMap<>();
		Map<String, Usuario> usuarios = new HashMap<>();

		Scanner scanner = new Scanner(new File("dados/cadastros.csv"), "UTF-8");

		while (scanner.hasNext()) {
			String linha = scanner.nextLine();
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useDelimiter(";");

			String arroubaCadastrado = linhaScanner.next();
			String senhaCadastrado = linhaScanner.next();
			String emailCadastrado = linhaScanner.next();
			String apelidoCadastrado = linhaScanner.next();
			String nomeCadastro = linhaScanner.next();
			String telefoneCadastro = linhaScanner.next();
			String gostosCadastro = linhaScanner.next();

			listaLogins.put(arroubaCadastrado, senhaCadastrado);
			usuarios.put(arroubaCadastrado, new Usuario(nomeCadastro, telefoneCadastro, emailCadastrado,
					senhaCadastrado, gostosCadastro, apelidoCadastrado, arroubaCadastrado));
			linhaScanner.close();

		}
		scanner.close();

		if (listaLogins.containsKey(arrouba) & listaLogins.get(arrouba).equals(senha)) {
			return usuarios.get(arrouba);
		} else {
			throw new RuntimeException("Email ou senha incorreto!");
		}
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", apelido=" + apelido + ", arrouba=" + arrouba + ", telefone=" + telefone
				+ ", email=" + email + ", senha=" + senha + ", gostos=" + gostos + "]";
	}

}
