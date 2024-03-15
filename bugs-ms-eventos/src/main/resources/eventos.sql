create database sql11691020;
use sql11691020;

CREATE TABLE `eventos` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
   `nombre` varchar(45) NOT NULL,
  `descripcion_corta` varchar(45) NOT NULL,
  `descripcion_extendida` varchar(100) NOT NULL,
  `foto` varchar(100) NOT NULL,
  `fecha_evento` varchar(15) NOT NULL,
  `hora_evento` varchar(10) NOT NULL,
  `rango_precios` float(10) NOT NULL,
  `normas` varchar(100) NOT NULL,
  `id_sala` int(11) NOT NULL,
  PRIMARY KEY (`id_evento`),
  FOREIGN KEY (`id_sala`) REFERENCES `sala`(`id_sala`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sala` (
  `id_sala` int(11) NOT NULL AUTO_INCREMENT,
   `nombre` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `tipo_recinto` varchar(20) NOT NULL,
  `aforo` int(10) NOT NULL,
  PRIMARY KEY (`id_sala`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;