-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2022 at 04:51 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scheduler`
--

-- --------------------------------------------------------

--
-- Table structure for table `avgcal`
--

CREATE TABLE `avgcal` (
  `Wid` int(11) NOT NULL,
  `ATtime` float NOT NULL,
  `AWtime` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `avgcal`
--

INSERT INTO `avgcal` (`Wid`, `ATtime`, `AWtime`) VALUES
(56, 73.5, 52.5),
(57, 73.5, 52.5),
(58, 73.5, 52.5);

-- --------------------------------------------------------

--
-- Table structure for table `calval`
--

CREATE TABLE `calval` (
  `ID` int(11) NOT NULL,
  `Ttim` int(11) NOT NULL,
  `Wtime` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `calval`
--

INSERT INTO `calval` (`ID`, `Ttim`, `Wtime`) VALUES
(279, 21, 0),
(280, 42, 21),
(281, 63, 42),
(282, 84, 63),
(283, 105, 84),
(284, 126, 105),
(285, 21, 0),
(286, 42, 21),
(287, 63, 42),
(288, 84, 63),
(289, 105, 84),
(290, 126, 105);

-- --------------------------------------------------------

--
-- Table structure for table `pinfo`
--

CREATE TABLE `pinfo` (
  `pid` int(11) NOT NULL,
  `pname` varchar(30) NOT NULL,
  `Atime` int(11) NOT NULL,
  `Btime` int(11) NOT NULL,
  `Pleve` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pinfo`
--

INSERT INTO `pinfo` (`pid`, `pname`, `Atime`, `Btime`, `Pleve`) VALUES
(24, 'billing', 45, 21, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sjfp`
--

CREATE TABLE `sjfp` (
  `id` int(11) NOT NULL,
  `Ta` int(11) NOT NULL,
  `Wt` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sjfp`
--

INSERT INTO `sjfp` (`id`, `Ta`, `Wt`) VALUES
(1, 5, 0),
(2, 10, 5),
(3, 15, 10),
(4, 20, 15),
(5, 25, 20),
(6, 30, 25);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `avgcal`
--
ALTER TABLE `avgcal`
  ADD PRIMARY KEY (`Wid`);

--
-- Indexes for table `calval`
--
ALTER TABLE `calval`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `pinfo`
--
ALTER TABLE `pinfo`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `sjfp`
--
ALTER TABLE `sjfp`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `avgcal`
--
ALTER TABLE `avgcal`
  MODIFY `Wid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `calval`
--
ALTER TABLE `calval`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=291;

--
-- AUTO_INCREMENT for table `pinfo`
--
ALTER TABLE `pinfo`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `sjfp`
--
ALTER TABLE `sjfp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
