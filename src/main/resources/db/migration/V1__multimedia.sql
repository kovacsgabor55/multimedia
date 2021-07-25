create table books
(
    id           integer      not null auto_increment,
    author       varchar(50)  not null,
    release_date date         not null,
    title        varchar(100) not null,
    primary key (id)
);
create table movies
(
    id          integer      not null auto_increment,
    director    varchar(50)  not null,
    film_studio varchar(30)  not null,
    title       varchar(100) not null,
    primary key (id)
);
create table musics
(
    id        integer      not null auto_increment,
    genre     varchar(15)  not null,
    performer varchar(50)  not null,
    title     varchar(100) not null,
    primary key (id)
);
