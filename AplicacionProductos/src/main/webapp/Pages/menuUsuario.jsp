<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.aplicacionproductos.Clases.Entidades.*" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tienda - Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Mi Tienda</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="despliegaProductos">Productos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="verCarrito">Carrito</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Contenido -->
<div class="container mt-4">
    <h3 class="text-center mb-4">Listado de Productos</h3>

    <div class="card shadow p-3">
        <table class="table table-hover align-middle">
            <thead class="table-dark">
            <tr>
                <th>Nombre</th>
                <th>Valor (Q)</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<ProductoLote> productos = (List<ProductoLote>) request.getAttribute("listaProductos");
                if (productos != null && !productos.isEmpty()) {
                    for (ProductoLote p : productos) {
            %>
            <tr>
                <td><%= p.Producto %></td>
                <td name="precio" value="<%= p.Precio %>"><%= p.Precio %></td>
                <td>
                    <form action="agregaCarrito" method="post" class="d-inline">
                        <input type="hidden" name="opt" value="1">
                        <input type="hidden" name="idProducto" value="<%= p.Lote %>">
                        <button type="submit" class="btn btn-success btn-sm">
                            Agregar al carrito
                        </button>
                    </form>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="3" class="text-center text-muted">No hay productos disponibles</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
