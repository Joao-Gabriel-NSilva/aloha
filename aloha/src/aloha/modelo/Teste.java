package aloha.modelo;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class Teste {

	public static void main(String args[]) {
		
		String meuEmail = "joao10x18ii@gmail.com";
		String senha = "k-onj18g180604";
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, senha));
		email.setSSLOnConnect(true);
		
		try {
			email.setFrom(meuEmail);
			email.setSubject("Testando envio de email");
			email.setMsg("Olá, esse é um teste");
			email.addTo("jgabriel10x@gmail.com");
			email.send();
			System.out.println("email enviado!");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
