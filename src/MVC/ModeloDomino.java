package MVC;

import javax.swing.Icon;
import javax.swing.JButton;

import Rutinas.*;

public class ModeloDomino {
	private ListaSencilla<JFicha> FichasMesa, FichasTiradas;
	private int Turno, LD1, LD2;
	private ListaSencilla<JFicha>[] FichasJugadores;
	private int PasaronConsecutivamente;
	private boolean PrimerTiro;

	public ModeloDomino() {
		this.FichasMesa = new ListaSencilla<JFicha>();
		this.FichasTiradas = new ListaSencilla<JFicha>();
		this.FichasJugadores = new ListaSencilla[4];
		this.Turno = -1;
		this.PasaronConsecutivamente = 0;
		this.PrimerTiro=true;
	}

	public ListaSencilla<JFicha> revolver() {
		this.LD1 = this.LD2 = -1;
		fichasOrdenadas();
		return fichasRevueltas();
	}

	public ListaSencilla<JFicha>[] repartir() {
		revolver();
		this.PrimerTiro=true;
		this.FichasJugadores = new ListaSencilla[4];
		this.FichasTiradas = new ListaSencilla<JFicha>();
		
		FichasJugadores[0] = new ListaSencilla<JFicha>();
		FichasJugadores[1] = new ListaSencilla<JFicha>();
		FichasJugadores[2] = new ListaSencilla<JFicha>();
		FichasJugadores[3] = new ListaSencilla<JFicha>();
		int c = 0;
		Nodo<JFicha> aux = FichasMesa.getFrente();
		while (aux != null) {
			aux.getInfo().setJugador(c);
			String img = "src/imgs/" + aux.getInfo().getLado1() + "x" + aux.getInfo().getLado2() + ".JPG";
			Icon iconoAux =Rutinas.AjustarImagen(img, 50, 50);
			aux.getInfo().setIcon(iconoAux);
			FichasJugadores[c].InsertarFrente(aux.getInfo());
			c++;
			if (c == 4)
				c = 0;
			aux = aux.getSig();
		}
		revisaMula();
		this.LD1 = this.LD2 = 6;
		this.PasaronConsecutivamente = 0;

		return FichasJugadores;
	}

	public void revisaMula() {

		for (int i = 0; i < 4; i++) {
			Nodo<JFicha> aux = FichasJugadores[i].getFrente();
			while (aux != null) {
				if (aux.getInfo().getLado1() == 6 && aux.getInfo().getLado2() == 6) {
					this.Turno = i;
					return;
				}
				aux = aux.getSig();
			}
		}

	}

	public ListaSencilla<JFicha> original() {
		this.LD1 = this.LD2 = -1;
		limpiaJugadores();
		return fichasOrdenadas();
	}

	private ListaSencilla<JFicha> fichasOrdenadas() {
		this.FichasMesa = new ListaSencilla<JFicha>();
		int L1 = 0, L2 = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				String img = "src/imgs/" + L1 + "x" + L2 + ".JPG";
				JFicha fichaAux = new JFicha(L1, L2, Rutinas.AjustarImagen(img, 90, 90), 0);
				this.FichasMesa.InsertarFin(fichaAux);
				L2++;
				if (L2 > 6) {
					L1++;
					L2 = L1;
				}
			}
		}
		return this.FichasMesa;
	}

	private ListaSencilla<JFicha> fichasRevueltas() {
		ListaSencilla<JFicha> listaAux = new ListaSencilla<JFicha>();
		while(FichasMesa.length()>0) {
			FichasMesa.Retirar(Rutinas.nextInt(1,FichasMesa.length()));
			listaAux.InsertarFrente(FichasMesa.getDr());
		}

		this.FichasMesa = listaAux;

		return this.FichasMesa;
	}

	public boolean pasar(int paso) {
		if ((paso) != this.Turno) {
			return false;
		}
		Nodo<JFicha> aux = this.FichasJugadores[paso].getFrente();
		while (aux != null) {
			if (aux.getInfo().getLado1() == this.LD1 || aux.getInfo().getLado1() == this.LD2
					|| aux.getInfo().getLado2() == this.LD1 || aux.getInfo().getLado2() == this.LD2)
				return false;

			aux = aux.getSig();
		}
		this.Turno++;
		if(this.Turno==4)this.Turno=0;
		return true;
	}
	public boolean fichaCorrecta(JFicha ficha) {
		if(PrimerTiro) {
			if(ficha.getLado1()==6 && ficha.getLado2()==6) {
				this.FichasTiradas.InsertarFrente(ficha);
				coincideLado(ficha);
				return true;
			}

			return false;
		}

		if (ficha.getLado1() == this.LD1 ) {
			//pon izqu
			this.FichasTiradas.InsertarFrente(ficha);
			this.LD1=ficha.getLado2();
			coincideLado(ficha);
			return true;
		}
		else if(ficha.getLado2() == this.LD1) {
			//pon izqu
			this.FichasTiradas.InsertarFrente(ficha);
			this.LD1=ficha.getLado1();
			coincideLado(ficha);
			
			return true;
		}
		else if( ficha.getLado1() == this.LD2 ) {
			//Pon derecha
			this.FichasTiradas.InsertarFin(ficha);
			this.LD2=ficha.getLado2();
			coincideLado(ficha);
			
			return true;
		}
		else if(ficha.getLado2() == this.LD2) {
			//Pon derecha
			this.LD2=ficha.getLado1();
			this.FichasTiradas.InsertarFin(ficha);
			coincideLado(ficha);
			
			return true;
		}
		
		return false;
	}
	private void coincideLado(JFicha ficha) {
		PrimerTiro=false;
		this.Turno++;
		if(Turno==4)this.Turno=0;
		PasaronConsecutivamente=0;
		quitarFicaAlJugador(ficha);
	}
	
	public void quitarFicaAlJugador(JFicha ficha) {
		//buscar entre las fichas del jugador para quitarsela
		this.FichasJugadores[ficha.getJugador()].Retirar(ficha);
	}
	public boolean todosPasaron() {
		this.PasaronConsecutivamente++;
		
		if (this.PasaronConsecutivamente == 4)
			return true;

		return false;
	}
	public ListaSencilla<JFicha> getFichasTiradas() {
		return this.FichasTiradas;
	}
	
	public ListaSencilla<JFicha>[] infoJugadores() {
		return this.FichasJugadores;
	}

	public void limpiaJugadores() {
		this.FichasJugadores = new ListaSencilla[4];

		FichasJugadores[0] = new ListaSencilla<JFicha>();
		FichasJugadores[1] = new ListaSencilla<JFicha>();
		FichasJugadores[2] = new ListaSencilla<JFicha>();
		FichasJugadores[3] = new ListaSencilla<JFicha>();
	}

	public int getLD1() {
		return this.LD1;
	}

	public int getLD2() {
		return this.LD2;
	}

	public int getTurno() {
		return this.Turno;
	}

	public int detectaGanador() {
		int menor = 0;
		for (int i = 0; i < 4; i++) {
			if (FichasJugadores[i].length() < FichasJugadores[menor].length())
				menor = i;
		}
		return menor;
	}

	public boolean revisaTurno(int jugador) {
		return jugador==this.Turno;
	}

	public boolean revisaSiGano(int jugador) {
		return !(FichasJugadores[jugador].length()>0);
	}
}
