package automotora;
import java.util.Date;

public class Venta {
    private Vehiculo vehiculo;
    private Usuario usuario;
    private Vendedor vendedor;
    private Date fecha;

    public Venta(Vehiculo vehiculo, Usuario usuario, Vendedor vendedor){
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.vendedor = vendedor;
        this.fecha = new Date();
    }
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public Vendedor getVendedor(){
        return vendedor;
    }
    public Date getFecha(){
        return fecha;
    }
}
