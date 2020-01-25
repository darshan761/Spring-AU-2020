create database officedb;
use officedb;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `salary` int(45) NOT NULL,
  `mobile`varchar(12) NOT NULL,
  PRIMARY KEY (`emp_id`)
);
INSERT into employee values(1,"Darshan","darshan.patil@spit.ac.in",45000,"866452534");
INSERT into employee values(2,"Rohit","rohit.gonsalves@spit.ac.in",34525, "3456774343");
SELECT * from employee;