create table product(
                        id bigserial primary key,
                        name varchar(100) not null,
                        price integer not null,
                        created_at timestamp not null default current_timestamp,
                        updated_at timestamp not null default current_timestamp
);