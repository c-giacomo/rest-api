create sequence users_seq start with 1 increment by 1;
create table user_role (
    user_id bigint not null,
    role varchar(255),
    unique (user_id, role)
);
create table users (
    enabled boolean not null,
    locked boolean not null,
    id bigint not null,
    name varchar(20) not null,
    surname varchar(20) not null,
    password varchar(20) not null,
    email varchar(30),
    username varchar(30) not null unique,
    primary key (id)
);
alter table if exists user_role add constraint fk_user_id foreign key (user_id) references users;