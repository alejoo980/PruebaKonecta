-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-04-2022 a las 18:20:55
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cafeteria1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `id_Inventario` int(100) NOT NULL,
  `Referencia` int(100) DEFAULT NULL,
  `Precio` int(100) DEFAULT NULL,
  `Nombre_Producto` text,
  `Peso` int(100) DEFAULT NULL,
  `Categoria` varchar(100) DEFAULT NULL,
  `Stock` int(100) DEFAULT NULL,
  `Fecha_De_Creacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`id_Inventario`, `Referencia`, `Precio`, `Nombre_Producto`, `Peso`, `Categoria`, `Stock`, `Fecha_De_Creacion`) VALUES
(1, 132352, 1000, 'Chocoso', 30, '2', 10, '2022-04-13'),
(3, 45412, 2000, 'big cola', 300, '1', 20, '2022-04-13'),
(4, 5545, 5454, 'gfgf', 4545, 'Alimentos', 6565, '2022-04-13'),
(5, 2569, 2000, 'Chocorramo', 30, 'Alimentos', 15, '2022-04-14'),
(6, 4343, 3232, 'sdsds', 23, 'Liquidos', 23, '2022-04-13'),
(7, 232323, 1500, 'Jabon', 50, 'Liquidos', 5, '1970-01-01'),
(8, 32323, 1200, 'pan pequeño', 80, 'Alimentos', 20, '1970-01-01'),
(9, 323, 1300, 'Jugo hit', 300, 'Liquidos', 23, '2022-04-14'),
(10, 434, 500, 'yuca', 32, 'Alimentos', 23, '2022-04-14'),
(11, 3434, 434, 'Arroz', 3434, 'Alimentos', 3434, '1970-01-01'),
(12, 3434, 3434, 'eeff', 343, 'Alimentos', 343, '2022-04-14'),
(13, 4545, 3434, 'dfd', 3434, 'Alimentos', 343, '2022-04-14'),
(14, 144545, 14545, 'dfdfdf', 144545, 'Alimentos', 145454, '1970-01-01'),
(15, 5454, 3434, 'dfgdfg', 5656, 'Alimentos', 5656, '2022-04-14'),
(16, 343, 343, 'dsfdsfsf', 3434, 'Alimentos', 343, '2022-04-14');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id_Inventario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `id_Inventario` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
