DROP TABLE IF EXISTS `bank_account`;
CREATE TABLE `bank_account` (
  `acc_number` int(11) NOT NULL,
  `acc_holder_name` varchar(45) DEFAULT NULL,
  `acc_type` varchar(45) DEFAULT NULL,
  `acc_email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`acc_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `bank_account` WRITE;

INSERT INTO `bank_account`
    VALUES (1101,'Tom Cruise','current','tom@gmail.com'),
            (1102,'Leonardo DiCaprio','savings','leo@gmail.com'),
            (1103,'Tom Hanks','current','tomhanks@gmail.com'),
            (1104,'Brad Pitt','savings','brad@gmail.com'),
            (1105,'Matt Damon','current','matt@gmail.com');

UNLOCK TABLES;
