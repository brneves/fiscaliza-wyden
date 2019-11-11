-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 11-Nov-2019 às 23:14
-- Versão do servidor: 5.7.23
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fiscaliza`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ocorrencia`
--

DROP TABLE IF EXISTS `ocorrencia`;
CREATE TABLE IF NOT EXISTS `ocorrencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_cadastro` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `foto` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `latitude` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `longitude` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `problema_id` bigint(20) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKelyfv9odc1ojbee58q8nb1nmr` (`problema_id`),
  KEY `FK8vyx5i6two7max2jhlodwew57` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `ocorrencia`
--

INSERT INTO `ocorrencia` (`id`, `data_cadastro`, `descricao`, `foto`, `latitude`, `longitude`, `status`, `problema_id`, `usuario_id`) VALUES
(7, '10/11/2019', 'Semáforo não funciona, instalado tem 2 semanas e não funciona', NULL, '-2.540367', '-44.210097', '0', 4, 7),
(8, '10/11/2019', 'Buraco na pista, asfaltaram todos e esqueceram desse', NULL, '-2.570237', '-44.228752', '0', 1, 7),
(9, '10/11/2019', 'Parada de ônibus toda quebrada', NULL, '-2.537366', '-44.223148', '0', 2, 7),
(10, '10/11/2019', 'Não existe parada de ônibus, ficamos esperando no sol', NULL, '-2.540146', '-44.209190', '0', 2, 7),
(11, '10/11/2019', 'Motoristas não param na parada', NULL, '-2.543585', '-44.215158', '0', 2, 7),
(12, '10/11/2019', 'Calçada sem acessibilidade', NULL, '-2.523451', '-44.245101', '0', 3, 7),
(13, '10/11/2019', 'Desnível muito grande na ponte', NULL, '-2.516601', '-44.269819', '0', 1, 7),
(14, '10/11/2019', 'Rua toda esburacada', NULL, '-2.554848', '-44.206177', '0', 1, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `problema`
--

DROP TABLE IF EXISTS `problema`;
CREATE TABLE IF NOT EXISTS `problema` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `icone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `problema` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `problema`
--

INSERT INTO `problema` (`id`, `icone`, `problema`) VALUES
(1, 'img/buraco.png', 'Buraco no asfalto'),
(2, 'img/onibus.png', 'Problema na parada de ônibus'),
(3, 'img/acessibilidade.png', 'Falta de Acessibilidade'),
(4, 'img/semaforo.png', 'Semáforo com defeito');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `senha` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `email`, `nome`, `senha`) VALUES
(7, 'ronaldo@ronaldoneves.com.br', 'Ronaldo Neves', '12');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `ocorrencia`
--
ALTER TABLE `ocorrencia`
  ADD CONSTRAINT `FK8vyx5i6two7max2jhlodwew57` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKelyfv9odc1ojbee58q8nb1nmr` FOREIGN KEY (`problema_id`) REFERENCES `problema` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
