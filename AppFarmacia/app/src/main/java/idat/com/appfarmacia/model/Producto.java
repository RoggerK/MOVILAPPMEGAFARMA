package idat.com.appfarmacia.model;

public class Producto {
    String urlImg;
    String nombre;
    String marca;
    String precio;
    

    public Producto() {
    }

    public Producto(String urlImg, String nombre, String marca, String precio) {
        this.urlImg = urlImg;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
