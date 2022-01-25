package aloha.views.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aloha.DAO.UsuarioDAO;
import aloha.modelo.Usuario;
import aloha.util.TextBubbleBorder;
import aloha.util.ViewUtil;
import aloha.util.IconTextField;

public class ViewLogin {

	private JFrame frame;
	private JTextField textFieldArrouba;
	private JTextField textFieldSenha;
	private JPasswordField passwordField;
	public static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;
	private static boolean clicouUmaVez = false;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("LOGIN");
		frame.setBounds(100, 100, 460, 840);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// text fied email 74, 353, 346, 70
		textFieldArrouba = ViewUtil.criaTextField(74, 262, 346, 70, "@", 25);
		textFieldArrouba.setForeground(Color.GRAY);
		textFieldArrouba.setFocusable(false);
		textFieldArrouba.setToolTipText("Nome de usuário cadastrado");
		textFieldArrouba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldArrouba.setFocusable(true);
				if (textFieldArrouba.getText().equals("@")) {
					textFieldArrouba.setText(null);
				}
				textFieldArrouba.setForeground(Color.BLACK);
			}
		});
		frame.getContentPane().add(textFieldArrouba);
		//

		// text fied senha
		textFieldSenha = ViewUtil.criaTextField(74, 353, 346, 70, "Senha", 25);
		textFieldSenha.setForeground(Color.GRAY);
		textFieldSenha.setFocusable(false);
		textFieldSenha.setToolTipText("Senha");
		textFieldSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!clicouUmaVez) {
					textFieldSenha.setVisible(false);
					textFieldSenha.setText(null);
					textFieldSenha.setForeground(Color.BLACK);
					passwordField.setVisible(true);
					clicouUmaVez = true;
				}
			}
		});
		frame.getContentPane().add(textFieldSenha);
		//

		// password field 
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		passwordField.setVisible(false);
		passwordField.setBounds(74, 353, 346, 70);
		passwordField.setBorder(new TextBubbleBorder(Color.BLACK, 1, 20, 0));
		frame.getContentPane().add(passwordField);
		//

		// botão entrar
		JButton botaoEntrar = ViewUtil.criaBotao(157, 580, 140, 44, "Entrar");
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha;
				String arrouba;
				
				String senha1 = null;
				for (char a : passwordField.getPassword()) {
					if(senha1 == null) {
						senha1 = String.valueOf(a);
					} else {
						senha1 = senha1 + a;
					}
				}
				
				senha = (passwordField.isVisible() ? senha1 : textFieldSenha.getText().strip());
				arrouba = (textFieldArrouba.getText().startsWith("@") ? textFieldArrouba.getText().strip()
						: "@" + textFieldArrouba.getText().strip());

				try {
					Usuario usuario = UsuarioDAO.fazLogin(arrouba, senha);
					JOptionPane.showMessageDialog(frame, "Login efetuado!");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Falha no Login",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		botaoEntrar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		botaoEntrar.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		if(frame.getContentPane().getBackground().equals(Color.WHITE)) {
        			botaoEntrar.setForeground(Color.BLACK);
        		} else {
        			botaoEntrar.setForeground(Color.WHITE);
        		}
        	}
        });
		frame.getContentPane().add(botaoEntrar);
		//
		
		//botão esqueceu a senha
		JButton botaoEsqueceuSenha = ViewUtil.criaBotao(127, 630, 200, 44, "Esqueceu a senha?");
		botaoEsqueceuSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		botaoEsqueceuSenha.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		botaoEsqueceuSenha.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		if(frame.getContentPane().getBackground().equals(Color.WHITE)) {
        			botaoEsqueceuSenha.setForeground(Color.BLACK);
        		} else {
        			botaoEsqueceuSenha.setForeground(Color.WHITE);
        		}
        	}
        });
		frame.getContentPane().add(botaoEsqueceuSenha);

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
		
		// check box manter conectado
		JCheckBox chckbxManterConectado = new JCheckBox("Manter conectado");
		chckbxManterConectado.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		chckbxManterConectado.setBounds(74, 450, 127, 23);
		frame.getContentPane().add(chckbxManterConectado);
		//

		// label bem vindo
		JLabel lblNewLabel = new JLabel("Bem vindo!");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 83, 325, 88);
		frame.getContentPane().add(lblNewLabel);
		//
		
		// icones
		JLabel lblUsuarioIcon = new JLabel("");
		lblUsuarioIcon.setBounds(10, 278, 46, 55);
		ImageIcon imgUsuario = new ImageIcon(this.getClass().getResource("/icons/user_icon.png"));
		lblUsuarioIcon.setIcon(imgUsuario);
		frame.getContentPane().add(lblUsuarioIcon);
		
		JLabel lblSenhaIcon = new JLabel("");
		lblSenhaIcon.setBounds(10, 368, 46, 55);
		ImageIcon imgSenha = new ImageIcon(this.getClass().getResource("/icons/password_icon.png"));
		lblSenhaIcon.setIcon(imgSenha);
		frame.getContentPane().add(lblSenhaIcon);
		
		ImageIcon imgOlhoAberto = new ImageIcon(this.getClass().getResource("/icons/eye_visible_hide_hidden_show_icon.png"));
		ImageIcon imgOlhoAbertoComRisco = new ImageIcon(this.getClass().getResource("/icons/eye_slash_visible_hide_hidden_show_icon.png"));
		JLabel lblOlho = new JLabel("");
		lblOlho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textFieldSenha.getText().equals("Senha")) {
					if(lblOlho.getIcon().equals(imgOlhoAberto)) {
						lblOlho.setIcon(imgOlhoAbertoComRisco);
						passwordField.setVisible(false);
						textFieldSenha.setVisible(true);
						textFieldSenha.setFocusable(true);
						textFieldSenha.setText(((JTextField) passwordField).getText());
					} else {
						lblOlho.setIcon(imgOlhoAberto);
						textFieldSenha.setVisible(false);
						passwordField.setVisible(true);
						passwordField.setText(textFieldSenha.getText());
					}
				}
			}
		});
		lblOlho.setBounds(388, 441, 32, 32);
		lblOlho.setIcon(imgOlhoAberto);
		frame.getContentPane().add(lblOlho);
		//
	}
}