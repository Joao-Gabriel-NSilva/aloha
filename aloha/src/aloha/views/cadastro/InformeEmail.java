package aloha.views.cadastro;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import aloha.modelo.Usuario;
import aloha.util.TarefaEnviaEmail;
import aloha.util.ViewUtil;

public class InformeEmail {

	private JFrame frame;
	private JTextField textFieldEmail;
	private JButton btnAvancar;
	private static Usuario USUARIO;
	private static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;
	public static boolean EMAIL_ENVIADO = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeEmail window = new InformeEmail();
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
	public InformeEmail() {
		initialize();
	}

	public InformeEmail(Usuario usuario, JFrame frameAnterior) {
		USUARIO = usuario;
		FRAME_ANTERIOR = frameAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Informe seu email!");

		// label informe email
		JLabel lblInforme = ViewUtil.criaJLabel(127, 52, 228, 62, "Informe seu e-mail!", 30);
		frame.getContentPane().add(lblInforme);
		//

		// label 2 e 3
		JLabel lbl2 = ViewUtil.criaJLabel(47, 169, 388, 36, "Precisamos do seu email. Vamos usa-lo para enviar", 20);
		frame.getContentPane().add(lbl2);

		JLabel lbl3 = ViewUtil.criaJLabel(47, 196, 266, 36, "informações importantes para você.", 20);
		frame.getContentPane().add(lbl3);
		//

		// text field email
		textFieldEmail = ViewUtil.criaTextField(20, 273, 400, 69, null, 26);
		textFieldEmail.setToolTipText("Seu e-mail");
		frame.getContentPane().add(textFieldEmail);
		//

		// botão avançar
		btnAvancar = ViewUtil.criaBotao(160, 450, 140, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(EMAIL_ENVIADO == false) {
						USUARIO.setEmail(textFieldEmail.getText());
						
						Runnable tarefa = new TarefaEnviaEmail(USUARIO);
						Thread thread = new Thread(tarefa, "Thread envia email");
						thread.start();
						
						frame.setVisible(false);
						
						if(FRAME_SEGUINTE != null) {
							FRAME_SEGUINTE.setVisible(true);
						} else {
							new CrieASenha(USUARIO, frame);
						}
					} else {
						FRAME_SEGUINTE.setVisible(true);
					}
					
				} catch (RuntimeException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				ConfirmeOCodigo.FRAME_SEGUINTE = frame;
			}
		});
		//
	}
}
