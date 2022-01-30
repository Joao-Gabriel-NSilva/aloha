package aloha.util;

import aloha.modelo.Usuario;
import aloha.views.cadastro.InformeEmail;

public class TarefaEnviaEmail implements Runnable {
	
	private Usuario usuario;
	private boolean ehCadastro;
	private String subject;
	private String msg;
	
	public TarefaEnviaEmail(Usuario usuario, boolean ehCadastro) {
		this.usuario = usuario;
		this.ehCadastro = ehCadastro;
	}
	
	
	public TarefaEnviaEmail(Usuario usuario, boolean ehCadastro, String subject, String msg) {
		this.usuario = usuario;
		this.ehCadastro = ehCadastro;
		this.subject = subject;
		this.msg = msg;
	}

	@Override
	public void run() {
		if(ehCadastro) {
			ViewUtil.enviaEmailCadastro(usuario);
			InformeEmail.EMAIL_ENVIADO = true;
		} else {
			ViewUtil.enviaEmail(usuario, subject, msg);
		}
	}

}
