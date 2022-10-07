package automotora;

import utils.GestorPDF;
import utils.ValidadorRut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Automotora {

	private List<Vehiculo> vehiculosAVenta;
	private List<Vehiculo> vehiculosVendidos;
	private List<Vendedor> vendedores;
	private List<Venta> ventas;
	private List<Usuario> usuarios;

	public Automotora() {
		this.vehiculosAVenta = new ArrayList<Vehiculo>();
		this.vehiculosVendidos = new ArrayList<Vehiculo>();
		this.vendedores = new ArrayList<Vendedor>();
		this.ventas = new ArrayList<Venta>();
		this.usuarios = new ArrayList<Usuario>();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public Venta generarVenta(String runVendedor, String runUsuario, Vehiculo vehiculo) throws IOException {
		Vendedor vendedor = this.buscarVendedor(runVendedor);
		Persona comprador = this.buscarUsuario(runUsuario);
		Venta venta = new Venta(vehiculo, (Usuario) comprador, vendedor);
		this.ventas.add(venta);
		GestorPDF gestorPDF= new GestorPDF();
		gestorPDF.generarBoleta(venta);
		return venta;
	}

	public Vendedor buscarVendedor(String rut) {
		Vendedor vendedor = null;
		for (Vendedor vendedorAux : this.vendedores) {
			if (vendedorAux.getRun().equals(rut)) {
				vendedor = vendedorAux;
				break;
			}
		}
		return vendedor;
	}

	public Persona buscarUsuario(String rut) {
		Persona usuario = null;
		for (Usuario usuarioAux : this.usuarios) {
			if (usuarioAux.getRun().equals(rut)) {
				usuario = usuarioAux;
				break;
			}
		}
		if(usuario==null){
			for (Vendedor vendedorAux : this.vendedores) {
				if (vendedorAux.getRun().equals(rut)) {
					usuario = vendedorAux;
					break;
				}
			}
		}
		return usuario;
	}

	public boolean agregarVendedor(String nombre, int edad, String rut) {
		if (ValidadorRut.validarDigito(rut) && this.buscarVendedor(rut)==null) {
			Vendedor vendedor = new Vendedor(nombre, rut, edad);
			this.vendedores.add(vendedor);
			//GestorDatos.registrarDato(vendedor,"vendedores.txt");
			return true;
		} else {
			return false;
		}
	}
	public boolean agregarUsuario(String nombre, String direccion, String numeroTelefonico, String correo, String rut) {
		if (ValidadorRut.validarDigito(rut) && this.buscarUsuario(rut)==null) {
			Usuario usuario= new Usuario(nombre,direccion,numeroTelefonico,correo,rut);
			this.usuarios.add(usuario);
			return true;
		} else {
			return false;
		}
	}


	public List<Vehiculo> getVehiculosAVenta() {
		return vehiculosAVenta;
	}

	public List<Vehiculo> getVehiculosVendidos() {
		return vehiculosVendidos;
	}


	public void modificarPrecioVehiculo(String nombre, int anio, int precio) {
		for (Vehiculo auto : this.vehiculosAVenta) {
			if (auto.getModelo().equals(nombre) && auto.getAnios() == anio) {
				auto.setPrecio(precio);
				break;
			}
		}
	}

	public void eliminarVehiculo(Vehiculo vehiculo) {
		this.vehiculosAVenta.remove(vehiculo);
	}

	public boolean removerVehiculo(String modelo, int anio) {
		for (Vehiculo auto : this.vehiculosAVenta) {
			if (auto.getModelo().equals(modelo) && auto.getAnios() == anio) {
				this.vehiculosAVenta.remove(auto);
				return true;
			}

		}
		return false;
	}

	public Vehiculo agregarVehiculo(String modelo, ColorVehiculo color, MarcaVehiculo marca,
									int anio, int precio, double kmRecorridos){
		Vehiculo vehiculo= new Vehiculo(modelo,color,marca,anio,precio,kmRecorridos);
		this.vehiculosAVenta.add(vehiculo);
		// GestorDatos.registrarDato(vehiculo,"vehiculos.txt");
		return vehiculo;
	}
	public void agregarVehiculosPorVender() {
		this.vehiculosAVenta.add(new Vehiculo("Celerio", ColorVehiculo.GRIS, MarcaVehiculo.SUSUKI,
				2018, 5000000, 40000.4));
		this.vehiculosAVenta.add(new Vehiculo("Hilux", ColorVehiculo.BLANCO, MarcaVehiculo.TOYOTA,
				2020, 12000000, 1000));
	}

	public void venderAuto(String nombre, int anios) {
		for (Vehiculo auto : this.vehiculosAVenta) {
			if (auto.getModelo().equals(nombre) && auto.getAnios() == anios) {
				this.vehiculosVendidos.add(auto);
				this.vehiculosAVenta.remove(auto);
				break;
			}
		}
	}

	public List<Vehiculo> buscarAutoNombreForBasico(String modelo) {
		List<Vehiculo> vehiculos = new ArrayList<>();
		for (int i = 0; i < this.vehiculosAVenta.size(); i++) {
			if (this.vehiculosAVenta.get(i).getModelo().equals(modelo)) {
				vehiculos.add(this.vehiculosAVenta.get(i));
			}
		}
		return vehiculos;
	}

	public List<Vehiculo> buscarAutoNombre(String modelo) {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		for (Vehiculo auto : this.vehiculosAVenta) {
			if (auto.getModelo().equals(modelo)) {
				vehiculos.add(auto);
			}
		}
		return vehiculos;
	}

	public List<Vehiculo> buscarAutoMarca(MarcaVehiculo marca) {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		for (Vehiculo auto : this.vehiculosAVenta) {
			if (auto.getMarca().equals(marca)) {
				vehiculos.add(auto);
			}
		}
		return vehiculos;
	}

	public void mostrarAutosLista(List<Vehiculo> vehiculos) {
		for (Vehiculo auto : vehiculos) {
			String datos = "nombre: " + auto.getModelo() + ", marca: " + auto.getMarca() + ", año: " + auto.getAnios()
					+ ", color= " + auto.getColor() + ", precio: " + auto.getPrecio() + ", kmRecorridos: " + auto.getKilometraje();
			System.out.println(datos);
		}
	}
}