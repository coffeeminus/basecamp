create table board (
	post_id int not null auto_increment,
	email varchar(255) not null,
    pw varchar(255) not null, 
    text text, 
    mod_time datetime,
    primary key (post_id)
);
