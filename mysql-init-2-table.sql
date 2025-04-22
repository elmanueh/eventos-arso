-- Este script crea las tablas necesarias para el funcionamiento de la aplicación.

-- Base de datos arso-espacios
USE `arso-espacios`;

CREATE TABLE `espacioFisico` (
  `id` varchar(36) NOT NULL,
  `capacidad` int DEFAULT NULL,
  `descripcion` longtext,
  `direccion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `propietario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `puntoInteres` (
  `id` varchar(36) NOT NULL,
  `descripcion` longtext,
  `distancia` float DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `url` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `espacioFisico_puntoInteres` (
  `idEspacioFisico` varchar(36) NOT NULL,
  `idPuntosInteres` varchar(36) NOT NULL,
  PRIMARY KEY (`idEspacioFisico`,`idPuntosInteres`),
  KEY `FK_espacioFisico_puntoInteres_idPuntosInteres` (`idPuntosInteres`),
  CONSTRAINT `FK_espacioFisico_puntoInteres_idEspacioFisico` FOREIGN KEY (`idEspacioFisico`) REFERENCES `espacioFisico` (`id`),
  CONSTRAINT `FK_espacioFisico_puntoInteres_idPuntosInteres` FOREIGN KEY (`idPuntosInteres`) REFERENCES `puntoInteres` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Base de datos arso-eventos
USE `arso-eventos`;

CREATE TABLE `espacioFisico` (
  `id` varchar(36) NOT NULL,
  `cancelado` bit(1) DEFAULT NULL,
  `capacidad` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ocupacion` (
  `id` varchar(36) NOT NULL,
  `fechaFin` datetime(6) DEFAULT NULL,
  `fechaInicio` datetime(6) DEFAULT NULL,
  `idEspacioFisico` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgmepjdqtsc6vudeo6bm5exln4` (`idEspacioFisico`),
  CONSTRAINT `FKgmepjdqtsc6vudeo6bm5exln4` FOREIGN KEY (`idEspacioFisico`) REFERENCES `espacioFisico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `evento` (
  `id` varchar(36) NOT NULL,
  `cancelado` bit(1) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `descripcion` longtext,
  `nombre` varchar(255) DEFAULT NULL,
  `plazas` int DEFAULT NULL,
  `organizador` varchar(255) DEFAULT NULL,
  `idOcupacion` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKig2eg5l88q2mm318mnh8pmmq7` (`idOcupacion`),
  CONSTRAINT `FKig2eg5l88q2mm318mnh8pmmq7` FOREIGN KEY (`idOcupacion`) REFERENCES `ocupacion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;