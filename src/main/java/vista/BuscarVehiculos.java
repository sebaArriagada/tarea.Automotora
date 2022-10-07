package vista;

import automotora.Automotora;
import automotora.MarcaVehiculo;
import automotora.Vehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class BuscarVehiculos extends Ventana{
	private JLabel textoModelo, textoMarca, textoEncabezado;
	private JTextField campoTextoModelo;
	private JComboBox listaMarca;
	private JButton botonBuscar, botonRegresar;
	private Automotora automotora;

	public BuscarVehiculos(Automotora automotora){
		super("Buscar Vehiculo", 500, 520);
		this.automotora = automotora;
		generarElementosVentana();
	}

	protected BuscarVehiculos(String nombre, int largoX, int largoY) {
		super(nombre, largoX, largoY);
	}

	private void generarElementosVentana() {
		generarCampoTextoNombre();
		generarBotonBuscarVehiculo();
		generarBotonCancelar();
		generarListaMarcaVehiculo();
	}

	private void generarCampoTextoNombre() {
		String textoModelo = "Modelo del Vehiculo";
		super.generarJLabel(this.textoModelo, textoModelo, 20,50,150,20);
		this.campoTextoModelo = super.generarJTextField(200,50,250,20);
		this.add(this.campoTextoModelo);
	}

	private void generarListaMarcaVehiculo(){
		super.generarJLabel(this.textoMarca,"Marca vehículo:",20,100,100,20);
		this.listaMarca=super.generarListaDesplegable(MarcaVehiculo.values(),120,100, 100, 20);
		this.add(this.listaMarca);
	}
	private void generarBotonBuscarVehiculo() {
		String textoBoton= "Buscar Vehículo";
		this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
		this.add(this.botonBuscar);
		this.botonBuscar.addActionListener(this);
	}
	private void generarBotonCancelar() {
		String textoBotonRegresar = "Regresar";
		this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
		this.add(this.botonRegresar);
		this.botonRegresar.addActionListener(this);
	}
	private String[][] registrarVehiculo(){
		List<Vehiculo> vehiculos= new ArrayList<>();
		String[][] datosVehiculos;
		if(this.campoTextoModelo.getText().length()==0){
			System.out.println(this.listaMarca.getSelectedItem());
			vehiculos=  automotora.buscarAutoMarca((MarcaVehiculo) this.listaMarca.getSelectedItem());
		}
		else{
			vehiculos= automotora.buscarAutoNombre(this.campoTextoModelo.getText());
		}
		System.out.println(vehiculos.size());
		datosVehiculos = new String[vehiculos.size()][6];
		for(int i=0; i<vehiculos.size(); i++){
			datosVehiculos[i][0]=vehiculos.get(i).getModelo();
			datosVehiculos[i][1]=vehiculos.get(i).getMarca().getMarcaVehiculo();
			datosVehiculos[i][2]= Integer.toString(vehiculos.get(i).getAnios());
			datosVehiculos[i][3]= String.valueOf(vehiculos.get(i).getColor());
			datosVehiculos[i][4]=Integer.toString(vehiculos.get(i).getPrecio());
			datosVehiculos[i][5]=Double.toString(vehiculos.get(i).getKilometraje());
		}
		return datosVehiculos;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.botonBuscar){
			String[] nombreColumnas={"Modelo","Marca","Año","Color","Precio","Kilómetros Recorridos"};
			Tabla ventanaTabla= new Tabla(registrarVehiculo(),nombreColumnas);
		}
		if (e.getSource() == this.botonRegresar){
			MenuPrincipal menuPrincipal = new MenuPrincipal(automotora);
			this.dispose();
		}

	}
}