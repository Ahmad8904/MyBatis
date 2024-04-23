CREATE TABLE `subscriber` (
  `id` int NOT NULL,
  `Name` varchar(255) NOT NULL,
  `ref_tariff` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

CREATE TABLE `tariff` (
  `id` int NOT NULL,
  `descr` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=ascii;

CREATE TABLE `payments` (
  `id` int NOT NULL,
  `ref_subscriber` int NOT NULL,
  `summa` int NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=ascii;
