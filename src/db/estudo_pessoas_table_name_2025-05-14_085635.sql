-- Banco de Estudo

CREATE DATABASE estudo_pessoas
    DEFAULT CHARACTER SET = 'utf8mb4';
--
-- Table structure for table `table_name`
--
Use estudo_pessoas

DROP TABLE IF EXISTS `table_name`;

CREATE TABLE `table_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'Create Time',
  `name` varchar(255) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL COMMENT 'Telefone no formato XXXXXXXXXXX',
  `endereco` varchar(150) DEFAULT NULL COMMENT 'Endereço Completo',
  `imagem_perfil` varchar(2083) DEFAULT NULL COMMENT 'URL da Imagem de Perfil',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Cadastro de Pessoas';

-- Inserção de dados de exemplo
INSERT INTO table_name (name, telefone, endereco, imagem_perfil) VALUES
('João Silva', '(31) 91234-5678', 'Rua das Flores, 123', 'https://imagem.com/perfil.png'),
('Maria Oliveira', '(31) 99887-1234', 'Avenida Central, 456', 'https://imagem.com/perfil2.png');

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-14  8:56:50

Use estudo_pessoas

CREATE TABLE produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade_estoque INT NOT NULL,
    descricao TEXT
);

CREATE TABLE compras (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data_compra DATETIME NOT NULL,
    table_name_id BIGINT NOT NULL,
    FOREIGN KEY (table_name_id) REFERENCES table_name(id)
);

CREATE TABLE itens_compra (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    compra_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (compra_id) REFERENCES compras(id),
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
);
