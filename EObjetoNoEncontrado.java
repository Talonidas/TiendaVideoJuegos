package excepciones;

public class EObjetoNoEncontrado extends Exception{ //Se crea excepcion para cuando una busqueda no se encuentre
	public EObjetoNoEncontrado(String s) {
		super(s);
	}
}
