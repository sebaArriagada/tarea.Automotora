package automotora;

public class Usuario extends Persona {

	private String direccion, numeroTelefonico, correo;
	private boolean primeraCompra;

	public Usuario(String nombre, String direccion, String numeroTelefonico, String correo, String run){
		super(nombre, run);
		this.direccion = direccion;
		this.numeroTelefonico = numeroTelefonico;
		this.correo = correo;
		this.primeraCompra = true;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroTelefonico() {
		return this.numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double obtenerDescuento(){
		if (this.primeraCompra = true){
			return 0.8;
		}
		else {
			return 1;
		}
	}
	public String toString(){
		return super.nombre + "," + this.direccion + "," + this.numeroTelefonico + "," + this.correo + "," + super.run;
	}

}