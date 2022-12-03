# User login: 
username: user@email.com
pass: password

# C2007_C2011_JEE_EBook
create database C2007_C2011_ebook;
use C2007_C2011_ebook;

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `email` varchar(64) NOT NULL,
  `fullname` varchar(30) NOT NULL,
  `address` varchar(128) NOT NULL,
  `city` varchar(32) NOT NULL,
  `country` varchar(64) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `zipcode` varchar(24) NOT NULL,
  `password` varchar(512) NOT NULL,
  `register_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `author` varchar(64) NOT NULL,
  `description` mediumtext NOT NULL,
  `isbn` varchar(15) NOT NULL,
  `image` longblob NOT NULL,
  `price` decimal(13,2) NOT NULL,
  `publish_date` date NOT NULL,
  `last_update_time` datetime NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(512) NOT NULL,
  `full_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `users` (`user_id`, `email`, `password`, `full_name`) VALUES
(4, 'ray@email.com', '94AEFB8BE78B2B7C344D11D1BA8A79EF087ECEB19150881F69460B8772753263', 'ray'),
(9, 'user@email.com', '94AEFB8BE78B2B7C344D11D1BA8A79EF087ECEB19150881F69460B8772753263', 'user'),
(10, 'admin@email.com', '94AEFB8BE78B2B7C344D11D1BA8A79EF087ECEB19150881F69460B8772753263', 'admin');


ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `product_category_fk` (`category_id`);


ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);


ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;


ALTER TABLE `product`
  ADD CONSTRAINT `product_category_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

