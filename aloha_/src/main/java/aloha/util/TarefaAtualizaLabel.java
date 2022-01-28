package aloha.util;

import javax.swing.JLabel;
import javax.swing.JTextField;

import aloha.modelo.Usuario;
import aloha.views.cadastro.CrieASenha;

public class TarefaAtualizaLabel implements Runnable {
	
	private JLabel label;
	private JTextField textField;
	public static boolean roda = true;
	private Usuario usuario;
	
	public TarefaAtualizaLabel(JLabel lbl, JTextField txtField) {
		this.label = lbl;
		this.textField = txtField;
	}
	
	public TarefaAtualizaLabel(JTextField txtField, Usuario usuario) {
		textField = txtField;
		this.usuario = usuario;
		
	}

	@Override
	public void run() {
		if(usuario == null) {
			while(roda) {
				if (!(textField.getText() == null) & !(textField.getText().equals("Apelido")) & 
						!(textField.getText().isEmpty())) {
					label.setText("Aloha, " + textField.getText() + "!");
				} else {
					label.setText("Aloha, novo usuário!");
				}
			}
		} else {
			while(roda) {
				if(usuario.setSenha(textField.getText().trim())) {
					CrieASenha.ATENDE_TODOS_OS_REQUISITOS = true;
				} else {
					CrieASenha.ATENDE_TODOS_OS_REQUISITOS = false;
				}
			}
		}
	}

}
