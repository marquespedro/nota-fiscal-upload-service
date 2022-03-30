CREATE TABLE `duplicata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_vencimento` datetime(6) DEFAULT NULL,
  `parcela` int DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  `nota_fiscal_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_NOTA_FISCAL_ID` (`nota_fiscal_id`),
  CONSTRAINT `FK_NOTA_FISCAL_ID` FOREIGN KEY (`nota_fiscal_id`) REFERENCES `nota_fiscal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci