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

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class FestasFav {

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
					FestasFav window = new FestasFav();
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
	public FestasFav() {
		initialize();
	}
	
	public FestasFav(Usuario usuario, JFrame frame) {
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
		frame.setTitle("Nos diga seus eventos favoritos");

		// lbls quais seus estilos de musica
		JLabel lblFestasFav = new JLabel("Quais são seus estilos de eventos");
		lblFestasFav.setHorizontalAlignment(SwingConstants.CENTER);
		lblFestasFav.setForeground(Color.BLACK);
		lblFestasFav.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblFestasFav.setBounds(10, 83, 434, 37);
		frame.getContentPane().add(lblFestasFav);
		//

		// lbl axe
		JLabel lblFestivais = new JLabel("Festivais");
		lblFestivais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblFestivais.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblFestivais.setForeground(Color.BLACK);
					} else {
						lblFestivais.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblFestivais.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblFestivais.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblFestivais.getText());
				}
			}
		});
		lblFestivais.setHorizontalAlignment(SwingConstants.CENTER);
		lblFestivais.setForeground(Color.BLACK);
		lblFestivais.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblFestivais.setBounds(10, 243, 434, 37);
		frame.getContentPane().add(lblFestivais);
		//

		// lbl blues
		JLabel lblShows = new JLabel("Shows");
		lblShows.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblShows.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblShows.setForeground(Color.BLACK);
					} else {
						lblShows.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblShows.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblShows.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblShows.getText());
				}
			}
		});
		lblShows.setHorizontalAlignment(SwingConstants.CENTER);
		lblShows.setForeground(Color.BLACK);
		lblShows.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblShows.setBounds(10, 293, 434, 37);
		frame.getContentPane().add(lblShows);
		//

		// lbl eletronicas
		JLabel lblBares = new JLabel("Bares");
		lblBares.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblBares.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblBares.setForeground(Color.BLACK);
					} else {
						lblBares.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblBares.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblBares.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblBares.getText());
				}
			}
		});
		lblBares.setHorizontalAlignment(SwingConstants.CENTER);
		lblBares.setForeground(Color.BLACK);
		lblBares.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblBares.setBounds(10, 343, 434, 37);
		frame.getContentPane().add(lblBares);
		//

		// lbl forro
		JLabel lblBaladas = new JLabel("Baladas");
		lblBaladas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblBaladas.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblBaladas.setForeground(Color.BLACK);
					} else {
						lblBaladas.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblBaladas.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblBaladas.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblBaladas.getText());
				}
			}
		});
		lblBaladas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaladas.setForeground(Color.BLACK);
		lblBaladas.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblBaladas.setBounds(10, 393, 434, 37);
		frame.getContentPane().add(lblBaladas);
		//

		// lbl funk
		JLabel lblFestasCasuais = new JLabel("Festas casuais");
		lblFestasCasuais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblFestasCasuais.getForeground().equals(Color.BLUE)) {
					if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
						lblFestasCasuais.setForeground(Color.BLACK);
					} else {
						lblFestasCasuais.setForeground(Color.WHITE);
					}
					for (int i = 0; i < USUARIO.getGostos().size(); i++) {
						if(USUARIO.getGostos().get(i).equals(lblFestasCasuais.getText())) {
							USUARIO.getGostos().remove(i);
						}
					}
				} else {
					lblFestasCasuais.setForeground(Color.BLUE);
					USUARIO.getGostos().add(lblFestasCasuais.getText());
				}
			}
		});
		lblFestasCasuais.setHorizontalAlignment(SwingConstants.CENTER);
		lblFestasCasuais.setForeground(Color.BLACK);
		lblFestasCasuais.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblFestasCasuais.setBounds(10, 443, 434, 37);
		frame.getContentPane().add(lblFestasCasuais);
		//

		// btn avancar
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				if(FRAME_SEGUINTE != null) {
					FRAME_SEGUINTE.setVisible(true);
				} else {
					new MusicasFav(USUARIO, frame);
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
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);
		
		JLabel lblFavoritos = new JLabel("favoritos?");
		lblFavoritos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoritos.setForeground(Color.BLACK);
		lblFavoritos.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lblFavoritos.setBounds(10, 120, 434, 37);
		frame.getContentPane().add(lblFavoritos);

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				ConhecerMelhor.FRAME_SEGUINTE = frame;
			}
		});
		//
	}
}
