package Rutinas;

public class Nodo <T>{
	
	private Nodo<T> Sig;
	private T       Info;
	public Nodo(T Dato){
		Info=Dato;
		Sig=null;
	}
	public Nodo<T> getSig() {
		return Sig;
	}
	public void setSig(Nodo<T> sig) {
		Sig = sig;
	}
	public T getInfo(){
		return Info;
	}
	
}
