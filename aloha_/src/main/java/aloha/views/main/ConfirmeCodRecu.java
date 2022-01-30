package aloha.views.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aloha.DAO.UsuarioDAO;
import aloha.modelo.Usuario;
import aloha.util.Icones;
import aloha.util.TarefaEnviaEmail;
import aloha.util.TextBubbleBorder;
import aloha.util.ViewUtil;

public class ConfirmeCodRecu {

	private JFrame frame;
	private JTextField textField;
	public static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;
	private static Usuario USUARIO;
	private static String CODIGO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmeCodRecu window = new ConfirmeCodRecu();
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
	public ConfirmeCodRecu() {
		initialize();
	}

	public ConfirmeCodRecu(Usuario usuario, String codigo, JFrame frmAnterior) {
		USUARIO = usuario;
		CODIGO = codigo;
		FRAME_ANTERIOR = frmAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Confirme seu código");
		frame.setBounds(100, 100, 460, 840);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// textField
		textField = new JTextField();
		textField.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textField.setBounds(39, 262, 381, 70);
		textField.setBorder(new TextBubbleBorder(Color.BLACK, 1, 20, 0));
		frame.getContentPane().add(textField);
		//

		// btn confirmar
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText().trim());
				System.out.println(CODIGO);
				if (textField.getText().trim().equals(CODIGO)) {
					String[] buttons = { "Sim, quero redefini-la", "Não, apenas fazer login"};
					
					Integer resposta = JOptionPane.showOptionDialog(frame,
							"Sua senha é: " + USUARIO.getSenha() + ". Deseja redefini-la?", "Confirmação",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
					
					if(resposta == 0) {
						frame.setVisible(false);
						if(FRAME_SEGUINTE != null) {
							FRAME_SEGUINTE.setVisible(true);
						} else {
							new RedefinirSenha(USUARIO, frame);
						}
					} else if(resposta == 1){
						frame.setVisible(false);
						ViewLogin.main(null);
					} else {}

				} else {
					JOptionPane.showMessageDialog(frame,
							"Código incorreto. Verifique se não há nenhum erro de digitação e tente novamente.",
							"Código incorreto", JOptionPane.PLAIN_MESSAGE, new Icones().getImgNaoVerificado());
				}
			}
		});
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfirmar.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
					btnConfirmar.setForeground(Color.BLACK);
				} else {
					btnConfirmar.setForeground(Color.WHITE);
				}
			}
		});
		btnConfirmar.setOpaque(true);
		btnConfirmar.setContentAreaFilled(false);
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnConfirmar.setBounds(139, 527, 176, 30);
		btnConfirmar.setFocusable(false);
		btnConfirmar.setBorderPainted(false);
		frame.getContentPane().add(btnConfirmar);
		//

		// lbls
		JLabel lblConfirme = new JLabel("Confirme seu código");
		lblConfirme.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirme.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblConfirme.setBounds(10, 89, 434, 30);
		frame.getContentPane().add(lblConfirme);

		JLabel lblInsiraOCodigo = new JLabel("Insira o código de verificação que foi enviado");
		lblInsiraOCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOCodigo.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblInsiraOCodigo.setBounds(10, 169, 434, 30);
		frame.getContentPane().add(lblInsiraOCodigo);

		JLabel lblPEmail = new JLabel("para o seu email.");
		lblPEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblPEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblPEmail.setBounds(10, 202, 434, 30);
		frame.getContentPane().add(lblPEmail);
		//

	}

}
