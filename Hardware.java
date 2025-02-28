package standard;

public class Hardware extends Producto{
	
	private String TipoHardware;

	public Hardware(String serial, int stock, String nombre, double precio, String proveedor, String tipoHardware) {
		super(serial, stock, nombre, precio, proveedor);
		
		TipoHardware = tipoHardware;
	}

	public String getTipoHardware() {
		return TipoHardware;
	}

	public void setTipoHardware(String tipoHardware) {
		this.TipoHardware = tipoHardware;
	} 
	
}
