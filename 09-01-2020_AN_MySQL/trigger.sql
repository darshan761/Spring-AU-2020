create database portfolio;
use portfolio;
create TABLE stocks( stock_id int, company varchar(20), price int, purchased timestamp);
create TABLE updated_stocks_audit( stock_id int, company varchar(20), old_price int, new_price int, purchased timestamp, updated timestamp);
create TABLE StocksArchives(stockid int,company varchar(20),price int, purchased timestamp);

CREATE TRIGGER before_stocks_insert BEFORE INSERT ON stocks FOR EACH ROW SET @sum = @sum + NEW.price;

SET @sum = 0;
INSERT into stocks values(123,"Accolite",2324,current_timestamp()),(435,"Quantiphi",1123,current_timestamp()),(546,"Workindia",3421,current_timestamp());
SELECT @sum AS 'Total Stock price';  


delimiter //
CREATE TRIGGER before_stocks_update BEFORE UPDATE ON stocks
		FOR EACH ROW
       BEGIN
           IF NEW.price < 0 THEN
               SET NEW.price = 0;
           ELSEIF NEW.price > 4000 THEN
               SET NEW.price = 4000;
           END IF;
		   INSERT INTO updated_stocks_audit values(OLD.stock_id,OLD.company,OLD.price,NEW.price, OLD.purchased, current_timestamp() );

       END;//
delimiter ;

UPDATE stocks SET price = 4567  where company="Accolite";
SELECT * from stocks;
SELECT * from updated_stocks_audit;

DELIMITER $$ 
CREATE TRIGGER before_stocks_delete
BEFORE DELETE
ON stocks FOR EACH ROW
BEGIN
    INSERT INTO StocksArchives(stockid,company,price,purchased)
    VALUES(OLD.stock_id,OLD.company,OLD.price,OLD.purchased);
END$$    
DELIMITER ;

Delete  from stocks where company = "Workindia";
SELECT * from stocks;
SELECT * from StocksArchives;
