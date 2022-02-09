package aloha.util;

import javax.swing.JLabel;
import javax.swing.JTextField;

import aloha.modelo.Usuario;
import aloha.views.cadastro.CrieASenha;
import aloha.views.recu_senha.RedefinirSenha;

public class TarefaAtualizaLabel implements Runnable {
	
	private JLabel label;
	private JTextField textField;
	private boolean roda = true;
	private Usuario usuario;
	private Object classe;
	
	public TarefaAtualizaLabel(JLabel lbl, JTextField txtField) {
		this.label = lbl;
		this.textField = txtField;
	}
	
	public TarefaAtualizaLabel(JTextField txtField, Usuario usuario, Object classe) {
		textField = txtField;
		this.usuario = usuario;
		this.classe = classe;
		System.out.println("thread iniciado");
	}
	
	public void ativa() {
		this.roda = true;
	}
	
	public void desativa() {
		this.roda = false;
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
					
					if(classe.equals(CrieASenha.class)) {
						CrieASenha.ATENDE_TODOS_OS_REQUISITOS = true;
						
					} else if(classe.equals(RedefinirSenha.class)) {
						RedefinirSenha.ATENDE_TODOS_OS_REQUISITOS = true;
					} 
					
				} else {
					
					if(classe.equals(CrieASenha.class)) {
						CrieASenha.ATENDE_TODOS_OS_REQUISITOS = false;
					} else if(classe.equals(RedefinirSenha.class)) {
						RedefinirSenha.ATENDE_TODOS_OS_REQUISITOS = false;
					}
				}
			}
		}
	}

}
