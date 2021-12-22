package aloha.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	
}
