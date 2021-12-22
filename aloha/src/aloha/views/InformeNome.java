package aloha.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class InformeNome {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeNome window = new InformeNome();
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
	public InformeNome() {
		initialize();
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
		
		//label 1
		JLabel lblNewLabel = new JLabel("Aloha, novo usuário!");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(137, 49, 228, 62);
		frame.getContentPane().add(lblNewLabel);
		//
		
		//label 2
		JLabel lblInformeSeuNome = new JLabel("Informe seu nome verdadeiro. Não utilize nome de terceiros");
		lblInformeSeuNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformeSeuNome.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblInformeSeuNome.setBounds(29, 169, 443, 36);
		frame.getContentPane().add(lblInformeSeuNome);
		//
		
		// text fied nome
		textFieldNome = new JTextField();
		textFieldNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setFocusable(true);
				if(textFieldNome.getText().equals("Primeiro nome")) {
					textFieldNome.setText(null);
				}
				textFieldNome.setForeground(Color.BLACK);
			}
		});
		textFieldNome.setForeground(Color.GRAY);
		textFieldNome.setText("Primeiro nome");
		textFieldNome.setToolTipText("Primeiro nome");
		textFieldNome.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		textFieldNome.setBounds(29, 302, 443, 44);
		textFieldNome.setColumns(10);
		textFieldNome.setBorder(ViewUtil.BORDA_ROSA);
		textFieldNome.setFocusable(false);
		frame.getContentPane().add(textFieldNome);
		//
		
		// text field sobrenome
		textFieldSobrenome = new JTextField();
		textFieldSobrenome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldSobrenome.setFocusable(true);
				if(textFieldSobrenome.getText().equals("Sobrenome")) {
					textFieldSobrenome.setText(null);
				}
				textFieldSobrenome.setForeground(Color.BLACK);
			}
		});
		textFieldSobrenome.setForeground(Color.GRAY);
		textFieldSobrenome.setText("Sobrenome");
		textFieldSobrenome.setToolTipText("Sobrenome");
		textFieldSobrenome.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		textFieldSobrenome.setColumns(10);
		textFieldSobrenome.setBounds(29, 393, 443, 44);
		textFieldSobrenome.setBorder(ViewUtil.BORDA_ROSA);
		textFieldSobrenome.setFocusable(false);
		frame.getContentPane().add(textFieldSobrenome);
		//
		
		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(29, 481, 443, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);
		
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario novo_usuario = new Usuario();
					novo_usuario.setPrimeiroNome(textFieldNome.getText());
					novo_usuario.setSobrenome(textFieldSobrenome.getText());
					frame.setVisible(false);
					new InformeTelefone(novo_usuario);
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//
	}
}
