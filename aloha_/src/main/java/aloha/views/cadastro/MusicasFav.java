package aloha.views.cadastro;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MusicasFav {

	private JFrame frame;
	private static Usuario USUARIO = new Usuario();
	private static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicasFav window = new MusicasFav();
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
	public MusicasFav() {
		initialize();
	}

	public MusicasFav(Usuario usuario, JFrame frameAnterior) {
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
		// frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Nos diga suas músicas favoritas");

		// lbls quais seus estilos de musica
		JLabel lblQuaisSao = new JLabel("Quais são os seus estilos de músicas");
		lblQuaisSao.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuaisSao.setForeground(Color.BLACK);
		lblQuaisSao.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblQuaisSao.setBounds(6, 61, 441, 37);
		frame.getContentPane().add(lblQuaisSao);

		JLabel lblMsicasFav = new JLabel("favoritos?");
		lblMsicasFav.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsicasFav.setForeground(Color.BLACK);
		lblMsicasFav.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblMsicasFav.setBounds(10, 102, 434, 37);
		frame.getContentPane().add(lblMsicasFav);
		//

		// lbl axe
		JLabel lblAxe = new JLabel("Axé");
		lblAxe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblAxe.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblAxe.setForeground(Color.BLACK);
					} else {
						lblAxe.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblAxe.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblAxe.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblAxe.getText());
				}
			}
		});
		lblAxe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAxe.setForeground(Color.BLACK);
		lblAxe.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblAxe.setBounds(10, 200, 434, 37);
		frame.getContentPane().add(lblAxe);
		//

		// lbl blues
		JLabel lblBlues = new JLabel("Blues");
		lblBlues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblBlues.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblBlues.setForeground(Color.BLACK);
					} else {
						lblBlues.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblBlues.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblBlues.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblBlues.getText());
				}
			}
		});
		lblBlues.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlues.setForeground(Color.BLACK);
		lblBlues.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblBlues.setBounds(10, 250, 434, 37);
		frame.getContentPane().add(lblBlues);
		//

		// lbl eletronicas
		JLabel lblEletronicas = new JLabel("Eletrônicas");
		lblEletronicas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblEletronicas.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblEletronicas.setForeground(Color.BLACK);
					} else {
						lblEletronicas.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblEletronicas.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblEletronicas.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblEletronicas.getText());
				}
			}
		});
		lblEletronicas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEletronicas.setForeground(Color.BLACK);
		lblEletronicas.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblEletronicas.setBounds(10, 300, 434, 37);
		frame.getContentPane().add(lblEletronicas);
		//

		// lbl forro
		JLabel lblForro = new JLabel("Forró");
		lblForro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblForro.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblForro.setForeground(Color.BLACK);
					} else {
						lblForro.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblForro.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblForro.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblForro.getText());
				}
			}
		});
		lblForro.setHorizontalAlignment(SwingConstants.CENTER);
		lblForro.setForeground(Color.BLACK);
		lblForro.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblForro.setBounds(10, 350, 434, 37);
		frame.getContentPane().add(lblForro);
		//

		// lbl funk
		JLabel lblFunk = new JLabel("Funk");
		lblFunk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblFunk.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblFunk.setForeground(Color.BLACK);
					} else {
						lblFunk.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblFunk.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblFunk.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblFunk.getText());
				}
			}
		});
		lblFunk.setHorizontalAlignment(SwingConstants.CENTER);
		lblFunk.setForeground(Color.BLACK);
		lblFunk.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblFunk.setBounds(10, 400, 434, 37);
		frame.getContentPane().add(lblFunk);
		//

		// lbl pop
		JLabel lblPop = new JLabel("Pop");
		lblPop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblPop.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblPop.setForeground(Color.BLACK);
					} else {
						lblPop.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblPop.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblPop.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblPop.getText());
				}
			}
		});
		lblPop.setHorizontalAlignment(SwingConstants.CENTER);
		lblPop.setForeground(Color.BLACK);
		lblPop.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblPop.setBounds(10, 450, 434, 37);
		frame.getContentPane().add(lblPop);
		//

		// lbl rock
		JLabel lblRock = new JLabel("Rock");
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

		// lbl sertanejo
		JLabel lblSertanejo = new JLabel("Sertanejo");
		lblSertanejo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblSertanejo.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblSertanejo.setForeground(Color.BLACK);
					} else {
						lblSertanejo.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblSertanejo.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblSertanejo.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblSertanejo.getText());
				}
			}
		});
		lblSertanejo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSertanejo.setForeground(Color.BLACK);
		lblSertanejo.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblSertanejo.setBounds(10, 550, 434, 37);
		frame.getContentPane().add(lblSertanejo);
		//

		// btn avancar
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				if(FRAME_SEGUINTE != null) {
					FRAME_SEGUINTE.setVisible(true);
				} else {
					new BebidasFav(USUARIO, frame);
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
				FestasFav.FRAME_SEGUINTE = frame;
			}
		});
		//
	}
}
