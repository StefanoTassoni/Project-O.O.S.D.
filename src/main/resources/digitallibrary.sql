-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Creato il: Set 19, 2018 alle 18:04
-- Versione del server: 5.7.19
-- Versione PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `digitallibrary`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `assegnazione`
--

DROP TABLE IF EXISTS `assegnazione`;
CREATE TABLE IF NOT EXISTS `assegnazione` (
  `IDuser` int(10) UNSIGNED NOT NULL,
  `IDscan` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`IDscan`,`IDuser`),
  KEY `user_assegnazione` (`IDuser`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `dispone`
--

DROP TABLE IF EXISTS `dispone`;
CREATE TABLE IF NOT EXISTS `dispone` (
  `IDgruppo` int(10) UNSIGNED NOT NULL,
  `IDpermessi` int(10) UNSIGNED NOT NULL,
  KEY `gruppo_dispone` (`IDgruppo`),
  KEY `permessi_dispone` (`IDpermessi`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `gruppo`
--

DROP TABLE IF EXISTS `gruppo`;
CREATE TABLE IF NOT EXISTS `gruppo` (
  `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` enum('supervisore','lettore','trascrittore') NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `modifica`
--

DROP TABLE IF EXISTS `modifica`;
CREATE TABLE IF NOT EXISTS `modifica` (
  `IDuser` int(10) UNSIGNED NOT NULL,
  `IDtrascrizione` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`IDuser`,`IDtrascrizione`),
  KEY `trascrizione_modifica` (`IDtrascrizione`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `opera`
--

DROP TABLE IF EXISTS `opera`;
CREATE TABLE IF NOT EXISTS `opera` (
  `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `titolo` varchar(200) NOT NULL,
  `autore` varchar(200) NOT NULL,
  `lingua` varchar(200) NOT NULL,
  `date_creazione` date NOT NULL,
  `data_publicazione` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `permessi`
--

DROP TABLE IF EXISTS `permessi`;
CREATE TABLE IF NOT EXISTS `permessi` (
  `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `scansione`
--

DROP TABLE IF EXISTS `scansione`;
CREATE TABLE IF NOT EXISTS `scansione` (
  `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `n_pagina` varchar(200) NOT NULL,
  `data_pubblicazione` datetime NOT NULL,
  `formato` char(200) NOT NULL,
  `IDopera` int(10) UNSIGNED NOT NULL,
  `IDuser` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `opera_scan` (`IDopera`),
  KEY `user_scan` (`IDuser`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `trascrizione`
--

DROP TABLE IF EXISTS `trascrizione`;
CREATE TABLE IF NOT EXISTS `trascrizione` (
  `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `testo` text,
  `IDscan` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `scan_trascription` (`IDscan`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) NOT NULL,
  `SURNAME` varchar(200) NOT NULL,
  `USERNAME` varchar(200) NOT NULL,
  `PASSWORD` varchar(200) NOT NULL,
  `NOME_GRUPPO` enum('supervisore','lettore','trascrittore') NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`ID`, `NAME`, `SURNAME`, `USERNAME`, `PASSWORD`, `NOME_GRUPPO`) VALUES
(1, 'FEDERICO', 'ANGELINI', 'federiange', 'fede', 'supervisore');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
