package aloha.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ViewUtil {

	public static Border BORDA_ROSA = new LineBorder(new Color(255, 20, 147), 3);
	
	public static JButton criaBotao(Integer x, Integer y, Integer width, Integer height, String text) {
		JButton botao = new JButton(text);
		botao.setOpaque(true);
		botao.setContentAreaFilled(false);
		botao.setForeground(Color.BLACK);
		botao.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		botao.setBorder(BORDA_ROSA);
		botao.setBounds(x, y, width, height);
		
		return botao;
	}
	
	public static JLabel criaLblVoltar(Object classe) {
		JLabel lbl = new JLabel("");
		ImageIcon img = new ImageIcon(classe.getClass().getResource("/botao_voltar.png"));
		lbl.setIcon(img);
		lbl.setBounds(0, 0, 37, 41);
		
		return lbl;
	}
	
	public static JCheckBox criaCheckBox(Integer x, Integer y, Integer width, Integer height, String text) {
		JCheckBox checkBox = new JCheckBox(text);
		checkBox.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		checkBox.setBounds(x, y, width, height);
		checkBox.setFocusable(false);
		
		return checkBox;
	}
	
	public static JTextField criaTextField(Integer x, Integer y, Integer width, Integer height, String text, 
			Integer tamanhoFonte) {
		JTextField textField = new JTextField();
		textField.setFont(new Font("Arial Narrow", Font.PLAIN, tamanhoFonte));
		textField.setText(text);
		textField.setBounds(x, y, width, height);
		textField.setFocusable(false);
		textField.setColumns(10);
		
		return textField;
	}
	
}
