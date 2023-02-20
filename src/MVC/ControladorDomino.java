package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Rutinas.*;

public class ControladorDomino implements ActionListener {
	private VistaDomino vista;
	private ModeloDomino modelo;

	public ControladorDomino(VistaDomino vista, ModeloDomino modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.btnOriginal) {
			original();
			return;
		}
		if (e.getSource() == vista.btnRevolver) {
			revolver();
			return;
		}
		if (e.getSource() == vista.btnRepartir) {
			repartir();
			return;
		}
		if (e.getSource() == vista.btnPaso1) {
			gestionaPase(0);
			return;
		}
		if (e.getSource() == vista.btnPaso2) {
			gestionaPase(1);
			return;
		}
		if (e.getSource() == vista.btnPaso3) {
			gestionaPase(2);
			return;
		}
		if (e.getSource() == vista.btnPaso4) {
			gestionaPase(3);
			return;
		}
		//Si llego aqui es porque se eligio una ficha de un jugador, revisar si es turno del jugador
		
		fichaDeMano((JFicha)e.getSource());
		

	}
	private void fichaDeMano(JFicha ficha) {
		if(!this.modelo.revisaTurno(ficha.getJugador())) {
			this.vista.turnoIncorrecto();
			return;
		}
		if(this.modelo.fichaCorrecta(ficha)) {
			//quita la ficha del jugador con ficha.jugador y ficha 
			this.vista.quitaFichaDelJugador(ficha,this);
			//poner las fichas en la Mesa central
			ListaSencilla<JFicha> listaAux = this.modelo.getFichasTiradas();
			
			int turno = this.modelo.getTurno();
			int l1 = this.modelo.getLD1();
			int l2 = this.modelo.getLD2();
			
			if(modelo.revisaSiGano(ficha.getJugador())) {
				this.vista.mensajeGano(ficha.getJugador()+1);
			}
			
			this.vista.setEtiquetas(turno + 1, l1, l2);
			
			this.vista.setFichasTiradas(listaAux);
			return;
		}
		this.vista.mensajeFichaIncorrecta();
		
	}
	private boolean gestionaPase(int btn) {
		if(this.modelo.pasar(btn)) {
			if(this.modelo.todosPasaron()) {
				int ganador = this.modelo.detectaGanador();
				this.vista.mensajeTodosPasaron(ganador+1);
				return true;
			}
			int turno = this.modelo.getTurno();
			int l1 = this.modelo.getLD1();
			int l2 = this.modelo.getLD2();
			this.vista.mensajePasasteTurno();
			this.vista.setEtiquetas(turno + 1, l1, l2);
			return true;
		}
		this.vista.mensajeNoPuedesPasar();
		return false;
	}

	public void repartir() {
		ListaSencilla<JFicha>[] FichasJugadores = this.modelo.repartir();

		this.vista.limpiaJugadores();
		this.vista.setControlador(this, FichasJugadores);
		this.vista.limpiaPanelCentral();
		this.vista.setFichasJugadores(FichasJugadores);

		int turno = this.modelo.getTurno();
		int l1 = this.modelo.getLD1();
		int l2 = this.modelo.getLD2();

		this.vista.setEtiquetas(turno + 1, l1, l2);
		
	}

	public void revolver() {
		ListaSencilla<JFicha> fichas = modelo.revolver();
		this.vista.limpiaJugadores();
		this.vista.setMesaFichas(fichas);

		this.vista.setEtiquetas(-1, -1, -1);
	}

	private void original() {
		ListaSencilla<JFicha> fichas = modelo.original();
		this.vista.setMesaFichas(fichas);

		this.vista.limpiaJugadores();
		this.modelo.limpiaJugadores();

		this.vista.setEtiquetas(-1, -1, -1);
	}

}
