
-- Tama's BBDD

CREATE SCHEMA IF NOT EXISTS 'tama' DEFAULT CHARACTER SET utf8;
USE 'tama' ;

CREATE TABLE IF NOT EXISTS usuario (

    id_usuario int not null primary key auto_increment,
    nombre varchar(100) not null ,
    email varchar(100) not null,
    contrasena varchar(100) not null,
    telefono varchar(15),
    iban varchar(15),
    fecha_registro date not null
);


CREATE TABLE IF NOT EXISTS pedido(
    id_pedido INT NOT NULL PRIMARY KEY auto_increment,
    id_usuario INT NOT NULL,
    fecha_pedido timestamp not null,
    total decimal(10,2) not null,
    estado enum('pendiente', 'enviado', 'entregado')
);

CREATE TABLE IF NOT EXISTS detallePedido(
    id_detalle int not null primary key auto_increment,
    id_pedido int not null,
    id_producto int not null,
    cantidad int not null,
    precio_unitario decimal (10,2),
    subtotal decimal(10,2),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

CREATE TABLE IF NOT EXISTS producto(
    id_producto int not null primary key auto_increment,
    nombre_producto varchar(100),
    descripcion text,
    precio decimal(10,2) not null,
    stock int
);

CREATE TABLE IF NOT EXISTS cita(
    id_cita int not null primary key auto_increment,
    id_usuario int not null,
    id_servicio int not null,
    id_administrador int not null,
    fecha_cita datetime not null,
    estado enum('pendiente', 'confirmada', 'cancelada'),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio),
    FOREIGN KEY (id_administrador) REFERENCES administrador(id_administrador)
);

CREATE TABLE IF NOT EXISTS servicio(
    id_servicio int not null primary key auto_increment,
    nombre_servicio varchar(100),
    descripcion text,
    duracion int not null,
    precio decimal(10,2)
);

CREATE TABLE IF NOT EXISTS administrador(
    id_administrador int primary key auto_increment,
    nombre varchar(100),
    email varchar(100),
    contrasena varchar(100)
)



