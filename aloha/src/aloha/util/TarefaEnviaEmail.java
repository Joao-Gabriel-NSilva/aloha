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
		InformeEmail.labelEnviandoEmail.setBounds(60, 530, 400, 40);
		InformeEmail.labelEnviandoEmail.setText("Email enviado para " + usuario.getEmail() + "!");
		InformeEmail.EMAIL_ENVIADO = true;
	}

}
