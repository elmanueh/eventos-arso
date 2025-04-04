CREATE DATABASE IF NOT EXISTS `arso-espacios`;

CREATE DATABASE IF NOT EXISTS `arso-eventos`;

GRANT ALL PRIVILEGES ON `arso-espacios`.* TO 'arso-mysql' @'%';

GRANT ALL PRIVILEGES ON `arso-eventos`.* TO 'arso-mysql' @'%';

FLUSH PRIVILEGES;