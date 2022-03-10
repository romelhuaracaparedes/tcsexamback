INSERT INTO rate(id, code) VALUES (1,'EUR');
INSERT INTO rate(id, code) VALUES (2,'USD');
INSERT INTO rate(id, code) VALUES (3,'PEN');


INSERT INTO details(id, cod_origin, cod_destination, exch_rate) VALUES (1,1,2,1.09);
INSERT INTO details(id, cod_origin, cod_destination, exch_rate) VALUES (2,1,3,4.05);
INSERT INTO details(id, cod_origin, cod_destination, exch_rate) VALUES (3,2,1,0.92);
INSERT INTO details(id, cod_origin, cod_destination, exch_rate) VALUES (4,2,3,3.71);
INSERT INTO details(id, cod_origin, cod_destination, exch_rate) VALUES (5,3,1,0.25);
INSERT INTO details(id, cod_origin, cod_destination, exch_rate) VALUES (6,3,2,0.27);























--INSERT INTO `usuarios` (username, password, enabled) VALUES ('romel','$2a$10$Q8J8E29289TNOQIxUBwTEOpHnaslYLABi/H/H9W36uBAFb.RcDUn2',1);
--INSERT INTO `usuarios` (username, password, enabled) VALUES ('admin','$2a$10$fVSNwvyApMjsxmSaKWNthutwgnpFgVyiCpZSg3Lyvo9zqTWBCX86m',1);
--
--INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
--INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');
--
--INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
--INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
--INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);


--Creamos algunos usuarios con sus roles
--INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('romel','$2a$10$Q8J8E29289TNOQIxUBwTEOpHnaslYLABi/H/H9W36uBAFb.RcDUn2',1, 'Romel', 'Huaraca','romelhuaraca@gmail.com');
--INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$fVSNwvyApMjsxmSaKWNthutwgnpFgVyiCpZSg3Lyvo9zqTWBCX86m',1, 'Eduardo', 'Pariona','eduardo@gmail.com');
--
--INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
--INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');
--
--INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
--INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
--INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);



