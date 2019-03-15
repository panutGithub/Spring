-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2019 at 11:31 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.1.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` char(3) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `surname`, `city`, `country`) VALUES
('C1', 'Frank', 'Born', 'Buriram', 'Thailand'),
('C10', 'Nan', 'Born', 'Buriram', 'Thailand'),
('C11', 'Olive', 'Banner', 'Surin', 'Thailand'),
('C12', 'Ben', 'Morocco', 'Surin', 'Thailand'),
('C2', 'Isac', 'River', 'Hanoi', 'Vietnam'),
('C3', 'John', 'Polo', 'Jakarta', 'Indonesia'),
('C4', 'Isac', 'River', 'Bangkok', 'Thailand'),
('C5', 'Frank', 'Mid', 'London', 'England'),
('C6', 'Fred', 'Well', 'Phuket', 'Thailand'),
('C7', 'Luis', 'Lane', 'New york', 'USA'),
('C8', 'ADAM', 'Polo', 'New york', 'USA'),
('C9', 'Dave', 'Jones', 'England', 'London');

-- --------------------------------------------------------

--
-- Table structure for table `dept`
--

CREATE TABLE `dept` (
  `id` char(2) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `loc` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dept`
--

INSERT INTO `dept` (`id`, `name`, `loc`) VALUES
('D1', 'IT', 'NEW YORK'),
('D2', 'ACCOUNTING', 'DALLAS'),
('D3', 'HR', 'CHICAGO'),
('D4', 'MARKETING', 'BOSTON'),
('D5', 'ADMIN', 'BANGKOK');

-- --------------------------------------------------------

--
-- Table structure for table `emp`
--

