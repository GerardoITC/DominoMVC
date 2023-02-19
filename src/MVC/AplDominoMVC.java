package MVC;

public class AplDominoMVC {
	
	public static void main(String A[]) {
		VistaDomino vista = new VistaDomino();
		ModeloDomino modelo = new ModeloDomino();
		ControladorDomino controlador = new ControladorDomino(vista,modelo);
		
		vista.setControlador(controlador);
	}

}
