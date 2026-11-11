create sequence category_seq start with 1 increment by 1;
create sequence expense_seq start with 1 increment by 1;
create sequence product_seq start with 1 increment by 1;
create sequence expense_product_seq start with 1 increment by 1;

create table category (
    id bigint not null,
    description varchar(40) not null,
    name varchar(40) not null,
    primary key (id)
);
create table expense (
    id bigint not null,
    amount float(53),
    date timestamp(6) with time zone,
    user_id bigint not null,
    description varchar(40),
    primary key (id)
);
create table product (
    id bigint not null,
    price float(53),
    category_id bigint not null,
    description varchar(40),
    name varchar(40),
    primary key (id)
);
create table expense_product (
    id bigint not null,
    quantity integer not null,
    expense_id bigint not null,
    product_id bigint not null,
    primary key (id)
);

alter table if exists expense add constraint fk_expense_user foreign key (user_id) references users on delete cascade;
alter table if exists product add constraint fk_product_category foreign key (category_id) references category;
alter table if exists expense_product add constraint fk_expense_product_expense foreign key (expense_id) references expense;
alter table if exists expense_product add constraint fk_expense_product_product foreign key (product_id) references product;