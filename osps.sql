-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2018 a las 07:23:46
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `osps`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activeproject`
--

CREATE TABLE `activeproject` (
  `projectID` int(11) NOT NULL,
  `userName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `activeproject`
--

INSERT INTO `activeproject` (`projectID`, `userName`) VALUES
(16, 'Carlos'),
(23, 'luis');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `userName` varchar(30) NOT NULL,
  `userPassword` varchar(30) NOT NULL,
  `email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`userName`, `userPassword`, `email`) VALUES
('admin', '1234', ''),
('Carlos', '1234', 'carlos@gmail.com'),
('David', '1234', 'david@gmail.com'),
('Luis', '1234', 'luis@gmail.com'),
('Pepe', '1234', 'pepe@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `project`
--

CREATE TABLE `project` (
  `projectID` int(11) NOT NULL,
  `nombreProyecto` varchar(30) NOT NULL,
  `lenguajeProyecto` varchar(30) CHARACTER SET utf32 NOT NULL,
  `github` varchar(60) DEFAULT NULL,
  `adminProyecto` varchar(30) DEFAULT NULL,
  `fechaInicio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `descripcionProyecto` varchar(250) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `project`
--

INSERT INTO `project` (`projectID`, `nombreProyecto`, `lenguajeProyecto`, `github`, `adminProyecto`, `fechaInicio`, `descripcionProyecto`) VALUES
(14, 'Prueba1', 'C++', 'https://github.com/', NULL, '2018-05-11 03:16:50', 'Descripcion sobre el proyecto numero 1'),
(16, 'Prueba2', 'C', 'https://github.com/es', NULL, '2018-05-11 03:17:55', 'Descripcion sobre el proyecto numero 2'),
(22, 'Prueba3', 'Java', 'https://github.com/ess', NULL, '2018-05-11 03:45:41', 'Descripcion sobre el proyecto numero 3'),
(23, 'Nuevo', 'Angular 5', 'https://github.com/es/es', 'admin', '2018-05-11 04:20:56', 'Descripcion sobre el proyecto 4'),
(24, 'Nuevo-2', 'Angular JS', 'https://github.com/es/es/es', 'admin', '2018-05-11 06:52:28', 'Descripcion sobre el proyecto');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activeproject`
--
ALTER TABLE `activeproject`
  ADD PRIMARY KEY (`projectID`,`userName`),
  ADD KEY `userName` (`userName`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userName`);

--
-- Indices de la tabla `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`projectID`),
  ADD UNIQUE KEY `nombreProyecto` (`nombreProyecto`),
  ADD UNIQUE KEY `github` (`github`),
  ADD KEY `adminProyecto` (`adminProyecto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `project`
--
ALTER TABLE `project`
  MODIFY `projectID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `activeproject`
--
ALTER TABLE `activeproject`
  ADD CONSTRAINT `activeproject_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `login` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `activeproject_ibfk_2` FOREIGN KEY (`projectID`) REFERENCES `project` (`projectID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`adminProyecto`) REFERENCES `login` (`userName`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
