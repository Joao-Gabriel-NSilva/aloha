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

public class ConfirmeOCodigo {

	private JFrame frame;
	private JTextField textField;
	private static Usuario USUARIO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmeOCodigo window = new ConfirmeOCodigo();
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
	public ConfirmeOCodigo() {
		initialize();
	}

	public ConfirmeOCodigo(Usuario usuario) {
		USUARIO = usuario;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 508, 685);
		frame.setLocation(700, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// text field código
		textField = ViewUtil.criaTextField(22, 279, 447, 44, null, 26);
		textField.setToolTipText("Código que lhe foi enviado");
		textField.setBorder(ViewUtil.BORDA_ROSA);
		frame.getContentPane().add(textField);
		//

		// label confirme seu código
		JLabel lblConfirmeSeuCdigo = new JLabel("Confirme seu código");
		lblConfirmeSeuCdigo.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lblConfirmeSeuCdigo.setBounds(132, 116, 228, 62);
		frame.getContentPane().add(lblConfirmeSeuCdigo);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				InformeTelefone.main(null);
			}
		});
		//

		// botão não recebeu
		JButton btnNoRecebeu = new JButton("Não recebeu?");
		btnNoRecebeu.setOpaque(true);
		btnNoRecebeu.setHorizontalAlignment(SwingConstants.LEADING);
		btnNoRecebeu.setForeground(Color.GRAY);
		btnNoRecebeu.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnNoRecebeu.setFocusable(false);
		btnNoRecebeu.setContentAreaFilled(false);
		btnNoRecebeu.setBounds(178, 349, 149, 36);
		frame.getContentPane().add(btnNoRecebeu);

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(54, 294, 384, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*
					 * confirma o código
					 */

					frame.setVisible(false);
					new InformeEmail(USUARIO);
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//
	}

}
