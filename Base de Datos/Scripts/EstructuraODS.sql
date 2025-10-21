USE db_ods;

-- CATALOGOS
CREATE TABLE TipoProducto(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Descripcion VARCHAR(60)
);

CREATE TABLE MetodoPago(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Descripcion VARCHAR(60)
);

CREATE TABLE TipoCuenta(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Descripcion VARCHAR(60)
);

CREATE TABLE EstatusCompra(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Descripcion VARCHAR(60)
);

-- TABLAS MAESTRAS
CREATE TABLE Producto(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    TipoProducto INT,
    NombreProducto VARCHAR(50),
    PrecioUnidad DECIMAL(7,2),
    FOREIGN KEY (TipoProducto) REFERENCES TipoProducto(Id)
);

CREATE TABLE Lote(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    IdProducto INT,
    FechaCaducidad DATE,
    CantidadInicial INT,
    CantidadRestante INT,
    Estatus BIT,
    FOREIGN KEY (IdProducto) REFERENCES Producto(Id)
);

CREATE TABLE Carrito(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    CantidadItems INT,
    Total DECIMAL(7,2),
    Estatus INT,
    FOREIGN KEY (Estatus) REFERENCES EstatusCompra(Id)
);

CREATE TABLE DetalleCarrito(
	IdCarrito INT,
    Lote INT,
    Item INT,
    Cantidad INT,
    ValorTotal DECIMAL(7, 2),
    Estado BIT
);

CREATE INDEX idx_DetalleCarrito ON DetalleCarrito(IdCarrito, Lote);

CREATE TABLE Cliente(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Usuario VARCHAR(20),
    NombreCompleto VARCHAR(60)
);

CREATE TABLE RelacionCarritoUsuario(
	IdCarrito INT,
    IdUsuario INT,
    FOREIGN KEY (IdCarrito) REFERENCES Carrito(Id),
    FOREIGN KEY (IdUsuario) REFERENCES Cliente(Id)
);


