DROP TABLE `Trade`.`orders`;
CREATE database if not exists `Trade`;
use `Trade`;
CREATE TABLE `Trade`.`orders` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `SIN` VARCHAR(45) NOT NULL,
  `ticker` VARCHAR(45) NOT NULL,
  `shares` INT NOT NULL,
  `unitPrice` DOUBLE NOT NULL,
  `status_code` INT NOT NULL,
  PRIMARY KEY (`orderId`));


insert into `Trade`.`orders` values(1,'943999999','MSFT',100,280.15,0);
insert into `Trade`.`orders` values(2,'943999999','GOOGL',10,120.13,0);
insert into `Trade`.`orders` values(3,'943999999','AMZN',4,141.53,0);
insert into `Trade`.`orders` values(4,'943999000','COIN',10,88.19,0);
insert into `Trade`.`orders` values(5,'943999000','MCD',10,261.68,0);
insert into `Trade`.`orders` values(6,'943999000','C',10,54.045,0);
insert into `Trade`.`orders` values(7,'943999999','TSLA',10,879.32,0);