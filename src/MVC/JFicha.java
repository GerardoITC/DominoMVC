package MVC;


import javax.swing.Icon;
import javax.swing.JButton;

public class JFicha extends JButton{
	int Lado1, Lado2,Jugador;
	public JFicha (int lado1,int lado2,Icon icono,int jugador)
	{
		super(icono);
		Lado1=lado1;
		Lado2=lado2;
		this.Jugador=jugador;
	}
	public void setLado1(int lado1) {
		Lado1 = lado1;
	}
	public void setLado2(int lado2) {
		Lado2 = lado2;
	}
	public int getLado1() {
		return Lado1;
	}
	public int getLado2() {
		return Lado2;
	}
	public int getJugador() {
		return this.Jugador;
	}
	public void setJugador(int jugador) {
		this.Jugador=jugador;
	}
}
