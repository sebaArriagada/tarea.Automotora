package vista;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame{
    private final String[][] datos;
    private final String[] nombreColumnas;

    public Tabla(String[][] datos, String[] nombreColumnas){
        super("Lista de Datos");
        this.datos = datos;
        this.nombreColumnas = nombreColumnas;
        generarTabla();
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        this.pack();
        this.setVisible(true);
    }
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void generarTabla() {
        DefaultTableModel dtm = new DefaultTableModel(this.datos, this.nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        final JTable tabla = new JTable(dtm);

        tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));
        JScrollPane scrollPane = new JScrollPane(tabla);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
        });
    }

    private void cerrarVentana() {
        this.dispose();
    }
}
