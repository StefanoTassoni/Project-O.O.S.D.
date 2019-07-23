-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Creato il: Lug 23, 2019 alle 23:35
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
  `fk_id_user` int(10) UNSIGNED NOT NULL,
  `qualifica` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `modulo`
--

INSERT INTO `modulo` (`ID`, `message`, `fk_id_user`, `qualifica`) VALUES
(4, 'Vorrei far parte della biblioteca', 6, 'laurea in matematica');

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
(24, 'decamerore', 'deca', 'deca', 'italian', '2019-07-10', '2019-07-18 00:00:00'),
(25, 'Batman', 'batman', 'kirby', 'itENg', '2019-07-17', '2019-07-17 00:00:00'),
(23, 'Divina Commedia', 'Romanzo', 'Dante Alighieri', 'Italiana', '1304-06-27', '1304-06-27 00:00:00');

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
  `pagina` varchar(200) NOT NULL,
  `data_pubblicazione` datetime NOT NULL,
  `formato` char(200) NOT NULL,
  `ID_opera` int(10) UNSIGNED NOT NULL,
  `ID_user` int(10) UNSIGNED NOT NULL,
  `path` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `scansione`
--

INSERT INTO `scansione` (`ID`, `pagina`, `data_pubblicazione`, `formato`, `ID_opera`, `ID_user`, `path`) VALUES
(11, '2', '2019-07-23 00:00:00', 'jpg', 25, 1, 'src/main/resources/imagedir/25/2.jpg'),
(10, '2', '2019-07-23 00:00:00', 'jpg', 24, 1, 'src/main/resources/imagedir/24/2.jpg'),
(6, '1', '2019-07-22 00:00:00', 'jpg', 23, 1, 'src/main/resources/imagedir/23/1.jpg'),
(7, '2', '2019-07-22 00:00:00', 'jpg', 23, 1, 'src/main/resources/imagedir/23/2.jpg'),
(8, '3', '2019-07-22 00:00:00', 'jpg', 23, 1, 'src/main/resources/imagedir/23/3.jpg'),
(9, '4', '2019-07-22 00:00:00', 'jpg', 23, 1, 'src/main/resources/imagedir/23/4.jpg');

-- --------------------------------------------------------

--
-- Struttura della tabella `trascrizione`
--

CREATE TABLE `trascrizione` (
  `ID` int(10) UNSIGNED NOT NULL,
  `testo` text,
  `ID_scan` int(10) UNSIGNED NOT NULL,
  `validata` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `trascrizione`
--

INSERT INTO `trascrizione` (`ID`, `testo`, `ID_scan`, `validata`) VALUES
(11, '<html dir=<apx>ltr<apx>><head></head><body contenteditable=<apx>true<apx>><p><font face=<apx>Lucida Grande<apx>>COMINCIA LA COMEDIA DI</font></p><p><font face=<apx>Lucida Grande<apx>>dante allegheri di firenzeTrascrittore</font></p></body></html>', 6, 1);

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
  `NOME_GRUPPO` enum('supervisore','lettore','trascrittore') NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`ID`, `NAME`, `SURNAME`, `USERNAME`, `PASSWORD`, `MAIL`, `NOME_GRUPPO`, `address`, `phone`) VALUES
(1, 'FEDERICO', 'ANGELINI', 'f', '252f10c83610ebca1a59cbae8255eba2f95be4d1d7bcfa89d7248a82d9f111', 'fede@gmail.com', 'supervisore', 'via de', ''),
(2, 'gino', 'paoli', 'paolino', 'daipaolo', 'gino@gmail.com', 'lettore', '', ''),
(3, 'rocco', 'papaleo', 'rocchetta', 'pappa', 'rocco@gmail.com', 'trascrittore', '', ''),
(4, 'feffo', 'feffo', 'feffo', '51fa5adfd09d64475ee75ed58b40c75c28d5323f8f18167662057f76aef25a6', 'feffo@feffo.it', 'supervisore', 'via da qui', '+393453453333'),
(5, 'fico', 'fico', 'fico@fico.it', '5d942a1d73fd8f28d71e6b3d2e42f44721db94b734c2edcfe6fcd48b76a74f9', 'fico@fico.it', 'supervisore', '', ''),
(6, 'ste', 'ste', 'stef', '7aacb6d011d8d98c2caa91c132e5a3cdeb346b143a871a4a223b79ea922487', 'ste@ste.it', 'supervisore', '', ''),
(7, 'stefano', 'stefano', 'stefano', '41c61f521e29163e5aa912e91d3f2db2201dab39c758e6b6473255251341af91', 'stefano@stef.it', 'supervisore', '', ''),
(8, 'prova', 'prova', 'l', 'acac86c0e69ca906f632be2dacccb2b77d22b0621f20ebece1a4835b93f6f0', 'prova@prova.it', 'supervisore', '', '');

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
(3, 2),
(5, 3),
(6, 3),
(4, 2),
(7, 2),
(8, 3);

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
  ADD KEY `opera_scan` (`ID_opera`),
  ADD KEY `user_scan` (`ID_user`);

--
-- Indici per le tabelle `trascrizione`
--
ALTER TABLE `trascrizione`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `scan_trascription` (`ID_scan`);

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
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `opera`
--
ALTER TABLE `opera`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT per la tabella `permessi`
--
ALTER TABLE `permessi`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `scansione`
--
ALTER TABLE `scansione`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT per la tabella `trascrizione`
--
ALTER TABLE `trascrizione`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
