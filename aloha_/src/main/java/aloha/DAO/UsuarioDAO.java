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
		Usuario usuario = em.find(Usuario.class, arrouba);
		if(usuario == null) {
			em.close();
			throw new RuntimeException("Nome de usuário ou senha incorreta!");
		}
		if(usuario.getSenha().equals(senha)) {
			em.close();
			return usuario;
		} else {
			em.close();
			throw new RuntimeException("Nome de usuário ou senha incorreta!");
		}
	}
	
	public static Usuario achaUsuario(String nomeDeUsuario) {
		EntityManager em = criaEntityManager();
		return em.find(Usuario.class, nomeDeUsuario);
	}
}
