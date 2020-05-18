-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2020 at 01:07 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

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
-- Table structure for table `distribution_transaction`
--

CREATE TABLE `distribution_transaction` (
  `id_transaction` int(255) NOT NULL,
  `id_item` int(11) NOT NULL,
  `id_lab` int(11) NOT NULL,
  `qty` int(255) NOT NULL,
  `send_at` datetime NOT NULL DEFAULT current_timestamp(),
  `accepted` int(1) NOT NULL,
  `accepted_at` datetime DEFAULT current_timestamp(),
  `id_distribution` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `distribution_transaction`
--

INSERT INTO `distribution_transaction` (`id_transaction`, `id_item`, `id_lab`, `qty`, `send_at`, `accepted`, `accepted_at`, `id_distribution`) VALUES
(1, 1, 1, 100, '2020-05-17 23:49:53', 1, '2020-05-17 23:49:53', 0);

-- --------------------------------------------------------

--
-- Table structure for table `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1', '<< Flyway Baseline >>', 'BASELINE', '<< Flyway Baseline >>', NULL, 'root', '2020-05-15 03:24:34', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `id_category`
--

CREATE TABLE `id_category` (
  `id_category` int(11) NOT NULL,
  `category_code` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `shown` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp(),
  `shown` int(11) NOT NULL DEFAULT 1,
  `created_by` int(11) NOT NULL DEFAULT 1,
  `id_brand` int(11) DEFAULT NULL,
  `id_distributor` int(11) DEFAULT NULL,
  `id_sto` int(11) DEFAULT NULL,
  `id_lab` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id_item`, `item_code`, `item_name`, `item_packaging`, `item_pieces_packaging`, `id_category`, `created_at`, `updated_at`, `shown`, `created_by`, `id_brand`, `id_distributor`, `id_sto`, `id_lab`) VALUES
