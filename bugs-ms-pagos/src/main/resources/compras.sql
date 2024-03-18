DROP TABLE `compras`;
CREATE TABLE `compras` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
   `id_usuario` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
   `nombre_evento` varchar(45) NOT NULL,
  `precio` float(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  PRIMARY KEY (`id_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;