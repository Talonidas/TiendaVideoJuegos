package standard;
import excepciones.EObjetoNoEncontrado;
import excepciones.EValorNulo;
import excepciones.EValidacionVariable;
import java.util.Arrays;

public class Tienda { //Clase Principal
	
	Producto [] productos; //declaramos arreglo productos
	
	public Tienda() { //Constructor tienda que inisializa el arreglo con 0 posiciones de manera que nosotros vamos agregando. 
		this.productos = new Producto[0]; 
	}
	
	public static void main(String[] args) {
	
	}
	
	//Metodo para buscar un producto
	public Producto buscarProducto(String nombre) throws EValorNulo, EObjetoNoEncontrado{ // La logica es la misma vista en clase 
		if (nombre == null) //Aca validamos que no hayan entradas nulas
			throw new EValorNulo("No ingresaste el nombre del producto..."); //Tiramos excepcion si hay
		
		int i = 0;
		
		while (i < productos.length && !productos[i].getNombre().equalsIgnoreCase(nombre)) { //buscamos en que posicion esta el producto que queremos, usamos ingore case para que sea mas flexible el codigo
			i++; 
		} 
		
		if (i < productos.length) //Validamos si i es menor al tamaño del arreglo es porque lo encontramos
			return productos[i]; //Devolvemos producto en la posicion encontrada
		else {
			throw new EObjetoNoEncontrado("Su producto no fue encontrado"); //Tiramos excepcion si no encontramos el producto
		}
	}
	
	//Metodo para buscar index de un producto
	public int buscarIndexProducto(String nombre) throws EValorNulo, EObjetoNoEncontrado { //Es muy parecido a Buscar Producto solo que en este devolvemos el index
		if (nombre == null) //Aca validamos que no hayan entradas nulas
			throw new EValorNulo("No ingresaste el nombre del producto..."); //Tiramos excepcion si hay
		
		int i = 0;
		
		while (i < productos.length && !productos[i].getNombre().equalsIgnoreCase(nombre)) { //usamos ignore case para que sea mas flexible
			i++; 
		} 
		
		if (i < productos.length) //Validamos si i es menor al tamaño del arreglo es porque lo encontramos
			return i; //Devolvemos la posicion del producto que fue encontrad0
		else {
			throw new EObjetoNoEncontrado("Su producto no fue encontrado"); //Tiramos excepcion si no encontramos el producto
		}
	}
	
	public void agregarHardware(String serial, String stockString, String nombre, String precioString, String proveedor, String tipoHardware) throws EValidacionVariable, EValorNulo {
		// VALIDACION DATOS ENTRADA //
		// Primero verificamos que no tengamos entradas nulas: 
		if (serial == null)
			throw new EValorNulo ("No ingresaste el serial"); 
		
		if (stockString == null)
			throw new EValorNulo ("No ingresaste el stock"); 
		
		if (nombre == null)
			throw new EValorNulo ("No ingresaste el nombre"); 
		
		if (precioString == null)
			throw new EValorNulo ("No ingresaste el precio"); 
		
		if (proveedor == null)
			throw new EValorNulo ("No ingresaste el proveedor"); 
		
		if (tipoHardware == null)
			throw new EValorNulo ("No ingresaste el tipo de hardware"); 
		
		// Ahora validamos stock: int y precio: double
		int stock; 
		double precio; 
		try {                                         // muy similar al metodo de adicionar stock verificamos que el stock si sea un int
			stock = Integer.parseInt(stockString);    // ATENCION EN ESTA PARTE (misma explicacion metodo agregarStock) generalmente nostros atrapamos (catch) la excepcion que creamos pero aca
                                                      // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
                                                      // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
                                                      // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
                                                      // Explicacion de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el stock inicial porfavor ingresa el numero...");
		}
		try {
			precio = Double.parseDouble(precioString);
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el precio porfavor ingresa el precio...");
		}
		
		// Agregamos Hardware luego de validar datos
		productos = Arrays.copyOf(productos, productos.length + 1); 
		productos[productos.length - 1]= new Hardware(serial, stock, nombre, precio, proveedor, tipoHardware);
	}
	
