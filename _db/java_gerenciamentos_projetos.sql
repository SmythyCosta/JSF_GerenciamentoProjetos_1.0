-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 28-Out-2019 às 18:52
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_gerenciamentos_projetos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `email` varchar(40) NOT NULL,
  `foto` longblob,
  `nascimento` date NOT NULL,
  `nome` varchar(50) NOT NULL,
  `nome_usuario` varchar(20) NOT NULL,
  `salario` decimal(10,2) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `grupo` int(11) NOT NULL,
  `setor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `ativo`, `cpf`, `email`, `foto`, `nascimento`, `nome`, `nome_usuario`, `salario`, `senha`, `grupo`, `setor`) VALUES
(1, 1, '871.530.070-67', 'smythy.costa@gmail.com', NULL, '1985-01-25', 'smythy', 'smythycosta', '2000.00', '123456', 1, 2),
(3, 1, '893.601.700-46', 'gsjhgjdas@fff.bb', NULL, '1978-06-25', 'marcelo carioca', 'mcarioca', '4000.00', '1234567', 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `grupo`
--

CREATE TABLE `grupo` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `grupo`
--

INSERT INTO `grupo` (`id`, `nome`) VALUES
(1, 'Administradores'),
(2, 'Publico');

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto`
--

CREATE TABLE `projeto` (
  `id` int(11) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `descricao` longtext NOT NULL,
  `fim` date NOT NULL,
  `inicio` date NOT NULL,
  `nome` varchar(50) NOT NULL,
  `setor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `projeto`
--

INSERT INTO `projeto` (`id`, `ativo`, `descricao`, `fim`, `inicio`, `nome`, `setor`) VALUES
(1, 1, 'dka kjlwk jt tjrlkt k trt', '2020-01-01', '2019-01-01', 'Eccomerce', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto_funcionario`
--

CREATE TABLE `projeto_funcionario` (
  `id` int(11) NOT NULL,
  `carga_horaria` int(11) NOT NULL,
  `fim_participacao` date NOT NULL,
  `gestor` tinyint(1) NOT NULL,
  `inicio_participacao` date NOT NULL,
  `funcionario` int(11) NOT NULL,
  `projeto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `projeto_funcionario`
--

INSERT INTO `projeto_funcionario` (`id`, `carga_horaria`, `fim_participacao`, `gestor`, `inicio_participacao`, `funcionario`, `projeto`) VALUES
(1, 20, '2019-02-25', 0, '2019-01-25', 1, 1),
(2, 30, '2019-06-05', 1, '2019-03-05', 3, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `setor`
--

CREATE TABLE `setor` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `setor`
--

INSERT INTO `setor` (`id`, `nome`) VALUES
(1, 'comercial'),
(2, 'operacional'),
(3, 'Recursos humanos'),
(4, 'financeiro'),
(5, 'test__Aaa'),
(6, 'test__Aaa2'),
(7, 'test__Aaa3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_rxosr8731eb3gbnlbt2mqfan8` (`cpf`),
  ADD UNIQUE KEY `UK_9elpj0b1l6l2nhq2ihcm2ohig` (`nome_usuario`),
  ADD UNIQUE KEY `UK_novw20q00ab613trwat48xjar` (`senha`),
  ADD KEY `IDX_USUARIO_NOME_USUARIO` (`nome_usuario`),
  ADD KEY `FK_2epyl7ynp1k1li649nj2skwwc` (`grupo`),
  ADD KEY `FK_od11aipxjf0cg1oj3ibr3o26b` (`setor`);

--
-- Indexes for table `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `projeto`
--
ALTER TABLE `projeto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_78xjktrduib7n0l937rac33h` (`setor`);

--
-- Indexes for table `projeto_funcionario`
--
ALTER TABLE `projeto_funcionario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ib6ch73es0ypu1lxtdbqoqff5` (`funcionario`),
  ADD KEY `FK_b86mgiterjthopv6h1atspjfm` (`projeto`);

--
-- Indexes for table `setor`
--
ALTER TABLE `setor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `grupo`
--
ALTER TABLE `grupo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `projeto`
--
ALTER TABLE `projeto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `projeto_funcionario`
--
ALTER TABLE `projeto_funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `FK_2epyl7ynp1k1li649nj2skwwc` FOREIGN KEY (`grupo`) REFERENCES `grupo` (`id`),
  ADD CONSTRAINT `FK_od11aipxjf0cg1oj3ibr3o26b` FOREIGN KEY (`setor`) REFERENCES `setor` (`id`);

--
-- Limitadores para a tabela `projeto`
--
ALTER TABLE `projeto`
  ADD CONSTRAINT `FK_78xjktrduib7n0l937rac33h` FOREIGN KEY (`setor`) REFERENCES `setor` (`id`);

--
-- Limitadores para a tabela `projeto_funcionario`
--
ALTER TABLE `projeto_funcionario`
  ADD CONSTRAINT `FK_b86mgiterjthopv6h1atspjfm` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`id`),
  ADD CONSTRAINT `FK_ib6ch73es0ypu1lxtdbqoqff5` FOREIGN KEY (`funcionario`) REFERENCES `funcionario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
