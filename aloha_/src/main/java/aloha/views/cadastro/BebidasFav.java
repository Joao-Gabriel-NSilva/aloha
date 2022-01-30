package aloha.views.cadastro;

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
import javax.swing.SwingConstants;

import aloha.DAO.UsuarioDAO;
import aloha.modelo.Usuario;
import aloha.util.ViewUtil;
import aloha.views.main.ViewInicial;

public class BebidasFav {

	private JFrame frame;
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
					BebidasFav window = new BebidasFav();
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
	public BebidasFav() {
		initialize();
	}
	
	public BebidasFav(Usuario usuario, JFrame frame) {
		USUARIO = usuario;
		FRAME_ANTERIOR = frame;
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
		frame.setTitle("Nos diga suas bebidas favoritas");

		// lbls quais seus estilos de musica
		JLabel lblBebidasFav = new JLabel("Quais são suas bebidas favoritas? ");
		lblBebidasFav.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebidasFav.setForeground(Color.BLACK);
		lblBebidasFav.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblBebidasFav.setBounds(10, 83, 434, 37);
		frame.getContentPane().add(lblBebidasFav);
		//

		// lbl Cerveja
		JLabel lblCerveja = new JLabel("Cerveja");
		lblCerveja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblCerveja.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblCerveja.setForeground(Color.BLACK);
					} else {
						lblCerveja.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblCerveja.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblCerveja.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblCerveja.getText());
				}
			}
		});
		lblCerveja.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerveja.setForeground(Color.BLACK);
		lblCerveja.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblCerveja.setBounds(10, 200, 434, 37);
		frame.getContentPane().add(lblCerveja);
		//

		// lbl Vodka
		JLabel lblVodka = new JLabel("Vodka");
		lblVodka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblVodka.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblVodka.setForeground(Color.BLACK);
					} else {
						lblVodka.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblVodka.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblVodka.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblVodka.getText());
				}
			}
		});
		lblVodka.setHorizontalAlignment(SwingConstants.CENTER);
		lblVodka.setForeground(Color.BLACK);
		lblVodka.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblVodka.setBounds(10, 250, 434, 37);
		frame.getContentPane().add(lblVodka);
		//

		// lbl uisque
		JLabel lblUisque = new JLabel("Uísque");
		lblUisque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblUisque.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblUisque.setForeground(Color.BLACK);
					} else {
						lblUisque.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblUisque.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblUisque.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblUisque.getText());
				}
			}
		});
		lblUisque.setHorizontalAlignment(SwingConstants.CENTER);
		lblUisque.setForeground(Color.BLACK);
		lblUisque.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblUisque.setBounds(10, 300, 434, 37);
		frame.getContentPane().add(lblUisque);
		//

		// lbl agua
		JLabel lblAgua = new JLabel("Água");
		lblAgua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblAgua.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblAgua.setForeground(Color.BLACK);
					} else {
						lblAgua.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblAgua.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblAgua.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblAgua.getText());
				}
			}
		});
		lblAgua.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgua.setForeground(Color.BLACK);
		lblAgua.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblAgua.setBounds(10, 350, 434, 37);
		frame.getContentPane().add(lblAgua);
		//

		// lbl tequila
		JLabel lblTequila = new JLabel("Tequila");
		lblTequila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblTequila.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblTequila.setForeground(Color.BLACK);
					} else {
						lblTequila.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblTequila.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblTequila.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblTequila.getText());
				}
			}
		});
		lblTequila.setHorizontalAlignment(SwingConstants.CENTER);
		lblTequila.setForeground(Color.BLACK);
		lblTequila.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblTequila.setBounds(10, 400, 434, 37);
		frame.getContentPane().add(lblTequila);
		//

		// lbl batida
		JLabel lblBatida = new JLabel("Batida");
		lblBatida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblBatida.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblBatida.setForeground(Color.BLACK);
					} else {
						lblBatida.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblBatida.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblBatida.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblBatida.getText());
				}
			}
		});
		lblBatida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatida.setForeground(Color.BLACK);
		lblBatida.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblBatida.setBounds(10, 450, 434, 37);
		frame.getContentPane().add(lblBatida);
		//

		// lbl refri
		JLabel lblRock = new JLabel("Refrigerante");
		lblRock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblRock.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblRock.setForeground(Color.BLACK);
					} else {
						lblRock.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblRock.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblRock.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblRock.getText());
				}
			}
		});
		lblRock.setHorizontalAlignment(SwingConstants.CENTER);
		lblRock.setForeground(Color.BLACK);
		lblRock.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblRock.setBounds(10, 500, 434, 37);
		frame.getContentPane().add(lblRock);
		//

		// btn avancar
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO.cadastra(USUARIO);
				frame.setVisible(false);
				ViewInicial.main(null);
			}
		});
		btnAvancar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAvancar.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
					btnAvancar.setForeground(Color.BLACK);
				} else {
					btnAvancar.setForeground(Color.WHITE);
				}
			}
		});
		btnAvancar.setOpaque(true);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnAvancar.setFocusable(false);
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setBorderPainted(false);
		btnAvancar.setBounds(149, 697, 155, 44);
		frame.getContentPane().add(btnAvancar);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar();
		frame.getContentPane().add(lblVoltar);

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				MusicasFav.FRAME_SEGUINTE = frame;
			}
		});
		//
	}

}
