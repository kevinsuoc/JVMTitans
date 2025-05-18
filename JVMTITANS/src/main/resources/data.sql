-- Crear roles si no existen
INSERT INTO rol (nombre)
SELECT 'ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM rol WHERE nombre = 'ADMIN');

INSERT INTO rol (nombre)
SELECT 'USER'
WHERE NOT EXISTS (SELECT 1 FROM rol WHERE nombre = 'USER');

-- Crear usuario admin (contraseña: admin123)
INSERT INTO usuario (username, password, email)
SELECT 'admin', '$2a$10$7tpj3AAXzZUnm4JwHkLk9.J9TqIygb9Vea35oJnbdpj5wJypEIgNa', 'admin@example.com'
WHERE NOT EXISTS (SELECT 1 FROM usuario WHERE username = 'admin');

-- Crear usuario user (contraseña: user123)
INSERT INTO usuario (username, password, email)
SELECT 'user', '$2a$10$le4dcN8V/Qo6wMq8XoJ50OZi62sG5sy0k./1xvth9XJai74GSbqQ2', 'user@example.com'
WHERE NOT EXISTS (SELECT 1 FROM usuario WHERE username = 'user');

-- Asignar rol ADMIN a admin
INSERT INTO usuario_roles (usuario_id, roles_id)
SELECT u.id, r.id
FROM usuario u, rol r
WHERE u.username = 'admin' AND r.nombre = 'ADMIN'
  AND NOT EXISTS (
    SELECT 1 FROM usuario_roles WHERE usuario_id = u.id AND roles_id = r.id
);

-- Asignar rol USER a user
INSERT INTO usuario_roles (usuario_id, roles_id)
SELECT u.id, r.id
FROM usuario u, rol r
WHERE u.username = 'user' AND r.nombre = 'USER'
  AND NOT EXISTS (
    SELECT 1 FROM usuario_roles WHERE usuario_id = u.id AND roles_id = r.id
);
