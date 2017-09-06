-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06-Set-2017 às 04:21
-- Versão do servidor: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `controledelivros`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE `livro` (
  `IdLivro` int(11) NOT NULL,
  `Titulo` varchar(100) NOT NULL,
  `Autor` varchar(100) NOT NULL,
  `Genero` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`IdLivro`, `Titulo`, `Autor`, `Genero`) VALUES
(1, 'Como Passar Em PWE', 'Gabriel Darruiz', 'Tecnologia');

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro_usuario`
--

CREATE TABLE `livro_usuario` (
  `idUsuario` int(11) NOT NULL,
  `idLivro` int(11) NOT NULL,
  `Status_Leitura` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(3) NOT NULL,
  `email` varchar(200) NOT NULL,
  `senha` varchar(16) NOT NULL,
  `nome` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `email`, `senha`, `nome`) VALUES
(1, 'victor@gmail.com', '12345678', 'Victor Goulart'),
(2, 'tyfcgvjhkgytfcyr', 'adfasd@as.com', 'tyfcgvjhkgytfcyr'),
(3, 'gabriel@gmail.com', '123', 'gabriel');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `livro`
--
ALTER TABLE `livro`
  ADD PRIMARY KEY (`IdLivro`);

--
-- Indexes for table `livro_usuario`
--
ALTER TABLE `livro_usuario`
  ADD PRIMARY KEY (`idUsuario`,`idLivro`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `livro`
--
ALTER TABLE `livro`
  MODIFY `IdLivro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
