create table service_user (
	id bigserial primary key,
	first_name varchar(20),
	last_name varchar(20),
	age integer,
	phone varchar(20) unique ,
	email varchar(100) unique,
	login varchar(100) unique,
	password varchar(100),
	role varchar(10)
);

create table cookie (
  id bigserial primary key,
  value VARCHAR(200),
  user_id bigint,
  foreign key (user_id) references service_user(id)
);

create table car (
  id bigserial primary key,
  model VARCHAR(100),
  number VARCHAR(100),
  owner_id BIGINT,
  FOREIGN KEY (owner_id) references service_user(id)
);