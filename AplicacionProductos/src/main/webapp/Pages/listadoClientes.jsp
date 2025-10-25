<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.aplicacionproductos.Clases.Entidades.Usuario" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Administrar Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Administrar clientes</h2>

    <%
        // Obtener la lista enviada desde el servlet
        List<Usuario> listaClientes = (List<Usuario>) request.getAttribute("listaClientes");
        if (listaClientes == null || listaClientes.isEmpty()) {
    %>
    <div class="alert alert-info text-center">
        No hay clientes registrados.
    </div>
    <%
    } else {
    %>
    <table class="table table-hover align-middle">
        <thead class="table-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nombre Completo</th>
            <th scope="col">Correo</th>
            <th scope="col" class="text-center">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <%
            int contador = 1;
            for (Usuario u : listaClientes) {
        %>
        <tr>
            <td><%= contador++ %></td>
            <td><%= u.getNombreCompleto() %></td>
            <td><%= u.getCorreo() %></td>
            <td class="text-center">
                <form action="AdminUsuario" method="post" style="display:inline;">
                    <input type="hidden" name="accion" value="eliminar">
                    <input type="hidden" name="id" value="<%= u.getId() %>">
                    <button type="submit" class="btn btn-danger btn-sm"
                            onclick="return confirm('¿Seguro que deseas eliminar este cliente?');">
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

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
