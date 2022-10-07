package automotora;
public class Vehiculo {
	private String modelo;
	private int anios, precio;
	private double kilometraje;
	private ColorVehiculo color;
	private MarcaVehiculo marca;

	public Vehiculo(String modelo, ColorVehiculo color, MarcaVehiculo marca, int anios, int precio, double kilometraje){
		this.modelo = modelo;
		this.color = color;
		this.marca = marca;
		this.anios = anios;
		this.precio = precio;
		this.kilometraje = kilometraje;
	}

	public Vehiculo(){
		this.modelo = "Sin datos";
		this.color = null;
		this.marca = null;
		this.anios = 0;
		this.kilometraje = 0;
	}
	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	public ColorVehiculo getColor() {
		return color;
	}

	public void setColor(ColorVehiculo color) {
		this.color = color;
	}

	public MarcaVehiculo getMarca() {
		return marca;
	}
	public void setMarca(MarcaVehiculo marca){
		this.marca = marca;
	}
	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getAnios() {
		return this.anios;
	}

	public double getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	@Override
	public String toString(){
		return this.modelo+","+this.color+","+this.marca+
				","+this.anios+","+this.precio+","+this.kilometraje;
	}

}