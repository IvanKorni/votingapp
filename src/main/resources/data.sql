delete from users;
delete from user_roles;
delete from roles;
delete from menu;

insert into users (id, username, password)
values (1, 'User', '{noop}password'),
       (2, 'Admin', '{noop}admin');


insert into roles (id, name)
values (1, 'ADMIN'),
       (2, 'USER');

insert into user_roles (user_id, role_id)
values (1, 2),
       (2, 1);

insert into menu (restaurant_name, menu)
values ('Восход', 'Завтрак, Обед, Ужин'),
       ('Жирок', 'Завтрак1, Обед1, Ужин1');