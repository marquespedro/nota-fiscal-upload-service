CREATE TABLE `nota_fiscal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dh_registro` datetime(6) DEFAULT NULL,
  `nome_arquivo` varchar(255) DEFAULT NULL,
  `nome_destinatario` varchar(255) DEFAULT NULL,
  `nome_emitente` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `valor_nota` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `nota-fiscal-db`.nota_fiscal AUTO_INCREMENT = 0;

INSERT INTO `nota-fiscal-db`.nota_fiscal (dh_registro, nome_arquivo, nome_destinatario, nome_emitente, numero, status, valor_nota) VALUES('2022-03-13 17:41:08.528000000', 'integration-test-nota-1.xml', 'JOÃO ALBERTO', 'INTEGRATION TEST & DISTRIBUIDORA LTDA.', '101011111212', 'PROCESSADA', 15258.00);

INSERT INTO `nota-fiscal-db`.nota_fiscal (dh_registro, nome_arquivo, nome_destinatario, nome_emitente, numero, status, valor_nota) VALUES('2022-03-13 17:41:08.528000000', 'integration-test-nota-2.xml', 'JOÃO ALBERTO', 'INTEGRATION TEST & DISTRIBUIDORA LTDA.', '101011111212', 'PROCESSADA', 15258.00);
