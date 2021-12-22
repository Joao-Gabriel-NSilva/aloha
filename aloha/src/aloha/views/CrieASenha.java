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

public class CrieASenha {

	private JFrame frame;
	private JTextField textFieldSenha;
	private static Usuario USUARIO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrieASenha window = new CrieASenha();
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
	public CrieASenha() {
		initialize();
	}

	public CrieASenha(Usuario usuario) {
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

		// label 1
		JLabel lblNewLabel = new JLabel("Crie sua senha");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(78, 50, 335, 62);
		frame.getContentPane().add(lblNewLabel);
		//

		// label 2 e 3
		JLabel lbl2 = new JLabel("Escolha apenas números com pelo menos 8 dígitos. Não use");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lbl2.setBounds(16, 123, 460, 41);
		frame.getContentPane().add(lbl2);

		JLabel lbl3 = new JLabel("números sequenciais (ex: 123 ou 321) ou repetidos (ex: 111).");
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lbl3.setBounds(16, 151, 460, 41);
		frame.getContentPane().add(lbl3);
		//

		// text field senha
		textFieldSenha = ViewUtil.criaTextField(22, 279, 447, 44, null, 26);
		textFieldSenha.setBorder(ViewUtil.BORDA_ROSA);
		frame.getContentPane().add(textFieldSenha);
		//

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(22, 353, 447, 44, "Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					USUARIO.setSenha(textFieldSenha.getText());
					frame.setVisible(false);
					new ConhecerMelhor(USUARIO);
					ConhecerMelhor.main(null);
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(btnAvancar);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				InformeEmail.main(null);
			}
		});
		//
	}

}
