create table board (
	email varchar(255) not null,
    pw varchar(255) not null,
    text text,
    mod_time datetime,
    primary key ( email )
);
