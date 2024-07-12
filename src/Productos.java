public class Productos {
    //codigo_producto, nombre, descripcion, precio, cantidad, categoria
    String codigo_producto;
    String nombre;
    String descripcion;
    double precio;
    int cantidad;
    String categoria;
    public Productos() {}

    public Productos(String codigo_producto, String nombre, String descripcion, double precio, int cantidad, String categoria) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
