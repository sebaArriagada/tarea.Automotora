package automotora;

public class Vendedor extends Persona{
    public int edad;

    public Vendedor(String nombre, String run, int edad){
        super(nombre,run);
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return super.nombre + "," + super.run + "," + this.edad;
    }

    public double obtenerDescuento(){
        return 0.9;
    }
}
