
-- DROP SCHEMA IF EXISTS `SystemServiceClients` ;
-- CREATE SCHEMA IF NOT EXISTS `SystemServiceClients` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- USE `SystemServiceClients` ;

-- -----------------------------------------------------
-- Table `category_menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category_menu` ;

CREATE TABLE `category_menu` (
  `category_id` INT(11) NOT NULL,
  `category_name` VARCHAR(50) NOT NULL,
  `image` BLOB NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dish` ;

CREATE TABLE IF NOT EXISTS `dish` (
  `dish_id` INT(11) NOT NULL,
  `category_id` INT(11) NOT NULL,
  `dish_name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(200) NULL,
  `time_cook` TIME NULL,
  `price` DECIMAL(10,0) NULL,
  `image_dish` BLOB NOT NULL,
  `large_image_dish` BLOB NOT NULL,
  UNIQUE INDEX `dish_name_UNIQUE` (`dish_name` ASC),
  INDEX `fk_category_name_idx` (`category_id` ASC),
  PRIMARY KEY (`dish_id`),
  CONSTRAINT `fk_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category_menu` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `client` ;

CREATE TABLE IF NOT EXISTS `client` (
  `client_id` INT(11) NOT NULL,
  `name_client` VARCHAR(80) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orders` ;

CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` INT(11) NOT NULL,
  `client_id` INT(11) NOT NULL,
  `table_number` INT NOT NULL,
  `price_all_order` DECIMAL(10,0) NOT NULL,
  `general_time_cook` TIME NOT NULL,
  `created` TIMESTAMP NOT NULL,
  `order_rate` INT NULL DEFAULT 0,
  `responce_description` VARCHAR(512) NULL,
  `status` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_client_id_idx` (`client_id` ASC),
  CONSTRAINT `fk_client_id`
    FOREIGN KEY (`client_id`)
    REFERENCES `client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `order_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order_item` ;

CREATE TABLE IF NOT EXISTS `order_item` (
  `order_item_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  `dish_id` INT(11) NOT NULL,
  `count` INT NOT NULL,
  `price` DECIMAL(10,0) NULL,
  PRIMARY KEY (`order_item_id`),
  INDEX `fk_order_id_idx` (`order_id` ASC),
  INDEX `fk_dish_id_idx` (`dish_id` ASC),
  CONSTRAINT `fk_order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `orders` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dish_id`
    FOREIGN KEY (`dish_id`)
    REFERENCES `dish` (`dish_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- SET SQL_MODE=@OLD_SQL_MODE;
-- SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
-- SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
