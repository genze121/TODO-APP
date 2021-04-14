create database Todo_Notes_App;
use Todo_Notes_App;

//===========================================================
// Table for registration and login of User
//===========================================================

create table register_login
(id int primary key not null auto_increment,
firstname varchar(30),
lastname varchar(30),
username varchar(30),
password varchar(10));

select * from register_login;

//===========================================================
// Table for storing Todo Notes
//===========================================================

create table todo
(id int primary key not null auto_increment,
title varchar(300),
is_done bit(1) not null,
username varchar(30),
description varchar(500),
userid int);

select * from todo;

