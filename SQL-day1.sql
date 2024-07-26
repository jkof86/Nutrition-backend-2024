create table foods (
	f_id serial primary key,
	name VARCHAR(50) unique not null,
	available bool not null,
	quantity INT,
	calories INT,
	protein INT,
	carbs INT,
	fat INT
);

insert into foods (f_id, name, available, quantity, calories, protein, carbs, fat) 
values (DEFAULT, 'Apple', true, 6613, 27947, 3005, 3389, 6366);

insert into foods (f_id, name, available, quantity, calories, protein, carbs, fat) 
values (DEFAULT, 'Orange', true, 582, 43403, 4123, 710, 1333);

insert into foods (f_id, name, available, quantity, calories, protein, carbs, fat) 
values (DEFAULT, 'Beef Bottom Round Steak', true, 2728, 20815, 2030, 2731, 1626);

insert into foods (f_id, name, available, quantity, calories, protein, carbs, fat) 
values (DEFAULT, 'Chicken Leg', true, 2580, 33046, 3411, 6674, 8061);

insert into foods (f_id, name, available, quantity, calories, protein, carbs, fat) 
values (DEFAULT, 'Chicken Breast', true, 3624, 32467, 3248, 6319, 4296);

update foods set available = true;
update foods set quantity=154, calories=80, protein=0, carbs=22, fat=0 where name = 'Apple';
update foods set quantity=130, calories=62, protein=1.2, carbs=15.4, fat=0.2 where name = 'Orange';
update foods set quantity=112, calories=210, protein=23, carbs=8, fat=12 where name = 'Beef Bottom Round Steak';
update foods set quantity=112, calories=150, protein=21, carbs=0, fat=7 where name = 'Chicken Leg';
update foods set quantity=112, calories=140, protein=25, carbs=0, fat=4 where name = 'Chicken Breast';

alter table foods
add available bool;

ALTER TABLE foods 
ALTER COLUMN f_id
add generated always as identity;

drop table foods;
select * from foods order by name;


create table users (
	u_id serial primary key,
	fname VARCHAR(50) not null,
	lname VARCHAR(50) not null,
	email VARCHAR(100) unique not null,
	pw VARCHAR(50),
	age smallint check(age >= 0),
	height smallint check(height >= 0),
	weight smallint check(weight >= 0),
	calorie_goal INT check(calorie_goal >= 0),
	protein_goal INT check(protein_goal >= 0),
	carbs_goal INT check(carbs_goal >= 0),
	fat_goal INT check(fat_goal >= 0)
);

insert into users (u_id, fname, lname, email, pw, age, height, weight, calorie_goal, protein_goal, carbs_goal, fat_goal) 
values (DEFAULT, 'Max', 'Battman', 'mbattman0@fotki.com', 'qI9$Wu2X+BkbUi', 98, 125, 40, 14622, 7451, 3539, 6558);

insert into users (u_id, fname, lname, email, pw, age, height, weight, calorie_goal, protein_goal, carbs_goal, fat_goal) 
values (DEFAULT, 'Mariska', 'Lealle', 'mlealle1@senate.gov', 'jX0!@C!krCe', 84, 89, 377, 40486, 7601, 8960, 3699);

insert into users (u_id, fname, lname, email, pw, age, height, weight, calorie_goal, protein_goal, carbs_goal, fat_goal) 
values (DEFAULT, 'Giffy', 'Ciccoloi', 'gciccoloi2@wisc.edu', 'jX1@S=5@', 44, 198, 820, 20523, 6521, 9262, 1885);

insert into users (u_id, fname, lname, email, pw, age, height, weight, calorie_goal, protein_goal, carbs_goal, fat_goal) 
values (DEFAULT, 'Natassia', 'Guslon', 'nguslon3@wikimedia.org', 'gH3_8pzXV_!=~tz', 74, 81, 765, 31593, 6271, 5201, 3998);

insert into users (u_id, fname, lname, email, pw, age, height, weight, calorie_goal, protein_goal, carbs_goal, fat_goal) 
values (DEFAULT, 'Candi', 'Bottoms', 'cbottoms4@nps.gov', 'hD9##DY#', 32, 86, 713, 68, 2336, 2651, 3155);

drop table users;
select * from users order by fname; 

insert into users values 
(default,);

insert into foods values 
(default,);

update users set age = ;
update users set age = where age = ;

alter table users 
add pw varchar(50);

alter table users
add email varchar(100);