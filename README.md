# C2007_C2011_JEE_EBook
create database C2007_C2011_ebook;
use C2007_C2011_ebook;

DROP TABLE IF EXISTS C2007_C2011_ebook.users ;
CREATE TABLE IF NOT EXISTS C2007_C2011_ebook.users (
	user_id int(11) NOT NULL AUTO_INCREMENT,
	email varchar(30) NOT NULL,
	password varchar(512) NOT NULL,
	full_name varchar(30) NOT NULL,
	PRIMARY KEY (user_id)
) ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS C2007_C2011_ebook.category ;
CREATE TABLE IF NOT EXISTS C2007_C2011_ebook.category (
	category_id int(11) NOT NULL AUTO_INCREMENT,
	name varchar(30) NOT NULL,
	PRIMARY KEY (category_id) 
) ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS C2007_C2011_ebook.product ;
CREATE TABLE IF NOT EXISTS C2007_C2011_ebook.product (
	product_id int(11) NOT NULL AUTO_INCREMENT,
	name varchar(128) NOT NULL,
	author varchar(64) NOT NULL,
	description mediumtext NOT NULL,
	isbn varchar(15) NOT NULL,
	image longblob NOT NULL,
	price DECIMAL(13,2) NOT NULL,
	publish_date date NOT NULL,
	last_update_time datetime NOT NULL,
	category_id int(11) NOT NULL,
	PRIMARY KEY (product_id),
	CONSTRAINT product_category_fk FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS C2007_C2011_ebook.customer ;
CREATE TABLE IF NOT EXISTS C2007_C2011_ebook.customer (
	customer_id int(11) NOT NULL AUTO_INCREMENT,
	email varchar(64) NOT NULL,
	fullname varchar(30) NOT NULL,
	address varchar(128) NOT NULL,
	city varchar(32) NOT NULL,
	country varchar(64) NOT NULL,
	phone varchar(15) NOT NULL,
	zipcode varchar(24) NOT NULL,
	password varchar(512) NOT NULL,
	register_date datetime NOT NULL,
	PRIMARY KEY (customer_id)
) ENGINE=InnoDB CHARSET=utf8;

