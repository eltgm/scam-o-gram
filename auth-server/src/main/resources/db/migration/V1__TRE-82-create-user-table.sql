CREATE TABLE roles
(
    id   serial primary key,
    role text not null unique
);

INSERT INTO roles(id, role)
VALUES (1, 'ADMIN'),
       (2, 'CLIENT');

CREATE TABLE user_table
(
    id            bigserial primary key,
    username      text unique not null,
    is_enabled    bool        not null default true,
    password_hash text        not null,
    name          text        not null,
    surname       text        not null,
    middle_name   text,
    birth_date    date,
    sex           text
);

CREATE TABLE user_roles
(
    role_id int not null references roles (id),
    user_id int not null references user_table (id)
);



INSERT INTO user_table(id, username, is_enabled, password_hash, name, surname, middle_name, birth_date, sex)
VALUES (1, 'user', true, '$2a$10$2CjV9j/YLU3Uy8jbZi2S..LdK6vLnVbMylLNC.4GWxHjrZ94T.72y', 'Vladislav', 'Sultanyarov', 'Alekseevich', '09-07-1998'::date, 'male'); -- 12344321

INSERT INTO user_roles
VALUES (1, 1),
       (2, 1);