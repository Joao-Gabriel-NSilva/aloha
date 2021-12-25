package aloha.views;

import java.awt.Color;
import java.awt.EventQueue;
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

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class InformeNome {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
	private ImageIcon sol = new ImageIcon(this.getClass().getResource("/ligth_theme.png"));
	private ImageIcon lua = new ImageIcon(this.getClass().getResource("/dark_theme.png"));
	private String nome;

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
		frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Bem vindo!");

		// text fied nome
		textFieldNome = ViewUtil.criaTextField(20, 312, 400, 65, "Primeiro nome", 26);
		textFieldNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNome.setFocusable(true);
				if (textFieldNome.getText().equals("Primeiro nome")) {
					textFieldNome.setText(null);
				}
				textFieldNome.setForeground(Color.BLACK);
			}
		});
		textFieldNome.setForeground(Color.GRAY);
		textFieldNome.setToolTipText("Primeiro nome");
		textFieldNome.setFocusable(false);
		frame.getContentPane().add(textFieldNome);
		//

		// text field sobrenome
		textFieldSobrenome = ViewUtil.criaTextField(20, 403, 400, 65, "Sobrenome", 26);
		textFieldSobrenome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldSobrenome.setFocusable(true);
				if (textFieldSobrenome.getText().equals("Sobrenome")) {
					textFieldSobrenome.setText(null);
				}
				textFieldSobrenome.setForeground(Color.BLACK);
			}
		});
		textFieldSobrenome.setForeground(Color.GRAY);
		textFieldSobrenome.setToolTipText("Sobrenome");
		textFieldSobrenome.setFocusable(false);
		frame.getContentPane().add(textFieldSobrenome);
		//

		// label 1
		if (!(textFieldNome.getText() == null) & !(textFieldNome.getText().equals("Primeiro nome")) & 
				!(textFieldNome.getText().isEmpty())) {
			nome = textFieldNome.getText();
		} else {
			nome = "novo usuário";
		}
		JLabel lblAloha = ViewUtil.criaJLabel(120, 49, 228, 62, "Aloha, " + nome + "!", 30);
		frame.getContentPane().add(lblAloha);
		//

		// label 2
		JLabel lblInformeSeuNome = ViewUtil.criaJLabel(45, 169, 400, 36,
				"Informe seu nome verdadeiro. Não utilize o nome", 20);
		frame.getContentPane().add(lblInformeSeuNome);

		JLabel lblInformeSeuNome2 = ViewUtil.criaJLabel(45, 200, 400, 36, "de terceiros.", 20);
		frame.getContentPane().add(lblInformeSeuNome2);
		//

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(160, 550, 130, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario novo_usuario = new Usuario();
					novo_usuario.setPrimeiroNome(textFieldNome.getText());
					novo_usuario.setSobrenome(textFieldSobrenome.getText());
					frame.setVisible(false);
					new InformeTelefone(novo_usuario, frame);
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//

		// lbl tema
		JLabel lblTema = ViewUtil.criaJLabel(410, 0, 37, 41, null, 0);
		lblTema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblTema.getIcon().equals(lua)) {
					lblTema.setIcon(sol);
					ViewUtil.setLightTheme(frame);
				} else {
					lblTema.setIcon(lua);
					ViewUtil.setDarkTheme(frame);
				}
			}
		});
		lblTema.setIcon(sol);
		frame.getContentPane().add(lblTema);
		//
	}
}
