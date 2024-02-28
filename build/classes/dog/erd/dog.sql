drop database dog;

create database dog;

use dog;

SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS dog;
DROP TABLE IF EXISTS liked;
DROP TABLE IF EXISTS gallery;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS user;

/* Create Tables */

CREATE TABLE board
(
boardId int NOT NULL AUTO_INCREMENT,
title varchar(255),
content varchar(4000),
modTime datetime DEFAULT CURRENT_TIMESTAMP,
isDeleted int,
viewCount int,
replyCount int,
uId varchar(255) NOT NULL,
PRIMARY KEY (boardId),
UNIQUE (uId)
);

CREATE TABLE dog
(
dogId int NOT NULL AUTO_INCREMENT,
bDate date,
breed varchar(255) NOT NULL,
gender varchar(255),
dname varchar(255),
uId varchar(255) NOT NULL,
PRIMARY KEY (dogId),
UNIQUE (uId)
);

CREATE TABLE gallery
(
galleryId int NOT NULL AUTO_INCREMENT,
title varchar(255) NOT NULL,
content varchar(4000),
isDeleted int DEFAULT 0,
viewCount int DEFAULT 0,
replyCount int DEFAULT 0,
fName varchar(255),
uId varchar(255) NOT NULL,
PRIMARY KEY (galleryId),
UNIQUE (uId)
);

CREATE TABLE item
(
itemId int NOT NULL AUTO_INCREMENT,
price int NOT NULL,
itemName varchar(255) NOT NULL,
iType varchar(255) DEFAULT 'etc' NOT NULL,
note varchar(2000),
fName varchar(255),
PRIMARY KEY (itemId)
);

CREATE TABLE liked
(
likedId int NOT NULL AUTO_INCREMENT,
galleryId int NOT NULL,
uId varchar(255) NOT NULL,
PRIMARY KEY (likedId),
UNIQUE (uId)
);

CREATE TABLE reply
(
replyId int NOT NULL AUTO_INCREMENT,
comment varchar(2000) NOT NULL,
regTime datetime DEFAULT CURRENT_TIMESTAMP,
boardId int NOT NULL,
uId varchar(255) NOT NULL,
PRIMARY KEY (replyId),
UNIQUE (uId)
);

CREATE TABLE user
(
uId varchar(255) NOT NULL,
pwd varchar(255) NOT NULL,
uname varchar(255) NOT NULL,
email varchar(255),
regDate date DEFAULT CURRENT_DATE,
isDeleted int DEFAULT 0,
balance int DEFAULT 0,
PRIMARY KEY (uId),
UNIQUE (uId)
);

/* Create Foreign Keys */

ALTER TABLE reply
ADD FOREIGN KEY (boardId)
REFERENCES board (boardId)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;

ALTER TABLE liked
ADD FOREIGN KEY (galleryId)
REFERENCES gallery (galleryId)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;

ALTER TABLE board
ADD FOREIGN KEY (uId)
REFERENCES user (uId)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;

ALTER TABLE dog
ADD FOREIGN KEY (uId)
REFERENCES user (uId)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;

ALTER TABLE gallery
ADD FOREIGN KEY (uId)
REFERENCES user (uId)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;

ALTER TABLE liked
ADD FOREIGN KEY (uId)
REFERENCES user (uId)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;

ALTER TABLE reply
ADD FOREIGN KEY (uId)
REFERENCES user (uId)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;

AlTER TABLE gallery MODIFY COLUMN fName VARCHAR(255) DEFAULT '';

- ERD