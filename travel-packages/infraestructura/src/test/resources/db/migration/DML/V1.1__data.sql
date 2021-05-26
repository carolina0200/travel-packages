insert into paquete (precio, estado, ciudad, hotel, descripcion, cupos, dias, fecha_creacion)
values (500, 'A', 'Cartagena', 'Decamenron', '', 5, 3, now());
insert into compra (id_paquete, valor, numero_menores, numero_adultos, nombre, correo, fecha_compra, fecha_ida, fecha_regreso)
values (1, 100, 0, 2, 'Adrian Ramirez', 'test@gmail.com', now(), now(), now())