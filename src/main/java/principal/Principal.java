package principal;

import automotora.Automotora;
import controller.AutomotoraController;
import vista.MenuPrincipal;

public class Principal {

	public class main {
		public static void main(String[] args) {
			Automotora automotora = new Automotora();
			automotora = AutomotoraController.cargaMasivaDatos(automotora);
			MenuPrincipal ventana = new MenuPrincipal(automotora);
		}
	}
}