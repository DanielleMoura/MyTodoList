-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Maio-2020 às 01:24
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `todolist`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(21);

-- --------------------------------------------------------

--
-- Estrutura da tabela `subtarefa`
--

CREATE TABLE `subtarefa` (
  `codigosub` bigint(20) NOT NULL,
  `horario` varchar(255) DEFAULT NULL,
  `nome_sub_tarefa` varchar(255) DEFAULT NULL,
  `tarefa_codigo` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tarefa`
--

CREATE TABLE `tarefa` (
  `codigo` bigint(20) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome_da_tarefa` varchar(255) DEFAULT NULL,
  `prazo` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tarefa_subtarefa`
--

CREATE TABLE `tarefa_subtarefa` (
  `tarefa_codigo` bigint(20) NOT NULL,
  `subtarefa_codigo` bigint(20) NOT NULL,
  `subtarefa_horario` varchar(255) NOT NULL,
  `subtarefa_codigosub` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `subtarefa`
--
ALTER TABLE `subtarefa`
  ADD PRIMARY KEY (`codigosub`),
  ADD KEY `FKln0pexclvms4n85byso3hooxk` (`tarefa_codigo`);

--
-- Índices para tabela `tarefa`
--
ALTER TABLE `tarefa`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `tarefa_subtarefa`
--
ALTER TABLE `tarefa_subtarefa`
  ADD UNIQUE KEY `UK_c1qshht255f1oevirdltouk6h` (`subtarefa_codigo`),
  ADD UNIQUE KEY `UK_22k32dh11mwoqlqh47y654nj0` (`subtarefa_codigosub`),
  ADD UNIQUE KEY `UK_1k6viqthty4m97v1v5ghpsh7n` (`subtarefa_horario`) USING HASH,
  ADD KEY `FKtci64f0sgjbekifjw1r44nbpd` (`tarefa_codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
