
/* menu*/
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwitch', '99', '1', '2019-04-23', 'Main Course', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129', '1', '2019-12-23', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149', '1', '2020-01-10', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Friees', '57', '0', '2020-07-02', 'Starters', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Choclate Brownie', '32', '1', '2021-11-02', 'Dessert', '1');


/*USER*/
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('1', 'Siva');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('2', 'Ajay');



/*Cart details*/
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,1);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,3);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,5);



/*View Menu Item List Admin (TYUC001)*/
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery 
from truyum.menu_item;



/*View Menu Item List Customer (TYUC002)*/
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery 
from truyum.menu_item 
where 
me_active='1' and me_date_of_launch>(select curdate());

/*Edit Menu Item (TYUC003)*/
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery  
from truyum.menu_item where me_id=1;

update truyum.menu_item
set 
me_name='Sandwich',
me_price='150.00',
me_active='0',
me_date_of_launch='2020-12-31',
me_category='Dessert',
me_free_delivery='1'
where me_id=1;

/*Add to Cart (TYUC004)*/
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,1);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,3);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(1,5);

/*View Cart (TYUC005)*/
use truyum;
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery 
from truyum.menu_item
inner join truyum.cart on
cart.ct_me_id=menu_item.me_id
where ct_us_id=1;

/*total*/
select sum(me_price) as Total
from truyum.menu_item
inner join truyum.cart on
cart.ct_me_id=menu_item.me_id
where ct_us_id=1;

/*Remove Item from Cart (TYUC006)*/
delete from cart 
where
cart.ct_me_id=1
and
cart.ct_us_id=1;

