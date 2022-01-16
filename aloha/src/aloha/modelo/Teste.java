package aloha.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Teste {

	public static void main(String args[]) throws FileNotFoundException {

//		Usuario usuario = new Usuario();
//		
//		usuario.setPrimeiroNome("João");
//		usuario.setSobrenome("Silva");
//		usuario.setEmail("jgabriel10x@gmail.com");
//		usuario.setTelefone("11123456789");
//		usuario.setSenha("12345678", "12345678");
//		usuario.getGostos().add("Refrigerante");
//		usuario.getGostos().add("Rock");
//		usuario.getGostos().add("Espetinho");
//		
//		Usuario.salvaCadastro(usuario);

		Map<String, String> listaLogins = new HashMap<>();
		Map<String, Usuario> usuarios = new HashMap<>();

		Scanner scanner = new Scanner(new File("dados/cadastros.csv"), "UTF-8");

		while (scanner.hasNextLine()) {
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
		System.out.println(usuarios.get("jgabriel10x@gmail.com").getGostos());
		System.out.println(listaLogins);

	}
}
