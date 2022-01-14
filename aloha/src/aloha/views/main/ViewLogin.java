package aloha.views.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import aloha.util.TextBubbleBorder;
import aloha.util.ViewUtil;
import aloha.views.cadastro.InformeTelefone;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class ViewLogin {

	private JFrame frame;
	private JTextField textFieldEmail;
	private JTextField textFieldSenha;
	private JPasswordField passwordField;
	public static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
	}
	
	public ViewLogin(JFrame frameAnterior) {
		FRAME_ANTERIOR = frameAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("LOGIN");
		frame.getContentPane().setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		frame.setBounds(100, 100, 460, 840);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// text fied email
		textFieldEmail = ViewUtil.criaTextField(20, 312, 400, 65, "", 26);
		textFieldEmail.setToolTipText("Email cadastrado");
		frame.getContentPane().add(textFieldEmail);
		//

		// text fied senha
		textFieldSenha = ViewUtil.criaTextField(20, 403, 400, 65, "", 26);
		textFieldSenha.setVisible(false);
		textFieldSenha.setToolTipText("Senha");
		frame.getContentPane().add(textFieldSenha);
		//

		// password field
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		passwordField.setBounds(20, 403, 400, 65);
		passwordField.setBorder(new TextBubbleBorder(Color.BLACK, 1, 20, 0));
		frame.getContentPane().add(passwordField);
		//

		// botão entrar
		JButton botaoEntrar = ViewUtil.criaBotao(151, 498, 151, 49, "Entrar");
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		frame.getContentPane().add(botaoEntrar);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				ViewInicial.FRAME_LOGIN = frame;
			}
		});
		//

		// check box mostrar senha
		JCheckBox chckbxMostrarSenha = new JCheckBox("Mostrar senha");
		chckbxMostrarSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		chckbxMostrarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxMostrarSenha.isSelected()) {
					passwordField.setVisible(false);
					textFieldSenha.setVisible(true);
					textFieldSenha.setText(passwordField.getText());
				} else {
					textFieldSenha.setVisible(false);
					passwordField.setVisible(true);
					passwordField.setText(textFieldSenha.getText());
				}
			}
		});
		chckbxMostrarSenha.setBounds(21, 484, 111, 23);
		frame.getContentPane().add(chckbxMostrarSenha);
		//

		// label bem vindo
		JLabel lblNewLabel = new JLabel("Bem vindo!");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 83, 325, 88);
		frame.getContentPane().add(lblNewLabel);
		//
	}
}