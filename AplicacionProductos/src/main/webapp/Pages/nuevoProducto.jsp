<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.aplicacionproductos.Clases.Entidades.*" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Agregar Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4">
        <h3 class="mb-4 text-center">Agregar Nuevo Producto</h3>

        <form action="nuevoProducto" method="post">
            <input type="hidden" name="opt" value="1">

            <div class="mb-3">
                <label for="tipoProducto" class="form-label">Tipo de Producto</label>
                <select class="form-select" id="tipoProducto" name="tipoProducto" required>
                    <option value="">Seleccione un tipo...</option>
                    <%
                        List<TipoProducto> tipoProductos = (List<TipoProducto>) request.getAttribute("tipoProductos");
                        if (tipoProductos != null && !tipoProductos.isEmpty()) {
                            for (TipoProducto t : tipoProductos) {
                    %>
                    <option value="<%= t.id %>"><%= t.descripcion %></option>
                    <%
                        }
                    } else {
                    %>
                    <option value="">No hay tipos de producto disponibles</option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div class="mb-3">
                <label for="nombreProducto" class="form-label">Nombre del Producto</label>
                <input type="text" class="form-control" id="nombreProducto" name="nombreProducto"
                       placeholder="Ej. Paracetamol 500mg" maxlength="50" required>
            </div>

            <div class="mb-3">
                <label for="precioUnidad" class="form-label">Precio por Unidad</label>
                <input type="number" class="form-control" id="precioUnidad" name="precioUnidad"
                       placeholder="Ej. 12.50" min="0" step="0.01" required>
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary">Guardar Producto</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
