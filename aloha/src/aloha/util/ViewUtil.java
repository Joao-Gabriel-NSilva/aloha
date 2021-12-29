package aloha.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ViewUtil {

	public static Border BORDA_ROSA = new LineBorder(new Color(255, 20, 147), 3);
	public static Border BORDA_AZUL = new LineBorder(Color.BLUE, 3);
	public static Color COR_ATUAL_FUNDO = Color.WHITE;
	public static Color COR_ATUAL_LETRAS = Color.BLACK;
	
	public static JButton criaBotao(Integer x, Integer y, Integer width, Integer height, String text) {
		JButton botao = new JButton(text);
		botao.setOpaque(true);
		botao.setContentAreaFilled(false);
		botao.setForeground(COR_ATUAL_LETRAS);
		botao.setFont(new Font("Arial Narrow", Font.PLAIN, 35));
		botao.setBounds(x, y, width, height);
		botao.setFocusable(false);
		botao.setBorderPainted(false);
		
		return botao;
	}
	
	public static JLabel criaLblVoltar(Object classe) {
		JLabel lbl = new JLabel("");
		ImageIcon img = new ImageIcon(classe.getClass().getResource("/botao_voltar.png"));
		lbl.setIcon(img);
		lbl.setBounds(5, 0, 37, 41);
		
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
		textField.setColumns(10);
		textField.setBorder(new TextBubbleBorder(Color.BLACK,1,20,0));
		
		return textField;
	}
	
	public static JFrame criaJFrame(Integer x, Integer y, Integer width, Integer height) {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(COR_ATUAL_FUNDO);
		frame.setResizable(false);
		frame.setBounds(x, y, width, height);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		return frame;
	}
	
	public static JLabel criaJLabel(Integer x, Integer y, Integer width, Integer height, String text, 
			Integer tamanhoFonte) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Arial Narrow", Font.PLAIN, tamanhoFonte));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(x, y, width, height);
		label.setForeground(COR_ATUAL_LETRAS);
		
		return label;
	}
	
	public static void setDarkTheme(JFrame frame) {
		COR_ATUAL_FUNDO = Color.GRAY;
		COR_ATUAL_LETRAS = Color.WHITE;
		frame.getContentPane().setBackground(COR_ATUAL_FUNDO);
		for(Component comp : frame.getContentPane().getComponents()) {
			if(!(comp instanceof JTextField)){
				comp.setForeground(COR_ATUAL_LETRAS);
			}
		}
	}
	
	public static void setLightTheme(JFrame frame) {
		COR_ATUAL_FUNDO = Color.WHITE;
		COR_ATUAL_LETRAS = Color.BLACK;
		frame.getContentPane().setBackground(COR_ATUAL_FUNDO);
		for(Component comp : frame.getContentPane().getComponents()) {
			if(!(comp instanceof JTextField)) {
				comp.setForeground(COR_ATUAL_LETRAS);
			}
		}
	}
}
