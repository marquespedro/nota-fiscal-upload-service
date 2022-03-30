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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci