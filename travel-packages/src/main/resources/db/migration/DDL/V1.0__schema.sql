create table compra (
 id int(11) not null auto_increment,
 id_paquete int(11) not null,
 valor int(10),
 numero_menores int(100),
 numero_adultos int(100),
 vigencia varchar(1),
 identificacion varchar(11),
 nombre varchar(100),
 correo varchar(100),
 fecha_compra datetime null,
 fecha_ida datetime null,
 fecha_regreso datetime null,
 primary key (id)
);

create table paquete (
 id int(11) not null auto_increment,
 precio int(10) not null,
 estado varchar(1) not null,
 ciudad varchar(100),
 hotel varchar(100),
 descripcion varchar(200),
 cupos int(10) not null,
 dias int(10) not null,
 fecha_creacion datetime null,
 fecha_hasta datetime null,
 primary key (id)
);