	public void agregarVideojuego(String serial, String stockString, String nombre, String precioString, String proveedor, String compatibilidad,
			Pegi pegi, GeneroVideojuego genero) throws EValorNulo, EValidacionVariable {
		// VALIDACION DATOS ENTRADA //
		if (serial == null)
			throw new EValorNulo ("No ingresaste el serial"); 
		
		if (stockString == null)
			throw new EValorNulo ("No ingresaste el stock"); 
		
		if (nombre == null)
			throw new EValorNulo ("No ingresaste el nombre"); 
		
		if (precioString == null)
			throw new EValorNulo ("No ingresaste el precio"); 
		
		if (proveedor == null)
			throw new EValorNulo ("No ingresaste el proveedor"); 
		
		if (pegi == null)
			throw new EValorNulo ("No ingresaste el pegi"); 
		
		if (genero == null)
			throw new EValorNulo ("No ingresaste el genero"); 
		
		// Ahora validamos stock: int y precio: double
		int stock; 
		double precio; 
		try {                                         // muy similar al metodo de adicionar stock verificamos que el stock si sea un int
			stock = Integer.parseInt(stockString);    // ATENCION EN ESTA PARTE (misma explicacion metodo agregarStock) generalmente nostros atrapamos (catch) la excepcion que creamos pero aca
                                                      // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
                                                      // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
                                                      // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
                                                      // Explicacion de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el stock inicial porfavor ingresa el numero...");
		}
		try {
			precio = Double.parseDouble(precioString);
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el precio porfavor ingresa el precio...");
		}
		
		// Agregamos Videojuegos luego de validar datos
		productos = Arrays.copyOf(productos, productos.length + 1); 
		productos[productos.length - 1]= new Videojuegos(serial, stock, nombre, precio, proveedor, compatibilidad, pegi, genero);
	}
	
	public void agregarMercancia(String serial, String stockString, String nombre, String precioString, String proveedor, String tipo, String sizeString,
			String sizeTypeString, String tematica) throws EValidacionVariable, EValorNulo { //REVISAR ATRIBUTOS MERCANCIA
		// VALIDACION DATOS ENTRADA //
		if (serial == null)
			throw new EValorNulo ("No ingresaste el serial"); 
		
		if (stockString == null)
			throw new EValorNulo ("No ingresaste el stock"); 
		
		if (nombre == null)
			throw new EValorNulo ("No ingresaste el nombre"); 
		
		if (precioString == null)
			throw new EValorNulo ("No ingresaste el precio"); 
		
		if (proveedor == null)
			throw new EValorNulo ("No ingresaste el proveedor"); 
		
		if (tipo == null)
			throw new EValorNulo ("No ingresaste el tipo");
		
		//Revisar --------------------
		if (sizeString == null) // REVISAR este atributo que es?
			throw new EValorNulo("No ingresaste la talla");
		if (sizeTypeString == null) //Revisar este atributo que es?
			throw new EValorNulo("No ingresaste el tipo de tamaño");
		//-------------------------------------
		
		if (tematica == null)
			throw new EValorNulo("No ingresaste la tematica");
		
		// Ahora validamos stock: int y precio: double
		int stock; 
		double precio; 
		
		try {                                         // muy similar al metodo de adicionar stock verificamos que el stock si sea un int
			stock = Integer.parseInt(stockString);    // ATENCION EN ESTA PARTE (misma explicacion metodo agregarStock) generalmente nostros atrapamos (catch) la excepcion que creamos pero aca
                                                      // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
                                                      // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
                                                      // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
                                                      // Explicacion de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el stock inicial porfavor ingresa el numero...");
		}
		try {
			precio = Double.parseDouble(precioString);
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el precio porfavor ingresa el precio...");
		}
		// REVISAR -----------------
		int size; 
		int sizeType; 
		try {                                         // muy similar al metodo de adicionar stock verificamos que el stock si sea un int
			size = Integer.parseInt(sizeString);      // ATENCION EN ESTA PARTE (misma explicacion metodo agregarStock) generalmente nostros atrapamos (catch) la excepcion que creamos pero aca
                                                      // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
                                                      // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
                                                      // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
                                                      // Explicacion de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste la talla porfavor ingresa el numero...");
		}
		
		try {
			sizeType = Integer.parseInt(sizeTypeString);
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el tipo de tamaño porfavor ingresa el numero...");
		}
		
		// Agregamos Mercancia luego de validar datos
		productos = Arrays.copyOf(productos, productos.length + 1); 
		productos[productos.length - 1]= new Mercancia(serial, stock, nombre, precio, proveedor, tipo, size, sizeType, tematica);
	}
	
	public void eliminarProducto(String nombre) throws EValorNulo, EObjetoNoEncontrado {
		int productoEliminar = buscarIndexProducto(nombre); 
		
		for (int i = productoEliminar; i < productos.length - 1; i++) {
			productos[i] =  productos[i + 1]; 
		}
		productos = Arrays.copyOf(productos, productos.length - 1);
	}
	
