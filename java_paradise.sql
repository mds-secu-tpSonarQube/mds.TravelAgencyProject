-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 03 Octobre 2016 à 14:34
-- Version du serveur :  5.5.52-0+deb8u1
-- Version de PHP :  5.6.24-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `java_paradise`
--
CREATE DATABASE IF NOT EXISTS `java_paradise` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `java_paradise`;

-- --------------------------------------------------------

--
-- Structure de la table `places`
--

CREATE TABLE IF NOT EXISTS `places` (
`id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `places`
--

INSERT INTO `places` (`id`, `name`) VALUES
(3, 'Jambon'),
(4, 'Fromage'),
(5, ''),
(6, ''),
(7, 'jambon');

-- --------------------------------------------------------

--
-- Structure de la table `trips`
--

CREATE TABLE IF NOT EXISTS `trips` (
`id` int(11) NOT NULL,
  `departure` int(11) NOT NULL,
  `destination` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `trips`
--

INSERT INTO `trips` (`id`, `departure`, `destination`, `price`) VALUES
(1, 3, 4, 35);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `places`
--
ALTER TABLE `places`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `trips`
--
ALTER TABLE `trips`
 ADD PRIMARY KEY (`id`), ADD KEY `destination` (`destination`), ADD KEY `departure` (`departure`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `places`
--
ALTER TABLE `places`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `trips`
--
ALTER TABLE `trips`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `trips`
--
ALTER TABLE `trips`
ADD CONSTRAINT `trips_ibfk_2` FOREIGN KEY (`departure`) REFERENCES `places` (`id`),
ADD CONSTRAINT `trips_ibfk_1` FOREIGN KEY (`destination`) REFERENCES `places` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
