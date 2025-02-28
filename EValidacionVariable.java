package excepciones;

public class EValidacionVariable extends Exception{ //Se crea excepcion para cuando una variable no coincide con el tipo que se espera
	public EValidacionVariable(String s) {
		super(s);
	}
}