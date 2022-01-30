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

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import aloha.DAO.Configuracoes;
import aloha.modelo.Usuario;

public class ViewUtil {

	private static Configuracoes config = new Configuracoes();
	private static Icones icones = new Icones();
	public static Border BORDA_ROSA = new LineBorder(new Color(255, 20, 147), 3);
	public static Color COR_ATUAL_FUNDO = config.getCorAtualFundo();
	public static Color COR_ATUAL_LETRAS = config.getCorAtualLetras();
	
	public static JButton criaBotao(Integer x, Integer y, Integer width, Integer height, String text) {
		JButton botao = new JButton(text);
		botao.setOpaque(true);
		botao.setContentAreaFilled(false);
		botao.setForeground(COR_ATUAL_LETRAS);
		botao.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		botao.setBounds(x, y, width, height);
		botao.setFocusable(false);
		botao.setBorderPainted(false);
		return botao;
	}
	
	public static JLabel criaLblVoltar() {
		JLabel lbl = new JLabel("");
		lbl.setIcon(icones.getImgVoltar());
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
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(x, y, width, height);
		label.setForeground(COR_ATUAL_LETRAS);
		
		return label;
	}
	
	public static void setDarkTheme(JFrame frame) {
		config.setCorAtualFundo(Color.DARK_GRAY);
		config.setCorAtualLetras(Color.WHITE);
		COR_ATUAL_FUNDO = config.getCorAtualFundo();
		COR_ATUAL_LETRAS = config.getCorAtualLetras();
		
		frame.getContentPane().setBackground(COR_ATUAL_FUNDO);
		for(Component comp : frame.getContentPane().getComponents()) {
			if(!(comp instanceof JTextField)){
				comp.setForeground(COR_ATUAL_LETRAS);
			}
		}
	}
	
	public static void setLightTheme(JFrame frame) {
		config.setCorAtualFundo(Color.WHITE);
		config.setCorAtualLetras(Color.BLACK);
		COR_ATUAL_FUNDO = config.getCorAtualFundo();
		COR_ATUAL_LETRAS = config.getCorAtualLetras();
		
		frame.getContentPane().setBackground(COR_ATUAL_FUNDO);
		for(Component comp : frame.getContentPane().getComponents()) {
			if(!(comp instanceof JTextField)) {
				comp.setForeground(COR_ATUAL_LETRAS);
			}
		}
	}
	
	public static boolean enviaEmailCadastro(Usuario usuario) {
		String meuEmail = "alohausuario1@gmail.com";
		String senha = "@ADMaloha00";
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, senha));
		email.setSSLOnConnect(true);
		
		try {
			email.setFrom(meuEmail);
			email.setSubject("Bem vindo ao Aloha!");
			email.setMsg("Olá, " + usuario.getApelido() + "!");
			email.addTo(usuario.getEmail());
			email.send();
			return true;
			
			
		} catch(Exception e) {
			throw new RuntimeException("Falha ao enviar email. Tem certeza que informou o email correto?"); 
		}
	}
	
	public static boolean enviaEmail(Usuario usuario, String subject, String msg) {
		String meuEmail = "alohausuario1@gmail.com";
		String senha = "@ADMaloha00";
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, senha));
		email.setSSLOnConnect(true);
		
		try {
			email.setFrom(meuEmail);
			email.setSubject(subject);
			email.setMsg(msg);
			email.addTo(usuario.getEmail());
			email.send();
			return true;
			
		} catch(Exception e) {
			throw new RuntimeException("Falha ao enviar email."); 
		}
	}
}

