USE db_seguridad;

-- CATALOGOS
CREATE TABLE EstatusUsuario(
	Id TINYINT AUTO_INCREMENT PRIMARY KEY,
    Descripcion VARCHAR(60)
);

CREATE TABLE TipoUsuario(
	Id TINYINT AUTO_INCREMENT PRIMARY KEY,
    Descripcion VARCHAR(60)
);

-- TABLAS MAESTRO
CREATE TABLE Usuarios(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Usuario VARCHAR(20),
    Pwd VARCHAR(60),
    NombreCompleto VARCHAR(60),
    Correo VARCHAR(60),
    Estatus TINYINT,
    TipoUsuario TINYINT,
    FechaHoraCreacion DATETIME,
    FechaHoraUltimaConexion DATETIME,
    FOREIGN KEY (Estatus) REFERENCES EstatusUsuario(Id),
    FOREIGN KEY (TipoUsuario) REFERENCES TipoUsuario(Id)
);

