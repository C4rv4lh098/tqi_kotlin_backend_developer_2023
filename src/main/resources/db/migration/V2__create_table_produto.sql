CREATE TABLE dbjumarket.produto (
	id INT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   unidade_medida VARCHAR(50) NOT NULL,
   preco DOUBLE NOT NULL,
   categoria_id INT NULL,
   PRIMARY KEY (id)
   );

ALTER TABLE dbjumarket.produto ADD CONSTRAINT FK_PRODUTO_ON_CATEGORIA FOREIGN KEY (categoria_id) REFERENCES categoria (id);

INSERT INTO `dbjumarket`.`produto` (`nome`, `unidade_medida`, `preco`, `categoria_id`) VALUES ('Coca-Cola 2L', 'Litro', '6.0', '1');
INSERT INTO `dbjumarket`.`produto` (`nome`, `unidade_medida`, `preco`, `categoria_id`) VALUES ('Coca-Cola 500ml', 'Litro', '3.80', '1');
INSERT INTO `dbjumarket`.`produto` (`nome`, `unidade_medida`, `preco`, `categoria_id`) VALUES ('Bolacha Cream Cracker', 'Grama', '7.99', '2');

