use tama ;
-- Insertar servicios
INSERT INTO servicio (nombre_servicio, descripcion, duracion, precio) VALUES
                                                                          ('Corte de cabello', 'Corte clásico para hombre', 30, 15.00),
                                                                          ('Manicura', 'Manicura básica con esmalte', 45, 20.00),
                                                                          ('Masaje relajante', 'Masaje de cuerpo completo', 60, 50.00);

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
                                                                ('Crema hidratante', 'Crema facial para piel seca', 12.00, 'foto2.jpg');

-- Insertar pedidos
INSERT INTO pedido (id_usuario, fecha_pedido, total, estado) VALUES
                                                                 (1, NOW(), 20.50, 'pagado'),
                                                                 (2, NOW(), 12.00, 'pendiente');

