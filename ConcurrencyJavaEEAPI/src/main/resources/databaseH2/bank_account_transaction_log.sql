DROP TABLE IF EXISTS `bank_account_transaction_log`;
CREATE TABLE `bank_account_transaction_log` (
  `id` int(11) NOT NULL,
  `tx_id` int(11) DEFAULT NULL,
  `tx_done_by` varchar(45) DEFAULT NULL,
  `curr_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tx_id_idx` (`tx_id`),
  CONSTRAINT `tx_id` FOREIGN KEY (`tx_id`) REFERENCES `bank_account_transaction` (`tx_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `bank_account_transaction_log` WRITE;

INSERT INTO `bank_account_transaction_log` 
    VALUES (1,20,'ketkeeda','2018-08-08 00:00:00'),
    (2,21,'ketkeeda','2018-08-08 00:00:00'),
    (3,22,'system','2018-08-09 00:00:00');

UNLOCK TABLES;