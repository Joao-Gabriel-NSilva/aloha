package aloha.util;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TarefaAtualizaLabel implements Runnable {
	
	private JLabel label;
	private JTextField textFieldApelido;
	public static boolean roda = true;
	
	public TarefaAtualizaLabel(JLabel lbl, JTextField txtField) {
		this.label = lbl;
		this.textFieldApelido = txtField;
	}

	@Override
	public void run() {
		while(roda) {
			if (!(textFieldApelido.getText() == null) & !(textFieldApelido.getText().equals("Apelido")) & 
					!(textFieldApelido.getText().isEmpty())) {
				label.setText("Aloha, " + textFieldApelido.getText() + "!");
			} else {
				label.setText("Aloha, novo usuário!");
			}
		}
	}

}