(1, '450', 'Covid-19 Medicine', 'Pack', 1, 1, '2020-05-15 23:57:26', '2020-05-15 23:57:26', 1, 1, 1, 1, NULL, NULL),
(2, '460', 'DITHIOTHREITOL,5G', 'Bottle', 1, 1, '2020-05-16 00:17:26', '2020-05-16 00:17:26', 1, 1, 1, 2, NULL, NULL),
(3, '121', 'degiherlambang', 'Bottle', 1, 1, '2020-05-16 16:25:25', '2020-05-16 16:25:25', 1, 1, 2, 4, NULL, NULL),
(4, '555', 'Covid-19 Medicine', 'Bottle', 1, 1, '2020-05-16 18:31:09', '2020-05-16 18:31:09', 1, 1, 1, 3, NULL, NULL),
(5, '11', 'Positif Kontrol RP', 'Tube', 1, 2, '2020-05-16 18:34:16', '2020-05-16 18:34:16', 1, 1, 1, 3, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `item_brand`
--

CREATE TABLE `item_brand` (
  `id_brand` int(11) NOT NULL,
  `brand_code` varchar(10) NOT NULL,
  `brand_name` varchar(64) NOT NULL,
  `shown` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_brand`
--

INSERT INTO `item_brand` (`id_brand`, `brand_code`, `brand_name`, `shown`) VALUES
(1, '001', 'Sigma', 1),
(2, '002', 'IDT', 1),
(3, '03', 'Bio Rad Laboratories', 1),
(4, '04', 'Pierce', 1),
(5, '005', 'Yamaha', 1);

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

--
-- Dumping data for table `item_category`
--

INSERT INTO `item_category` (`id_category`, `category_name`, `category_code`, `shown`) VALUES
(1, 'Consumable', '01', 1),
(2, 'Non-Consumable', '02', 1),
(3, 'Consumable/Non-Consumable', '03', 1);

-- --------------------------------------------------------

--
-- Table structure for table `item_distributor`
--

CREATE TABLE `item_distributor` (
  `id_distributor` int(11) NOT NULL,
  `distributor_name` varchar(64) NOT NULL,
  `distributor_code` varchar(10) NOT NULL,
  `shown` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_distributor`
--

INSERT INTO `item_distributor` (`id_distributor`, `distributor_name`, `distributor_code`, `shown`) VALUES
(1, 'Korean Legacy', '221', 1),
(2, 'US Corp', '222', 1),
(3, 'China medic', '224', 1),
(4, 'British Embasy', '225', 1),
(5, 'Viking Legion', '225', 1);

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
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp(),
  `created_by` int(11) DEFAULT NULL,
  `shown` int(11) NOT NULL DEFAULT 1,
  `lab_contact` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `labs`
--

INSERT INTO `labs` (`id_lab`, `lab_code`, `password`, `lab_name`, `lab_address`, `lab_pic`, `lab_mail`, `created_at`, `updated_at`, `created_by`, `shown`, `lab_contact`) VALUES
(1, '0651', 'herlambang', 'Lab Bekasi', 'Bekasi Utara', 'PIC', 'lab_bekasi@kemenkes.gov.id', '2020-05-16 00:40:20', '2020-05-16 00:40:20', 1, 1, '112233'),
(2, '500', 'jakpus', 'Lab Jakarta Pusat', 'Gondangdia', 'PIC', 'lab_jakpus@kemenkes.gov.id', '2020-05-16 00:53:44', '2020-05-16 00:53:44', 1, 1, '112244'),
(3, '501', 'jabar', 'Lab Jawa Barat', 'Bandung', 'PIC', 'lab_jabar@kemenkes.gov.id', '2020-05-16 00:56:15', '2020-05-16 00:56:15', 1, 1, '112255'),
(4, '502', 'jateng', 'Lab Jawa Tengah', 'Semarang', 'PIC', 'lab_jateng@kemenkes.gov.id', '2020-05-16 00:57:49', '2020-05-16 00:57:49', 1, 1, '112266'),
(5, '010101', 'labbali', 'Lab Bali', 'Kuta Bali', 'PIC', 'lab_bali@kemenkes.gov.id', '2020-05-17 14:02:42', '2020-05-17 14:02:42', 1, 1, '112299'),
(6, '0992', 'labmalang99', 'Lab Malang 1', 'Malang, Jawa Timur', 'none', 'lab_malang@kemenkes.gov.id', '2020-05-17 19:06:18', '2020-05-17 19:06:18', 1, 1, '111231');

-- --------------------------------------------------------

--
-- Table structure for table `stock_order`
--

CREATE TABLE `stock_order` (
  `id_sto` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  `source_point` int(11) NOT NULL,
  `end_point` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `sto_send_time` datetime NOT NULL DEFAULT current_timestamp(),
  `sto_arrive_time` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp(),
  `shown` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_order`
--

INSERT INTO `stock_order` (`id_sto`, `id_item`, `source_point`, `end_point`, `amount`, `status`, `sto_send_time`, `sto_arrive_time`, `created_at`, `updated_at`, `shown`) VALUES
(1, 1, 1, 5, 200, 0, '2020-05-18 15:43:23', NULL, '2020-05-18 15:43:23', '2020-05-18 15:43:23', 1),
(2, 2, 1, 4, 300, 2, '2020-05-18 15:52:08', '2020-05-18 17:42:04', '2020-05-18 15:52:08', '2020-05-18 15:52:08', 1),
(3, 0, 0, 0, 0, 0, '2020-05-18 18:06:32', NULL, '2020-05-18 18:06:32', '2020-05-18 18:06:32', 0);

-- --------------------------------------------------------

--
-- Table structure for table `stock_source`
--

CREATE TABLE `stock_source` (
  `id_source` int(100) NOT NULL,
  `source_name` varchar(100) NOT NULL,
  `shown` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stock_source`
--

INSERT INTO `stock_source` (`id_source`, `source_name`, `shown`) VALUES
(1, 'KANTOR PUSAT, JAKARTA', 1),
(2, 'KANTOR PUSAT, TANGERANG', 1);

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
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `mail`, `fullname`, `password`, `user_type`, `created_at`, `updated_at`) VALUES
(1, 'nusacamp@scmcovid.gov.id', 'Nusacamp', '$2a$10$cN0obQ0Z0Tv/kz5tfs4nh.b5GHVaGRc7N/wwqfulob.pUUqdS12TS', 1, '2020-05-15 11:12:35', '2020-05-15 11:12:35');

-- --------------------------------------------------------

--
-- Table structure for table `users_types`
--

CREATE TABLE `users_types` (
  `user_id` int(11) NOT NULL,
  `user_type_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

CREATE TABLE `user_type` (
  `id` int(1) NOT NULL,
  `type_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_type`
--

INSERT INTO `user_type` (`id`, `type_name`) VALUES
(1, 'ADMIN'),
(2, 'KEMENKES'),
(3, 'LAB'),
(4, 'BNPB');

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_distribution_list`
-- (See below for the actual view)
--
CREATE TABLE `view_distribution_list` (
`id_distribution` int(11)
,`lab_destination` varchar(200)
,`source_name` varchar(100)
,`item_name` varchar(255)
,`amount` int(11)
,`status` int(11)
,`send_at` datetime
,`arrived_at` datetime
,`shown` int(11)
,`created_at` datetime
,`updated_at` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_items_list`
-- (See below for the actual view)
--
CREATE TABLE `view_items_list` (
`id_item` int(11)
,`item_name` varchar(255)
,`item_packaging` varchar(30)
,`item_pieces_packaging` int(11)
,`brand_name` varchar(64)
,`category_name` varchar(64)
,`distributor_name` varchar(64)
,`shown` int(11)
,`created_at` datetime
,`created_by` int(11)
,`updated_at` datetime
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
,`shown` int(11)
,`lab_pic` varchar(150)
,`created_at` datetime
,`updated_at` datetime
,`created_by` varchar(200)
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
,`password` varchar(64)
,`fullname` varchar(200)
,`user_type` int(11)
,`type_name` varchar(20)
);

-- --------------------------------------------------------

--
-- Structure for view `view_distribution_list`
--
DROP TABLE IF EXISTS `view_distribution_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_distribution_list`  AS  select `stock_order`.`id_sto` AS `id_distribution`,`labs`.`lab_name` AS `lab_destination`,`stock_source`.`source_name` AS `source_name`,`item`.`item_name` AS `item_name`,`stock_order`.`amount` AS `amount`,`stock_order`.`status` AS `status`,`stock_order`.`sto_send_time` AS `send_at`,`stock_order`.`sto_arrive_time` AS `arrived_at`,`stock_order`.`shown` AS `shown`,`stock_order`.`created_at` AS `created_at`,`stock_order`.`updated_at` AS `updated_at` from (((`stock_order` join `labs` on(`stock_order`.`end_point` = `labs`.`id_lab`)) join `stock_source` on(`stock_order`.`source_point` = `stock_source`.`id_source`)) join `item` on(`stock_order`.`id_item` = `item`.`id_item`)) ;

-- --------------------------------------------------------

--
-- Structure for view `view_items_list`
--
DROP TABLE IF EXISTS `view_items_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_items_list`  AS  select `item`.`id_item` AS `id_item`,`item`.`item_name` AS `item_name`,`item`.`item_packaging` AS `item_packaging`,`item`.`item_pieces_packaging` AS `item_pieces_packaging`,`item_brand`.`brand_name` AS `brand_name`,`item_category`.`category_name` AS `category_name`,`item_distributor`.`distributor_name` AS `distributor_name`,`item`.`shown` AS `shown`,`item`.`created_at` AS `created_at`,`item`.`created_by` AS `created_by`,`item`.`updated_at` AS `updated_at` from (((`item` join `item_brand` on(`item`.`id_brand` = `item_brand`.`id_brand`)) join `item_category` on(`item`.`id_category` = `item_category`.`id_category`)) join `item_distributor` on(`item`.`id_distributor` = `item_distributor`.`id_distributor`)) ;

-- --------------------------------------------------------

--
-- Structure for view `view_labs_list`
--
DROP TABLE IF EXISTS `view_labs_list`;


CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_labs_list`  AS  select `labs`.`id_lab` AS `id_lab`,`labs`.`lab_code` AS `lab_code`,`labs`.`lab_name` AS `lab_name`,`labs`.`lab_address` AS `lab_address`,`labs`.`lab_mail` AS `lab_mail`,`labs`.`lab_contact` AS `lab_contact`,`labs`.`shown` AS `shown`,`labs`.`lab_pic` AS `lab_pic`,`labs`.`created_at` AS `created_at`,`labs`.`updated_at` AS `updated_at`,`user`.`fullname` AS `created_by` from (`labs` join `user`) where `labs`.`id_lab` <> 0 ;

-- --------------------------------------------------------

--
-- Structure for view `view_stock_list`
--
DROP TABLE IF EXISTS `view_stock_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_stock_list`  AS  select `stock_order`.`id_sto` AS `id_sto`,`stock_order`.`sto_send_time` AS `sto_send_time`,`stock_order`.`sto_arrive_time` AS `sto_arrive_time`,`stock_order`.`created_at` AS `created_at`,`stock_order`.`updated_at` AS `updated_at` from `stock_order` where `stock_order`.`id_sto` <> 0 ;

-- --------------------------------------------------------

--
-- Structure for view `view_users_list`
--
DROP TABLE IF EXISTS `view_users_list`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_users_list`  AS  select `user`.`id` AS `id`,`user`.`mail` AS `mail`,`user`.`password` AS `password`,`user`.`fullname` AS `fullname`,`user`.`user_type` AS `user_type`,`user_type`.`type_name` AS `type_name` from (`user` join `user_type`) where `user`.`id` = `user_type`.`id` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `distribution_transaction`
--
ALTER TABLE `distribution_transaction`
  ADD PRIMARY KEY (`id_transaction`);

--
-- Indexes for table `flyway_schema_history`
--
ALTER TABLE `flyway_schema_history`
  ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

--
-- Indexes for table `id_category`
--
ALTER TABLE `id_category`
  ADD PRIMARY KEY (`id_category`);

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
-- Indexes for table `stock_source`
--
ALTER TABLE `stock_source`
  ADD PRIMARY KEY (`id_source`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_types`
--
ALTER TABLE `users_types`
  ADD KEY `FKvw48x5v58c6ik1gmjec98p8b` (`user_type_id`),
  ADD KEY `FKbp4k5k6k6vx7ce8aw7hp9dohp` (`user_id`);

--
-- Indexes for table `user_type`
--
ALTER TABLE `user_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `distribution_transaction`
--
ALTER TABLE `distribution_transaction`
  MODIFY `id_transaction` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `id_category`
--
ALTER TABLE `id_category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `item_brand`
--
ALTER TABLE `item_brand`
  MODIFY `id_brand` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `item_category`
--
ALTER TABLE `item_category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `item_distributor`
--
ALTER TABLE `item_distributor`
  MODIFY `id_distributor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `labs`
--
ALTER TABLE `labs`
  MODIFY `id_lab` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `stock_order`
--
ALTER TABLE `stock_order`
  MODIFY `id_sto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `stock_source`
--
ALTER TABLE `stock_source`
  MODIFY `id_source` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
