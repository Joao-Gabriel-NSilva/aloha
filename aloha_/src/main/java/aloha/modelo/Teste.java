package aloha.modelo;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String args[]) throws FileNotFoundException {

//		Usuario usuario = new Usuario();
//		
//		usuario.setNome("João Gabriel Nascimento");
//		usuario.setApelido("Jaum");
//		usuario.setArrouba("@jgabriel10x");
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
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
		
//		em.getTransaction().begin();
//		em.persist(usuario);
//		em.getTransaction().commit();
		System.out.println("Pronto");
		em.close();
		emf.close();
	}
}