CREATE TABLE `emp` (
  `id` char(4) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `job` varchar(10) DEFAULT NULL,
  `mgr_id` char(4) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `dept_id` char(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emp`
--

INSERT INTO `emp` (`id`, `name`, `surname`, `job`, `mgr_id`, `hiredate`, `sal`, `comm`, `dept_id`) VALUES
('E010', 'BEN', 'SMITH', 'SALES', 'E101', '1985-12-17', '15000.00', '5000.00', 'D1'),
('E011', 'SMITH', 'GREEN', 'CLERK', 'E101', '1992-01-03', '8000.00', '0.00', 'D1'),
('E020', 'CARL', 'GRIMM', 'SALES', 'E201', '1987-01-08', '8700.00', '10000.00', 'D2'),
('E030', 'DANNY', 'SIMPSON', 'SALES', 'E301', '1989-02-09', '9000.00', '9000.00', 'D3'),
('E031', 'DAVE', 'JOBS', 'SALES', 'E301', '1998-03-10', '10500.00', '15000.00', 'D3'),
('E032', 'KEN', 'RUN', 'CLERK', 'E301', '1992-06-04', '9000.00', '0.00', 'D3'),
('E040', 'EVA_G', 'CARSON', 'SALES', 'E401', '1991-11-08', '9300.00', '7200.00', 'D4'),
('E041', 'SCOTT', 'HANS', 'ANALYST', 'E401', '1990-12-27', '30000.00', '0.00', 'D4'),
('E050', 'LUIS', 'CARSON', 'SALES', 'E501', '1991-05-23', '10000.00', '7000.00', 'D5'),
('E051', 'TONY', 'BEAM', 'ANALYST', 'E501', '1993-12-27', '32000.00', '0.00', 'D5'),
('E101', 'ANN', 'SMART', 'MANAGER', NULL, '1980-12-17', '25000.00', '0.00', 'D1'),
('E201', 'ABIGEL', 'HOBS', 'MANAGER', NULL, '1981-03-20', '29500.00', '0.00', 'D2'),
('E301', 'AMILY', 'DEAN', 'MANAGER', NULL, '1981-04-22', '28500.00', '0.00', 'D3'),
('E401', 'ADAM', 'SHAW', 'MANAGER', NULL, '1979-08-13', '24500.00', '0.00', 'D4'),
('E501', 'ADRIAN', 'MOORE', 'MANAGER', NULL, '1975-11-05', '30000.00', '0.00', 'D5');

-- --------------------------------------------------------

--
-- Table structure for table `orderh`
--

CREATE TABLE `orderh` (
  `id` int(11) NOT NULL,
  `cid` char(2) DEFAULT NULL,
  `orderdate` datetime DEFAULT NULL,
  `eid` char(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderh`
--

INSERT INTO `orderh` (`id`, `cid`, `orderdate`, `eid`) VALUES
(101, 'C1', '2014-03-05 18:30:00', 'E101'),
(102, 'C8', '2014-03-05 19:00:00', 'E101'),
(103, 'C1', '2014-03-05 20:00:00', 'E101'),
(104, 'C2', '2014-03-05 10:00:00', 'E201'),
(105, 'C3', '2014-03-05 10:10:00', 'E201'),
(106, 'C8', '2014-03-05 10:50:00', 'E201'),
(107, 'C4', '2014-03-05 19:00:00', 'E301'),
(108, 'C5', '2014-03-05 20:00:00', 'E301'),
(109, 'C6', '2014-03-05 10:00:00', 'E301'),
(110, 'C1', '2014-04-01 09:00:00', 'E101'),
(111, 'C3', '2014-04-01 10:10:00', 'E201'),
(112, 'C4', '2014-04-05 17:00:00', 'E301');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` char(3) NOT NULL,
  `name` char(20) DEFAULT NULL,
  `ptype` char(1) DEFAULT NULL,
  `price` decimal(7,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `ptype`, `price`, `stock`) VALUES
('P1', 'Notebook Acer', 'N', '24000.00', 50),
('P10', 'AP', 'W', '3500.00', 8),
('P11', 'Switch', 'W', '2100.00', 9),
('P12', 'Service1', NULL, '400.00', 0),
('P13', 'Service2', NULL, '99.00', 100),
('P2', 'iPad', 'T', '24000.00', 10),
('P3', 'Galaxy Note 2', 'P', '18000.00', 20),
('P31', 'Cooling Gel', 'A', '39.00', 80),
('P32', 'Thumb Drive', 'A', '99.00', 100),
('P4', 'iPhonE004 16GB', 'P', '16000.00', 5),
('P5', 'iPod 32 GB', 'M', '8000.00', 17),
('P6', 'Cas iPad', 'A', '900.00', 50),
('P7', 'Nokia lumia 520', 'P', '5200.00', 12),
('P8', 'Notebook Thinkpad', 'N', '35000.00', 47),
('P9', 'Router', 'W', '1500.00', 7);

--
-- Triggers `product`
--
DELIMITER $$
CREATE TRIGGER `init_price` AFTER INSERT ON `product` FOR EACH ROW insert into log_price(pid,old_price,new_price)
	values(NEW.id, 0, NEW.price)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `producttype`
--

CREATE TABLE `producttype` (
  `id` char(1) NOT NULL,
  `name` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producttype`
--

INSERT INTO `producttype` (`id`, `name`) VALUES
('A', 'Acc'),
('M', 'Multimedia'),
('N', 'Notebook'),
('P', 'Phone'),
('S', 'Software'),
('T', 'Tablet'),
('W', 'Network');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(3) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `username`) VALUES
(1, 'Newname1', 'a1'),
(2, 'b', 'b1'),
(3, 'UpdateNewName', 'c1'),
(4, 'UpdateNewName', 'c1');

-- --------------------------------------------------------

--
-- Table structure for table `t_test`
--

CREATE TABLE `t_test` (
  `id_test` int(11) NOT NULL,
  `name_test` varchar(100) DEFAULT NULL,
  `email_test` varchar(255) DEFAULT NULL,
  `address_test` varchar(255) DEFAULT NULL,
  `username_test` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_test`
--

INSERT INTO `t_test` (`id_test`, `name_test`, `email_test`, `address_test`, `username_test`) VALUES
(1, 'name2', 'test2@hotmail.co.th', 'address: test 02/2', 'userNew2'),
(2, 'name1', 'test1@hotmail.co.th', 'address: test 01/1', 'userNew1'),
(3, 'name3', 'test3@hotmail.co.th', 'address: test 03/3', 'userNew3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dept`
--
ALTER TABLE `dept`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `emp`
--
ALTER TABLE `emp`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_emp_dept` (`dept_id`),
  ADD KEY `fk_mng` (`mgr_id`);

--
-- Indexes for table `orderh`
--
ALTER TABLE `orderh`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cid` (`cid`),
  ADD KEY `eid` (`eid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ptype` (`ptype`);

--
-- Indexes for table `producttype`
--
ALTER TABLE `producttype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_test`
--
ALTER TABLE `t_test`
  ADD PRIMARY KEY (`id_test`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `t_test`
--
ALTER TABLE `t_test`
  MODIFY `id_test` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `emp`
--
ALTER TABLE `emp`
  ADD CONSTRAINT `fk_emp_dept` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_mng` FOREIGN KEY (`mgr_id`) REFERENCES `emp` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `orderh`
--
ALTER TABLE `orderh`
  ADD CONSTRAINT `orderh_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `orderh_ibfk_2` FOREIGN KEY (`eid`) REFERENCES `emp` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`ptype`) REFERENCES `producttype` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
