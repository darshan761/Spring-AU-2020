create database office;
use office;
CREATE TABLE Employee (
	emp_id int primary key,
    name varchar(20),
    score decimal(4,2),
    email varchar(30)
    );
INSERT into Employee values(13, "Darshan Patil",9.45,"darshan.patil@spit.ac.in");
INSERT into Employee values(32, "Rohit Gonsalves",9.65,"rohit.gonsalves@spit.ac.in");
INSERT into Employee values(45, "Omkar Raykar",9.55,"omkar.raykar@spit.ac.in");
INSERT into Employee values(87, "Rohan Pawar",9.69,"rohan.pawar@spit.ac.in");
INSERT into Employee values(14, "Gaurav Yadav",9.62,"darshan.patil@spit.ac.in");
INSERT into Employee values(21, "Abhigyan Nayak",9.85,"abhigyan.nayak@ami.ac.in");
INSERT into Employee values(7, "Jasprit Singh",9.71,"jasprit.singh@nit.ac.in");
INSERT into Employee values(19, "Rohan Jagtap",9.45,"rohan.jagtap@spit.ac.in");
INSERT into Employee values(26, "Jinay Parekh",9.95,"jinay.parekh@spit.ac.in");
INSERT into Employee values(41, "Lekha Sharma",9.91,"lekha.sharma@spit.ac.in");
INSERT into Employee values(11, "Radnyee mhatre",9.55,"radnyee.mhatre@spit.ac.in");

SELECT * from Employee;

USE `office`;
DROP procedure IF EXISTS `pagination`;

DELIMITER $$
USE `office`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pagination`(IN page_no int, IN no_row int)
BEGIN
	DECLARE a INT;
	SET a = (page_no - 1)*no_row;
	SELECT * from Employee LIMIT a,no_row;
END$$

DELIMITER ;


call pagination(4,2);
