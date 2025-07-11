DROP DATABASE IF EXISTS aeropuertodb;
DROP TABLE IF EXISTS puedeAterrizar CASCADE;
DROP TABLE IF EXISTS escalas CASCADE;
DROP TABLE IF EXISTS vuelos CASCADE;
DROP TABLE IF EXISTS avion CASCADE;
DROP TABLE IF EXISTS tipoDeAvion CASCADE;
DROP TABLE IF EXISTS aeropuerto CASCADE;
create database aeropuertodb;
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE aeropuerto(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombreaeropuerto varchar(128) not null,
    ciudad varchar(128),
    pais varchar(128)
);

CREATE TABLE tipodeavion(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombretipodeavion varchar(128) not null,
    cantidadmaximaasientos int,
    empresa varchar(64)
);

CREATE TABLE avion(
    numerodeserieavion UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tipodeavion UUID,
    totaldeasientos int,
    foreign key (tipodeavion) references tipodeavion(id)
);

CREATE TABLE vuelos(
    numerodevuelo UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    numeroserieavion UUID,
    aeropuertosalida UUID,
    horasalida time,
    aeropuertollegada UUID,
    horallegada time,
    foreign key (numeroserieavion) references avion(numerodeserieavion),
    foreign key (aeropuertosalida) references aeropuerto(id),
    foreign key (aeropuertollegada) references aeropuerto(id)
);

CREATE TABLE escalas(
    numerodeescala UUID not null,
    numerodevuelo UUID,
    idaeropuerto UUID,
    horallegada time,
    horapartida time,
    primary key (numerodeescala, numerodevuelo),
    foreign key (idaeropuerto) references aeropuerto(id),
    foreign key (numerodevuelo) references vuelos(numerodevuelo)
);

CREATE TABLE puedeaterrizar(
    nombretipodeAvion UUID,
    nombreaeropuerto UUID,
    foreign key (nombretipodeAvion) references tipodeavion(id),
    foreign key (nombreaeropuerto) references aeropuerto(id)
);


CREATE UNIQUE INDEX idx_pk_aeropuerto ON aeropuerto(id);
CREATE UNIQUE INDEX idx_pk_tipodeavion ON tipodeavion(id);
CREATE UNIQUE INDEX idx_pk_avion ON avion(numerodeserieavion);
CREATE UNIQUE INDEX idx_pk_vuelos ON vuelos(numerodevuelo);
CREATE UNIQUE INDEX idx_pk_escalas ON escalas(numerodevuelo, numerodeescala);

CREATE INDEX idx_fk_vuelos_avion ON vuelos(numeroserieavion);
CREATE INDEX idx_fk_vuelos_salida ON vuelos(aeropuertosalida);
CREATE INDEX idx_fk_vuelos_llegada ON vuelos(aeropuertollegada);
CREATE INDEX idx_fk_escalas_vuelo ON escalas(numerodevuelo);
CREATE INDEX idx_fk_escalas_aeropuerto ON escalas(idaeropuerto);
CREATE INDEX idx_fk_avion_tipo ON avion(tipodeavion);
CREATE INDEX idx_fk_puedeaterrizar_tipo ON puedeaterrizar(nombretipodeavion);
CREATE INDEX idx_fk_puedeaterrizar_aeropuerto ON puedeaterrizar(nombreaeropuerto);


INSERT INTO aeropuerto (id, nombreaeropuerto, ciudad, pais) VALUES
('11111111-1111-1111-1111-111111111111','Aeropuerto Internacional de Ezeiza', 'Buenos Aires', 'Argentina'),
('22222222-2222-2222-2222-222222222222','Aeroparque Jorge Newbery', 'Buenos Aires', 'Argentina'),
('33333333-3333-3333-3333-333333333333','Aeropuerto de Córdoba', 'Córdoba', 'Argentina'),
('44444444-4444-4444-4444-444444444444','Aeropuerto Internacional Simón Bolívar', 'Caracas', 'Venezuela'),
('55555555-5555-5555-5555-555555555555','Aeropuerto Internacional Mariscal Sucre', 'Quito', 'Ecuador'),
('66666666-6666-6666-6666-666666666666','Aeropuerto Internacional de Colonia', 'Colonia', 'Uruguay');


INSERT INTO tipodeavion (id, nombretipodeavion, cantidadmaximaasientos , empresa) VALUES
('11111111-2222-1111-1111-111111111111','Boeing 737', 180, 'Boeing'),
('22222222-3333-2222-2222-222222222222','Airbus A320', 160, 'Airbus'),
('33333333-4444-3333-3333-333333333333','Embraer 190', 100, 'Embraer');


insert into avion (numerodeserieavion, tipodeavion , totaldeasientos) values 
('11111111-2222-2222-1111-111111111111','22222222-3333-2222-2222-222222222222', 115),
('22222222-3333-3333-2222-222222222222','11111111-2222-1111-1111-111111111111', 195),
('66666666-1111-6666-6666-666666666666','33333333-4444-3333-3333-333333333333', 78);
('66666666-1111-6666-2312-666666666666','33333333-4444-3333-3333-333333333333', 3);

INSERT INTO vuelos(numerodevuelo , numeroserieavion , aeropuertosalida , horasalida , aeropuertollegada , horallegada) VALUES
('66666666-1111-2222-6666-666666666666', '11111111-2222-2222-1111-111111111111', '11111111-1111-1111-1111-111111111111', '14:00:00', '22222222-2222-2222-2222-222222222222', '15:00:00'),
('22222222-3333-3333-1111-222222222222','22222222-3333-3333-2222-222222222222', '33333333-3333-3333-3333-333333333333', '09:00:00', '44444444-4444-4444-4444-444444444444', '13:30:00'),
('33333333-4444-3333-1111-333333333333', '66666666-1111-6666-6666-666666666666', '55555555-5555-5555-5555-555555555555', '05:45:00', '66666666-6666-6666-6666-666666666666', '08:00:00');

INSERT INTO escalas (numerodeescala , numerodevuelo , idaeropuerto , horallegada , horapartida ) VALUES
('33333333-4444-3333-2222-333333333333', '22222222-3333-3333-1111-222222222222','66666666-6666-6666-6666-666666666666', '11:30:00', '12:00:00'),
('22222222-3333-7777-1111-222222222222', '33333333-4444-3333-1111-333333333333', '44444444-4444-4444-4444-444444444444', '07:00:00', '07:15:00')
/* El primero es de Argentina a Venezuela, tiene escala en Uruguay, y el segundo es de ecuador a uruguay, con escala en venezuela */

INSERT INTO puedeAterrizar (nombretipodeavion , nombreaeropuerto) VALUES
('11111111-2222-1111-1111-111111111111','22222222-2222-2222-2222-222222222222'),
('22222222-3333-2222-2222-222222222222','44444444-4444-4444-4444-444444444444'),
('33333333-4444-3333-3333-333333333333','66666666-6666-6666-6666-666666666666');

insert into avion (numerodeserieavion, tipodeavion , totaldeasientos) values
('66666666-1111-6666-2312-666666666666','33333333-4444-3333-3333-333333333333', 3);

select * from aeropuerto;
select * from tipodeavion;
select * from avion;
select * from vuelos;
select * from escalas;
select * from puedeaterrizar;