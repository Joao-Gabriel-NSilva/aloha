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

public class InformeTelefone {

	private JFrame frame;
	private JTextField textFieldTelefone;
	private JTextField textFieldDDD;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeTelefone window = new InformeTelefone();
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
	public InformeTelefone() {
		initialize();
	}

	public InformeTelefone(Usuario novo_usuario) {
		this.usuario = novo_usuario;
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

		// label 1
		JLabel lblNewLabel = new JLabel("Qual é o seu telefone?");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(78, 50, 335, 62);
		frame.getContentPane().add(lblNewLabel);
		//

		// label 2
		JLabel lbl2 = new JLabel("Precisamos te enviar um código de "
				+ "confirmação para garantir");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lbl2.setBounds(22, 123, 447, 41);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("que só você terá acesso á sua conta.");
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lbl3.setBounds(22, 151, 447, 41);
		frame.getContentPane().add(lbl3);
		//
		
		// text field nome
		textFieldTelefone = new JTextField();
		textFieldTelefone.setToolTipText("Primeiro nome");
		textFieldTelefone.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBorder(ViewUtil.BORDA_ROSA);
		textFieldTelefone.setBounds(86, 279, 383, 44);
		frame.getContentPane().add(textFieldTelefone);
		//
		
		// text field sobrenome
		textFieldDDD = new JTextField();
		textFieldDDD.setToolTipText("Primeiro nome");
		textFieldDDD.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		textFieldDDD.setColumns(10);
		textFieldDDD.setBorder(ViewUtil.BORDA_ROSA);
		textFieldDDD.setBounds(23, 279, 44, 44);
		frame.getContentPane().add(textFieldDDD);
		//
		
		// botão avançar
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setOpaque(true);
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		btnAvancar.setBorder(ViewUtil.BORDA_ROSA);
		btnAvancar.setBounds(22, 385, 447, 44);
		frame.getContentPane().add(btnAvancar);
		
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					usuario.setTelefone(textFieldDDD.getText() + textFieldTelefone.getText());
					/*
					 * envia sms
					 */
					frame.setVisible(false);
					new ConfirmeOCodigo(usuario);
				} catch(RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//
		
		// botão voltar
		JButton btnVoltar = new JButton("< voltar");
		btnVoltar.setForeground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setOpaque(true);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setBounds(0, 0, 87, 23);
		btnVoltar.setFocusable(false);
		frame.getContentPane().add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InformeNome.main(null);
			}
		});
		//
		
	}

}
