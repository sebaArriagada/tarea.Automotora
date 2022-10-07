package vista;

import automotora.Automotora;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegistroClientes extends Ventana {
	private JLabel textoEncabezado, textoCorreo, textoNombre, textoRut, textoDireccion, textoNumero;
	private JTextField campoTextoCorreo, campoTextoRut, campoTextoDireccion, campoTextoNumero, campoTextoNombre;
	private JButton botonRegistrar, botonCancelar;
	private final Automotora automotora;

	public RegistroClientes(Automotora automotora){
		super("Registro de Clientes", 500, 520);
		this.automotora = automotora;
		generarElementosVentana();
	}
	private void generarElementosVentana(){
		generarEncabezado();
		generarBotonCancelar();
		generarBotonRegistrar();
		generarCampoDireccion();
		generarCampoNombre();
		generarCampoNumeroTelefonico();
		generarCampoRut();
		generarCampoCorreo();
	}
	private void generarEncabezado(){
		String textoCabecera = "Registro de Clientes";
		super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

	}
	private void generarBotonRegistrar(){
		String textoBoton= "Registrar Cliente";
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
		String textoNombre= "Nombre:";
		super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
		this.campoTextoNombre= super.generarJTextField(200,50,250,20);
		this.add(this.campoTextoNombre);
	}
	private void generarCampoRut(){
		String textoRut= "Rut:";
		super.generarJLabel(this.textoRut,textoRut,20,100,150,20);
		this.campoTextoRut= super.generarJTextField(200,100,250,20);
		this.add(this.campoTextoRut);
	}
	private void generarCampoDireccion(){
		String textoDireccion= "Dirección:";
		super.generarJLabel(this.textoDireccion,textoDireccion,20,150,150,20);
		this.campoTextoDireccion= super.generarJTextField(200,150,250,20);
		this.add(this.campoTextoDireccion);
	}
	private void generarCampoCorreo(){
		String textoCorreo= "Correo electrónico:";
		super.generarJLabel(this.textoCorreo,textoCorreo,20,200,150,20);
		this.campoTextoCorreo= super.generarJTextField(200,200,250,20);
		this.add(this.campoTextoCorreo);
	}
	private void generarCampoNumeroTelefonico(){
		String textoNumero= "Número telefónico:";
		super.generarJLabel(this.textoNumero,textoNumero,20,250,150,20);
		this.campoTextoNumero= super.generarJTextField(200,250,250,20);
		this.add(this.campoTextoNumero);
	}
	private boolean registrarCliente(){
		return automotora.agregarUsuario(this.campoTextoNombre.getText(),this.campoTextoDireccion.getText(),this.campoTextoNumero.getText(),
				this.campoTextoCorreo.getText(), this.campoTextoRut.getText());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.botonRegistrar) {
			if(registrarCliente()) {
				JOptionPane.showMessageDialog(this,"Cliente registrado correctamente");
				MenuPrincipal menuPrincipal = new MenuPrincipal(automotora);
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this,"Ingrese un rut válido");
			}

		}
		if (e.getSource() == this.botonCancelar){
			MenuPrincipal menuPrincipal = new MenuPrincipal(automotora);
			this.dispose();
		}
	}
}