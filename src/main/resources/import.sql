INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('javi','$2a$10$les3lO6fU/ZiS2S8/2lZ1.Z2r6XI85J2N6awWz9JAJHZ7ZxIrUY.S',1, 'Javi', 'Javi','javi@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$EJ6RSaL63oXE3.Q0B5d/Y.m5uatWBQ0VSnGwnHpmWu3a8CAiFib6.',1, 'Admin', 'Admin','admin@gmail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);