	public void modificarHardware(String nombreActual, String serial, String stockString, String nombre, String precioString, String proveedor, String tipoHardware) throws EValorNulo, EObjetoNoEncontrado, EValidacionVariable {
		
		if (nombreActual == null)
			throw new EValorNulo ("No ingresaste el nombre actual del hardware"); 
		
		int productoModificar = buscarIndexProducto(nombreActual);
		// Validacion Datos Entrada //
		if (serial == null)
			throw new EValorNulo ("No ingresaste el nuevo serial"); 
		
		if (stockString == null)
			throw new EValorNulo ("No ingresaste el nuevo stock"); 
		
		if (nombre == null)
			throw new EValorNulo ("No ingresaste el nuevo nombre"); 
		
		if (precioString == null)
			throw new EValorNulo ("No ingresaste el nuevo precio"); 
		
		if (proveedor == null)
			throw new EValorNulo ("No ingresaste el nuevo proveedor"); 
		
		if (tipoHardware == null)
			throw new EValorNulo ("No ingresaste el nuevo tipo de hardware"); 
		
		int stock; 
		double precio; 
		try {                                         // muy similar al metodo de adicionar stock verificamos que el stock si sea un int
			stock = Integer.parseInt(stockString);    // ATENCION EN ESTA PARTE (misma explicacion metodo agregarStock) generalmente nostros atrapamos (catch) la excepcion que creamos pero aca
                                                      // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
                                                      // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
                                                      // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
                                                      // Explicacion de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el stock inicial porfavor ingresa el numero...");
		}
		try {
			precio = Double.parseDouble(precioString);
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el precio porfavor ingresa el precio...");
		}
		
		// Atributos de producto
		productos[productoModificar].setSerial(serial);
		productos[productoModificar].setStock(stock);
		productos[productoModificar].setNombre(nombre);
		productos[productoModificar].setPrecio(precio);
		productos[productoModificar].setProveedor(proveedor);
		
		//Para acceder a los atributos propios de cada subclase hay que hacer un "down casting"
		// Atributos especificos de Hardware
		Hardware productoHardware = (Hardware) productos[productoModificar]; // "Creamos una variable de tipo hardware la cual es igual al producto que queremos modificar el (Hardware) es para decirle a java que trate este Producto como Hardware para poder modificarlo."
		productoHardware.setTipoHardware(tipoHardware); // "Aca accedemos normalmente a los metodos set de hardware."
	}
	
	public void modificarVideojuegos(String nombreActual, String serial, String stockString, String nombre, String precioString, String proveedor, String compatibilidad,
			Pegi pegi, GeneroVideojuego genero) throws EValorNulo, EObjetoNoEncontrado, EValidacionVariable {
		
		if (nombreActual == null)
			throw new EValorNulo ("No ingresaste el nombre actual del hardware");
		
		int productoModificar = buscarIndexProducto(nombreActual);
		
		// Validacion de datos 
		
		if (serial == null)
			throw new EValorNulo ("No ingresaste el nuevo serial"); 
		
		if (stockString == null)
			throw new EValorNulo ("No ingresaste el nuevo stock"); 
		
		if (nombre == null)
			throw new EValorNulo ("No ingresaste el nuevo nombre"); 
		
		if (precioString == null)
			throw new EValorNulo ("No ingresaste el nuevo precio"); 
		
		if (proveedor == null)
			throw new EValorNulo ("No ingresaste el nuevo proveedor"); 
		
		if (pegi == null)
			throw new EValorNulo ("No ingresaste el nuevo pegi"); 
		
		if (genero == null)
			throw new EValorNulo ("No ingresaste el nuevo genero"); 
		
		int stock; 
		double precio; 
		try {                                         // muy similar al metodo de adicionar stock verificamos que el stock si sea un int
			stock = Integer.parseInt(stockString);    // ATENCION EN ESTA PARTE (misma explicacion metodo agregarStock) generalmente nostros atrapamos (catch) la excepcion que creamos pero aca
                                                      // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
                                                      // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
                                                      // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
                                                      // Explicacion de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el stock inicial porfavor ingresa el numero...");
		}
		try {
			precio = Double.parseDouble(precioString);
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el precio porfavor ingresa el precio...");
		}
		
		// atributos de producto
		productos[productoModificar].setSerial(serial);
		productos[productoModificar].setStock(stock);
		productos[productoModificar].setNombre(nombre);
		productos[productoModificar].setPrecio(precio);
		productos[productoModificar].setProveedor(proveedor);
		
		//Nuevamente acccedemos a los atributos de videojuegos.
		
		Videojuegos productoVideojuego = (Videojuegos) productos[productoModificar]; 
		productoVideojuego.setCompatibilidad(compatibilidad);
		productoVideojuego.setPegi(pegi);
		productoVideojuego.setGenero(genero);
		
	}
	
