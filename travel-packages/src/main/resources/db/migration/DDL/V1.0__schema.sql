create table compra (
 id int(11) not null auto_increment,
 id_paquete int(11) not null,
 valor double not null,
 numero_menores int(5),
 numero_adultos int(5),
 nombre varchar(100),
 correo varchar(100),
 fecha_compra datetime not null,
 fecha_ida datetime not null,
 fecha_regreso datetime not null,
 primary key (id)
);

create table paquete (
 id int(11) not null auto_increment,
 precio double not null,
 estado varchar(1) not null,
 ciudad varchar(100) not null,
 hotel varchar(100),
 descripcion varchar(200),
 cupos int(10) not null,
 dias int(10) not null,
 fecha_creacion datetime not null,
 primary key (id)
);