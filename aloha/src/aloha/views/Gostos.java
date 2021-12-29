package aloha.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import aloha.modelo.Usuario;
import aloha.util.TextBubbleBorder;
import aloha.util.ViewUtil;

public class Gostos {

	private JFrame frame;
	private JTextField outraFesta;
	private JTextField outraMusica;
	private JTextField outraComida;
	private static Usuario USUARIO;
	private List<ArrayList<Object>> listas = new ArrayList<>();
	private static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gostos window = new Gostos();
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
	public Gostos() {
		initialize();
	}

	public Gostos(Usuario usuario, JFrame frameAnterior) {
		USUARIO = usuario;
		FRAME_ANTERIOR = frameAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Quais são seus gostos?");

		// lbl gostos
		JLabel lbl2 = ViewUtil.criaJLabel(75, 45, 311, 62, "Quais são os seus gostos?", 30);
		frame.getContentPane().add(lbl2);
		//

		// lbl Festas
		JLabel lblFestas = ViewUtil.criaJLabel(45, 114, 411, 45, "Quais são os seus estilos de festa favoritos?", 22);
		frame.getContentPane().add(lblFestas);
		//

		// check box estilos de festa
		ArrayList<Object> listaFesta = new ArrayList<>();
		listas.add(listaFesta);
		
		JCheckBox chboxRave = ViewUtil.criaCheckBox(28, 172, 68, 23, "Rave");
		frame.getContentPane().add(chboxRave);
		listaFesta.add(chboxRave);

		JCheckBox chboxFestival = ViewUtil.criaCheckBox(124, 172, 73, 23, "Festival");
		frame.getContentPane().add(chboxFestival);
		listaFesta.add(chboxFestival);

		JCheckBox chboxShow = ViewUtil.criaCheckBox(225, 172, 59, 23, "Show");
		frame.getContentPane().add(chboxShow);
		listaFesta.add(chboxShow);

		outraFesta = ViewUtil.criaTextField(312, 171, 100, 23, "Outra", 17);
		outraFesta.setBorder(new TextBubbleBorder(Color.BLACK,1,5,0));
		outraFesta.setFocusable(false);
		outraFesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outraFesta.setFocusable(true);
				outraFesta.setText(null);
			}
		});
		frame.getContentPane().add(outraFesta);
		listaFesta.add(outraFesta);
		//

		// lbl musicas
		JLabel lblMusicas = ViewUtil.criaJLabel(39, 220, 423, 45, "Quais são seus estilos de música favoritos?", 22);
		frame.getContentPane().add(lblMusicas);
		//

		// chech box musicas
		ArrayList<Object> listaMusicas = new ArrayList<>();
		listas.add(listaMusicas);
		
		JCheckBox chboxRap = ViewUtil.criaCheckBox(28, 277, 59, 23, "Rap");
		frame.getContentPane().add(chboxRap);
		listaMusicas.add(chboxRap);

		JCheckBox chboxFunk = ViewUtil.criaCheckBox(125, 277, 68, 23, "Funk");
		frame.getContentPane().add(chboxFunk);
		listaMusicas.add(chboxFunk);

		JCheckBox chboxSertanejo = ViewUtil.criaCheckBox(231, 277, 85, 23, "Sertanejo");
		frame.getContentPane().add(chboxSertanejo);
		listaMusicas.add(chboxSertanejo);

		JCheckBox chboxPagode = ViewUtil.criaCheckBox(349, 277, 75, 23, "Pagode");
		frame.getContentPane().add(chboxPagode);
		listaMusicas.add(chboxPagode);

		JCheckBox chboxPop = ViewUtil.criaCheckBox(28, 317, 63, 23, "Pop");
		frame.getContentPane().add(chboxPop);
		listaMusicas.add(chboxPop);

		outraMusica = ViewUtil.criaTextField(125, 317, 100, 23, "Outra", 17);
		outraMusica.setBorder(new TextBubbleBorder(Color.BLACK,1,5,0));
		outraMusica.setFocusable(false);
		outraMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outraMusica.setFocusable(true);
				outraMusica.setText(null);
			}
		});
		frame.getContentPane().add(outraMusica);
		listaMusicas.add(outraMusica);
		//

		// lbl bebidas
		JLabel lblBebidas = ViewUtil.criaJLabel(76, 365, 341, 43, "Quais são suas bebidas favoritas?", 22);
		frame.getContentPane().add(lblBebidas);
		//

		// check box bebidas
		ArrayList<Object> listaBebidas = new ArrayList<>();
		listas.add(listaBebidas);
		
		JCheckBox chboxCerveja = ViewUtil.criaCheckBox(29, 415, 75, 23, "Cerveja");
		frame.getContentPane().add(chboxCerveja);
		listaBebidas.add(chboxCerveja);

		JCheckBox chboxAlcolicas = ViewUtil.criaCheckBox(124, 415, 80, 23, "Alcólicas");
		chboxAlcolicas.setToolTipText("Bebidas alocólicas em geral. Vodka, Uísque, etc.");
		frame.getContentPane().add(chboxAlcolicas);
		listaBebidas.add(chboxAlcolicas);

		JCheckBox chboxRefrigerante = ViewUtil.criaCheckBox(224, 415, 105, 23, "Refrigerante");
		frame.getContentPane().add(chboxRefrigerante);
		listaBebidas.add(chboxRefrigerante);

		JCheckBox chboxAgua = ViewUtil.criaCheckBox(349, 415, 68, 23, "Água");
		frame.getContentPane().add(chboxAgua);
		listaBebidas.add(chboxAgua);
		//

		// lbl comidas
		JLabel lblComidas = ViewUtil.criaJLabel(76, 450, 289, 39, "Quais são suas comidas favoritas?", 22);
		frame.getContentPane().add(lblComidas);
		//

		// check box comida
		ArrayList<Object> listaComidas = new ArrayList<>();
		listas.add(listaComidas);
		
		JCheckBox chboxEspetinho = ViewUtil.criaCheckBox(29, 504, 90, 23, "Espetinho");
		frame.getContentPane().add(chboxEspetinho);
		listaComidas.add(chboxEspetinho);

		JCheckBox chboxComidaBoteco = ViewUtil.criaCheckBox(139, 504, 142, 23, "Comida de boteco");
		frame.getContentPane().add(chboxComidaBoteco);
		listaComidas.add(chboxComidaBoteco);

		JCheckBox chboxLanche = ViewUtil.criaCheckBox(301, 504, 72, 23, "Lanche");
		frame.getContentPane().add(chboxLanche);
		listaComidas.add(chboxLanche);

		JCheckBox chboxPizza = ViewUtil.criaCheckBox(28, 541, 60, 23, "Pizza");
		frame.getContentPane().add(chboxPizza);
		listaComidas.add(chboxPizza);

		outraComida = ViewUtil.criaTextField(139, 541, 100, 23, "Outra", 17);
		outraComida.setBorder(new TextBubbleBorder(Color.BLACK,1,5,0));
		outraComida.setFocusable(false);
		outraComida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outraComida.setFocusable(true);
				outraComida.setText(null);
			}
		});
		frame.getContentPane().add(outraComida);
		listaComidas.add(outraComida);
		//

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(05, 590, 442, 44, "Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (ArrayList<Object> lista : listas) {
					for (Object obj : lista) {
						try {
							if(((JCheckBox) obj).isSelected()) {
								USUARIO.getGostos().add(((JCheckBox) obj).getText());
							}
						} catch (ClassCastException ex) {
							if(!((JTextField) obj).getText().equals("Outra") & 
									!((JTextField) obj).getText().trim().isEmpty()) {
								USUARIO.getGostos().add(((JTextField) obj).getText());
							}
						}
					}
				}
				System.out.println(USUARIO.getGostos());
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
				ConhecerMelhor.FRAME_SEGUINTE = frame;
			}
		});
		//

	}
}
