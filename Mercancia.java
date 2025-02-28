package standard;

public class Mercancia extends Producto{ //Subclase de producto
	//Atributos propios de la clase
	String tipo; 
	int size;
	int sizeType; 
	String tematica;
	
	//Constructor de Mercancia que hereda de Producto
	public Mercancia(String serial, int stock, String nombre, double precio, String proveedor, String tipo, int size,
			int sizeType, String tematica) {
		super(serial, stock, nombre, precio, proveedor);
		this.tipo = tipo;
		this.size = size;
		this.sizeType = sizeType;
		this.tematica = tematica;
	}
	
	// Getters y Setters de Mercancia
	public String getTipo() {
		return tipo;
	}
	public int getSize() {
		return size;
	}
	public int getSizeType() {
		return sizeType;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setSizeType(int sizeType) {
		this.sizeType = sizeType;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	} 
	
	
}
