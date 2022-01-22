package aloha.modelo;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String args[]) throws FileNotFoundException {

//		Usuario usuario = new Usuario();
//		
//		String dataFormatada = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//		DateFormat df = DateFormat.getInstance();
//		
//		usuario.setApelido("Jaum");
//		usuario.setArrouba("@jgabriel10x");
//		usuario.setNome("João Gabriel Nascimento");
//		usuario.setDataDeNascimento(new Date());
//		usuario.setEmail("jgabriel10x@gmail.com");
//		usuario.setTelefone("11123456789");
//		usuario.setSenha("12345678", "12345678");
//		usuario.getGostos().add("Refrigerante");
//		usuario.getGostos().add("Rock");
//		usuario.getGostos().add("Espetinho");
		
		//Usuario.salvaCadastro(usuario);


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aloha");
		EntityManager em = emf.createEntityManager();
		
		Usuario a = em.find(Usuario.class, "@jgabriel10x");
		System.out.println(a);
		
//		em.getTransaction().begin();
//		em.persist(usuario);
//		em.getTransaction().commit();
//		System.out.println("Pronto");
		em.close();
		emf.close();
	}
}






