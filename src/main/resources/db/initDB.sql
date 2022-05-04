drop table if exists user_roles;
drop table if exists menu;
drop table if exists users;
drop table if exists roles;

create table users
(
    id         int                          not null primary key,
    username   VARCHAR(255)                 not null,
    password   VARCHAR(255)                 not null,
    voted      BOOLEAN default false        not null,
    date_voted DATE    default '2020-01-01' not null
);

create table roles
(
    id   int          not null primary key,
    name varchar(100) not null
);

create table user_roles
(
    user_id INT not null,
    role_id INT not null,
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

create table menu
(
    id              int           not null auto_increment primary key,
    restaurant_name varchar(15)   null,
    menu            varchar(25)   null,
    vote            int default 0 not null null
);

