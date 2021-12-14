package aloha.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private Usuario usuario;

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
		this.usuario = usuario;
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

		// butão voltar
		JButton btnVoltar = new JButton("< voltar");
		btnVoltar.setOpaque(true);
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setFocusable(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBounds(0, 0, 87, 23);
		frame.getContentPane().add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ConfirmeOCodigo.main(null);
			}
		});
		//

		// botão avançar
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setOpaque(true);
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		btnAvancar.setBounds(29, 361, 443, 44);
		btnAvancar.setBorder(ViewUtil.BORDA_ROSA);
		frame.getContentPane().add(btnAvancar);

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					usuario.setEmail(textFieldEmail.getText());
					frame.setVisible(false);
					new CrieASenha(usuario);
				} catch(RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//
	}

}
