CREATE DATABASE proyecto;

USE proyecto;

/*1- tabla (maestra: contiene la info general de una sabana) 23,prueba,20/04/2026,sabana prueba
idsabana primarykey 
nombre,
fechas
comentario*/
CREATE TABLE maestra(
	id_sabana INT PRIMARY KEY,
	nombre VARCHAR(30),
	fecha DATE,
	comentario VARCHAR(100)
);
/*2.- servicios  1,23, xxx,Servicio de mantenimiento  de desarrollo	Seguimiento	Soporte avanzado		                1,0 	        490,00 € 	      1,0 	                     490 € 	                            -   € 	35,0%	0,0%	                       754 € 		1							1					
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
	id_servicios INT,
	id_sabana INT,
	Concepto VARCHAR(100),
	Comentario VARCHAR(100),
	Tipo VARCHAR(50),
	Agrupacion_topes VARCHAR(30),
	Horas DECIMAL(4,2),
	Costes_h DECIMAL(4,2),
	Mult DECIMAL(4,2),
	Coste DECIMAL(4,2),
	Tope_licitación DECIMAL(4,2),
	Margen DECIMAL(4,2),	
	Des DECIMAL(4,2),
	PVP	DECIMAL(4,2),
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
	i6	INT
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
	id_areaContabilidad INT,
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
	Hito_cierre INT
);

/*4- Margenes  1,23,1,35
idmargen primarykey
idsabana foreingkey
idtipomargen  foreingkey
margen*/
CREATE TABLE margenes( 
	id_margen INT,
	id_sabana INT,
	id_tipoMargen INT, 
	margen DECIMAL(4,2)
);
												
/*5- topes 1,23,3,null
idtopes primarykey
idsabana  foreingkey
idtipoTopes  foreingkey
topes*/
CREATE TABLE topes( 
	id_topes INT, 
	id_sabana INT,
	id_tipoTopes INT, 
	topes INT
);

/*6.- TipoMargenes 1,implantacion
idtipomargen primarykey
tipo*/
CREATE TABLE tipoMargenes(
	id_tipoMargen INT,
	tipo VARCHAR(50)
);

/*7.- TipoTopes 3,gestion
idtipoTopes primarykey
Agrupacióntopes*/
CREATE TABLE tipoTopes(
	id_tipoTopes INT,
	agrupacionTopes INT
);

/*8.- margenesanuales
idmargenanual
idmargen
año 
COSTE por Expediente	
PVP por Expediente	
GP por Expediente	
%GP*/
CREATE TABLE margenesMensuales( 
	id_margenAnual INT,
	id_margen INT,
	ano INT,
	COSTE DECIMAL(4,2),	
	PVP DECIMAL(4,2),
	GP 	INT,
	GPpct INT
);

/*9.- topesanuales
idtopeanual
idtope
años
COSTE	
PVP	GP	
%GP*/
CREATE TABLE topes_anuales( 
	id_topeAnual INT,
	id_tope INT,
	anos INT,
	COSTE DECIMAL(4,2),
	PVP DECIMAL(4,2),	
	GP INT,
	GPpct INT
);