package controller;

import data.GestorDatos;
import automotora.Automotora;
import automotora.ColorVehiculo;
import automotora.MarcaVehiculo;
import automotora.Vehiculo;
import java.util.List;

public class AutomotoraController {

	public static Automotora cargaMasivaDatos(Automotora automotora){
		GestorDatos.leerArchivoVendedores(automotora, "vendedores.txt");
		GestorDatos.leerArchivoClientes(automotora, "usuarios.txt");
		GestorDatos.leerArchivoVehiculos(automotora, "vehiculos.txt");
		return automotora;
	}
	public static List buscarVehiculo(Automotora automotora, String modelo){
		return automotora.buscarAutoNombre(modelo);
	}
	public static Vehiculo agregarVehiculo(Automotora automotora, String modelo, ColorVehiculo color, MarcaVehiculo marca, int anio, int precio, double kilometraje){
		return automotora.agregarVehiculo(modelo,color,marca,anio,precio,kilometraje);
	}
	public static boolean removerVehiculo(Automotora automotora, String modelo, int anio){
		return automotora.removerVehiculo(modelo,anio);
	}
	public static void almacenarDatos(Automotora automotora){
		GestorDatos.registrarDatos(automotora.getUsuarios(),"usuarios.txt");
		GestorDatos.registrarDatos(automotora.getVendedores(),"vendedores.txt");
		GestorDatos.registrarDatos(automotora.getVehiculosAVenta(),"vehiculos.txt");
	}
}