package org.example.aplicacionproductos.Clases.Entidades;

public class ProductoLote {
    public int Lote;
    public String Producto;
    public String Cantidad;
    public Float Precio;

    public ProductoLote(){}
    public ProductoLote(int Lote, String Producto, String Cantidad) {
        this.Lote = Lote;
        this.Producto = Producto;
        this.Cantidad = Cantidad;
    }

}
