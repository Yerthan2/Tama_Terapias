
drop database if exists tama;
create database if not exists tama;
-- Tabla servicio
CREATE TABLE servicio (
                          id_servicio INT AUTO_INCREMENT PRIMARY KEY,
                          nombre_servicio VARCHAR(100),
                          descripcion VARCHAR(100),
                          duracion INT,
                          precio DECIMAL(10,2)
);

-- Tabla usuario
CREATE TABLE usuario (
                         id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100),
                         email VARCHAR(100),
                         contrasena VARCHAR(100),
                         fecha_registro DATETIME
);

-- Tabla administrador
CREATE TABLE administrador (
                               id_administrador INT AUTO_INCREMENT PRIMARY KEY,
                               nombre VARCHAR(100),
                               email VARCHAR(100),
                               contrasena VARCHAR(100)
);

-- Tabla producto
CREATE TABLE producto (
                          id_producto INT AUTO_INCREMENT PRIMARY KEY,
                          nombre_producto VARCHAR(100),
                          descripcion VARCHAR(100),
                          precio DECIMAL(10,2)
);

-- Tabla pedido
CREATE TABLE pedido (
                        id_pedido INT AUTO_INCREMENT PRIMARY KEY,
                        id_usuario INT,
                        fecha_pedido DATETIME,
                        total DECIMAL(10,2),
                        estado ENUM('pendiente', 'pagado', 'entregado'),
                        FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Tabla detallePedido
CREATE TABLE detallePedido (
                               id_detalle INT AUTO_INCREMENT PRIMARY KEY,
                               id_pedido INT,
                               id_producto INT,
                               cantidad INT,
                               subtotal DECIMAL(10,2),
                               FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
                               FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Tabla cita
CREATE TABLE cita (
                      id_cita INT AUTO_INCREMENT PRIMARY KEY,
                      id_usuario INT,
                      id_servicio INT,
                      id_administrador INT,
                      fecha DATETIME,
                      estado ENUM('pendiente', 'confirmada', 'cancelada'),
                      FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
                      FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio),
                      FOREIGN KEY (id_administrador) REFERENCES administrador(id_administrador)
);
