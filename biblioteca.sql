



DROP DATABASE BIBLIOTECA;

CREATE DATABASE BIBLIOTECA;
USE BIBLIOTECA;
CREATE TABLE USUARIOS(
Codigo_Usuarios INT UNIQUE auto_increment,
Nombre  VARCHAR(45) NOT NULL,
Email VARCHAR(45)NOT NULL,
Pwd VARCHAR(45) NOT NULL,
Apellido VARCHAR(45),
DNI  VARCHAR(45) NOT NULL,
Domicilio VARCHAR(45),
Ciudad VARCHAR(45),
Provincia VARCHAR(45),
Puesto varchar(45),
CONSTRAINT PK_USUARIOS PRIMARY KEY (Codigo_Usuarios)
);
INSERT INTO USUARIOS(Codigo_Usuarios, Nombre,Email,Pwd, Apellido, DNI, Domicilio, Ciudad, Provincia,puesto) VALUES(12,'Francisco','f@gmail.com','paco123','Benitez','24123451E','Calle Narvaez, 14','Valdemoro','Madrid','admin');

CREATE TABLE LIBROS(
id INT NOT NULL UNIQUE auto_increment,
Nombre VARCHAR(55),
Editorial VARCHAR(55),
Autor VARCHAR(55),
Genero VARCHAR(55),
Fecha DATE,
PRECIO DECIMAL(8,4) NOT NULL,
SAGA VARCHAR(55),
PRESTADO INT,
PRIMARY KEY (id)
);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(7, 'Todo Saldrá Bien', 'Duome', 'Emilio Ortiz Pulido', 'Literatura', '2016-02-23','14.6','Perretes',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(8, 'Todo Saldrá Bien', 'Duome', 'Emilio Ortiz Pulido', 'Literatura', '2016-02-23','14.6','Perretes',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(9, 'Todo Saldrá Bien', 'Duome', 'Emilio Ortiz Pulido', 'Literatura', '2016-02-23','14.6','Perretes',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(10, 'Todo Saldrá Bien', 'Duome', 'Emilio Ortiz Pulido', 'Literatura', '2016-02-23','14.6','Perretes',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(12, 'Seis patas, Dos amigos', 'Duome','Emilio Ortiz Pulido', 'Humanidades', '2017-03-02', '12.9', 'Perretes',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(13, 'A traves de Mis pequeños ojos', 'Duome', 'Emilio Ortiz Pulido', 'Humanidades', '2016-02-03', '11.9', 'Perretes',3);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(14, 'Quijote de la mancha', 'C.La Mancha', 'Cervantes', 'Literatura', '1616-12-03', '6.5','Mancha',2);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(15, 'Tormenta de Espadas', 'Bantan', 'George.R.Martin', 'Literatura', '2012-02-15', '28.3', 'Tronos',2);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(17, 'Festin de Cuervos', 'Bantan', 'George.R.Martin', 'Literatura', '2012-03-05', '33', 'Tronos',3);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(18, 'Danza de Dragones', 'Bantan', 'George.R.Martin', 'Literatura', '2012-04-05', '35', 'Tronos',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(22, 'Juego de tronos', 'Bantan', 'George.R.Martin', 'Literatura', '2019-02-19','37', 'Tronos',3);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(30, 'It', 'Anaya', 'Steven King', 'Literatura', '2012-06-21', '11.9','King',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(33, 'Carrie','Anaya', 'Steven King', 'Literatura', '2012-09-04', '12.4','King',2);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(36, 'El Resplandor', 'Anaya', 'Steven King', 'Literatura', '2012-04-05', '15.7','King',3);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(28, 'La Piedra Filosofal', 'Pearson', 'J.K.Rowling', 'Literatura', '2014-03-16', '21.3', 'Potter',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(32, 'El caliz del fuego', 'Pearson','J.K.Rowling', 'Literatura', '2014-03-16', '21.3', 'Potter',3);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(11, 'Las reliquias de la muerte', 'Pearson', 'J.K.Rowling', 'Literatura', '2014-01-06', '16.7', 'Potter',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(24, 'Codigo Da Vinci ','Book', 'Dan Brown', 'Literatura', '2015-08-12', '15.2','Dan',2);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(50, 'El Alquimista', 'Brasilero','Paulo Cohelo', 'Literatura','2015-08-09','14','Cohelo',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(51, 'Bilbao en el recuerdo', 'El gallo de Oro','Miguel De Unamuno', 'Humanista','2021-05-17','13','Poesía',1);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(52, '1984', 'DEBOLSILLO','George Orwell', 'Literatura','2021-03-10','8.50','Rebelión',3);
INSERT INTO LIBROS(id,Nombre,Editorial,Autor,Genero,Fecha,Precio,Saga,prestado) VALUES(53, 'Rebelión en la granaja', 'DEBOLSILLO','George Orwell', 'Literatura','2021-03-10','8.50','Rebelión',1);





DELIMITER |
CREATE procedure spUpdateLibro(
	libro_id int(11),
    libro_nombre varchar(55),
    libro_editorial varchar(55),
    libro_autor varchar(55),
    libro_genero varchar(55),
    libro_fecha date,
    libro_precio decimal(60,38),
    libro_saga varchar (55),
    libro_prestado int
 
)
BEGIN
update libros SET nombre=libro_nombre, editorial=libro_editorial, autor=libro_autor, genero=libro_genero, fecha=libro_fecha, precio=libro_precio, saga=libro_saga, prestado=libro_prestado
    WHERE libro_id=id;
END |
DELIMITER ;

DELIMITER |
CREATE procedure spNewUser(
	in cd INT,
    in nombre varchar(100),
    in email varchar(100),
    in apellido varchar(100),
    in pwd varchar(100),
    in DNI varchar(100),
    in Domicilio varchar(100),
    in ciudad varchar(100),
    in provincia varchar(100)
 
)
BEGIN
	INSERT INTO usuarios(codigo_usuarios, nombre, email, pwd, apellido, dni, domicilio, ciudad, provincia) VALUES(codigo_usuarios,nombre,email,apellido,pwd,DNI,domicilio,ciudad,provincia);
END |
DELIMITER ;

DELIMITER |
CREATE procedure spNewLibro(
	in cd INT,
    in nombre varchar(100),
    in editorial varchar(100),
    in autor varchar(100),
    in genero varchar(100),
    in fecha date,
    in Precio Decimal(8,4),
    in saga varchar(100),
    in prestado int
 
)
BEGIN
	INSERT INTO libros(id, nombre, editorial, autor, genero, fecha, precio, saga, prestado) VALUES(id, nombre, editorial, autor, genero, fecha, precio, saga, prestado);
END |
DELIMITER ;



DELIMITER |
CREATE procedure spPedirLibro(
	libro_id int(11)
    
 
)
BEGIN
update libros SET prestado=2
    WHERE libro_id=id AND prestado=1;
END |
DELIMITER;



DELIMITER |
CREATE procedure spDevolver(
		libro_id int(11)
    
 
)
BEGIN
update libros SET prestado=1
    WHERE libro_id=id AND prestado=3;
END |
DELIMITER ;
