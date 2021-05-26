update compra
set nombre = :nombre,
    correo = :correo,
    fecha_ida = :fechaIda,
	fecha_regreso = :fechaRegreso
where id = :id;