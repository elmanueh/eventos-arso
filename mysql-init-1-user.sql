-- Este script crea las bases de datos y los usuarios necesarios para el funcionamiento de la aplicación.

CREATE DATABASE IF NOT EXISTS `arso-espacios`;
CREATE DATABASE IF NOT EXISTS `arso-eventos`;
GRANT ALL PRIVILEGES ON `arso-espacios`.* TO 'arso-mysql' @'%';
GRANT ALL PRIVILEGES ON `arso-eventos`.* TO 'arso-mysql' @'%';
FLUSH PRIVILEGES;
