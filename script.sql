CREATE DATABASE IF NOT EXISTS proyecto;

USE proyecto;

/*1- tabla (maestra: contiene la info general de una sabana) 23,prueba,20/04/2026,sabana prueba
idsabana primarykey 
nombre,
fechas
comentario*/
CREATE TABLE maestra(
	id_sabana INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(30),
	fecha DATE,
	comentario VARCHAR(100)
);
/*2.- servicios  1,23, xxxx,Servicio de mantenimiento  de desarrollo	Seguimiento	Soporte avanzado		                1,0 	        490,00 € 	      1,0 	                     490 € 	                            -   € 	35,0%	0,0%	                       754 € 		1							1					
idservicios primarykey
idsabana foreingkey
Concepto	
Comentario	
Tipo	
Agrupación topes	
Horas	
Coste/h	
Mult.	
Coste	
Tope licitación
Margen	
Desc.	
PVP	
I	
1	
2
3
4
5
6
I
1
2	
3
4	
5	
6*/
CREATE TABLE servicios(
	id_servicios INT AUTO_INCREMENT PRIMARY KEY,
    id_sabana INT,
    Concepto VARCHAR(100),
    Comentario VARCHAR(100),
    Tipo VARCHAR(50),
    Agrupacion_topes VARCHAR(30),
    Horas DECIMAL(4,2),
    Costes_h DECIMAL(4,2),
    Mult DECIMAL(4,2),
    Coste DECIMAL(4,2),
    Tope_licitacion DECIMAL(4,2),
    Margen DECIMAL(4,2),
    Des DECIMAL(4,2),
    PVP DECIMAL(4,2),
	cI	INT,
	c1	INT,
	c2	INT,
	c3	INT,
	c4	INT,
	c5	INT,
	c6	INT,	
	iI	INT,
	i1	INT,
	i2	INT,
	i3	INT,
	i4	INT,
	i5	INT,
	i6	INT,
	FOREIGN KEY (id_sabana) REFERENCES maestra(id_sabana)
);

/*3.- area contabilidad 1,1,xx,x,,x,,x
idareacontabilidad primarykey
idservicios foreingkey
Tipo Pago 	
Meses 	
Hito firma	
H1	
H2	
H3	
H4	
H5	
H6	
Hito cierre*/
CREATE TABLE areaContabilidad(
	id_areaContabilidad INT AUTO_INCREMENT PRIMARY KEY,
	id_servicios INT,
	Tipo_pago VARCHAR(50),
	Meses INT,
	Hito_firma INT,
	H1 INT,	
	H2 INT,
	H3 INT,
	H4 INT,
	H5 INT,
	H6 INT,
	Hito_cierre INT,
	FOREIGN KEY (id_servicios) REFERENCES servicios(id_servicios)
);

/*4- Margenes  1,23,1,35
idmargen primarykey
idsabana foreingkey
idtipomargen  foreingkey
margen*/
CREATE TABLE margenes( 
	id_margen INT AUTO_INCREMENT PRIMARY KEY,
	id_sabana INT,
	id_tipoMargen INT, 
	margen DECIMAL(4,2),
	FOREIGN KEY (id_sabana) REFERENCES maestra(id_sabana),
	FOREIGN KEY (id_tipoMargen) REFERENCES tipoMargenes(id_tipoMargen)
);
												
/*5- topes 1,23,3,null
idtopes primarykey
idsabana  foreingkey
idtipoTopes  foreingkey
topes*/
CREATE TABLE topes( 
	id_topes INT AUTO_INCREMENT PRIMARY KEY, 
	id_sabana INT,
	id_tipoTopes INT, 
	topes INT,
	FOREIGN KEY (id_sabana) REFERENCES maestra(id_sabana),
	FOREIGN KEY (id_tipoTopes) REFERENCES tipoTopes(id_tipoTopes)
);

/*6.- TipoMargenes 1,implantacion
idtipomargen primarykey
tipo*/
CREATE TABLE tipoMargenes(
	id_tipoMargen INT AUTO_INCREMENT PRIMARY KEY,
	tipo VARCHAR(50)
);

/*7.- TipoTopes 3,gestion
idtipoTopes primarykey
Agrupacióntopes*/
CREATE TABLE tipoTopes(
	id_tipoTopes INT AUTO_INCREMENT PRIMARY KEY,
	agrupacionTopes VARCHAR(30)
);

/*8.- margenesanuales
idmargenanual
idmargen
año 
COSTE por Expediente	
PVP por Expediente	
GP por Expediente	
%GP*/
CREATE TABLE margenesAnuales( 
	id_margenAnual INT AUTO_INCREMENT PRIMARY KEY,
	id_margen INT,
	ano INT,
	COSTE DECIMAL(4,2),	
	PVP DECIMAL(4,2),
	GP 	INT,
	GPpct INT,
	FOREIGN KEY (id_margen) REFERENCES margenes(id_margen)
);

/*9.- topesanuales
idtopeanual
idtope
años
COSTE	
PVP	GP	
%GP*/
CREATE TABLE topes_anuales( 
	id_topeAnual INT AUTO_INCREMENT PRIMARY KEY,
	id_topes INT,
	anos INT,
	COSTE DECIMAL(4,2),
	PVP DECIMAL(4,2),	
	GP INT,
	GPpct INT,
	FOREIGN KEY (id_topes) REFERENCES topes(id_topes)
	
USE proyecto;
INSERT INTO tipoTopes (agrupacionTopes) VALUES ('Implantacion'), ('Formacion'), ('Gestion'), ('Infraestructura'), ('Soporte'), ('Soporte avanzado'), ('Evolucion y mejora'), ('Desarrollo'), ('Comodin 1'), ('Comodin 2'), ('Comodin 3'), ('Comodin 4');

ALTER TABLE margenes MODIFY margen DECIMAL(10,2);
ALTER TABLE topes MODIFY topes INT;
ALTER TABLE servicios MODIFY Horas DECIMAL(10,2);
ALTER TABLE servicios MODIFY Costes_h DECIMAL(10,2);
ALTER TABLE servicios MODIFY Mult DECIMAL(10,2);
ALTER TABLE servicios MODIFY Coste DECIMAL(10,2);
ALTER TABLE servicios MODIFY Tope_licitacion DECIMAL(10,2);
ALTER TABLE servicios MODIFY Margen DECIMAL(10,2);
ALTER TABLE servicios MODIFY Des DECIMAL(10,2);
ALTER TABLE servicios MODIFY PVP DECIMAL(10,2);


USE proyecto;
SELECT * FROM tipoMargenes;
SELECT * FROM tipoTopes;

USE proyecto;
INSERT INTO tipoMargenes (tipo) VALUES ('Implantacion'), ('Formacion'), ('Gestion'), ('Infraestructura'), ('Soporte'), ('Soporte avanzado'), ('Evolucion y mejora'), ('Desarrollo'), ('Comodin 1'), ('Comodin 2'), ('Comodin 3'), ('Comodin 4');

USE proyecto;
DELETE FROM topes;
DELETE FROM margenes;
DELETE FROM servicios;
DELETE FROM maestra;
ALTER TABLE maestra AUTO_INCREMENT = 1;
ALTER TABLE servicios AUTO_INCREMENT = 1;
ALTER TABLE margenes AUTO_INCREMENT = 1;
ALTER TABLE topes AUTO_INCREMENT = 1;

);