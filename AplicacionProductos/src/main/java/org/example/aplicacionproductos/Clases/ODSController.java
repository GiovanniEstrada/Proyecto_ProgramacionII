package org.example.aplicacionproductos.Clases;

import org.example.aplicacionproductos.Clases.Entidades.ProductoLote;
import org.example.aplicacionproductos.Clases.Entidades.*;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ODSController extends DBController{

    public ODSController(){
        super("db.user_ods", "db.password_ods", "db.url_ods");
    }

    public boolean crearUsuario(String username, String nombreCompleto){
        try{
            String qryInsertaUsuario = "INSERT INTO `cliente`(`Usuario`, `NombreCompleto`) VALUES ( ?, ?)";
            PreparedStatement ps = conn.prepareStatement(qryInsertaUsuario);
            ps.setString(1, username);
            ps.setString(2, nombreCompleto);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                System.out.println("No se logró crear el usuario");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }

        return false;
    }

    public List<ProductoLote> obtenerLotes(){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT L.Id, P.NombreProducto, L.CantidadRestante FROM lote L LEFT JOIN producto P ON P.Id = L.IdProducto;");
            ResultSet rs = ps.executeQuery();
            List<ProductoLote> listaProductoLote = new ArrayList<ProductoLote>();
            while(rs.next()){
                ProductoLote productoLote = new ProductoLote(
                        rs.getInt("Id"),
                        rs.getString("NombreProducto"),
                        rs.getString("CantidadRestante")
                );

                listaProductoLote.add(productoLote);
            }
            return listaProductoLote;
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }

    public List<ProductoLote> obtenerProductos(){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM producto L LEFT JOIN producto P ON P.Id = L.IdProducto;");
            ResultSet rs = ps.executeQuery();
            List<ProductoLote> listaProductoLote = new ArrayList<ProductoLote>();
            while(rs.next()){
                ProductoLote productoLote = new ProductoLote(
                        rs.getInt("Id"),
                        rs.getString("NombreProducto"),
                        rs.getString("CantidadRestante")
                );

                listaProductoLote.add(productoLote);
            }
            return listaProductoLote;
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }

    public List<TipoProducto> obtenerTipoProducto(){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM `tipoproducto`");
            ResultSet rs = ps.executeQuery();
            List<TipoProducto> listaTipoProducto = new ArrayList<TipoProducto>();
            while(rs.next()){
                TipoProducto tipoProducto = new TipoProducto(
                        rs.getInt("Id"),
                        rs.getString("Descripcion")
                );

                listaTipoProducto.add(tipoProducto);
            }
            return listaTipoProducto;
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }

    public boolean ingresaProducto(int tipoProducto, String nombreProducto, BigDecimal precioUnidad){
        try{
            String qryInsertaProducto = "INSERT INTO `producto`(`TipoProducto`, `NombreProducto`, `PrecioUnidad`) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(qryInsertaProducto);
            ps.setInt(1, tipoProducto);
            ps.setString(2, nombreProducto);
            ps.setBigDecimal(3, precioUnidad);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                System.out.println("No se logró crear el producto");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al crear el producto: " + e.getMessage());
        }

        return false;
    }

    public List<Producto> obtenerListaProductos(){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM `producto`");
            ResultSet rs = ps.executeQuery();
            List<Producto> listaProductos = new ArrayList<Producto>();
            while(rs.next()){
                Producto tipoProducto = new Producto(
                        rs.getInt("Id"),
                        rs.getInt("TipoProducto"),
                        rs.getString("NombreProducto"),
                        rs.getBigDecimal("PrecioUnidad")
                );

                listaProductos.add(tipoProducto);
            }
            return listaProductos;
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }

    public boolean ingresaLote(int idProducto, LocalDate fechaCaducidad, int cantidadInicial){
        try{
            String qryInsertaProducto = "INSERT INTO `lote`(`IdProducto`, `FechaCaducidad`, `CantidadInicial`, `CantidadRestante`, `Estatus`) VALUES (?, ?, ?, ?, 1)";
            PreparedStatement ps = conn.prepareStatement(qryInsertaProducto);
            ps.setInt(1, idProducto);
            ps.setDate(2, java.sql.Date.valueOf(fechaCaducidad));
            ps.setInt(3, cantidadInicial);
            ps.setInt(4, cantidadInicial);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                System.out.println("No se logró crear el producto");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al crear el producto: " + e.getMessage());
        }

        return false;
    }

    public List<ProductoLote> obtieneCatalogoProductos(){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT l.Id AS Lote, p.NombreProducto, MAX(p.PrecioUnidad) AS PrecioUnidad, SUM(l.CantidadRestante) AS CantidadRestante FROM producto p INNER JOIN lote l ON L.IdProducto = P.Id GROUP BY p.Id");
            ResultSet rs = ps.executeQuery();
            List<ProductoLote> listaProductoLote = new ArrayList<ProductoLote>();
            while(rs.next()){
                ProductoLote productoLote = new ProductoLote();
                productoLote.Producto = rs.getString("NombreProducto");
                productoLote.Lote = rs.getInt("Lote");
                productoLote.Precio =  rs.getFloat("PrecioUnidad");
                productoLote.Cantidad = rs.getString("CantidadRestante");

                listaProductoLote.add(productoLote);
            }
            return listaProductoLote;
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }

    public Usuario obtieneUsuarioPorNombre(String Usuario){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cliente WHERE Usuario = ?");
            ps.setString(1, Usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("Id"));
                return usuario;
            }
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }

    public RelacionUsuarioCarrito obtieneRelacionCarro(int usuario){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM `relacioncarritousuario` WHERE IdUsuario = ?");
            ps.setInt(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                RelacionUsuarioCarrito relacionUsuarioCarrito = new RelacionUsuarioCarrito();
                relacionUsuarioCarrito.idCarrito = rs.getInt("IdCarrito");
                relacionUsuarioCarrito.idUsuario = rs.getInt("IdUsuario");
                return relacionUsuarioCarrito;
            }
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }

    public boolean creaCarrito(int cantidad, double total, int estatus){
        try{
            String qryInsertaCarrito = "INSERT INTO `carrito`( `CantidadItems`, `Total`, `Estatus`) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(qryInsertaCarrito);
            ps.setInt(1, cantidad);
            ps.setDouble(2, total);
            ps.setInt(3, estatus);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                System.out.println("No se logró crear el carrito");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al crear el producto: " + e.getMessage());
        }

        return false;
    }

    public RelacionUsuarioCarrito listadoDetalleCarrito(int usuario){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM `relacioncarritousuario` WHERE IdUsuario = ?");
            ps.setInt(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                RelacionUsuarioCarrito relacionUsuarioCarrito = new RelacionUsuarioCarrito();
                relacionUsuarioCarrito.idCarrito = rs.getInt("IdCarrito");
                relacionUsuarioCarrito.idUsuario = rs.getInt("IdUsuario");
                return relacionUsuarioCarrito;
            }
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }

    public Carrito obtieneCarrito(int usuario){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM carrito C INNER JOIN relacioncarritousuario R ON R.IdCarrito = C.Id AND C.Estatus = 1 AND R.IdUsuario = ?");
            ps.setInt(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Carrito carrito = new Carrito();
                carrito.idCarrito = rs.getInt("IdCarrito");
                carrito.cantidadItems = rs.getInt("CantidadItems");
                carrito.total = rs.getFloat("total");
                return carrito;
            }
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }

    public boolean creaRelacionCarrito(int idCarrito, int idUsuario){
        try{
            String qryInsertaCarrito = "INSERT INTO `relacioncarritousuario`(`IdCarrito`, `IdUsuario`) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(qryInsertaCarrito);
            ps.setInt(1, idCarrito);
            ps.setInt(2, idUsuario);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                System.out.println("No se logró crear el carrito");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al crear el producto: " + e.getMessage());
        }

        return false;
    }

    public boolean creaDetalleCarrito(int idCarrito, int lote, int item, int cantidad, float valorTotal){
        try{
            String qryInsertaCarrito = "INSERT INTO `detallecarrito`(`IdCarrito`, `Lote`, `Item`, `Cantidad`, `ValorTotal`, `Estado`) VALUES (?,?,?,?,?,1)";
            PreparedStatement ps = conn.prepareStatement(qryInsertaCarrito);
            ps.setInt(1, idCarrito);
            ps.setInt(2, lote);
            ps.setInt(3, item);
            ps.setInt(4, cantidad);
            ps.setFloat(5, valorTotal);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                System.out.println("No se logró crear el carrito");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al crear el producto: " + e.getMessage());
        }

        return false;
    }
    // SELECT * FROM carrito C INNER JOIN relacioncarritousuario R ON R.IdCarrito = C.Id AND R.IdUsuario = ''

    // SELECT * FROM detallecarrito D INNER JOIN relacioncarritousuario R ON R.IdUsuario = '' LEFT JOIN lote L ON L.Id = D.Lote LEFT JOIN producto P ON P.Id = L.IdProducto
}
