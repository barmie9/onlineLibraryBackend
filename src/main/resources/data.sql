------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------BOOK_GENRE----------------------------------------------------------
insert into BOOK_GENRE (id,name,desc) values(1,'Komedia', 'Smieszne rzeczy i takie tam');
insert into BOOK_GENRE (id,name,desc) values(2,'Horor', 'Przerazajace rzecz');
insert into BOOK_GENRE (id,name,desc) values(3,'Przygodowe', 'Przygody i takie tam');
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------BOOK--------------------------------------------------------------
insert into BOOK (id,title,price,genre_id) values(1,'Title 1',12,1);
insert into BOOK (id,title,price,genre_id) values(2,'Title 2',13,2);
insert into BOOK (id,title,price,genre_id) values(3,'Title 3',11,3);
insert into BOOK (id,title,price,genre_id) values(4,'Title 4',14,1);
insert into BOOK (id,title,price,genre_id) values(5,'Title 5',15,2);
insert into BOOK (id,title,price,genre_id) values(6,'Title 6',16,3);
insert into BOOK (id,title,price,genre_id) values(7,'Title 7',17,1);
insert into BOOK (id,title,price,genre_id) values(8,'Title 8',11,1);
insert into BOOK (id,title,price,genre_id) values(9,'Title 9',14,2);
insert into BOOK (id,title,price,genre_id) values(10,'Title 10',23,3);
insert into BOOK (id,title,price,genre_id) values(11,'Title 11',22,1);
--insert into BOOK (id,title,price,genre_id) values(,'Title ',12,);
------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------AUTHOR----------------------------------------------------------
insert into AUTHOR (id,name,last_name,data_of_birth,data_of_death) values (1,'Bob','Jail',DATE '1988-12-29',DATE '2010-11-22');
insert into AUTHOR (id,name,last_name,data_of_birth,data_of_death) values (2,'Suzi','Rivers',DATE '1812-4-27',DATE '1922-8-12');
insert into AUTHOR (id,name,last_name,data_of_birth,data_of_death) values (3,'Logan','Rout',DATE '1833-3-15',DATE '1910-7-13');
insert into AUTHOR (id,name,last_name,data_of_birth,data_of_death) values (4,'John','Pathe',DATE '1843-11-6',DATE '1920-6-14');
insert into AUTHOR (id,name,last_name,data_of_birth,data_of_death) values (5,'Adam','Kowalski',DATE '1856-2-4',DATE '1945-5-15');
insert into AUTHOR (id,name,last_name,data_of_birth,data_of_death) values (6,'Jan','Jakubiak',DATE '1843-6-23',DATE '1921-4-2');
insert into AUTHOR (id,name,last_name,data_of_birth,data_of_death) values (7,'Michał','Januszewski',DATE '1843-12-12',DATE '1903-3-3');
insert into AUTHOR (id,name,last_name,data_of_birth,data_of_death) values (8,'Bartek','Snieg',DATE '1865-1-12',DATE '1965-2-4');
--insert into AUTHOR (id,name,last_name) values (1,'Bob','Jail');
------------------------------------------------------------------------------------------------------------------------
----------------------------------------------BOOK_AUTHORS--------------------------------------------------------------
insert into BOOK_AUTHORS (id,book_id,author_id) values (1,1,1);
insert into BOOK_AUTHORS (id,book_id,author_id) values (2,2,2);
insert into BOOK_AUTHORS (id,book_id,author_id) values (3,3,3);
insert into BOOK_AUTHORS (id,book_id,author_id) values (4,4,4);
insert into BOOK_AUTHORS (id,book_id,author_id) values (5,5,5);
insert into BOOK_AUTHORS (id,book_id,author_id) values (6,6,6);
insert into BOOK_AUTHORS (id,book_id,author_id) values (7,7,7);
insert into BOOK_AUTHORS (id,book_id,author_id) values (8,8,8);
insert into BOOK_AUTHORS (id,book_id,author_id) values (9,9,1);
insert into BOOK_AUTHORS (id,book_id,author_id) values (10,10,2);
insert into BOOK_AUTHORS (id,book_id,author_id) values (11,11,3);
insert into BOOK_AUTHORS (id,book_id,author_id) values (12,1,4);
insert into BOOK_AUTHORS (id,book_id,author_id) values (13,2,5);
insert into BOOK_AUTHORS (id,book_id,author_id) values (14,3,6);
insert into BOOK_AUTHORS (id,book_id,author_id) values (15,4,7);
insert into BOOK_AUTHORS (id,book_id,author_id) values (16,5,8);
insert into BOOK_AUTHORS (id,book_id,author_id) values (17,6,1);
insert into BOOK_AUTHORS (id,book_id,author_id) values (18,6,2);
insert into BOOK_AUTHORS (id,book_id,author_id) values (19,7,3);
insert into BOOK_AUTHORS (id,book_id,author_id) values (20,7,4);
insert into BOOK_AUTHORS (id,book_id,author_id) values (21,7,5);
------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------USER_LIBRARY-----------------------------------------------------------
--insert into USER_LIBRARY (id,email,username,password,name,last_name,date_of_birth,picture) values();
insert into USER_LIBRARY (id,email,username,password,name,last_name,date_of_birth)
values(1,'admin@domena.com','admin','password','Bob','Bobowski',DATE '1999-3-22');
insert into USER_LIBRARY (id,email,username,password,name,last_name,date_of_birth)
values(2,'user_test_01@domena.com','user_01','password','Jan','Nowak',DATE '1993-4-25');
------------------------------------------------------------------------------------------------------------------------