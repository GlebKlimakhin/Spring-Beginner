drop table products;

create table products (
    id                          bigserial primary key,
    title                       varchar(100),
    price                       int,
    created_at                  timestamp default current_timestamp,
    updated_at                  timestamp default current_timestamp
);
