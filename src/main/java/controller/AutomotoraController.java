package controller;
import automotora.Automotora;
import automotora.Usuario;
import automotora.Vehiculo;
import java.util.ArrayList;
import java.util.List;

public class AutomotoraController {

	private List<Usuario> usuarios;
	private List<Vehiculo> vehiculos;

	public AutomotoraController(){
		this.usuarios = new ArrayList<Usuario>();
		this.vehiculos = new ArrayList<Vehiculo>();
	}

	public Usuario agregarCliente(Usuario usuario) {
		this.usuarios.add(usuario);
		return usuario;
	}

	public Vehiculo agregarVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
		return vehiculo;
	}

	public Vehiculo buscarVehiculo(String modelo) {
		for (Vehiculo vehiculo : this.vehiculos){
			if(vehiculo.getModelo().equals(modelo)){
				return vehiculo;
			}
		}
		//si no hay ningun vehiculo con dicho modelo, retorna nulo
		return null;
	}
}