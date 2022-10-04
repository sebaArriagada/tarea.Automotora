package vista;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.InternationalFormatter;

public class Ventana extends JFrame implements ActionListener{
    private final Font fuenteTitulo;
    private final Font fuenteTexto;
    protected Ventana(String nombre, int largoX, int largoY){
        super(nombre);
        super.setVisible(true);
        super.setDefaultCloseOperation(0);
        super.setSize(largoX, largoX);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        this.setLayout(null);
        this.fuenteTexto = new Font("Calibri", 1, 14);
        this.fuenteTitulo = new Font("Calibri",3 ,20);
    }

    protected void generarJLabelEncabezado(JLabel label, String texto, int posicionX, int posicionY, int largoX, int largoY){
        label = new JLabel(texto);
        label.setBounds(posicionX, posicionY, largoX, largoY);
        label.setFont(this.fuenteTitulo);
        this.add(label);
    }

    protected JButton generarBoton(String texto, int posicionX, int posicionY, int largoX, int largoY){
        JButton boton = new JButton(texto);
        boton.setBounds(posicionX, posicionY, largoX, largoY);
        boton.setFont(this.fuenteTexto);
        return boton;
    }

    protected void generarJLabel(JLabel label, String texto, int posicionX, int posicionY, int largoX, int largoY) {
        label = new JLabel(texto);
        label.setBounds(posicionX, posicionY, largoX, largoY);
        label.setFont(this.fuenteTexto);
        this.add(label);
    }

    
}
