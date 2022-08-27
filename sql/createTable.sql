DROP TABLE `trade`.`orders`;
CREATE database if not exists `trade`;
use `trade`;
CREATE TABLE `trade`.`orders` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `SIN` VARCHAR(45) NOT NULL,
  `ticker` VARCHAR(45) NOT NULL,
  `shares` INT NOT NULL,
  `unitPrice` DOUBLE NOT NULL,
  `status_code` INT NOT NULL,
  PRIMARY KEY (`orderId`));


insert into `trade`.`orders` values(1,'943999999','MSFT',100,240.32,0);
insert into `trade`.`orders` values(2,'943999999','GOOGL',10,130.13,0);
insert into `trade`.`orders` values(3,'943999999','MSFT',10,283.15,0);
insert into `trade`.`orders` values(4,'943999999','GOOGL',10,117.98,0);
insert into `trade`.`orders` values(5,'943999000','MSFT',100,280.15,0);
insert into `trade`.`orders` values(6,'943999999','GOOGL',50,118.13,0);
insert into `trade`.`orders` values(7,'943999999','TSLA',4,141.53,0);
insert into `trade`.`orders` values(8,'943999000','AMZN',4,91.53,0);
insert into `trade`.`orders` values(9,'943999999','COIN',30,97.12,0);
insert into `trade`.`orders` values(10,'943999000','MCD',20,123.29,0);
insert into `trade`.`orders` values(11,'943999999','COIN',10,99.12,0);
insert into `trade`.`orders` values(12,'943999999','AMZN',4,121.73,0);
insert into `trade`.`orders` values(13,'943999999','TSLA',5,143.33,0);
insert into `trade`.`orders` values(14,'943999999','MCD',6,122.37,0);
insert into `trade`.`orders` values(15,'943999999','AMZN',10,145.13,0);
insert into `trade`.`orders` values(16,'943999999','COIN',10,88.19,0);
insert into `trade`.`orders` values(17,'943999000','COIN',10,88.19,0);
insert into `trade`.`orders` values(18,'943999000','MCD',10,261.68,0);
insert into `trade`.`orders` values(19,'943999000','C',10,54.045,0);
insert into `trade`.`orders` values(20,'943999000','AMZN',4,91.53,0);
insert into `trade`.`orders` values(21,'943999000','COIN',30,97.12,0);
insert into `trade`.`orders` values(22,'943999000','COIN',20,123.29,0);
insert into `trade`.`orders` values(23,'943999000','COIN',10,99.12,0);
insert into `trade`.`orders` values(24,'943999999','AMZN',4,121.73,0);
insert into `trade`.`orders` values(25,'943999999','TSLA',10,879.32,0);