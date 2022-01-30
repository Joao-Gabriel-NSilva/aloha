package aloha.views.cadastro;

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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 460, 840);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Informe seu email!");

		// label informe email
		JLabel lblInforme = new JLabel("Informe seu e-mail!");
		lblInforme.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lblInforme.setBounds(113, 52, 228, 62);
		lblInforme.setForeground(Color.BLACK);
		//JLabel lblInforme = ViewUtil.criaJLabel(127, 52, 228, 62, "Informe seu e-mail!", 32);
		frame.getContentPane().add(lblInforme);
		//

		// label 2, 3 e 4
		JLabel lbl2 = new JLabel("Precisamos do seu email. Vamos usa-lo");
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(9, 169, 435, 36);
		lbl2.setForeground(Color.BLACK);
		//JLabel lbl2 = ViewUtil.criaJLabel(47, 169, 388, 36, "Precisamos do seu email. Vamos usa-lo", 25);
		frame.getContentPane().add(lbl2);

		JLabel lbl3 = new JLabel("para enviar informações importantes");
		lbl3.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setBounds(5, 196, 444, 36);
		lbl3.setForeground(Color.BLACK);
		//JLabel lbl3 = ViewUtil.criaJLabel(47, 196, 388, 36, "para enviar informações importantes", 25);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("para você.");
		lbl4.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setBounds(9, 223, 435, 36);
		lbl4.setForeground(Color.BLACK);
		//JLabel lbl4 = ViewUtil.criaJLabel(47, 223, 266, 36, "para você.", 25);
		frame.getContentPane().add(lbl4);
		//

		// text field email
		textFieldEmail = ViewUtil.criaTextField(20, 273, 400, 69, null, 25);
		textFieldEmail.setToolTipText("Seu e-mail");
		frame.getContentPane().add(textFieldEmail);
		//

		// botão avançar
		btnAvancar = new JButton("Avançar");
		btnAvancar.setOpaque(true);
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnAvancar.setBounds(157, 450, 140, 44);
		btnAvancar.setFocusable(false);
		btnAvancar.setBorderPainted(false);
		//btnAvancar = ViewUtil.criaBotao(160, 450, 140, 44, "Avançar");
		frame.getContentPane().add(btnAvancar);

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(EMAIL_ENVIADO == false) {
						USUARIO.setEmail(textFieldEmail.getText());
						
						Runnable tarefa = new TarefaEnviaEmail(USUARIO, true);
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
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAvancar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnAvancar.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		if(frame.getContentPane().getBackground().equals(Color.WHITE)) {
        			btnAvancar.setForeground(Color.BLACK);
        		} else {
        			btnAvancar.setForeground(Color.WHITE);
        		}
        	}
        });
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar();
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
