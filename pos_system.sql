-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 08, 2020 at 01:23 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `CartID` int(11) NOT NULL,
  `InvoiceID` varchar(1000) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `BarCode` varchar(100) NOT NULL,
  `Quntity` int(100) NOT NULL,
  `Price` double NOT NULL,
  `TotalPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`CartID`, `InvoiceID`, `Name`, `BarCode`, `Quntity`, `Price`, `TotalPrice`) VALUES
(1, '00000000', 'Anju', '56688', 5, 1000, 5000),
(2, '00000000', 'Anju', '1455548', 4, 100, 400),
(3, '00000000', 'Anju', '56688', 55, 1000, 55000),
(4, '1', 'Saniru', '1455548', 58, 100, 5800),
(5, '2', 'RockStar', '56688', 57, 1000, 57000),
(6, '2', 'Saniru', '1455548', 5, 100, 500),
(7, '2', 'Saniru', '1455548', 5, 100, 500),
(8, '2', 'Anju', '56688', 4, 1000, 4000),
(9, '2', 'Anju', '1455548', 2, 100, 200),
(10, '3', 'Saniru', '1455548', 2, 100, 200),
(11, '3', 'Anju', '56688', 5, 1000, 5000),
(12, '3', 'Anju', '56688', 6, 1000, 6000),
(13, '4', 'RockStar', '1455548', 6, 100, 600),
(14, '4', 'Anju', '56688', 5, 1000, 5000),
(15, '5', 'Anju', '1455548', 7, 100, 700),
(16, '6', 'RockStar', '56688', 2, 1000, 2000),
(17, '6', 'RockStar', '56688', 5, 1000, 5000),
(18, '7', 'Anju', '56688', 4, 1000, 4000),
(19, '8', 'Saniru', '56688', 8, 1000, 8000),
(20, '9', 'Anju', '1455548', 5, 100, 500),
(21, '10', 'Anju', '1455548', 5, 100, 500),
(22, '11', 'Saniru', '56688', 5, 1000, 5000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CusID` int(11) NOT NULL,
  `CusName` varchar(50) NOT NULL,
  `Mobile` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CusID`, `CusName`, `Mobile`, `Address`) VALUES
(1, 'ewffweifno', 'ewcwcwe', 'wcwcw'),
(2, 'Saniru', '0789123353', 'baduwaththa,ullala,kamburupitiya'),
(3, 'Anju', '155661665', 'dasdsdasdsds'),
(4, 'RockStar', '155565655', 'saddasd,sdddasd,dadsad');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeName` varchar(50) NOT NULL,
  `NIC` varchar(20) NOT NULL,
  `Salary` double NOT NULL,
  `Job` varchar(50) NOT NULL,
  `Contact` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeName`, `NIC`, `Salary`, `Job`, `Contact`) VALUES
('Eranthi', '9111212v', 20000, 'ewefw', '1231234412');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ProductsID` varchar(50) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `SupplierID` varchar(100) NOT NULL,
  `Quntity` int(100) NOT NULL,
  `Price` double NOT NULL,
  `BarCode` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ProductsID`, `ProductName`, `SupplierID`, `Quntity`, `Price`, `BarCode`) VALUES
('1', 'Super Cream Cracker', '1004', 15, 100, 1455548),
('2', 'nibba', '1006', 5, 1000, 56688);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `SaleID` int(100) NOT NULL,
  `InvoiceID` int(100) NOT NULL,
  `CusID` int(100) NOT NULL,
  `CustomerName` varchar(100) NOT NULL,
  `TotalQuntity` int(100) NOT NULL,
  `TotalPrice` double NOT NULL,
  `Status` varchar(100) NOT NULL,
  `Balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`SaleID`, `InvoiceID`, `CusID`, `CustomerName`, `TotalQuntity`, `TotalPrice`, `Status`, `Balance`) VALUES
(1, 3, 2, 'Saniru', 500, 500, 'Paid', 0),
(2, 4, 2, 'Saniru', 2, 200, 'Paid', 300),
(3, 4, 3, 'Anju', 5, 5000, 'Partial Paid', 250),
(4, 4, 3, 'Anju', 6, 6000, 'Unpaid Paid', -1000),
(5, 5, 4, 'RockStar', 6, 600, 'Paid', 200),
(6, 5, 3, 'Anju', 5, 5000, 'Paid', 1000),
(7, 6, 3, 'Anju', 7, 700, 'Paid', 0),
(8, 7, 4, 'RockStar', 2, 2000, 'Paid', 6000),
(9, 7, 4, 'RockStar', 5, 5000, 'Paid', 4000),
(10, 8, 3, 'Anju', 4, 4000, 'Paid', 0),
(11, 9, 2, 'Saniru', 8, 8000, 'Unpaid Paid', -5000),
(12, 10, 3, 'Anju', 5, 500, 'Paid', 0),
(13, 11, 3, 'Anju', 5, 500, 'Paid', 0),
(14, 12, 2, 'Saniru', 5, 5000, 'Paid', 0);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` int(50) NOT NULL,
  `SupplierName` varchar(100) NOT NULL,
  `ProductsID` varchar(50) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quntity` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `SupplierName`, `ProductsID`, `ProductName`, `Quntity`) VALUES
(1004, 'Saniru', '1', 'Cream Cracker', 56);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`CartID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CusID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProductsID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`SaleID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `CartID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CusID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `SaleID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
