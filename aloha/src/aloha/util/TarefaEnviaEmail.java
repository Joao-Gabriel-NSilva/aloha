package aloha.util;

import aloha.modelo.Usuario;
import aloha.views.cadastro.InformeEmail;

public class TarefaEnviaEmail implements Runnable {
	
	private Usuario usuario;
	
	public TarefaEnviaEmail(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void run() {
		ViewUtil.enviaEmail(usuario);
		InformeEmail.EMAIL_ENVIADO = true;
	}

}
