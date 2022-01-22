package aloha.views.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class GostosTeste {

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
					GostosTeste window = new GostosTeste();
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
	public GostosTeste() {
		initialize();
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
		// frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Nos diga seus gostos");

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		lblVoltar.setLocation(0, 0);
		frame.getContentPane().add(lblVoltar);

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);

		JPanel panelGeral = new JPanel();
		panelGeral.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(panelGeral);
		scrollPane.setBounds(0, 75, 454, 737);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scrollPane);
		GridBagLayout gbl_panelGeral = new GridBagLayout();
		gbl_panelGeral.columnWidths = new int[]{432, 0};
		gbl_panelGeral.rowHeights = new int[]{458, 497, 0};
		gbl_panelGeral.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelGeral.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelGeral.setLayout(gbl_panelGeral);
		
				JPanel panel1 = new JPanel();
				panel1.setBackground(Color.WHITE);
				GridBagConstraints gbc_panel1 = new GridBagConstraints();
				gbc_panel1.fill = GridBagConstraints.BOTH;
				gbc_panel1.insets = new Insets(0, 0, 5, 0);
				gbc_panel1.gridx = 0;
				gbc_panel1.gridy = 0;
				panelGeral.add(panel1, gbc_panel1);
				//

				// lbl forro
				JLabel lblForro = new JLabel("Forró");
				lblForro.setBounds(0, 244, 442, 37);
				lblForro.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (lblForro.getForeground().equals(Color.BLUE)) {
							if (panel1.getBackground().equals(Color.WHITE)) {
								lblForro.setForeground(Color.BLACK);
							} else {
								lblForro.setForeground(Color.WHITE);
							}
							for (int i = 0; i < USUARIO.getGostos().size(); i++) {
								if (USUARIO.getGostos().get(i).equals(lblForro.getText())) {
									USUARIO.getGostos().remove(i);
								}
							}
						} else {
							lblForro.setForeground(Color.BLUE);
							USUARIO.getGostos().add(lblForro.getText());
						}
					}
				});
				panel1.setLayout(null);
				//

				// lbls quais seus estilos de musica
				JLabel lblQuaisSao = new JLabel("Quais são os seus estilos de");
				lblQuaisSao.setBounds(1, 0, 440, 37);
				lblQuaisSao.setHorizontalAlignment(SwingConstants.CENTER);
				lblQuaisSao.setForeground(Color.BLACK);
				lblQuaisSao.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
				panel1.add(lblQuaisSao);
				
						JLabel lblMsicasFav = new JLabel("música favoritos?");
						lblMsicasFav.setBounds(0, 42, 442, 37);
						lblMsicasFav.setHorizontalAlignment(SwingConstants.CENTER);
						lblMsicasFav.setForeground(Color.BLACK);
						lblMsicasFav.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
						panel1.add(lblMsicasFav);
						//

						// lbl blues
						JLabel lblBlues = new JLabel("Blues");
						lblBlues.setBounds(0, 160, 442, 37);
						lblBlues.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (lblBlues.getForeground().equals(Color.BLUE)) {
									if (panel1.getBackground().equals(Color.WHITE)) {
										lblBlues.setForeground(Color.BLACK);
									} else {
										lblBlues.setForeground(Color.WHITE);
									}
									for (int i = 0; i < USUARIO.getGostos().size(); i++) {
										if (USUARIO.getGostos().get(i).equals(lblBlues.getText())) {
											USUARIO.getGostos().remove(i);
										}
									}
								} else {
									lblBlues.setForeground(Color.BLUE);
									USUARIO.getGostos().add(lblBlues.getText());
								}
							}
						});
						//

						// lbl axe
						JLabel lblAxe = new JLabel("Axé");
						lblAxe.setBounds(0, 118, 442, 37);
						lblAxe.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (lblAxe.getForeground().equals(Color.BLUE)) {
									if (panel1.getBackground().equals(Color.WHITE)) {
										lblAxe.setForeground(Color.BLACK);
									} else {
										lblAxe.setForeground(Color.WHITE);
									}
									for (int i = 0; i < USUARIO.getGostos().size(); i++) {
										if (USUARIO.getGostos().get(i).equals(lblAxe.getText())) {
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
						panel1.add(lblAxe);
						lblBlues.setHorizontalAlignment(SwingConstants.CENTER);
						lblBlues.setForeground(Color.BLACK);
						lblBlues.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
						panel1.add(lblBlues);
						//

						// lbl eletronicas
						JLabel lblEletronicas = new JLabel("Eletrônicas");
						lblEletronicas.setBounds(0, 202, 442, 37);
						lblEletronicas.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (lblEletronicas.getForeground().equals(Color.BLUE)) {
									if (panel1.getBackground().equals(Color.WHITE)) {
										lblEletronicas.setForeground(Color.BLACK);
									} else {
										lblEletronicas.setForeground(Color.WHITE);
									}
									for (int i = 0; i < USUARIO.getGostos().size(); i++) {
										if (USUARIO.getGostos().get(i).equals(lblEletronicas.getText())) {
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
						panel1.add(lblEletronicas);
						lblForro.setHorizontalAlignment(SwingConstants.CENTER);
						lblForro.setForeground(Color.BLACK);
						lblForro.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
						panel1.add(lblForro);
						//

						// lbl rock
						JLabel lblRock = new JLabel("Rock");
						lblRock.setBounds(0, 370, 442, 37);
						lblRock.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (lblRock.getForeground().equals(Color.BLUE)) {
									if (panel1.getBackground().equals(Color.WHITE)) {
										lblRock.setForeground(Color.BLACK);
									} else {
										lblRock.setForeground(Color.WHITE);
									}
									for (int i = 0; i < USUARIO.getGostos().size(); i++) {
										if (USUARIO.getGostos().get(i).equals(lblRock.getText())) {
											USUARIO.getGostos().remove(i);
										}
									}
								} else {
									lblRock.setForeground(Color.BLUE);
									USUARIO.getGostos().add(lblRock.getText());
								}
							}
						});
						//

						// lbl pop
						JLabel lblPop = new JLabel("Pop");
						lblPop.setBounds(0, 328, 442, 37);
						lblPop.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (lblPop.getForeground().equals(Color.BLUE)) {
									if (panel1.getBackground().equals(Color.WHITE)) {
										lblPop.setForeground(Color.BLACK);
									} else {
										lblPop.setForeground(Color.WHITE);
									}
									for (int i = 0; i < USUARIO.getGostos().size(); i++) {
										if (USUARIO.getGostos().get(i).equals(lblPop.getText())) {
											USUARIO.getGostos().remove(i);
										}
									}
								} else {
									lblPop.setForeground(Color.BLUE);
									USUARIO.getGostos().add(lblPop.getText());
								}
							}
						});
						//

						// lbl funk
						JLabel lblFunk = new JLabel("Funk");
						lblFunk.setBounds(0, 286, 442, 37);
						lblFunk.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (lblFunk.getForeground().equals(Color.BLUE)) {
									if (panel1.getBackground().equals(Color.WHITE)) {
										lblFunk.setForeground(Color.BLACK);
									} else {
										lblFunk.setForeground(Color.WHITE);
									}
									for (int i = 0; i < USUARIO.getGostos().size(); i++) {
										if (USUARIO.getGostos().get(i).equals(lblFunk.getText())) {
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
						panel1.add(lblFunk);
						lblPop.setHorizontalAlignment(SwingConstants.CENTER);
						lblPop.setForeground(Color.BLACK);
						lblPop.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
						panel1.add(lblPop);
						lblRock.setHorizontalAlignment(SwingConstants.CENTER);
						lblRock.setForeground(Color.BLACK);
						lblRock.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
						panel1.add(lblRock);
						//

						// lbl sertanejo
						JLabel lblSertanejo = new JLabel("Sertanejo");
						lblSertanejo.setBounds(0, 412, 442, 37);
						lblSertanejo.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (lblSertanejo.getForeground().equals(Color.BLUE)) {
									if (panel1.getBackground().equals(Color.WHITE)) {
										lblSertanejo.setForeground(Color.BLACK);
									} else {
										lblSertanejo.setForeground(Color.WHITE);
									}
									for (int i = 0; i < USUARIO.getGostos().size(); i++) {
										if (USUARIO.getGostos().get(i).equals(lblSertanejo.getText())) {
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
						panel1.add(lblSertanejo);
		
				///////////////////////////////////////////////////////////////////
		
				JPanel panel2 = new JPanel();
				panel2.setLayout(null);
				panel2.setBackground(Color.WHITE);
				GridBagConstraints gbc_panel2 = new GridBagConstraints();
				gbc_panel2.fill = GridBagConstraints.BOTH;
				gbc_panel2.gridx = 0;
				gbc_panel2.gridy = 1;
				panelGeral.add(panel2, gbc_panel2);
				
						JLabel lblQuaisSao2 = new JLabel("Quais são os seus estilos de músicas");
						lblQuaisSao2.setHorizontalAlignment(SwingConstants.CENTER);
						lblQuaisSao2.setForeground(Color.BLACK);
						lblQuaisSao2.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
						lblQuaisSao2.setBounds(5, 33, 441, 37);
						panel2.add(lblQuaisSao2);
						
								JLabel lblBebidaFav = new JLabel("favoritos?");
								lblBebidaFav.setHorizontalAlignment(SwingConstants.CENTER);
								lblBebidaFav.setForeground(Color.BLACK);
								lblBebidaFav.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
								lblBebidaFav.setBounds(9, 74, 434, 37);
								panel2.add(lblBebidaFav);
								
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
														if (USUARIO.getGostos().get(i).equals(lblCerveja.getText())) {
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
										lblCerveja.setBounds(15, 142, 421, 37);
										panel2.add(lblCerveja);
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
														if (USUARIO.getGostos().get(i).equals(lblVodka.getText())) {
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
										lblVodka.setBounds(9, 182, 434, 37);
										panel2.add(lblVodka);
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
														if (USUARIO.getGostos().get(i).equals(lblUisque.getText())) {
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
										lblUisque.setBounds(9, 222, 434, 37);
										panel2.add(lblUisque);
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
														if (USUARIO.getGostos().get(i).equals(lblAgua.getText())) {
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
										lblAgua.setBounds(9, 262, 434, 37);
										panel2.add(lblAgua);
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
														if (USUARIO.getGostos().get(i).equals(lblTequila.getText())) {
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
										lblTequila.setBounds(9, 302, 434, 37);
										panel2.add(lblTequila);
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
														if (USUARIO.getGostos().get(i).equals(lblBatida.getText())) {
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
										lblBatida.setBounds(9, 342, 434, 37);
										panel2.add(lblBatida);
										//

										// lbl refri
										JLabel lblRefrigerante = new JLabel("Refrigerante");
										lblRefrigerante.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent e) {
												if (lblRefrigerante.getForeground().equals(Color.BLUE)) {
													if (frame.getContentPane().getBackground().equals(Color.WHITE)) {
														lblRefrigerante.setForeground(Color.BLACK);
													} else {
														lblRefrigerante.setForeground(Color.WHITE);
													}
													for (int i = 0; i < USUARIO.getGostos().size(); i++) {
														if (USUARIO.getGostos().get(i).equals(lblRefrigerante.getText())) {
															USUARIO.getGostos().remove(i);
														}
													}
												} else {
													lblRefrigerante.setForeground(Color.BLUE);
													USUARIO.getGostos().add(lblRefrigerante.getText());
												}
											}
										});
										lblRefrigerante.setHorizontalAlignment(SwingConstants.CENTER);
										lblRefrigerante.setForeground(Color.BLACK);
										lblRefrigerante.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
										lblRefrigerante.setBounds(9, 382, 434, 37);
										panel2.add(lblRefrigerante);
		//

	}
}
