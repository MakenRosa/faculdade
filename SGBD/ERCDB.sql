-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema erc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema erc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `erc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `erc` ;

-- -----------------------------------------------------
-- Table `erc`.`cfg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `erc`.`cfg` (
  `idCfg` INT NOT NULL,
  `dia` DATE NULL DEFAULT '0000-00-00',
  `excepts` VARCHAR(20) NULL DEFAULT '',
  PRIMARY KEY (`idCfg`),
  UNIQUE INDEX `idDia` (`idCfg` ASC) VISIBLE,
  UNIQUE INDEX `dia` (`dia` ASC) VISIBLE,
  UNIQUE INDEX `excepts` (`excepts` ASC) VISIBLE,
  UNIQUE INDEX `dia_2` (`dia` ASC) VISIBLE,
  UNIQUE INDEX `excepts_2` (`excepts` ASC) VISIBLE,
  UNIQUE INDEX `dia_3` (`dia` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `erc`.`pessoas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `erc`.`pessoas` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nmPessoa` VARCHAR(45) NOT NULL,
  `cpfPessoa` INT NOT NULL,
  `cargoPessoa` VARCHAR(20) NOT NULL,
  `matriculaPessoa` INT NOT NULL,
  UNIQUE INDEX `idPessoa` (`idPessoa` ASC) VISIBLE,
  UNIQUE INDEX `nmPessoa` (`nmPessoa` ASC) VISIBLE,
  UNIQUE INDEX `cpfPessoa` (`cpfPessoa` ASC) VISIBLE,
  UNIQUE INDEX `matriculaPessoa` (`matriculaPessoa` ASC) VISIBLE,
  UNIQUE INDEX `cpfPessoa_2` (`cpfPessoa` ASC) VISIBLE,
  UNIQUE INDEX `cpfPessoa_3` (`cpfPessoa` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `erc`.`enderecos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `erc`.`enderecos` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `eKey` VARCHAR(12) NOT NULL,
  `eInbox` VARCHAR(20) NULL DEFAULT NULL,
  `eSetor` VARCHAR(15) NOT NULL,
  `idPessoa` INT NOT NULL,
  `endereco` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`idEndereco`),
  UNIQUE INDEX `eAddress` (`idEndereco` ASC) VISIBLE,
  UNIQUE INDEX `idPessoa` (`idPessoa` ASC) VISIBLE,
  UNIQUE INDEX `eAddress_2` (`idEndereco` ASC) VISIBLE,
  UNIQUE INDEX `endereco` (`endereco` ASC) VISIBLE,
  CONSTRAINT `enderecos_ibfk_1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `erc`.`pessoas` (`idPessoa`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `erc`.`mensagens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `erc`.`mensagens` (
  `idMessage` INT NOT NULL AUTO_INCREMENT,
  `bodyMessage` VARCHAR(256) NULL DEFAULT NULL,
  `headerMessage` VARCHAR(180) NOT NULL,
  `idEndereco` INT NOT NULL,
  `idCfg` INT NOT NULL,
  PRIMARY KEY (`idMessage`),
  UNIQUE INDEX `idMessage` (`idMessage` ASC) VISIBLE,
  UNIQUE INDEX `idEndereco` (`idEndereco` ASC) VISIBLE,
  UNIQUE INDEX `idDia` (`idCfg` ASC) VISIBLE,
  UNIQUE INDEX `idCfg` (`idCfg` ASC) VISIBLE,
  CONSTRAINT `servidor_fk1`
    FOREIGN KEY (`idEndereco`)
    REFERENCES `erc`.`enderecos` (`idEndereco`),
  CONSTRAINT `servidor_fk2`
    FOREIGN KEY (`idCfg`)
    REFERENCES `erc`.`cfg` (`idCfg`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
