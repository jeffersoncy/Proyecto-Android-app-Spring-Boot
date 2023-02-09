insert into programa values(100,'BALONCESTO');
insert into programa values(200,'FUTBOL SALA FUNCIONARIOS 15 CUPOS');

insert into usuario(user_id,user_documento,user_nombre,user_genero,user_fecha,user_email,user_password) values(1,123,'juan salamanca','M',null,'juans@unicauca.edu.co','12345678');
insert into usuario(user_id,user_documento,user_nombre,user_genero,user_fecha,user_email,user_password) values(2,456,'pepito peres','M',null,'pepito@unicauca.edu.co','12345678');

insert into horario(hor_hora_inicio,hor_hora_fin,hor_fecha_inicio,hor_fecha_fin,hor_dia,esc_nombre,pro_id,user_id,hor_estado) values(9,11,'2022-12-15','2022-12-15','LUNES','CANCHA SINTETICA NO. 1',100,null,'0');
insert into horario(hor_hora_inicio,hor_hora_fin,hor_fecha_inicio,hor_fecha_fin,hor_dia,esc_nombre,pro_id,user_id,hor_estado) values(10,11,'2022-12-14','2022-12-14','MARTES','CANCHA SINTETICA NO. 1',200,null,'0');
insert into horario(hor_hora_inicio,hor_hora_fin,hor_fecha_inicio,hor_fecha_fin,hor_dia,esc_nombre,pro_id,user_id,hor_estado) values(13,14,'2022-12-13','2022-12-13','JUEVES','CANCHA SINTETICA NO. 1',100,null,'0');
insert into horario(hor_hora_inicio,hor_hora_fin,hor_fecha_inicio,hor_fecha_fin,hor_dia,esc_nombre,pro_id,user_id,hor_estado) values(9,11,'2022-12-16','2022-12-16','LUNES','CANCHA SINTETICA NO. 2',200,null,'0');

insert into categoria (cat_nombre,cat_foto,cat_descripcion) values('TULCAN','','El Centro Deportivo Universitario Tulcán, está ubicado al frente del edificio de Ingeniería Civil sobre la Carrera 2 entre Calles 10 N y 15 N');

