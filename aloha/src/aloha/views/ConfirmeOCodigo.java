package aloha.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ConfirmeOCodigo {

	private JFrame frame;
	private JTextField textField;
	private Usuario usuario;

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
		this.usuario = usuario;
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
		textField = new JTextField();
		textField.setToolTipText("Código que lhe foi enviado");
		textField.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		textField.setColumns(10);
		textField.setBorder(ViewUtil.BORDA_ROSA);
		textField.setBounds(54, 216, 384, 44);
		frame.getContentPane().add(textField);
		//
		
		// label confirme seu código
		JLabel lblConfirmeSeuCdigo = new JLabel("Confirme seu código");
		lblConfirmeSeuCdigo.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lblConfirmeSeuCdigo.setBounds(132, 116, 228, 62);
		frame.getContentPane().add(lblConfirmeSeuCdigo);
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
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setOpaque(true);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setBorder(ViewUtil.BORDA_ROSA);
		btnAvancar.setBounds(54, 294, 384, 44);
		frame.getContentPane().add(btnAvancar);
		
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*
					 * confirma o código
					 */
					
					
					frame.setVisible(false);
					new InformeEmail(usuario);
				} catch(RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//
	}

}
