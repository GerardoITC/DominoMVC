package Paneles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.JPanel;

import MVC.JFicha;
import Rutinas.ListaSencilla;
import Rutinas.Nodo;

import javax.swing.Box;
import javax.swing.ImageIcon;

public class JPanelCentro extends JPanel {
	private Image imagen;
	private Box horizontal;
	private ScrollPane Sp;
	private JPanel pfichas;

	public JPanelCentro() {
		//imagen = new ImageIcon(getClass().getResource("tablero.jpg")).getImage();
		colorFondo(true);
		setLayout(new GridLayout(1,1));
	}

//	@Override
//	public void paint(Graphics g) {
//		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
//
//		setOpaque(false);
//		super.paint(g);
//	}
	public void colorFondo(boolean b) {
		Color color=new Color(10, 152, 153);
		if(b)
		setBackground(color);
		else 
			setBackground(null);
	}
	public void fichasMesa(ListaSencilla<JFicha> fichas) {
		// Pintar las fichas en un panel 4x7
		removeAll();
		pfichas=new JPanel();
		pfichas.setLayout(new GridLayout(4,7));

		while(fichas.Retirar(1)) {
			pfichas.add(fichas.getDr());
		}
		pfichas.setVisible(true);
		add(pfichas);
		validate();
	}

	public void setFichasTiradas(ListaSencilla<JFicha> fichasTiradas) {
		// pintar las fichas en un box horizontal con sp
		removeAll();
		horizontal = Box.createHorizontalBox();
		Sp = new ScrollPane();
		Sp.add(horizontal);

		Nodo<JFicha> aux = fichasTiradas.getFrente();
		while(aux!=null) {
			horizontal.add(aux.getInfo());
			aux=aux.getSig();
		}
		horizontal.setVisible(true);
		add(Sp);
		validate();
	}

	public void limpiarPanelCentro() {
		horizontal = Box.createHorizontalBox();
		horizontal.removeAll();
		horizontal.validate();
		pfichas=new JPanel();
		removeAll();
		validate();
		
	}
	

}