insert into categoria (cat_nombre,cat_foto,cat_descripcion) values('DIAMANTE','','El Centro Deportivo Universitario el Diamante está ubicado sobre la Carrera 2 entre el Instituto Técnico Industrial y la Urbanización Pomona');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA SINTETICA NO. 1','Es una cancha con el sistema de revestimiento acrílico compuesto por seis (6) capas, utilizado en canchas de hockey, pistas de patinaje, ciclo rutas, zonas de bicicletas. también se puede utilizar para canchas de tenis, baloncesto, fútbol sala y voleibol. El sistema es 100% acrílico, obteniendo una combinación de capas de textura y acabado no abrasivo. Dispone de una gradería cubierta y silletería. En este escenario se puede practicar voleibol, baloncesto y fútbol sala.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA SINTETICA NO. 2','Es una cancha con el sistema de revestimiento acrílico compuesto por seis (6) capas, utilizado en canchas de hockey, pistas de patinaje, ciclo rutas, zonas de bicicletas. también se puede utilizar para canchas de tenis, baloncesto, fútbol sala y voleibol. El sistema es 100% acrílico, obteniendo una combinación de capas de textura y acabado no abrasivo. Dispone de una gradería cubierta y silletería. En este escenario se puede practicar tenis y fútbol sala.', '','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA SINTETICA NO. 3','Es una cancha con el sistema de revestimiento acrílico compuesto por seis (6) capas, utilizado en canchas de hockey, pistas de patinaje, ciclo rutas, zonas de bicicletas. también se puede utilizar para canchas de tenis, baloncesto, fútbol sala y voleibol. El sistema es 100% acrílico, obteniendo una combinación de capas de textura y acabado no abrasivo. Dispone de una gradería cubierta y silletería. En este escenario se puede practicar tenis y fútbol sala.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA SINTETICA NO. 4','Es una cancha con el sistema de revestimiento acrílico compuesto por seis (6) capas, utilizado en canchas de hockey, pistas de patinaje, ciclo rutas, zonas de bicicletas. también se puede utilizar para canchas de tenis, baloncesto, fútbol sala y voleibol. El sistema es 100% acrílico, obteniendo una combinación de capas de textura y acabado no abrasivo. Dispone de una gradería cubierta y silletería. En este escenario se puede practicar voleibol.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA SINTETICA NO. 5','Es una cancha con el sistema de revestimiento acrílico compuesto por seis (6) capas, utilizado en canchas de hockey, pistas de patinaje, ciclo rutas, zonas de bicicletas. también se puede utilizar para canchas de tenis, baloncesto, fútbol sala y voleibol. El sistema es 100% acrílico, obteniendo una combinación de capas de textura y acabado no abrasivo. Dispone de una gradería cubierta y silletería. En este escenario se puede practicar baloncesto y fútbol sala.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA SINTETICA NO. 6','Es una cancha con el sistema de revestimiento acrílico compuesto por seis (6) capas, utilizado en canchas de hockey, pistas de patinaje, ciclo rutas, zonas de bicicletas. también se puede utilizar para canchas de tenis, baloncesto, fútbol sala y voleibol. El sistema es 100% acrílico, obteniendo una combinación de capas de textura y acabado no abrasivo. Dispone de una gradería cubierta y silletería. En este escenario se puede practicar baloncesto.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA SINTETICA NO. 7','Es una cancha con el sistema de revestimiento acrílico compuesto por seis (6) capas, utilizado en canchas de hockey, pistas de patinaje, ciclo rutas, zonas de bicicletas. también se puede utilizar para canchas de tenis, baloncesto, fútbol sala y voleibol. El sistema es 100% acrílico, obteniendo una combinación de capas de textura y acabado no abrasivo. Dispone de una gradería cubierta y silletería. En este escenario se puede practicar baloncesto.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA DE FUTBOL CDU','Medidas reglamentarias, dispone de tres tribunas en el lado oriental, dos de ellas con cubierta, cancha en grama tipo bermuda 419, grama de alto tráfico, especial para campos deportivos. Se caracteriza por ser muy densa, de textura fina, logra una superficie suave y homogénea, es de color verde oscuro y su crecimiento es agresivo y de cobertura dominante. Puede soportar tráfico intenso y tiene excelente capacidad de regeneración en caso de deterioro.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('PISTA ATLETICA','Escenario con medidas reglamentarias (400 m.), dispone de tres tribunas en el lado oriental, dos de ellas con cubierta.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('COLISEO CUBIERTO UNIVERSITARIO','Escenario cubierto, piso en concreto, recubierto de una base en acrílico, tiene tres tribunas. En este escenario se puede practicar baloncesto, fútbol sala, fútbol sala y voleibol, además de servir como espacio para actividades culturales.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('DOJOS','Dojos cubiertos para la práctica de ai ki do y taekwondo con medidas reglamentarias.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('PATINODROMO','Patinódromo con medidas reglamentarias.','','1','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('PISCINA OLIMPICA DE NATACION','Piscinas olímpicas de clavados y natación con medidas reglamentarias para la práctica de disciplinas como clavados, natación clásica, natación con aletas, polo acuático y rugby subacuático.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('SALONES MULTIFUNCIONALES','Salón para ajedrez, Salón para la práctica de aeróbicos, tenis de mesa y baile deportivo.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('GIMNASIO','Salon acondicionado con diferentes tipos de maquinas para realizar valoraciones, controles y actividades físicas de carácter formativo y deportivo de interés orientadas desde un enfoque y tratamiento multi-diverso con el fin de facilitar y optimizar el desenvolvimiento de sus diferentes capacidades motrices y favorecer su salud','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('SALON DE PESAS','Salon reglamentario para practicar el levantamiento de pesas.','','0','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA DE SOFTBOL','Cancha de softbol con medidas reglamentarias en grama natural.','','0','DIAMANTE');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('PARQUE EJERCICIO','Parque recreativo con estructuras metalicas funcionales para realizar ejercicio, ademas de maquinas multifuncionales para ejercicios de calistenia ubicado detras del coliseo.','','1','TULCAN');

insert into escenario (esc_nombre,esc_descripcion,esc_foto,esc_estado,cat_nombre) values('CANCHA DE FUTBOL DIAMANTE','Cancha de fútbol con medidas reglamentarias en grama natural.','','0','DIAMANTE');
