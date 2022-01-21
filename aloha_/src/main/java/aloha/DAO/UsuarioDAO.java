package aloha.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import aloha.modelo.Usuario;

public class UsuarioDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aloha");
	
	public static EntityManager criaEntityManager() {
		return emf.createEntityManager();
	}
	
	public static Usuario fazLogin(String arrouba, String senha) {
		EntityManager em = criaEntityManager();
		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, arrouba);
		if(usuario.getSenha().equals(senha)) {
			return usuario;
		} else {
			throw new RuntimeException("Nome de usuário ou senha incorreta!");
		}
	}
}
