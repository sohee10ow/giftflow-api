create table issue_order (
                             id bigserial primary key,
                             partner_id bigint not null,
                             product_id bigint not null,
                             pin_inventory_id bigint,
                             partner_order_id varchar(100) not null,
                             status varchar(20) not null,
                             issued_at timestamp,
                             canceled_at timestamp,
                             created_at timestamp not null default current_timestamp,
                             updated_at timestamp not null default current_timestamp,

                             constraint fk_issue_order_partner
                                 foreign key (partner_id)
                                     references partner(id),

                             constraint fk_issue_order_product
                                 foreign key (product_id)
                                     references product(id),

                             constraint fk_issue_order_pin_inventory
                                 foreign key (pin_inventory_id)
                                     references pin_inventory(id)
);
