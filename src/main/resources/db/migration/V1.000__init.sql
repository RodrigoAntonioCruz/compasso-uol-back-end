-- --------------------------------------------------------
--
-- Banco de dados: `compasso_db` - V1.000__init
--
-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(155) NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nome`, `estado`) VALUES
(1, 'Porto Alegre', 'RS'),
(2, 'Florianópolis', 'SC'),
(3, 'Uruguaiana', 'RS'),
(4, 'Curitiba', 'PR'),
(5, 'Chapecó', 'SC'),
(6, 'Fortaleza', 'CE'),
(7, 'São Paulo', 'SP'),
(8, 'Jundiaí', 'SP'),
(9, 'Belford Roxo', 'RJ'),
(10, 'Rio de Janeiro', 'RJ');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(155) NOT NULL,
  `idade` int(20) NOT NULL,
  `data_nascimento` date NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `cidade_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `idade`, `data_nascimento`, `sexo`, `cidade_id`) VALUES
(1, 'Rodrigo Cruz', '36', '1985-06-28', 'M', 1),
(2, 'Antonio Cezar', '38', '1983-03-25', 'M', 3),
(3, 'Jane Carla', '41', '1980-04-30', 'F', 10),
(4, 'Junior Silva', '37', '1984-06-28', 'M', 4),
(5, 'André Augusto Santos', '43', '1978-08-25', 'M', 1),
(6, 'Flavia Ana Costa', '48', '1973-10-05', 'F', 3),
(7, 'Fábio Pires', '48', '1973-01-25', 'M', 6),
(8, 'Flavio Hulk ', '43', '1978-02-20', 'M', 4),
(9, 'Carla Santos da Silva', '41', '1980-04-29', 'F', 4),
(10, 'Clarisse da Rosa', '37', '1984-10-20', 'F', 8);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `cidade`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD KEY `FKc2150e1t4hbr2owxjx1smbcwc_idx` (`cidade_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FKc2150e1t4hbr2owxjx1smbcwc_idx` FOREIGN KEY (`cidade_id`) REFERENCES `cidade` (`id`);
COMMIT;
