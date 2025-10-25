<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.aplicacionproductos.Clases.Entidades.*" %>
<%@ page import="org.example.aplicacionproductos.Clases.Entidades.ProductoLote" %>
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Administrar Productos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <h2 class="text-center mb-4">Administración de Productos</h2>

  <%
    List<ProductoLote> listaProductos = (List<ProductoLote>) request.getAttribute("listaProductos");
    if (listaProductos == null || listaProductos.isEmpty()) {
  %>
  <div class="alert alert-info text-center">
    No hay productos registrados.
  </div>
  <%
  } else {
  %>

  <table class="table table-striped table-hover align-middle shadow rounded-3">
    <thead class="table-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Lote</th>
      <th scope="col">Nombre</th>
      <th scope="col">Fecha de Vencimiento</th>
      <th scope="col" class="text-center">Acciones</th>
    </tr>
    </thead>
    <tbody>
    <%
      int contador = 1;
      for (ProductoLote p : listaProductos) {
    %>
    <tr>
      <td><%= contador++ %></td>
      <td><%= p.Lote %></td>
      <td><%= p.Producto %></td>
      <td><%= p.Cantidad %></td>
      <td class="text-center">
        <form action="producto" method="post" style="display:inline;">
          <input type="hidden" name="accion" value="eliminar">
          <input type="hidden" name="id" value="<%= p.Lote %>">
          <button type="submit" class="btn btn-danger btn-sm"
                  onclick="return confirm('¿Seguro que deseas eliminar este producto?');">
            Eliminar
          </button>
        </form>
      </td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
  <%
    }
  %>

  <div class="text-center mt-4">
    <a href="nuevoProducto" class="btn btn-success">
      <i class="bi bi-plus-circle"></i> Agregar Nuevo Producto
    </a>
  </div>
  <div class="text-center mt-4">
    <a href="nuevoLote" class="btn btn-success">
      <i class="bi bi-plus-circle"></i> Agregar Nuevo Lote
    </a>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap Icons (para el ícono del botón) -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
</body>
</html>
