create sequence category_seq start with 1 increment by 1;
create sequence expense_seq start with 1 increment by 1;
create sequence product_seq start with 1 increment by 1;

create table category (
    id bigint not null,
    description varchar(40) not null,
    name varchar(40) not null,
    primary key (id)
);
create table expense (
    amount float(53),
    date timestamp(6) with time zone,
    id bigint not null,
    user_id bigint not null,
    description varchar(40),
    primary key (id)
);
create table product (
    price float(53),
    category_id bigint not null unique,
    expense_id bigint not null,
    id bigint not null,
    description varchar(40),
    name varchar(40),
    primary key (id)
);

alter table if exists expense add constraint fk_expense_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;
alter table if exists product add constraint fk_category_entity foreign key (category_id) references category;
alter table if exists product add constraint fk_expense_entity foreign key (expense_id) references expense;