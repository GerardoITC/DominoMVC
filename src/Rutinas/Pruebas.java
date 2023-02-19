package Rutinas;

import MVC.JFicha;
import Paneles.JPanelCentro;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Pruebas extends JFrame {

	private JFicha btnGuardar;
	private JButton btn2;

	public Pruebas() {
		super("PRUEBA");

		setSize(1000, 700);
		setLocationRelativeTo(null);

		JPanelCentro p = new JPanelCentro();

		add(p, BorderLayout.CENTER);
		
		btnGuardar = new JFicha(0, 0, Rutinas.AjustarImagen("src/imgs/0x0.JPG", 50, 50),1);


		p.setLayout(new GridLayout(4, 7));
		for (int i = 0; i < 8; i++) {
			btn2 = new JButton(Rutinas.AjustarImagen("src/imgs/0x0.JPG", 50, 50));
			p.add(btn2);
		}
		p.add(btnGuardar);
		add(new JButton(Rutinas.AjustarImagen("src/imgs/0x1.JPG", 100, 100)), BorderLayout.SOUTH);
		add(new JButton(Rutinas.AjustarImagen("src/imgs/0x1.JPG", 100, 100)), BorderLayout.EAST);
		add(new JButton(Rutinas.AjustarImagen("src/imgs/0x1.JPG", 100, 100)), BorderLayout.WEST);
		add(new JButton(Rutinas.AjustarImagen("src/imgs/0x1.JPG", 100, 100)), BorderLayout.NORTH);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Pruebas();

	}

}
