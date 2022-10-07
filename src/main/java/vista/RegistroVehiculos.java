package vista;

import automotora.Automotora;
import automotora.ColorVehiculo;
import automotora.MarcaVehiculo;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.*;

public class RegistroVehiculos extends Ventana {
	private JLabel textoEncabezado, textoMarca, textoModelo, textoColor, textoAnio, textoPrecio, textoKilometraje;
	private JTextField campoTextoRut, campoTextoNombre, campoTextoDireccion, campoTextoNumero, campoTextoCorreo;
	private JButton botonRegistrar, botonCancelar;
	private JFormattedTextField campoAnio, campoPrecio, campoKilometraje;
	private JComboBox listaMarca, listaColor;
	private Automotora automotora;

	private void generarEncabezado() {
		String textoCabecera = "Registro de Vehículo";
		super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

	}
	public RegistroVehiculos(Automotora automotora){
		super("Registro de Vehículo", 500, 520);
		this.automotora= automotora;
		generarElementosVentana();

	}
	private void generarElementosVentana() {
		generarEncabezado();
		generarListaMarcaVehiculo();
		generarListaColorVehiculo();
		generarCampoNombre();
		generarCampoPrecioVehiculo();
		generarCampoAnioVehiculo();
		generarCampoKmRecorridos();
		generarBotonRegistrar();
		generarBotonCancelar();
	}

	private void generarListaMarcaVehiculo(){
		super.generarJLabel(this.textoMarca,"Marca vehículo:",20,100,100,20);
		String [] arreglo = new String[]{"hola","chao"};
		this.listaMarca =super.generarListaDesplegable(arreglo,120,100, 100, 20);
		this.add(this.listaMarca);
	}
	private void generarListaColorVehiculo(){
		super.generarJLabel(this.textoColor,"Color vehículo:",250,100,100,20);
		this.listaColor =super.generarListaDesplegable(ColorVehiculo.values(),350,100, 100, 20);
		this.add(this.listaColor);
	}

	private void generarBotonRegistrar() {
		String textoBoton= "Registrar Vehículo";
		this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
		this.add(this.botonRegistrar);
		this.botonRegistrar.addActionListener(this);
	}
	private void generarBotonCancelar() {
		String textoBotonCancelar = "Cancelar";
		this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
		this.add(this.botonCancelar);
		this.botonCancelar.addActionListener(this);
	}
	private void generarCampoNombre(){
		String textoNombre= "Modelo Vehículo:";
		super.generarJLabel(this.textoModelo,textoNombre,20,50,150,20);
		this.campoTextoNombre= super.generarJTextField(200,50,250,20);
		this.add(this.campoTextoNombre);
	}
	private void generarCampoAnioVehiculo() {
		super.generarJLabel(this.textoAnio, "Año:", 20, 150, 200, 20);
		InternationalFormatter formato = super.generarFormato(1950);
		this.campoAnio = super.generarJFormattedTextField(formato, 200, 150, 250, 20);
		this.add(this.campoAnio);
	}
	private void generarCampoPrecioVehiculo(){
		super.generarJLabel(this.textoPrecio, "Precio:", 20, 200, 200, 20);
		InternationalFormatter formato = super.generarFormato(0);
		this.campoPrecio = super.generarJFormattedTextField(formato, 200, 200, 250, 20);
		this.add(this.campoPrecio);
	}
	private void generarCampoKmRecorridos(){
		super.generarJLabel(this.textoKilometraje, "Kilómetros recorridos:", 20, 250, 200, 20);
		InternationalFormatter formato = super.generarFormato(0);
		this.campoKilometraje = super.generarJFormattedTextField(formato, 200, 250, 250, 20);
		this.add(this.campoKilometraje);
	}
	private boolean registrarVehiculo(){
		if(this.campoTextoNombre.getText().length()==0 || this.campoKilometraje.getText().length()==0 ||
				this.campoPrecio.getText().length()==0 || this.campoAnio.getText().length()==0 ||
				this.listaColor.getSelectedItem()==null || this.listaMarca.getSelectedItem()==null){
			return false;
		}
		else{
			return true;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.botonRegistrar){
			if(registrarVehiculo()){
				automotora.agregarVehiculo(this.campoTextoNombre.getText(),(ColorVehiculo) this.listaColor.getSelectedItem(),
						(MarcaVehiculo) this.listaMarca.getSelectedItem(),
						Integer.parseInt(this.campoAnio.getText()),Integer.parseInt(this.campoPrecio.getText()),
						Double.parseDouble(this.campoKilometraje.getText()));
				JOptionPane.showMessageDialog(this,"Vehículo registrado correctamente","Mensaje de confirmación",
						JOptionPane.INFORMATION_MESSAGE);
				MenuPrincipal menuPrincipal = new MenuPrincipal(automotora);
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this,"Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == this.botonCancelar){
			MenuPrincipal menuPrincipal = new MenuPrincipal(automotora);
			this.dispose();
		}
	}
}