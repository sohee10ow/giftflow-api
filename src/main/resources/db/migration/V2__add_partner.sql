create table partner (
                         id bigserial primary key,
                         name varchar(100) not null,
                         status varchar(20) not null,
                         callback_url varchar(255),
                         created_at timestamp not null default current_timestamp,
                         updated_at timestamp not null default current_timestamp
);
