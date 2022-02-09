package aloha.views.recu_senha;

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

import aloha.DAO.UsuarioDAO;
import aloha.modelo.Usuario;
import aloha.util.TarefaAtualizaLabel;
import aloha.util.TextBubbleBorder;
import aloha.util.ViewUtil;
import aloha.views.cadastro.CrieASenha;
import aloha.views.main.ViewLogin;

public class RedefinirSenha {

	public static boolean ATENDE_TODOS_OS_REQUISITOS = false;
	private JFrame frame;
	private JTextField textFieldSenha;
	private JTextField textFieldConfirmeSenha;
	private static Usuario USUARIO;
	public static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;
	public static JLabel lblMaiuscula;
	public static JLabel lblMinuscula;
	public static JLabel lblNumero;
	private static Thread thread1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedefinirSenha window = new RedefinirSenha();
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
	public RedefinirSenha() {
		initialize();
	}

	public RedefinirSenha(Usuario usuario, JFrame frmAnterior) {
		USUARIO = usuario;
		FRAME_ANTERIOR = frmAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 460, 840);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Crie uma senha!");

		// label 1
		JLabel lbl1 = new JLabel("Crie uma nova senha");
		lbl1.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(97, 50, 260, 62);
		lbl1.setForeground(Color.BLACK);
		// JLabel lblCrieSuaSenha = ViewUtil.criaJLabel(115, 50, 260, 62, "Crie sua
		// senha!", 30);
		frame.getContentPane().add(lbl1);
		//

		// label 2, 3 e 4
		JLabel lbl2 = new JLabel("A nova senha deve conter:");
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(0, 142, 454, 41);
		lbl2.setForeground(Color.BLACK);
		// JLabel lbl2 = ViewUtil.criaJLabel(16, 123, 460, 41, "Crie uma senha com pelo
		// menos 8 dígitos. Não", 20);
		frame.getContentPane().add(lbl2);

		JLabel lbl4 = new JLabel("uma maiúscula;");
		lbl4.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lbl4.setHorizontalAlignment(SwingConstants.LEFT);
		lbl4.setBounds(157, 199, 140, 36);
		lbl4.setForeground(Color.BLACK);
		// JLabel lbl4 = ViewUtil.criaJLabel(16, 179, 460, 41, "repetidos (ex: 111).",
		// 20);
		frame.getContentPane().add(lbl4);

		JLabel lblUmaMinsculaE = new JLabel("uma minúscula;");
		lblUmaMinsculaE.setHorizontalAlignment(SwingConstants.LEFT);
		lblUmaMinsculaE.setForeground(Color.BLACK);
		lblUmaMinsculaE.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblUmaMinsculaE.setBounds(157, 246, 140, 30);
		frame.getContentPane().add(lblUmaMinsculaE);

		JLabel lblEUmNmero = new JLabel("um número.");
		lblEUmNmero.setHorizontalAlignment(SwingConstants.LEFT);
		lblEUmNmero.setForeground(Color.BLACK);
		lblEUmNmero.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblEUmNmero.setBounds(171, 289, 111, 36);
		frame.getContentPane().add(lblEUmNmero);
		//

		// text field senha
		textFieldSenha = new JTextField();
		textFieldSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textFieldSenha.setText("Senha");
		textFieldSenha.setBounds(27, 366, 400, 65);
		textFieldSenha.setColumns(10);
		textFieldSenha.setBorder(new TextBubbleBorder(Color.BLACK, 1, 20, 0));
		// textFieldSenha = ViewUtil.criaTextField(20, 303, 400, 65, "Senha", 26);
		TarefaAtualizaLabel tarefa = new TarefaAtualizaLabel(textFieldSenha, USUARIO, RedefinirSenha.class);
		textFieldSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textFieldSenha.setFocusable(true);
			}
		});
		textFieldSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldSenha.getText().equals("Senha")) {
					textFieldSenha.setText(null);
				}
				textFieldSenha.setForeground(Color.BLACK);

				if (thread1 == null) {
					tarefa.ativa();
					thread1 = new Thread(tarefa, "verificador de condições da senha");
					thread1.start();
				}

			}
		});
		textFieldSenha.setForeground(Color.GRAY);
		textFieldSenha.setToolTipText("Senha");
		textFieldSenha.setFocusable(false);
		frame.getContentPane().add(textFieldSenha);

		textFieldConfirmeSenha = new JTextField();
		textFieldConfirmeSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textFieldConfirmeSenha.setText("Confirme a senha");
		textFieldConfirmeSenha.setBounds(27, 446, 400, 65);
		textFieldConfirmeSenha.setColumns(10);
		textFieldConfirmeSenha.setBorder(new TextBubbleBorder(Color.BLACK, 1, 20, 0));
		// textFieldConfirmeSenha = ViewUtil.criaTextField(20, 383, 400, 65, "Confirme a
		// senha", 26);
		textFieldConfirmeSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldConfirmeSenha.getText().equals("Confirme a senha")) {
					textFieldConfirmeSenha.setText(null);
				}
				textFieldConfirmeSenha.setForeground(Color.BLACK);
			}
		});
		textFieldConfirmeSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textFieldConfirmeSenha.setFocusable(true);
			}
		});
		textFieldConfirmeSenha.setForeground(Color.GRAY);
		textFieldConfirmeSenha.setToolTipText("Senha");
		textFieldConfirmeSenha.setFocusable(false);
		frame.getContentPane().add(textFieldConfirmeSenha);
		//

		// botão avançar
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setOpaque(true);
		btnConfirmar.setContentAreaFilled(false);
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnConfirmar.setBounds(147, 563, 160, 44);
		btnConfirmar.setFocusable(false);
		btnConfirmar.setBorderPainted(false);
		// JButton btnAvancar = ViewUtil.criaBotao(160, 500, 140, 44, "Avançar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(ATENDE_TODOS_OS_REQUISITOS);
					System.out.println(USUARIO.setSenha(textFieldSenha.getText(), textFieldConfirmeSenha.getText()));
					if (ATENDE_TODOS_OS_REQUISITOS
							& USUARIO.setSenha(textFieldSenha.getText(), textFieldConfirmeSenha.getText())) {
						tarefa.desativa();
						thread1 = null;
						frame.setVisible(false);

						UsuarioDAO.salvaAlteracoes(USUARIO);

						ViewLogin.FRAME_ANTERIOR = frame;
						if (FRAME_SEGUINTE != null) {
							FRAME_SEGUINTE.setVisible(true);
						} else {
							new ViewLogin(frame);
						}

					}

				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
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
		frame.getContentPane().add(btnConfirmar);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar();
		frame.getContentPane().add(lblVoltar);
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				ConfirmeCodRecu.FRAME_SEGUINTE = frame;
			}
		});
		//

		// labels de verificado
		lblMaiuscula = new JLabel("");
		lblMaiuscula.setBounds(311, 194, 46, 41);
		frame.getContentPane().add(lblMaiuscula);
		CrieASenha.lblMaiuscula = lblMaiuscula;

		lblMinuscula = new JLabel("");
		lblMinuscula.setBounds(311, 241, 46, 41);
		frame.getContentPane().add(lblMinuscula);
		CrieASenha.lblMinuscula = lblMinuscula;

		lblNumero = new JLabel("");
		lblNumero.setBounds(311, 290, 46, 41);
		frame.getContentPane().add(lblNumero);
		CrieASenha.lblNumero = lblNumero;
		//
	}

}
