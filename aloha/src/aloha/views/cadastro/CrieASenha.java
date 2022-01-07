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
import aloha.util.ViewUtil;

public class CrieASenha {

	private JFrame frame;
	private JTextField textFieldSenha;
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

	public CrieASenha(Usuario usuario, JFrame frameAnterior) {
		USUARIO = usuario;
		FRAME_ANTERIOR = frameAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Crie uma senha!");

		// label 1
		JLabel lblNewLabel = ViewUtil.criaJLabel(115, 50, 260, 62, "Crie sua senha!", 30);
		frame.getContentPane().add(lblNewLabel);
		//

		// label 2, 3 e 4
		JLabel lbl2 = ViewUtil.criaJLabel(16, 123, 460, 41, "Escolha apenas números com pelo menos 8 dígitos. Não", 20);
		frame.getContentPane().add(lbl2);

		JLabel lbl3 =  ViewUtil.criaJLabel(16, 151, 460, 41, "use números sequenciais (ex: 123 ou 321) "
				+ "ou repetidos", 20);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = ViewUtil.criaJLabel(16, 179, 460, 41, "(ex: 111).", 20);
		frame.getContentPane().add(lbl4);
		//

		// text field senha
		textFieldSenha = ViewUtil.criaTextField(20, 303, 400, 65, null, 26);
		frame.getContentPane().add(textFieldSenha);
		//

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(160, 500, 140, 44, "Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					USUARIO.setSenha(textFieldSenha.getText());
					
					frame.setVisible(false);
					if(FRAME_SEGUINTE != null) {
						FRAME_SEGUINTE.setVisible(true);
					} else {
						new ConhecerMelhor(USUARIO, frame);
					}
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
				FRAME_ANTERIOR.setVisible(true);
				InformeEmail.FRAME_SEGUINTE = frame;
			}
		});
		//
	}

}
