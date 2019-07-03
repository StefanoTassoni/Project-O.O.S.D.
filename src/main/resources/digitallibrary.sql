-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Creato il: Lug 03, 2019 alle 18:54
-- Versione del server: 5.6.35
-- Versione PHP: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

CREATE TABLE `assegnazione` (
  `IDuser` int(10) UNSIGNED NOT NULL,
  `IDscan` int(10) UNSIGNED NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `dispone`
--

CREATE TABLE `dispone` (
  `IDgruppo` int(10) UNSIGNED NOT NULL,
  `IDpermessi` int(10) UNSIGNED NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `gruppo`
--

CREATE TABLE `gruppo` (
  `ID` int(10) UNSIGNED NOT NULL,
  `nome` enum('supervisore','lettore','trascrittore') NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `gruppo`
--

INSERT INTO `gruppo` (`ID`, `nome`) VALUES
(1, 'supervisore'),
(2, 'trascrittore'),
(3, 'lettore');

-- --------------------------------------------------------

--
-- Struttura della tabella `modifica`
--

CREATE TABLE `modifica` (
  `IDuser` int(10) UNSIGNED NOT NULL,
  `IDtrascrizione` int(10) UNSIGNED NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `modulo`
--

CREATE TABLE `modulo` (
  `ID` int(10) UNSIGNED NOT NULL,
  `message` text NOT NULL,
  `fk_id_user` int(10) UNSIGNED NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `opera`
--

CREATE TABLE `opera` (
  `ID` int(10) UNSIGNED NOT NULL,
  `titolo` varchar(200) NOT NULL,
  `categoria` varchar(200) NOT NULL,
  `autore` varchar(200) NOT NULL,
  `lingua` varchar(200) NOT NULL,
  `date_creazione` date NOT NULL,
  `data_publicazione` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `opera`
--

INSERT INTO `opera` (`ID`, `titolo`, `categoria`, `autore`, `lingua`, `date_creazione`, `data_publicazione`) VALUES
(1, 'divina commedia', 'romanzo', 'dante alighieri', 'italiano volgare', '1800-01-01', '2018-05-15 00:00:00'),
(2, 'odissea', 'poema', 'omero', 'greco antico', '1200-01-01', '2018-06-10 00:00:00'),
(3, 'decamerone', 'raccolta di novelle', 'giovanni boccaccio', 'italiano', '1350-01-01', '2020-05-15 00:00:00'),
(9, 'zzzz testa', '', '', '', '2018-11-12', '2018-11-06 03:15:00'),
(10, 'test a', 'test a', 'test a', 'test a', '2018-11-12', '2018-11-06 03:15:00');

-- --------------------------------------------------------

--
-- Struttura della tabella `permessi`
--

CREATE TABLE `permessi` (
  `ID` int(10) UNSIGNED NOT NULL,
  `nome` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `scansione`
--

CREATE TABLE `scansione` (
  `ID` int(10) UNSIGNED NOT NULL,
  `n_pagina` varchar(200) NOT NULL,
  `data_pubblicazione` datetime NOT NULL,
  `formato` char(200) NOT NULL,
  `IDopera` int(10) UNSIGNED NOT NULL,
  `IDuser` int(10) UNSIGNED NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `trascrizione`
--

CREATE TABLE `trascrizione` (
  `ID` int(10) UNSIGNED NOT NULL,
  `testo` text,
  `IDscan` int(10) UNSIGNED NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE `user` (
  `ID` int(10) UNSIGNED NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `SURNAME` varchar(200) NOT NULL,
  `USERNAME` varchar(200) NOT NULL,
  `PASSWORD` varchar(200) NOT NULL,
  `MAIL` varchar(200) NOT NULL,
  `NOME_GRUPPO` enum('supervisore','lettore','trascrittore') NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`ID`, `NAME`, `SURNAME`, `USERNAME`, `PASSWORD`, `MAIL`, `NOME_GRUPPO`) VALUES
(1, 'FEDERICO', 'ANGELINI', 'fede', 'fede', 'fede@gmail.com', 'supervisore'),
(2, 'gino', 'paoli', 'paolino', 'daipaolo', 'gino@gmail.com', 'lettore'),
(3, 'rocco', 'papaleo', 'rocchetta', 'pappa', 'rocco@gmail.com', 'trascrittore');

-- --------------------------------------------------------

--
-- Struttura della tabella `usergroup`
--

CREATE TABLE `usergroup` (
  `fk_user` int(10) NOT NULL,
  `fk_group` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `usergroup`
--

INSERT INTO `usergroup` (`fk_user`, `fk_group`) VALUES
(1, 1),
(2, 3),
(3, 2);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `assegnazione`
--
ALTER TABLE `assegnazione`
  ADD PRIMARY KEY (`IDscan`,`IDuser`),
  ADD KEY `user_assegnazione` (`IDuser`);

--
-- Indici per le tabelle `dispone`
--
ALTER TABLE `dispone`
  ADD KEY `gruppo_dispone` (`IDgruppo`),
  ADD KEY `permessi_dispone` (`IDpermessi`);

--
-- Indici per le tabelle `gruppo`
--
ALTER TABLE `gruppo`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `modifica`
--
ALTER TABLE `modifica`
  ADD PRIMARY KEY (`IDuser`,`IDtrascrizione`),
  ADD KEY `trascrizione_modifica` (`IDtrascrizione`);

--
-- Indici per le tabelle `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `user_modulo` (`fk_id_user`);

--
-- Indici per le tabelle `opera`
--
ALTER TABLE `opera`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `permessi`
--
ALTER TABLE `permessi`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `scansione`
--
ALTER TABLE `scansione`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `opera_scan` (`IDopera`),
  ADD KEY `user_scan` (`IDuser`);

--
-- Indici per le tabelle `trascrizione`
--
ALTER TABLE `trascrizione`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `scan_trascription` (`IDscan`);

--
-- Indici per le tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `mail` (`MAIL`),
  ADD UNIQUE KEY `username` (`USERNAME`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `gruppo`
--
ALTER TABLE `gruppo`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT per la tabella `modulo`
--
ALTER TABLE `modulo`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `opera`
--
ALTER TABLE `opera`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT per la tabella `permessi`
--
ALTER TABLE `permessi`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `scansione`
--
ALTER TABLE `scansione`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `trascrizione`
--
ALTER TABLE `trascrizione`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
