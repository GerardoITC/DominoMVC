package Rutinas;


public class ListaSencilla<T> {
	private Nodo<T> Frente,Fin;
	private T Dr;
	
	public ListaSencilla(){
		Frente=Fin=null;
		Dr=null;
	}
	public boolean InsertarFrente(T Dato){
		Nodo<T> Nuevo;
		try {
			Nuevo=new Nodo(Dato);
		} catch (Exception E){
			return false;
		}
		if(Frente==null){
			Frente=Fin=Nuevo;
		}
		else{
			Nuevo.setSig(Frente);
			Frente=Nuevo;
		}
			
		return true;
	}
	public boolean InsertarFin(T Dato){
		
		Nodo<T> Nuevo;
		try {
			Nuevo=new Nodo(Dato);
		} catch (Exception E){
			return false;
		}
		
		if(Frente==null){
			Frente=Fin=Nuevo;
		}
		else{
			Fin.setSig(Nuevo);
			Fin=Nuevo;
		}
			
		return true;
	}
	public boolean InsertarOrdenado(T Dato){
		if(Frente==null){
			return InsertarFrente(Dato);
			
		}
		
		String CriterioNuevo=Dato.toString();
		// insertar al inicio
		if(CriterioNuevo.compareTo( Frente.getInfo().toString()     ) <= 0 ){
			return InsertarFrente(Dato);
		}
		//
		if(CriterioNuevo.compareTo( Fin.getInfo().toString()     ) >= 0 ){
			return InsertarFin(Dato);
		}
		Nodo<T> Nuevo;
		try {
			Nuevo=new Nodo(Dato);
		} catch (Exception E){
			return false;
		}
		Nodo<T> Aux=Frente.getSig();
		Nodo<T> Ant=Frente;
		while ( Aux.getInfo().toString().compareTo(CriterioNuevo)<0   ){
			Ant=Aux;
			Aux=Aux.getSig();
		}
		Ant.setSig(Nuevo);
		Nuevo.setSig(Aux);
		return true;
	}
	public boolean Buscar(T Dato){
		int Cont=0;
		Nodo<T> Aux;
		for(Aux=Frente ; Aux != null ; Aux=Aux.getSig()){
			Cont++;
			if(Aux.getInfo().toString().compareTo(Dato.toString())==0)
				break;
		}
		if(Aux==null)
			return false;
		Dr=Aux.getInfo();
		return true;
	}
	
	public boolean Retirar(T Dato){
		
		int Cont=0;
		Nodo<T> Aux;
		for(Aux=Frente ; Aux != null ; Aux=Aux.getSig()){
			Cont++;
			if(Aux.getInfo().toString().compareTo(Dato.toString())==0)
				break;
		}
		if(Aux==null)
			return false;
		return Retirar(Cont);

	}
	public boolean Retirar(int PosicionNodo){
		if(PosicionNodo>length())
			return false;
		Nodo<T> Aux=Frente;
		Nodo<T> Ant=null;
		for(int i=1 ; i<PosicionNodo ; i++){
			Ant=Aux;
			Aux=Aux.getSig();
		}	
		Dr=Aux.getInfo();
		// �nico nodo en la lista
		if(Frente==Fin){
			Frente=Fin=null;
			return true;
		}
		// El primero de la lista
		if(Aux==Frente){
			Frente=Frente.getSig();
			return true;
		}
		// �ltimo nodo de la lista
		if(Aux==Fin){
			Ant.setSig(null);
			Fin=Ant;
			return true;
		}
		//enytre dos nodos
		Ant.setSig(Aux.getSig());
		return true;
	}
	public int length(){
		int Cont=0;
		Nodo<T> Aux;
		for(Aux=Frente ; Aux != null ; Aux=Aux.getSig()){
			Cont++;
		}
		return Cont;
	}
	public T getDr(){
		return Dr;
	}
	
	
	public Nodo<T> getFrente(){
		return Frente;
	}

}
