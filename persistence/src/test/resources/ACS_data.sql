insert into category_menu(category_id,category_name) values(1,'one');
insert into category_menu(category_id,category_name) values(2,'two');


insert into dish(dish_id,category_id,dish_name,description,price) values(1,1,'fish','about fish', 12.95);

insert into client(client_id,name_client,email) values(1,'admin','admin@gmail.com');

insert into orders(order_id,client_id,table_number) values(1,1,1);

insert into order_item(order_item_id,order_id,dish_id,`count`,price) values(1,1,1,2,12.95);





