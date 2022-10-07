package vista;

import controller.AutomotoraController;
import automotora.Automotora;
import vista.*;

import javax.swing.*;
import java.awt.event.*;

public class MenuPrincipal extends Ventana {
	private JLabel textoMenu;
	private JButton botonRegistrarCliente;
	private JButton botonRegistrarVehiculo;
	private JButton botonBuscarVehiculo;
	private JButton botonSalida;
	private Automotora automotora;
	public MenuPrincipal(Automotora automotora){
		super("Menu Ventanas", 500, 520);
		this.automotora = automotora;
		generarElementosVentana();
	}
	private void generarElementosVentana(){
		generarMensajeMenu();
		generarBotonRegistrarUsuario();
		generarBotonRegistrarVehiculo();
		generarBotonBuscarVehiculo();
		genenrarBotonSalir();
	}
	private void generarMensajeMenu(){
		String textoBienvenida = "Sistema de Venta de Vehiculos";
		super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
	}
	private void generarBotonRegistrarUsuario(){
		String textoBoton = "Registrar Cliente";
		this.botonRegistrarCliente = super.generarBoton(textoBoton, 175, 100, 150, 40);
		this.add(this.botonRegistrarCliente);
		this.botonRegistrarCliente.addActionListener(this);
	}
	private void generarBotonRegistrarVehiculo(){
		String textoBoton = "Registrar Vehiculo";
		this.botonRegistrarVehiculo = super.generarBoton(textoBoton, 175, 180, 150, 40);
		this.add(this.botonRegistrarVehiculo);
		this.botonRegistrarVehiculo.addActionListener(this);
	}
	private void generarBotonBuscarVehiculo(){
		String textoBoton = "Buscar un Vehiculo";
		this.botonBuscarVehiculo = super.generarBoton(textoBoton, 175, 260, 150, 40);
		this.add(this.botonBuscarVehiculo);
		this.botonBuscarVehiculo.addActionListener(this);
	}
	private void genenrarBotonSalir(){
		String textoBoton = "Salir";
		this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
		this.add(this.botonSalida);
		this.botonSalida.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == this.botonRegistrarCliente){
			RegistroClientes registroClientes = new RegistroClientes(automotora);
			//Cierre Ventana Actual
			this.dispose();
		}
		if (e.getSource() == this.botonRegistrarVehiculo){
			RegistroVehiculos registroVehiculos = new RegistroVehiculos(automotora);
			this.dispose();
		}
		if (e.getSource() == this.botonBuscarVehiculo){
			BuscarVehiculos buscarVehiculos = new BuscarVehiculos(automotora);
			this.dispose();
		}
		if (e.getSource() == this.botonSalida){
			AutomotoraController.almacenarDatos(this.automotora);
			this.dispose();
			System.exit(0);
		}
	}
}