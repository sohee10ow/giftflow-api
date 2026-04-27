create table pin_inventory (
                               id bigserial primary key,
                               product_id bigint not null,
                               pin_code varchar(100) not null,
                               status varchar(20) not null,
                               created_at timestamp not null default current_timestamp,
                               updated_at timestamp not null default current_timestamp,

                               constraint fk_pin_inventory_product
                                   foreign key (product_id)
                                       references product(id),

                               constraint uk_pin_inventory_pin_code
                                   unique (pin_code)
);