
drop database if exists tama;
create database if not exists tama;
use tama;
-- Tabla servicio
CREATE TABLE servicio (
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre_servicio VARCHAR(100) not null,
    descripcion VARCHAR(100),
    duracion INT not null,
    precio DECIMAL(10,2) not null
);

-- Tabla usuario
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY not null,
    nombre VARCHAR(100) not null,
    email VARCHAR(100) not null,
    contrasena VARCHAR(100) not null,
    fecha_registro DATETIME not null,
    rolUsuario enum('ADMIN', 'USUARIO') NOT NULL

);

-- Tabla administrador
CREATE TABLE administrador (
    id_administrador INT AUTO_INCREMENT PRIMARY KEY not null,
    nombre VARCHAR(100) not null,
    email VARCHAR(100) not null unique,
    contrasena VARCHAR(100) not null,
    rolUsuario enum('ADMIN', 'USUARIO') NOT NULL

);

-- Tabla producto
CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY not null,
    nombre_producto VARCHAR(100) not null,
    descripcion VARCHAR(100) not null,
    precio DECIMAL(10,2) not null,
    imagen varchar(100) not null
);

-- Tabla pedido
CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY not null,
    id_usuario INT not null,
    fecha_pedido DATETIME not null,
    total DECIMAL(10,2) not null,
    direccion_envio varchar(100) not null,
    estado ENUM('pendiente', 'pagado', 'entregado') not null,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Tabla detallePedido
CREATE TABLE detallePedido (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY not null,
    id_pedido INT not null,
    id_producto INT not null,
    cantidad INT not null,
    subtotal DECIMAL(10,2) not null,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Tabla cita
CREATE TABLE cita (
    id_cita INT AUTO_INCREMENT PRIMARY KEY not null,
    id_usuario INT not null,
    id_servicio INT not null,
    id_administrador INT not null,
    fecha DATETIME not null,
    estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA'),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio),
    FOREIGN KEY (id_administrador) REFERENCES administrador(id_administrador)
);