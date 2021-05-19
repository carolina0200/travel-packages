update compra
set vigencia = :vigencia,
	fecha_ida = :fechaIda,
	fecha_regreso = :fechaRegreso
where id = :id;