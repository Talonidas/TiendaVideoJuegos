package Default;

import java.util.Arrays;

public class Trabajador extends User{
	
	public Trabajador(String nombre, String typeID, String identificacion, String telefono) {
		super(nombre, typeID, identificacion, telefono);
	}
	
	public int findIndexProducto(String idProd) throws ENoEncontrado{  //Encuentra el indice del producto basado en el ID
		int i = 0;
		while(i<listaProductos.length && !(listaProductos[i].getSerial().equals(idProd))){
			i++;
		}
		if(i == listaProductos.length) {
			throw new ENoEncontrado(idProd);
		}
		return i;	
	}
	
	public static double calcularPrecios(Producto[] p) {
		double price = 0;
		for(int i = 0; i < p.length; i++) {
			price += p.getPrecio();
		}
		return price;
	}
	
	public static void VenderProductos(Producto[] p) throws ENoEncontrado{
		for(int i = 0; i < p; i++) {
			int j = findIndexProducto(p[i].getSerial()); //Encuentra un punto donde el serial del producto en listaProductos es igual 
			listaProductos[j].actualizarStock(-p[i].getCantidad());
		}
	}
	
	
	////////////////////////////Getters y setters
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getTypeID() {
		return typeID;
	}
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
