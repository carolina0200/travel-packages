update paquete
set cupos = (( SELECT cupos FROM paquete WHERE id = :id) - :cupos)
where id = :id;