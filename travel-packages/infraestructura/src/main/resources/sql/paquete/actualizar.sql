update paquete
set estado = :estado,
	ciudad = :ciudad,
	hotel = :hotel,
	cupos = :cupos,
	dias = :dias,
	descripcion = :descripcion,
	fecha_hasta = :fechaHasta
where id = :id