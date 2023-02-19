package MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.*;
import Rutinas.*;
import Paneles.JPanelCentro;

public class VistaDomino extends JFrame {
	private JPanelCentro pCentro;
	public JButton btnOriginal, btnRevolver, btnRepartir, btnPaso1, btnPaso2, btnPaso3, btnPaso4;
	private Box panelOpciones, PJ1, PJ2, PJ3, PJ4;
	private JPanel panelSur;
	private JLabel lblTurno, lblNumerosDisponibles;

	public VistaDomino() {
		super("JUEGO DOMINO MVC");
		componentes();
	}

	public void componentes() {
		setSize(800, 680);
		setLocationRelativeTo(null);

		PJ1 = Box.createHorizontalBox();

		PJ2 = Box.createVerticalBox();

		PJ4 = Box.createVerticalBox();

		panelCentro();
		panelSur = new JPanel();
		panelSur.setLayout(new GridLayout(0, 1));
		panelOpciones = Box.createHorizontalBox();

		
		PJ3 = Box.createHorizontalBox();

		panelSur.add(PJ3);
		panelSur.add(panelOpciones);
		

		add(panelSur, BorderLayout.SOUTH);

		btnOriginal = new JButton("Original");
		btnRevolver = new JButton("Revolver");
		btnRepartir = new JButton("Repartir");

		panelOpciones.add(btnOriginal);
		panelOpciones.add(btnRevolver);
		panelOpciones.add(btnRepartir);

		btnPaso1 = new JButton("Pasar J1");
		btnPaso2 = new JButton("Pasar J2");
		btnPaso3 = new JButton("Pasar J3");
		btnPaso4 = new JButton("Pasar J4");

		PJ1.add(btnPaso1);
		PJ2.add(btnPaso2);
		PJ3.add(btnPaso3);
		PJ4.add(btnPaso4);

		add(PJ1, BorderLayout.NORTH);
		add(PJ2, BorderLayout.WEST);
		add(PJ4, BorderLayout.EAST);
		botonesEjemplo();

		lblTurno = new JLabel("Aún no inicia el juego");
		lblNumerosDisponibles = new JLabel("");

		panelOpciones.add(lblTurno);
		panelOpciones.add(lblNumerosDisponibles);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void botonesEjemplo() {
//		PJ1.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),1));
//		PJ1.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),1));
//		PJ1.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),1));
//		PJ1.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),1));
//		PJ1.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),1));
//		PJ1.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),1));
//		PJ1.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),1));
//		
//		PJ2.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),2));
//		PJ2.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),2));
//		PJ2.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),2));
//		PJ2.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),2));
//		PJ2.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),2));
//		PJ2.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),2));
//		PJ2.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),2));
//		
//		PJ3.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),3));
//		PJ3.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),3));
//		PJ3.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),3));
//		PJ3.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),3));
//		PJ3.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),3));
//		PJ3.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),3));
//		PJ3.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),3));
//		
//		
//		PJ4.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),4));
//		PJ4.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),4));
//		PJ4.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),4));
//		PJ4.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),4));
//		PJ4.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),4));
//		PJ4.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),4));
//		PJ4.add(new JFicha(1,1,Rutinas.AjustarImagen("src/imgs/1x1.JPG",50,50),4));
//		
	}

	public void setFichasTiradas(ListaSencilla<JFicha> fichasTiradas) {
		pCentro.setFichasTiradas(fichasTiradas);

	}

	public void setMesaFichas(ListaSencilla<JFicha> fichas) {
		pCentro.fichasMesa(fichas);
	}

	public void panelCentro() {
		pCentro = new JPanelCentro();
		add(pCentro);
	}

	public void mensajeTodosPasaron(int ganador) {
		Rutinas.Mensaje("Todos pasarón, el ganador es: J" + ganador);
	}

	public void mensajeNoPuedesPasar() {
		Rutinas.Mensaje("No puedes pasar, revisa tus fichas o el turno");
	}

	public void setControlador(ControladorDomino c) {
		// ponerle el escuchador a todos los botones
		btnOriginal.addActionListener(c);
		btnRevolver.addActionListener(c);
		btnRepartir.addActionListener(c);

		btnPaso1.addActionListener(c);
		btnPaso2.addActionListener(c);
		btnPaso3.addActionListener(c);
		btnPaso4.addActionListener(c);

	}

	public void setControlador(ControladorDomino c, ListaSencilla<JFicha>[] fichas) {
		for (int i = 0; i < 4; i++) {
			Nodo<JFicha> fichaAux = fichas[i].getFrente();
			while (fichaAux != null) {
				fichaAux.getInfo().addActionListener(c);
				fichaAux = fichaAux.getSig();
			}
		}
	}

	public void setEtiquetas(int turno, int l1, int l2) {

		if (l1 == -1) {
			lblNumerosDisponibles.setText("Aún no incia el juego");
			lblTurno.setText("");
			return;
		}
		lblTurno.setText("Es turno del jugador: " + (turno) + "   -------  ");
		lblNumerosDisponibles.setText("Números disponibles: " + l1 + " y " + l2);
	}

	public void setFichasJugadores(ListaSencilla<JFicha>[] fichasJugadores) {

		int c = 0, k = 0;
		for (int i = 0; i < 28; i++) {
			JFicha aux = consigueFicha(c, k, fichasJugadores);
			refrescaPJ();
			if (c == 0) {
				PJ1.add(aux);
			}
			else if (c == 1) {
				PJ2.add(aux);
			}
			else if (c == 2) {
				PJ3.add(aux);
			}
			else if (c == 3) {
				PJ4.add(aux);
			}
			c++;
			if (c == 4) {
				c = 0;
				k++;
			}
		}
	}
	public void refrescaPJ() {

		update(getGraphics());
		try {
			Thread.sleep(100);
		}catch(Exception e){		
		}
		validate();
		
		
	}
	public JFicha consigueFicha(int c, int k, ListaSencilla<JFicha>[] fichasJugadores) {

		Nodo<JFicha> aux = fichasJugadores[c].getFrente();
		int i = 0;
		while (i < k) {
			aux = aux.getSig();
			i++;
		}
		return aux.getInfo();
	}

	public void limpiaJugadores() {
		PJ1.removeAll();
		PJ2.removeAll();
		PJ3.removeAll();
		PJ4.removeAll();

		PJ1.add(btnPaso1);
		PJ2.add(btnPaso2);
		PJ3.add(btnPaso3);
		PJ4.add(btnPaso4);
	}

	public void limpiaPanelCentral() {
		pCentro.limpiarPanelCentro();
		pCentro.validate();
		pCentro.repaint();
		validate();
	}

	public void turnoIncorrecto() {
		Rutinas.Mensaje("Turno incorrecto");
	}

	public void quitaFichaDelJugador(JFicha ficha, ControladorDomino c) {
		if (ficha.getJugador() == 0) {
			PJ1.remove(ficha);
			PJ1.validate();
			PJ1.repaint();
			efectoQuitarFicha(ficha, c);
			return;
		}
		if (ficha.getJugador() == 1) {
			PJ2.remove(ficha);
			PJ2.validate();
			PJ3.repaint();
			efectoQuitarFicha(ficha, c);
			return;
		}
		if (ficha.getJugador() == 2) {
			PJ3.remove(ficha);
			PJ3.validate();
			PJ3.repaint();
			efectoQuitarFicha(ficha, c);
			return;
		}
		PJ4.remove(ficha);
		PJ4.validate();
		PJ4.repaint();
		efectoQuitarFicha(ficha, c);
	}

	private void efectoQuitarFicha(JFicha ficha, ControladorDomino c) {
		ficha.removeActionListener(c);
		
		// Dormir el hilo
		try {
			Thread.sleep(300); // El tiempo en milisegundos
		} catch (Exception e) {
			// Tratamiento de la excepción
		}
	}

	public void mensajeFichaIncorrecta() {
		Rutinas.Mensaje("Ficha incorrecta");

	}

	public void mensajePasasteTurno() {
		Rutinas.Mensaje("Pasaste turno");

	}

	public void mensajeGano(int j) {
		Rutinas.Mensaje("Felicidades, gano el jugador " + j);

	}

}
