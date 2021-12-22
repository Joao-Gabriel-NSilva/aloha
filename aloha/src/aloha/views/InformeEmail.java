package aloha.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class InformeEmail {

	private JFrame frame;
	private JTextField textFieldEmail;
	private static Usuario USUARIO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeEmail window = new InformeEmail();
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
	public InformeEmail() {
		initialize();
	}

	public InformeEmail(Usuario usuario) {
		USUARIO = usuario;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 508, 685);
		frame.setLocation(700, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// label informe email
		JLabel lblInforme = new JLabel("Informe seu e-mail");
		lblInforme.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lblInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lblInforme.setBounds(137, 52, 228, 62);
		frame.getContentPane().add(lblInforme);
		//

		// label 2 e 3
		JLabel lbl2 = new JLabel("Precisamos do seu email. Vamos usa-lo para enviar");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lbl2.setBounds(57, 169, 388, 36);
		frame.getContentPane().add(lbl2);

		JLabel lbl3 = new JLabel("informações importantes para você");
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lbl3.setBounds(118, 196, 266, 36);
		frame.getContentPane().add(lbl3);
		//

		// text field email
		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("Seu e-mail");
		textFieldEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(29, 273, 443, 44);
		textFieldEmail.setBorder(ViewUtil.BORDA_ROSA);
		frame.getContentPane().add(textFieldEmail);
		//

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(29, 361, 443, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					USUARIO.setEmail(textFieldEmail.getText());
					frame.setVisible(false);
					new CrieASenha(USUARIO);
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				ConfirmeOCodigo.main(null);
			}
		});
		//
	}

}
