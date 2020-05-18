-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2020 at 03:32 PM

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
(2, '460', 'DITHIOTHREITOL,5G', 'Bottle', 1, 1, '2020-05-16 00:17:26', '2020-05-16 00:17:26', 0, 0, 1, 2, NULL, NULL),
(3, '121', 'degiherlambang', 'Bottle', 1, 1, '2020-05-16 16:25:25', '2020-05-16 16:25:25', 0, 0, 2, 4, NULL, NULL),
(4, '555', 'Covid-19 Medicine', 'Bottle', 1, 1, '2020-05-16 18:31:09', '2020-05-16 18:31:09', 0, 0, 1, 3, NULL, NULL),
(5, '11', 'Positif Kontrol RP', 'Tube', 1, 2, '2020-05-16 18:34:16', '2020-05-16 18:34:16', 0, 0, 1, 3, NULL, NULL),
(6, NULL, NULL, NULL, 0, 0, '2020-05-16 18:36:58', '2020-05-16 18:36:58', 0, 1, 0, 0, NULL, NULL);

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
  `sto_send_time` datetime NOT NULL,
  `sto_arrive_time` datetime NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp(),
  `shown` int(11) NOT NULL DEFAULT 1,
  `id_stock_order` int(11) NOT NULL,
  `stock_arrive_time` varchar(255) DEFAULT NULL,
  `stock_send_time` varchar(255) DEFAULT NULL
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
`id_lab` int(11)
,`lab_name` varchar(200)
,`item_name` varchar(255)
,`id_distributor` int(11)
,`distributor_name` varchar(64)
,`sto_send_time` datetime
,`sto_arrive_time` datetime
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

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_distribution_list`  AS  select `labs`.`id_lab` AS `id_lab`,`labs`.`lab_name` AS `lab_name`,`item`.`item_name` AS `item_name`,`item_distributor`.`id_distributor` AS `id_distributor`,`item_distributor`.`distributor_name` AS `distributor_name`,`stock_order`.`sto_send_time` AS `sto_send_time`,`stock_order`.`sto_arrive_time` AS `sto_arrive_time` from (((`labs` join `item` on(`labs`.`id_lab` = `item`.`id_item`)) join `item_distributor` on(`item`.`id_item` = `item_distributor`.`distributor_name`)) join `stock_order` on(`item`.`id_item` = `stock_order`.`id_sto`)) ;

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

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_labs_list`  AS  select `labs`.`id_lab` AS `id_lab`,`labs`.`lab_code` AS `lab_code`,`labs`.`lab_name` AS `lab_name`,`labs`.`lab_address` AS `lab_address`,`labs`.`lab_mail` AS `lab_mail`,`labs`.`lab_contact` AS `lab_contact` from `labs` where `labs`.`id_lab` <> 0 ;

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
-- AUTO_INCREMENT for table `id_category`
--
ALTER TABLE `id_category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
  MODIFY `id_sto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
