-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2020 at 10:09 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `covid`
--

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id_item` int(11) NOT NULL,
  `item_code` varchar(64) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_packaging` varchar(30) DEFAULT NULL,
  `item_pieces_packaging` int(11) DEFAULT NULL,
  `id_category` int(11) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shown` int(11) NOT NULL DEFAULT '1',
  `created_by` int(11) NOT NULL DEFAULT '1',
  `id_brand` int(11) DEFAULT NULL,
  `id_distributor` int(11) DEFAULT NULL,
  `id_sto` int(11) DEFAULT NULL,
  `id_lab` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_brand`
--

CREATE TABLE `item_brand` (
  `id_brand` int(11) NOT NULL,
  `brand_code` varchar(10) NOT NULL,
  `brand_name` varchar(64) NOT NULL,
  `shown` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_category`
--

CREATE TABLE `item_category` (
  `id_category` int(11) NOT NULL,
  `category_name` varchar(64) NOT NULL,
  `category_code` varchar(10) NOT NULL,
  `shown` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_distributor`
--

CREATE TABLE `item_distributor` (
  `id_distributor` int(11) NOT NULL,
  `distributor_name` varchar(64) NOT NULL,
  `distributor_code` varchar(10) NOT NULL,
  `shown` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `labs`
--

CREATE TABLE `labs` (
  `id_lab` int(11) NOT NULL,
  `lab_code` varchar(12) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `lab_name` varchar(200) DEFAULT NULL,
  `lab_address` varchar(300) DEFAULT NULL,
  `lab_pic` varchar(150) DEFAULT NULL,
  `lab_mail` varchar(100) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` int(11) DEFAULT NULL,
  `shown` int(11) NOT NULL DEFAULT '1',
  `lab_contact` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock_order`
--

CREATE TABLE `stock_order` (
  `id_sto` int(11) NOT NULL,
  `sto_send_time` datetime NOT NULL,
  `sto_arrive_time` datetime NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shown` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `password` varchar(64) NOT NULL,
  `user_type` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

CREATE TABLE `user_type` (
  `id` int(1) NOT NULL,
  `type_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_distribution_list`
-- (See below for the actual view)
--
CREATE TABLE `view_distribution_list` (
`lab_name` varchar(200)
,`item_name` varchar(255)
,`distributor_name` varchar(64)
,`sto_send_time` datetime
,`sto_arrive_time` datetime
,`id_distributor` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_items_list`
-- (See below for the actual view)
--
CREATE TABLE `view_items_list` (
`item_name` varchar(255)
,`item_packaging` varchar(30)
,`item_pieces_packaging` int(11)
,`brand_name` varchar(64)
,`category_name` varchar(64)
,`id_item` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_labs_list`
-- (See below for the actual view)
--
CREATE TABLE `view_labs_list` (
`id_lab` int(11)
,`lab_code` varchar(12)
,`lab_name` varchar(200)
,`lab_address` varchar(300)
,`lab_mail` varchar(100)
,`lab_contact` varchar(20)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_stock_list`
-- (See below for the actual view)
--
CREATE TABLE `view_stock_list` (
`id_sto` int(11)
,`sto_send_time` datetime
,`sto_arrive_time` datetime
,`created_at` datetime
,`updated_at` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_users_list`
-- (See below for the actual view)
--
CREATE TABLE `view_users_list` (
`id` int(11)
,`mail` varchar(50)
,`fullname` varchar(200)
,`user_type` int(11)
,`type_name` varchar(20)
);

-- --------------------------------------------------------

--
-- Structure for view `view_distribution_list`
--
DROP TABLE IF EXISTS `view_distribution_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_distribution_list`  AS  select `labs`.`lab_name` AS `lab_name`,`item`.`item_name` AS `item_name`,`item_distributor`.`distributor_name` AS `distributor_name`,`stock_order`.`sto_send_time` AS `sto_send_time`,`stock_order`.`sto_arrive_time` AS `sto_arrive_time`,`item_distributor`.`id_distributor` AS `id_distributor` from (((`labs` join `item` on((`labs`.`id_lab` = `item`.`id_item`))) join `item_distributor` on((`item`.`id_item` = `item_distributor`.`distributor_name`))) join `stock_order` on((`item`.`id_item` = `stock_order`.`id_sto`))) ;

-- --------------------------------------------------------

--
-- Structure for view `view_items_list`
--
DROP TABLE IF EXISTS `view_items_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_items_list`  AS  select `item`.`item_name` AS `item_name`,`item`.`item_packaging` AS `item_packaging`,`item`.`item_pieces_packaging` AS `item_pieces_packaging`,`item_brand`.`brand_name` AS `brand_name`,`item_category`.`category_name` AS `category_name`,`item`.`id_item` AS `id_item` from ((`item` join `item_brand` on((`item`.`id_item` = `item_brand`.`id_brand`))) join `item_category` on((`item`.`id_item` = `item_category`.`id_category`))) ;

-- --------------------------------------------------------

--
-- Structure for view `view_labs_list`
--
DROP TABLE IF EXISTS `view_labs_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_labs_list`  AS  select `labs`.`id_lab` AS `id_lab`,`labs`.`lab_code` AS `lab_code`,`labs`.`lab_name` AS `lab_name`,`labs`.`lab_address` AS `lab_address`,`labs`.`lab_mail` AS `lab_mail`,`labs`.`lab_contact` AS `lab_contact` from `labs` where (`labs`.`id_lab` <> 0) ;

-- --------------------------------------------------------

--
-- Structure for view `view_stock_list`
--
DROP TABLE IF EXISTS `view_stock_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_stock_list`  AS  select `stock_order`.`id_sto` AS `id_sto`,`stock_order`.`sto_send_time` AS `sto_send_time`,`stock_order`.`sto_arrive_time` AS `sto_arrive_time`,`stock_order`.`created_at` AS `created_at`,`stock_order`.`updated_at` AS `updated_at` from `stock_order` where (`stock_order`.`id_sto` <> 0) ;

-- --------------------------------------------------------

--
-- Structure for view `view_users_list`
--
DROP TABLE IF EXISTS `view_users_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_users_list`  AS  select `user`.`id` AS `id`,`user`.`mail` AS `mail`,`user`.`fullname` AS `fullname`,`user`.`user_type` AS `user_type`,`user_type`.`type_name` AS `type_name` from (`user` join `user_type`) where (`user`.`id` = `user_type`.`id`) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id_item`);

--
-- Indexes for table `item_brand`
--
ALTER TABLE `item_brand`
  ADD PRIMARY KEY (`id_brand`);

--
-- Indexes for table `item_category`
--
ALTER TABLE `item_category`
  ADD PRIMARY KEY (`id_category`);

--
-- Indexes for table `item_distributor`
--
ALTER TABLE `item_distributor`
  ADD PRIMARY KEY (`id_distributor`);

--
-- Indexes for table `labs`
--
ALTER TABLE `labs`
  ADD PRIMARY KEY (`id_lab`);

--
-- Indexes for table `stock_order`
--
ALTER TABLE `stock_order`
  ADD PRIMARY KEY (`id_sto`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_type`
--
ALTER TABLE `user_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item_brand`
--
ALTER TABLE `item_brand`
  MODIFY `id_brand` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item_category`
--
ALTER TABLE `item_category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item_distributor`
--
ALTER TABLE `item_distributor`
  MODIFY `id_distributor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `labs`
--
ALTER TABLE `labs`
  MODIFY `id_lab` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stock_order`
--
ALTER TABLE `stock_order`
  MODIFY `id_sto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
