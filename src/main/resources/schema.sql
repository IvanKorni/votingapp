DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

create table users
(
    id int not null,
    username varchar not null,
    password varchar not null,
    voted boolean default false,
    date_voted date default '2020-01-01' not null,
    constraint TABLE_NAME_PK
        primary key (id)
);

create table roles
(
    id int not null,
    name varchar not null,
    constraint ROLES_PK
        primary key (id)
);

create table user_roles
(
    user_id int not null,
    role_id int not null,
    constraint USER_ROLES_USERS_ID_FK
        foreign key (user_id) references users (id)
            on update cascade on delete cascade,
    constraint USER_ROLES_USERS_ID_FK_2
        foreign key (role_id) references users (id)
            on update cascade on delete cascade
);


create table menu
(
    id int auto_increment,
    restaurant_name varchar null,
    menu varchar null,
    vote int default 0 not null,
    constraint MENU_PK
        primary key (id)
);


