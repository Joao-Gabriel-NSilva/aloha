package aloha.views.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

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

public class EsqueceuASenha {

	private JFrame frame;
	public static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;
	private JTextField textField;
	private boolean enviouUmaVez = false;
	private String codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EsqueceuASenha window = new EsqueceuASenha();
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
	public EsqueceuASenha() {
		initialize();
	}

	public EsqueceuASenha(JFrame frmAnterior) {
		FRAME_ANTERIOR = frmAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Recupere sua senha");
		frame.setBounds(100, 100, 460, 840);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar();
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				ViewLogin.FRAME_ESQUECEU_SENHA = frame;
			}
		});
		frame.getContentPane().add(lblVoltar);
		//

		// lbls
		JLabel lblRecupere = new JLabel("Procure sua conta");
		lblRecupere.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecupere.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblRecupere.setBounds(10, 89, 434, 30);
		frame.getContentPane().add(lblRecupere);

		JLabel lblInsiraSeuEmail = new JLabel("Insira seu email ou número de celular");
		lblInsiraSeuEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraSeuEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblInsiraSeuEmail.setBounds(10, 169, 434, 30);
		frame.getContentPane().add(lblInsiraSeuEmail);

		JLabel lblCadastrado = new JLabel("cadastrado.");
		lblCadastrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrado.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblCadastrado.setBounds(10, 202, 434, 30);
		frame.getContentPane().add(lblCadastrado);
		//

		// textField
		textField = new JTextField();
		textField.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		textField.setBounds(39, 262, 381, 70);
		textField.setBorder(new TextBubbleBorder(Color.BLACK, 1, 20, 0));
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textField.setFocusable(true);
			}
		});
		frame.getContentPane().add(textField);
		//

		// btn procurar
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = null;
				JOptionPane.setDefaultLocale(new Locale("pt", "br"));

				try {
					usuario = UsuarioDAO.achaUsuarioPorEmail(textField.getText().trim());
				} catch (IndexOutOfBoundsException ex) {

					try {
						usuario = UsuarioDAO.achaUsuarioPorTelefone(textField.getText().trim());
					} catch (IndexOutOfBoundsException ex2) {
						JOptionPane.showMessageDialog(frame,
								"Nenhuma conta foi encontrada. Verifique se não há nenhum erro de digitação.",
								"Conta não encontrada", JOptionPane.PLAIN_MESSAGE, new Icones().getImgNaoVerificado());
					}
				}

				if (usuario != null) {

					String[] buttons = { "Ok", "Cancelar" };

					Integer resposta = JOptionPane.showOptionDialog(frame,
							"Um email com o código de verificação será enviado para " + usuario.getEmail(),
							"Conta de " + usuario.getApelido() + " encontrada", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);

					if (resposta == 0) {
						if (enviouUmaVez == false) {
							Integer randomNum = ThreadLocalRandom.current().nextInt(100000, 999999 + 1);
							codigo = randomNum.toString();

							TarefaEnviaEmail tarefa = new TarefaEnviaEmail(usuario, false, "Código de recuperação",
									"Seu código de recuperação é: " + codigo);
							Thread thread = new Thread(tarefa, "Enviador de email");
							thread.start();
							enviouUmaVez = true;

							frame.setVisible(false);
							if (FRAME_SEGUINTE != null) {
								FRAME_SEGUINTE.setVisible(true);
							} else {
								new ConfirmeCodRecu(usuario, codigo, frame);
							}
						} else {
							frame.setVisible(false);
							if (FRAME_SEGUINTE != null) {
								FRAME_SEGUINTE.setVisible(true);
							} else {
								new ConfirmeCodRecu(usuario, codigo, frame);
							}
						}
					} else {
					}
				}
			}
		});
		btnProcurar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnProcurar.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		if(frame.getContentPane().getBackground().equals(Color.WHITE)) {
        			btnProcurar.setForeground(Color.BLACK);
        		} else {
        			btnProcurar.setForeground(Color.WHITE);
        		}
        	}
        });
		btnProcurar.setOpaque(true);
		btnProcurar.setContentAreaFilled(false);
		btnProcurar.setForeground(Color.BLACK);
		btnProcurar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnProcurar.setBounds(155, 527, 143, 30);
		btnProcurar.setFocusable(false);
		btnProcurar.setBorderPainted(false);
		frame.getContentPane().add(btnProcurar);
		//

	}
}
