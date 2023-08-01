CREATE TABLE dbjumarket.compra (
  id INT AUTO_INCREMENT NOT NULL,
   cliente_id INT NULL,
   pagamento INT NOT NULL,
   valor_total DOUBLE NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE dbjumarket.compra_produto (
  compra_id INT NOT NULL,
   produto_id INT NOT NULL
);

ALTER TABLE dbjumarket.compra ADD CONSTRAINT FK_COMPRA_ON_CLIENTE FOREIGN KEY (cliente_id) REFERENCES cliente (id);

ALTER TABLE dbjumarket.compra_produto ADD CONSTRAINT fk_compro_on_compra FOREIGN KEY (compra_id) REFERENCES compra (id);

ALTER TABLE dbjumarket.compra_produto ADD CONSTRAINT fk_compro_on_produto FOREIGN KEY (produto_id) REFERENCES produto (id);
