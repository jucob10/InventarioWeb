-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-10-2024 a las 23:50:09
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventariobd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada_producto`
--

CREATE TABLE `entrada_producto` (
  `id` bigint(20) NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL,
  `nombre_proveedor` varchar(255) DEFAULT NULL,
  `tipo_movimiento` varchar(255) DEFAULT NULL,
  `unidades_entrada` int(11) DEFAULT NULL,
  `valor_producto` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrada_producto`
--

INSERT INTO `entrada_producto` (`id`, `categoria`, `codigo`, `nombre_producto`, `nombre_proveedor`, `tipo_movimiento`, `unidades_entrada`, `valor_producto`) VALUES
(1, 'Cables_adaptadores', '1001', 'CABLE HDMI', 'Panamericana', 'Entrada', 10, 10000),
(2, 'Cables_adaptadores', '1003', 'CABLE USB', 'Distribuidora TEC', 'Entrada', 20, 15000),
(3, 'Portatiles', '1004', 'PORTATIL ASUS', 'Compañia USA LTD  ', 'Entrada', 10, 2500000),
(4, 'Audio_Video', '1005', 'DVD', 'ABC Compañia SA', 'Entrada', 15, 100000),
(5, 'Pantallas', '1009', 'MONITOR KALLEY GRIS', 'Compañia USA LTD  ', 'Entrada', 17, 1500000),
(6, 'Audio_Video', '1002', 'PARLANTE', 'Panamericana', 'Entrada', 30, 30000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `dat_id` bigint(20) NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`dat_id`, `categoria`, `codigo`, `nombre_producto`) VALUES
(1, 'Cables_adaptadores', '1001', 'CABLE HDMI'),
(2, 'Audio_Video', '1002', 'PARLANTE'),
(3, 'Cables_adaptadores', '1003', 'CABLE USB'),
(4, 'Portatiles', '1004', 'PORTATIL ASUS'),
(5, 'Audio_Video', '1005', 'DVD'),
(6, 'Portatiles', '1006', 'PORTATIL ACER'),
(7, 'Accesorios', '1007', 'MOUSE USB'),
(8, 'Pantallas', '1008', 'MONITOR SAMSUNG NEGRO'),
(9, 'Pantallas', '1009', 'MONITOR KALLEY GRIS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` bigint(20) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre_proveedor` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `direccion`, `nombre_proveedor`, `pais`) VALUES
(1, 'AV salvador 50-30', 'Compañia A', 'Salvador'),
(2, '143 Calle Palma', 'Compañia B', 'Estados Unidos'),
(3, 'Av calofornia 25 USA', 'Compañia USA LTD  ', 'California USA'),
(4, 'CL 110 # 20 - 15', 'Panamericana', 'Bogota Colombia'),
(5, 'Av BRASIL 20 - 80', 'Corportacion Brasil SAS', 'Brasil'),
(6, 'Av florida 20 - 50', 'Distribuidora TEC', 'Florida USA'),
(7, 'CL 68 # 110 - 39', 'ABC Compañia SA', 'Medellin Colombia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida_producto`
--

CREATE TABLE `salida_producto` (
  `id` bigint(20) NOT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL,
  `tipo_movimiento` varchar(255) DEFAULT NULL,
  `unidades_inventario` double DEFAULT NULL,
  `unidades_salida` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salida_producto`
--

INSERT INTO `salida_producto` (`id`, `nombre_producto`, `tipo_movimiento`, `unidades_inventario`, `unidades_salida`) VALUES
(1, 'PORTATIL ASUS', 'Salida', 10, 2),
(2, 'DVD', 'Salida', 15, 5),
(3, 'PARLANTE', 'Salida', 30, 8),
(4, 'CABLE USB', 'Salida', 20, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE `stock` (
  `id` bigint(20) NOT NULL,
  `producto_stock` varchar(255) DEFAULT NULL,
  `saldo_unidades` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`id`, `producto_stock`, `saldo_unidades`) VALUES
(1, 'CABLE HDMI', 10),
(2, 'CABLE USB', 15),
(3, 'DVD', 10),
(4, 'MONITOR KALLEY GRIS', 17),
(5, 'PARLANTE', 22),
(6, 'PORTATIL ASUS', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `nombre_usuario` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `cargo`, `nombre_usuario`, `password`) VALUES
(1, 'Programador', 'Yissedt', '123'),
(2, 'Scrum Master', 'Johana', '123'),
(3, 'Programador', 'Miguel', '123'),
(4, 'Product Owner', 'Julian', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrada_producto`
--
ALTER TABLE `entrada_producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`dat_id`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `salida_producto`
--
ALTER TABLE `salida_producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entrada_producto`
--
ALTER TABLE `entrada_producto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `dat_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `salida_producto`
--
ALTER TABLE `salida_producto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `stock`
--
ALTER TABLE `stock`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