	public void modificarMercancia(String nombreActual, String serial, String stockString, String nombre, String precioString, String proveedor, String tipo, String sizeString,
			String sizeTypeString, String tematica) throws EValorNulo, EObjetoNoEncontrado, EValidacionVariable {
		
		if (nombreActual == null)
			throw new EValorNulo ("No ingresaste el nombre actual del hardware"); 
		
		int productoModificar = buscarIndexProducto(nombreActual);
		
		// Validacion Datos Entrada //
		if (serial == null)
			throw new EValorNulo ("No ingresaste el nuevo serial"); 
		
		if (stockString == null)
			throw new EValorNulo ("No ingresaste el nuevo stock"); 
		
		if (nombre == null)
			throw new EValorNulo ("No ingresaste el nuevo nombre"); 
		
		if (precioString == null)
			throw new EValorNulo ("No ingresaste el nuevo precio"); 
		
		if (proveedor == null)
			throw new EValorNulo ("No ingresaste el nuevo proveedor"); 
		
		if (tipo == null)
			throw new EValorNulo ("No ingresaste el tipo");
		
		
		//Revisar --------------------
		if (sizeString == null) // REVISAR este atributo que es?
			throw new EValorNulo("No ingresaste la talla");
		if (sizeTypeString == null) //Revisar este atributo que es?
			throw new EValorNulo("No ingresaste el tipo de tamaño");
		//-------------------------------------
		
		if (tematica == null)
			throw new EValorNulo("No ingresaste la tematica");
		
		int stock; 
		double precio; 
		
		try {                                         // muy similar al metodo de adicionar stock verificamos que el stock si sea un int
			stock = Integer.parseInt(stockString);    // ATENCION EN ESTA PARTE (misma explicacion metodo agregarStock) generalmente nostros atrapamos (catch) la excepcion que creamos pero aca
                                                      // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
                                                      // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
                                                      // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
                                                      // Explicacion de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el stock inicial porfavor ingresa el numero...");
		}
		try {
			precio = Double.parseDouble(precioString);
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el precio porfavor ingresa el precio...");
		}
		
		int size; 
		int sizeType; 
		try {                                         // muy similar al metodo de adicionar stock verificamos que el stock si sea un int
			size = Integer.parseInt(sizeString);      // ATENCION EN ESTA PARTE (misma explicacion metodo agregarStock) generalmente nostros atrapamos (catch) la excepcion que creamos pero aca
                                                      // atrapamos la excepcion NumberFormatException que si le dan click veran que se relaciona a la excepcion que
                                                      // lanza .parseInt, atrapamos esa excepcion e imprimimos el mensaje que nosotros queremos. 
                                                      // Explicacion de Eclipse "parseInt": Throws:NumberFormatException - if the string does not contain aparsable integer.
                                                      // Explicacion de Eclipse NumberFormatException: Thrown to indicate that the application has attempted to converta string to one of the numeric types, but that the string does nothave the appropriate format.
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste la talla porfavor ingresa el numero...");
		}
		
		try {
			sizeType = Integer.parseInt(sizeTypeString);
		} catch (NumberFormatException e) {
			throw new EValidacionVariable("No ingresaste el tipo de tamaño porfavor ingresa el numero...");
		}
		
		//atributos de producto
		productos[productoModificar].setSerial(serial);
		productos[productoModificar].setStock(stock);
		productos[productoModificar].setNombre(nombre);
		productos[productoModificar].setPrecio(precio);
		productos[productoModificar].setProveedor(proveedor);
		
		Mercancia productoMercancia = (Mercancia) productos[productoModificar]; 
		productoMercancia.setTipo(tipo);
		productoMercancia.setSize(size);
		productoMercancia.setSizeType(sizeType);
		productoMercancia.setTematica(tematica);
		
	}
	
	public void adicionarStockMain(String nombre, String cantidadAdicionada) throws EValorNulo, EObjetoNoEncontrado, EValidacionVariable { // Se llama al metodo de producto desde el main
		int productoAdicionarStock = buscarIndexProducto(nombre); 
		
		productos[productoAdicionarStock].adicionarStock(cantidadAdicionada);
	}
	
	public void eliminarStockMain(String nombre, String cantidadEliminada) throws EValorNulo, EObjetoNoEncontrado, EValidacionVariable { // Se llama el metodo de producto desde el main
		int productoEliminarStock = buscarIndexProducto(nombre); 
		
		productos[productoEliminarStock].eliminarStock(cantidadEliminada);
	}
}
