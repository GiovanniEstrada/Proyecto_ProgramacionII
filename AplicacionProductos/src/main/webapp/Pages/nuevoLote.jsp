<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.aplicacionproductos.Clases.Entidades.*" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Agregar Lote</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4">
        <h3 class="mb-4 text-center">Agregar Nuevo Lote</h3>

        <form action="nuevoLote" method="post">
            <input type="hidden" name="opt" value="1">

            <div class="mb-3">
                <label for="idProducto" class="form-label">Producto</label>
                <select class="form-select" id="idProducto" name="idProducto" required>
                    <option value="">Seleccione un producto...</option>
                    <%
                        List<Producto> listaProductos = (List<Producto>) request.getAttribute("listaProductos");
                        if (listaProductos != null && !listaProductos.isEmpty()) {
                            for (Producto p : listaProductos) {
                    %>
                    <option value="<%= p.getId() %>"><%= p.getNombreProducto() %></option>
                    <%
                        }
                    } else {
                    %>
                    <option value="">No hay productos disponibles</option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div class="mb-3">
                <label for="fechaCaducidad" class="form-label">Fecha de Caducidad</label>
                <input type="date" class="form-control" id="fechaCaducidad" name="fechaCaducidad" required>
            </div>

            <div class="mb-3">
                <label for="cantidadInicial" class="form-label">Cantidad Inicial</label>
                <input type="number" class="form-control" id="cantidadInicial" name="cantidadInicial" required min="1">
            </div>

            <div class="d-flex justify-content-between">
                <a href="ProductosServlet?opt=2" class="btn btn-secondary">Regresar</a>
                <button type="submit" class="btn btn-primary">Guardar Lote</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
