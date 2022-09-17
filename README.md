<h1 align="center">Wiki-Blog-Server</h1>
<p align="center">📝 A Java service to CRUD posts and comments on blogs</p>

<p align="center">
    <a href="#about">About</a> |
    <a href="#installations">Installations</a> |
    <a href="#technologies">Technologies</a> | 
    <a href="#license">License</a>
</p>

## 😁**About**
This app was created for blogs who need to create, delete, update posts and comments in their app. The purpose of developing this service is to learn about Data Source, Connection Pool and JSON response in Java language.

## 👨‍💻**Installations**
To use this API, it's require install in your computer:
- [Java & JVM](https://www.oracle.com/java/technologies/downloads/)
- [Apache Tomcat](https://tomcat.apache.org/download-90.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

## ✨**Technologies**
- [Java](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html)
- [PostgreSQL](https://www.postgresql.org/docs/)

## **Database Query**
~~~ sql
create database wiki-blog;
use wiki-blog;

create table Posts (
	id serial primary key not null,
	title varchar not null,
	author varchar not null,
	content text not null,
	modification_date timestamp not null default current_timestamp
);

create table Comments (
	id serial primary key not null,
	id_post int not null,
	content text not null,
	date_time timestamp default current_timestamp,
	constraint post_fk foreign key (id_post) references Posts(id)
);
~~~

## ⚖**License**
This project is under the license [MIT](./LICENSE).
