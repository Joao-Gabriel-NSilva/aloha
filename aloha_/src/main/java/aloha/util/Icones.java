package aloha.util;

import javax.swing.ImageIcon;

public class Icones {

	public ImageIcon getImgVerificado() {
		return new ImageIcon(this.getClass().getResource("/icons/verificado.png"));
	}
	
	public ImageIcon getImgNaoVerificado() {
		return new ImageIcon(this.getClass().getResource("/icons/nao_verificado.png"));
	}
}
