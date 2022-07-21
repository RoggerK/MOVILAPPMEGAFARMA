package idat.com.appfarmacia.model;

public class ProductoPyP {
    String nombre;
    String precio;
    String precio_unitario;

    public ProductoPyP() {

    }

    public ProductoPyP(String nombre, String precio, String precio_unitario) {
        this.nombre = nombre;
        this.precio = precio;
        this.precio_unitario = precio_unitario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

}
