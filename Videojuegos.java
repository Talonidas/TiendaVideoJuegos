package standard;

public class Videojuegos extends Producto {
	private String Compatibilidad;
	private Pegi pegi; 
	private GeneroVideojuego genero;
	
	public Videojuegos(String serial, int stock, String nombre, double precio, String proveedor, String compatibilidad,
			Pegi pegi, GeneroVideojuego genero) { //se reciben todos los atributos
		super(serial, stock, nombre, precio, proveedor); // se llama al constructor de producto
		
		Compatibilidad = compatibilidad;
		this.pegi = pegi;
		this.genero = genero;
	}

	public String getCompatibilidad() {
		return Compatibilidad;
	}

	public Pegi getPegi() {
		return pegi;
	}

	public GeneroVideojuego getGenero() {
		return genero;
	}

	public void setCompatibilidad(String compatibilidad) {
		Compatibilidad = compatibilidad;
	}

	public void setPegi(Pegi pegi) {
		this.pegi = pegi;
	}

	public void setGenero(GeneroVideojuego genero) {
		this.genero = genero;
	}
	
	
}
