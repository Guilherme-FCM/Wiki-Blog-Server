create table Posts (
	id serial primary key not null,
	title varchar not null,
	author varchar not null,
	content text not null,
	modification_date date
	default current_timestamp
);

create table Comments (
	id serial primary key not null,
	id_post int not null,
	content text not null,
	date_time date default current_timestamp,
	constraint post_fk foreign key (id_post) references Posts(id)
);