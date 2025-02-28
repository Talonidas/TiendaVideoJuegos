package standard;

import excepciones.EValidacionVariable;
import excepciones.EValorNulo;

public abstract class Producto { // Declaramos Producto como abstract para evitar que se instancie
	
	//Atributos de Producto
	protected String serial; 
	protected int    stock; 
	protected String nombre; 
	protected double precio;
	protected String proveedor; 
	
	//Constructor de producto (es heredado por las subclases)
	public Producto(String serial, int stock, String nombre, double precio, String proveedor) {
		super();
		this.serial = serial;
		this.stock = stock;
		this.nombre = nombre;
		this.precio = precio;
		this.proveedor = proveedor;
	}
	
	// Metodo adicionar Stock
	public void adicionarStock(String cantidadAgregadaString) throws EValorNulo, EValidacionVariable { // Recibimos como String para usar el metodo Integer.parseInt para validar que sea int
		
		try {
			int cantidadAgregada = Integer.parseInt(cantidadAgregadaString); //Metodo validacion que sea un int
			
			if (cantidadAgregada <= 0) //Metodo validacion que no sea negativo o que no sea 0 
				throw new EValorNulo("Agregaste una cantidad invalida..."); // Se lanza este mensaje
			
			this.stock += cantidadAgregada; //Si se ejecuta bien agrega cantidadAgregada
			
			                                // Este catch es importante!
		} catch (NumberFormatException e) { //ATENCION EN ESTA PARTE generalmente nostros atrapamos (catch) la excepcion que creamos nosotros mismos pero aca
			                                // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
			                                // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
			                                // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
			                                // Explicacion  de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
			throw new EValidacionVariable("No ingresaste stock para adicionar..."); 
		} 
	}
	
	// Metodo eliminar Stock
	public void eliminarStock(String cantidadEliminadaString) throws EValorNulo, EValidacionVariable { // Sigue la misma logica del anterior metodo, recibimos string para validar
		
		try {
			int cantidadEliminada = Integer.parseInt(cantidadEliminadaString); //Validamos que si sea int
			
			if (cantidadEliminada <= 0) //Validamos que sea mayor a 0
				throw new EValorNulo("Por favor agrega una cantidad valida..."); 
			
			this.stock -= cantidadEliminada; 
			                                    // Este catch es importante!
			} catch (NumberFormatException e) { // ATENCION EN ESTA PARTE (misma explicacion metodo agregarStock) generalmente nostros atrapamos (catch) la excepcion que creamos pero aca
                                                // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
                                                // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
				                                // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
                                                // Explicacion de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
				throw new EValidacionVariable("No ingresaste stock para adicionar..."); 
			}
	}
	
	//Calcular Precio de venta (es un metodo que podemos cambiar de ubicacion)
	
	//REVISAR PARA SABER DONDE PONER, gracias :)
	public double calcularPrecio(Producto[] productosVenta) throws EValorNulo { //Recibimos como parametro el arreglo de productos que vamos a calcularles el precio
		if (productosVenta == null || productosVenta.length == 0) //Validamos que no este vacio
			throw new EValorNulo("No hay productos para calcularles el precio");
		
		double PrecioFinal = 0;
		
		for(int i = 0; i < productosVenta.length; i++) // Recorremos el arreglo 
			PrecioFinal += productosVenta[i].getPrecio(); //sumamos al PrecioFinal
		
		return PrecioFinal; //Devolvemos precio
	}
	
	// Getters y setters
	public String getSerial() {
		return serial;
	}
	public int getStock() {
		return stock;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	} 
	
	
}
