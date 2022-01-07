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

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class InformeEmail {

	private JFrame frame;
	private JTextField textFieldEmail;
	private static Usuario USUARIO;
	private static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;

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
		textFieldEmail = ViewUtil.criaTextField(20, 273, 400, 65, null, 26);
		textFieldEmail.setToolTipText("Seu e-mail");
		frame.getContentPane().add(textFieldEmail);
		//

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(160, 450, 140, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					USUARIO.setEmail(textFieldEmail.getText());
					
					if(enviaEmail(USUARIO)) {
						JOptionPane.showMessageDialog(null, "Email enviado para " + USUARIO.getEmail(), "Enviado!", 
								JOptionPane.INFORMATION_MESSAGE);
					}
					
					frame.setVisible(false);
					
					if(FRAME_SEGUINTE != null) {
						FRAME_SEGUINTE.setVisible(true);
					} else {
						new CrieASenha(USUARIO, frame);
					}
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
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
	
	private boolean enviaEmail(Usuario usuario) {
		String meuEmail = "alohausuario1@gmail.com";
		String senha = "@ADMaloha00";
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, senha));
		email.setSSLOnConnect(true);
		
		try {
			email.setFrom(meuEmail);
			email.setSubject("Bem vindo ao Aloha!");
			email.setMsg("Olá, " + usuario.getPrimeiroNome() + "!");
			email.addTo(usuario.getEmail());
			email.send();
			return true;
			
			
		} catch(Exception e) {
			throw new RuntimeException("Falha ao enviar email. Tem certeza que informou o email correto"); 
		}
	}

}
