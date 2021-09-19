create table if not exists customers
(
    id  bigserial    not null
        constraint customers_pk
        primary key,
    name  varchar(100) not null,
    email varchar(100) not null
);

alter table customers
    owner to postgres;

create unique index customers_id_uindex
    on customers (id);

create table if not exists products
       (
           id bigserial not null
               constraint products_pkey
               primary key,
           price integer,
           title varchar(255)
       );

alter table products
    owner to postgres;

create table if not exists products_customers
(
    product_id  bigserial not null
        constraint products_customers_product_id_fkey
            references products,
    customer_id bigserial not null
        constraint products_customers_customer_id_fkey
            references customers
);


alter table products_customers
    owner to postgres;

INSERT INTO public.customers (id, name, email)
VALUES (DEFAULT, 'Gleb', 'g@tt.ru');

INSERT INTO public.customers (id, name, email)
VALUES (DEFAULT, 'Oleg', 'o@tt.ru');

INSERT INTO public.customers (id, name, email)
VALUES (DEFAULT, 'Vlad', 'v@tt.ru');


INSERT INTO public.products (id, price, title)
VALUES (DEFAULT, 150, 'chair');

INSERT INTO public.products (id, price, title)
VALUES (DEFAULT, 344, 'table');

INSERT INTO public.products (id, price, title)
VALUES (DEFAULT, 3423, 'fridge');

INSERT INTO public.products_customers (product_id, customer_id)
VALUES (1, 1), (1, 2), (1, 3), (2, 2), (3, 2), (3, 3);





