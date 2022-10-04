package automotora;
public class Vehiculo {
	private String modelo;
	private int anios;
	private int precio;
	private double kilometraje;
	private String color;
	private String marca;
	public Automotora automotora;

	public String getModelo() {
		return this.modelo;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return this.marca;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getAniosos() {
		return this.anios;
	}

	public double getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public Vehiculo(String modelo, String color, String marca, int precio, int anios, double kilometraje) {
		this.modelo = modelo;
		this.color = color;
		this.marca = marca;
		this.precio = precio;
		this.anios = anios;
		this.kilometraje = kilometraje;
	}
}