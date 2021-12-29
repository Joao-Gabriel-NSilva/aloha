package aloha.util;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TarefaAtualizaLabel implements Runnable {
	
	private JLabel label;
	private JTextField textFieldNome;
	public static boolean roda = true;
	
	public TarefaAtualizaLabel(JLabel lbl, JTextField txtField) {
		this.label = lbl;
		this.textFieldNome = txtField;
	}

	@Override
	public void run() {
		while(roda) {
			if (!(textFieldNome.getText() == null) & !(textFieldNome.getText().equals("Primeiro nome")) & 
					!(textFieldNome.getText().isEmpty())) {
				label.setText("Aloha, " + textFieldNome.getText() + "!");
			} else {
				label.setText("Aloha, novo usuário!");
			}
		}
	}

}
