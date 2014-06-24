drop table geek if exists cascade;

create table geek (
	id_geek numeric not null,
	pseudo varchar(255) not null,
	sex tinyint not null, -- 0 for woman, 1 for man
	gravatar_url varchar(255),
	interest varchar(255) not null,
	primary key (id_geek)
);

create sequence geek_seq start with 1000;