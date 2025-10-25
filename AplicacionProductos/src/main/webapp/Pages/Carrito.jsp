<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Mi Carrito</title>

    <link rel="icon" type="image/png" href="img/carrito-de-compras.png">

    <style>
        :root{
            --brand:#000;
            --brand-2:#ff6b6b;
            --ink:#0f172a;
            --muted: #8b6464;
            --bg:#ffffff;
            --surface:#f3f4f6;
            --card:#ffffff;
            --radius:18px;
            --shadow:0 10px 25px rgba(2,8,23,.10), 0 2px 6px rgba(2,8,23,.06);
        }
        *{box-sizing:border-box}
        body{
            margin:0;
            font-family:system-ui,-apple-system,Segoe UI,Roboto,Inter,Helvetica,Arial;
            color:var(--ink);
            background:#fff;
            line-height:1.45;
        }
        h1,h2,h3{margin:0}

        /* Header rojo */
        .header{
            background:var(--brand);
            color:#fff;
            padding:1rem 1.25rem;
        }
        .header .wrap{
            max-width:1200px;margin:0 auto;display:flex;gap:.75rem;align-items:center;
        }
        .header .logo{
            width:36px;height:36px;border-radius:8px;display:grid;place-items:center;
            background:rgba(255,255,255,.18);
            /* Puedes cambiar por <img src="img/carrito-de-compras.png" ...> si deseas */
        }
        .header h1{font-size:2.2rem;font-weight:900;letter-spacing:.2px}

        /* Layout principal */
        .container{
            max-width:1200px;margin:1.25rem auto;padding:0 1rem;
            display:grid;grid-template-columns:1fr 360px;gap:1.25rem;align-items:start;
        }
        @media (max-width:980px){ .container{grid-template-columns:1fr} }

        /* Tabla de items (flex-table) */
        .table{
            background:var(--surface);
            border-radius:var(--radius);
            padding:1.25rem;
        }
        .thead, .row{
            display:grid;
            grid-template-columns: 1.4fr .6fr .8fr .6fr auto;
            gap:1rem; align-items:center;
        }
        .thead{
            color:#0f172a;font-weight:800;font-size:1.15rem;margin:0 .5rem 1rem;
        }

        .row{
            background:var(--card); border-radius:16px; box-shadow:var(--shadow);
            padding: .8rem; margin:.9rem .5rem;
        }
        .product{
            display:flex; align-items:center; gap:.9rem;
        }
        .thumb{
            width:68px; height:68px; border-radius:10px; background:#e5e7eb; flex:0 0 auto;
            display:flex;align-items:center;justify-content:center;color:#94a3b8;font-size:.8rem;
            /* Reemplazar por <img class="thumb" src="img/PRODUCTO.jpg" alt=""> */
        }
        .pname{font-weight:700}
        .muted{color:var(--muted);font-size:.92rem}

        .price, .total{font-weight:800}
        .total{color:#0f172a}

        /* Controles cantidad */
        .qty{
            display:inline-flex;align-items:center;gap:.55rem;justify-content:center;
        }
        .btn-icon{
            width:34px;height:34px;border-radius:999px;border:1px solid rgba(2,8,23,.12);
            background:#fff;display:grid;place-items:center;font-size:1.2rem;font-weight:900;
            cursor:pointer;transition:.15s ease; user-select:none;
        }
        .btn-icon:hover{transform:translateY(-1px);box-shadow:0 6px 14px rgba(2,8,23,.10)}
        .qty .value{min-width:28px;text-align:center;font-weight:800}

        /* Borrar */
        .trash{
            width:38px;height:38px;border-radius:12px;border:1px solid rgba(2,8,23,.12);
            display:grid;place-items:center;background:#fff;cursor:pointer;transition:.15s ease;
        }
        .trash:hover{background:#fee2e2;border-color:#fecaca}
        .trash::before{
            content:"🗑️"; font-size:1.05rem; line-height:1;
        }

        /* Panel resumen */
        .summary{
            border:1px solid rgba(2,8,23,.12); border-radius:16px; padding:1rem; background:#fff;
            position:sticky; top:14px;
        }
        .summary h2{
            font-size:1.8rem; text-align:center; margin:1rem 0; font-weight:900;
        }
        .note{
            margin: .5rem 0 1.25rem;
        }
        .note label{
            display:block; text-align:center; color:#111827; margin-bottom:.5rem;
        }
        .note textarea{
            width:100%; height:110px; border:1px solid rgba(2,8,23,.12); border-radius:10px;
            background:#fafafa; padding:.75rem; resize:vertical; outline:none;
        }
        .line{
            height:1px; background:linear-gradient(90deg, transparent, rgba(2,8,23,.12), transparent);
            margin:.85rem 0;
        }
        .pair{display:flex;justify-content:space-between;margin:.35rem 0;color:#111827}
        .pair.total{font-weight:900}
        .actions{display:flex;flex-direction:column;gap:.8rem;margin-top:1rem}
        .btn{
            display:inline-flex;align-items:center;justify-content:center;gap:.5rem;
            border-radius:999px; padding:.8rem 1rem; font-weight:800; cursor:pointer; border:1px solid transparent;
            transition:.2s ease; text-align:center; text-decoration:none;
        }
        .btn-primary{background:var(--brand);color:#fff;box-shadow:0 10px 20px rgba(5,5,5,.25)}
        .btn-primary:hover{background:var(--brand-2)}
        .btn-ghost{background:#fff;border-color:rgba(2,8,23,.12); color:#111827}
        .btn-ghost:hover{transform:translateY(-1px); box-shadow:0 6px 14px rgba(2,8,23,.08)}
    </style>
</head>
<body>

<!-- HEADER -->
<header class="header">
    <div class="wrap">
        <div class="logo" aria-hidden="true">🛒</div>
        <h1>Mi Carrito</h1>
    </div>
</header>

<!-- CONTENIDO -->
<main class="container">

    <!-- Columna izquierda: items -->
    <!-- Columna izquierda: items -->
    <section class="table" aria-label="Listado de productos en carrito">

        <div class="thead">
            <div>Producto</div>
            <div>Precio</div>
            <div>Cantidad</div>
            <div>Total</div>
            <div></div>
        </div>

        <!-- ====== FILA DE PRODUCTO (SIN IMAGEN NI DESCRIPCIÓN) ====== -->
        <article class="row" data-sku="">
            <div class="product">
                <div class="pname">Nombre del producto</div>
            </div>

            <div class="price">Q --.--</div>

            <div class="qty" data-qty="">
                <button class="btn-icon" data-action="dec" aria-label="Restar 1">−</button>
                <span class="value" data-value>1</span>
                <button class="btn-icon" data-action="inc" aria-label="Sumar 1">+</button>
            </div>

            <div class="total">Q --.--</div>

            <button class="trash" title="Quitar del carrito" aria-label="Eliminar"></button>
        </article>

        <!-- Duplica <article class="row"> para más productos -->
        <article class="row" data-sku="">
            <div class="product">
                <div class="pname">Otro producto</div>
            </div>

            <div class="price">Q --.--</div>

            <div class="qty" data-qty="">
                <button class="btn-icon" data-action="dec" aria-label="Restar 1">−</button>
                <span class="value" data-value>1</span>
                <button class="btn-icon" data-action="inc" aria-label="Sumar 1">+</button>
            </div>

            <div class="total">Q --.--</div>

            <button class="trash" title="Quitar del carrito" aria-label="Eliminar"></button>
        </article>

    </section>


    <!-- Columna derecha: resumen -->
    <aside class="summary" aria-label="Resumen de pago">
        <div class="note">
            <label for="comentario">¿Te gustaría dejar un comentario acerca de tu pedido?</label>
            <textarea id="comentario" placeholder="Escribe tu comentario aquí..."></textarea>
        </div>
        <h2>Total a Pagar</h2>

        <div class="line"></div>

        <div class="pair"><span>Subtotal</span><span id="subtotal">Q --.--</span></div>
        <div class="pair"><span>Costo de envío</span><span id="shipping">Q --.--</span></div>

        <div class="line"></div>

        <div class="pair total"><span>Total</span><span id="grandtotal">Q --.--</span></div>

        <div class="actions">
            <a class="btn btn-primary" href="login.html">Finalizar Compra</a>
            <a class="btn btn-ghost" href="index.html">Continuar Comprando</a>
        </div>

    </aside>

</main>

</body>
</html>
