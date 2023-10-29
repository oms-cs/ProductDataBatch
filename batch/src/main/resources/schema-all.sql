--uniq_id,
--crawl_timestamp,
--product_url,
--product_name,
--product_category_tree,
--pid,
--retail_price,
--discounted_price,
--image,is_FK_Advantage_product,
--description,
--product_rating,
--overall_rating,
--brand,
--product_specifications

DROP TABLE IF EXISTS `product_details_table`;

CREATE TABLE IF NOT EXISTS `product_details_table` (
  `uniq_id` VARCHAR(255) NOT NULL,
  `product_name` MEDIUMTEXT NULL,
  `crawl_timestamp` VARCHAR(45) NULL,
  `product_url` LONGTEXT NULL,
  `product_category_tree` LONGTEXT NULL,
  `pid` VARCHAR(45) NULL,
  `retail_price` DECIMAL NULL,
  `discounted_price` DECIMAL NULL,
  `product_rating` INT(20) NULL,
  `overall_rating` INT(20) NULL,
  `brand` VARCHAR(50) NULL,
  `product_specification` LONGTEXT NULL,
  `image` LONGTEXT NULL,
  `is_FK_Advantage_product` VARCHAR(15) NULL,
  `description` LONGTEXT NULL,
  PRIMARY KEY (`uniq_id`)
 );

