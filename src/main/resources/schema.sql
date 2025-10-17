create database if not exists tama;
use tama ;

-- Insertar servicios
INSERT INTO servicio (nombre_servicio, descripcion, duracion, precio) VALUES
                                                                          ('Acupuntura sin Agujas', 'Acupuntura sin agujas', 60, 45.00),
                                                                          ('Acupuntura con Agujas', 'Acupuntura con agujas', 60, 40.00),
                                                                          ('Masaje relajante', 'Masaje de cuerpo completo', 60, 50.00),
                                                                          ( 'Quiromasaje', 'Quiromasaje realizado con todo', 60, 60)

-- Insertar usuarios
INSERT INTO usuario (nombre, email, contrasena, fecha_registro, rolUsuario) VALUES
                                                                    ('Laura Gómez', 'laura@example.com', '1234', NOW(),'USUARIO'),
                                                                    ('Carlos Ruiz', 'carlos@example.com', 'abcd', NOW(), 'USUARIO');

-- Insertar administradores
INSERT INTO administrador (nombre, email, contrasena,rolUsuario) VALUES
                                                          ('Ana Torres', 'ana.admin@example.com', 'admin123', 'ADMIN'),
                                                          ('Luis Martínez', 'luis.admin@example.com', 'admin456', 'ADMIN');

-- Insertar productos
INSERT INTO producto (nombre_producto, descripcion, precio, imagen) VALUES
                                                                ('Champú herbal', 'Champú natural sin sulfatos', 8.50, 'foto.jpg'),
                                                                ('Crema hidratante', 'Crema facial para piel seca', 12.00, 'foto2.jpg'),
                                                                ('Ampolla de Cobre', '48 ampollas de cobre', 16.5, 'foto3.jpg');

-- Insertar pedidos
INSERT INTO pedido (id_usuario, fecha_pedido, total, direccion_envio, estado) VALUES
                                                                 (1, NOW(), 20.50, 'C/FDAFa','pagado'),
                                                                 (2, NOW(), 12.00, 'C/DFAFDASF','pendiente');

-- Insertar citas
INSERT INTO cita (id_cita, id_usuario, id_servicio, id_administrador, fecha, estado) VALUES
                                                                                (1,1, 1, 1, '2025-10-01 10:00:00', 'PENDIENTE'),   -- Laura con Ana, corte de cabello
                                                                                (2,2, 2, 2, '2025-10-02 11:30:00', 'CONFIRMADA'), -- Carlos con Luis, manicura
                                                                                (3,1, 3, 2, '2025-10-03 17:00:00', 'CANCELADA');  -- Laura con Luis, masaje relajante
