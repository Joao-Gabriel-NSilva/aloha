package aloha.DAO;

import java.util.List;

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
		if (usuario == null) {
			em.close();
			throw new RuntimeException("Nome de usuário ou senha incorreta!");
		}
		if (usuario.getSenha().equals(senha)) {
			em.close();
			return usuario;
		} else {
			em.close();
			throw new RuntimeException("Nome de usuário ou senha incorreta!");
		}
	}
	
	public static void cadastra(Usuario usuario) {
		EntityManager em = criaEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void salvaAlteracoes(Usuario usuario) {
		EntityManager em = criaEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}

	public static Usuario achaUsuarioPorPK(String nomeDeUsuario) {
		EntityManager em = criaEntityManager();
		Usuario usuario = em.find(Usuario.class, nomeDeUsuario);
		em.close();
		return usuario;
	}

	public static Usuario achaUsuarioPorEmail(String email) throws IndexOutOfBoundsException {
		EntityManager em = criaEntityManager();

		Usuario usuario = (Usuario) em
				.createNativeQuery("SELECT * " + "FROM usuario user " + "WHERE user.email = ?;", Usuario.class)
				.setParameter(1, email).getResultList().get(0);

		em.close();
		return usuario;
	}

	public static Usuario achaUsuarioPorTelefone(String telefone) {
		EntityManager em = criaEntityManager();

		Usuario usuario = (Usuario) em
				.createNativeQuery("SELECT * " + "FROM usuario user " + "WHERE user.telefone = ?;", Usuario.class)
				.setParameter(1, telefone).getResultList().get(0);

		em.close();
		return usuario;
	}
}
