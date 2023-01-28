------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------BOOK_GENRE----------------------------------------------------------
insert into BOOK_GENRE (id,name,desc) values(1,'Komedia', 'Smieszne rzeczy i takie tam');
insert into BOOK_GENRE (id,name,desc) values(2,'Horor', 'Przerazajace rzecz');
insert into BOOK_GENRE (id,name,desc) values(3,'Przygodowe', 'Przygody i takie tam');
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
------------------------------------------------------BOOK--------------------------------------------------------------
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(1,'Title 1',12,'1 - Content ksiazki o czyms tam, trolololo',
'1 - Krotkie opis ksiazki',
'1 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
1,8);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(2,'Title 2',13,'2 - Content ksiazki o czyms tam, trolololo',
'2 - Krotkie opis ksiazki',
'2 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
2,7);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(3,'Title 3',11,'3 - Content ksiazki o czyms tam, trolololo',
'3 - Krotkie opis ksiazki',
'3 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
3,6);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(4,'Title 4',14,'4 - Content ksiazki o czyms tam, trolololo',
'4 - Krotkie opis ksiazki',
'4 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
1,5);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(5,'Title 5',15,'5 - Content ksiazki o czyms tam, trolololo',
'5 - Krotkie opis ksiazki',
'5 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
2,4);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(6,'Title 6',16,'6 - Content ksiazki o czyms tam, trolololo',
'6 - Krotkie opis ksiazki',
'6 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
3,3);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(7,'Title 7',17,'7 - Content ksiazki o czyms tam, trolololo',
'7 - Krotkie opis ksiazki',
'7 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
1,2);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(8,'Title 8',11,'8 - Content ksiazki o czyms tam, trolololo',
'8 - Krotkie opis ksiazki',
'8 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
1,1);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(9,'Title 9',14,'9 - Content ksiazki o czyms tam, trolololo',
'9 - Krotkie opis ksiazki',
'9 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
2,2);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(10,'Title 10',23,'10 - Content ksiazki o czyms tam, trolololo',
'10 - Krotkie opis ksiazki',
'10 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
3,1);
insert into BOOK (id,title,price,content,desc_short,desc_long,genre_id,author_id)
values(11,'Title 11',22,'11 - Content ksiazki o czyms tam, trolololo',
'11 - Krotkie opis ksiazki',
'11 - Dlugi opis ksiazki. Do rodzinnego domu przyjeżdża ze szkół w Wilnie na wakacje młody Tadeusz. Okazuje się, że Soplicowo, majątek jego opiekuna Sędziego Soplicy, jest pełne gości, którzy zjechali tu, aby uczestniczyć w procesie o stary zamek, niegdyś własność bogatego  magnata Stolnika Horeszki.',
1,2);
------------------------------------------------------------------------------------------------------------------------
----------------------------------------------BOOK_AUTHORS--------------------------------------------------------------
--insert into BOOK_AUTHORS (id,book_id,author_id) values (1,1,1);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (2,2,2);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (3,3,3);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (4,4,4);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (5,5,5);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (6,6,6);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (7,7,7);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (8,8,8);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (9,9,1);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (10,10,2);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (11,11,3);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (12,1,4);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (13,2,5);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (14,3,6);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (15,4,7);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (16,5,8);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (17,6,1);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (18,6,2);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (19,7,3);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (20,7,4);
--insert into BOOK_AUTHORS (id,book_id,author_id) values (21,7,5);
------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------USER_LIBRARY-----------------------------------------------------------
--insert into USER_LIBRARY (id,email,username,password,name,last_name,date_of_birth,picture) values();
insert into USER_LIBRARY (id,email,username,password,name,last_name,date_of_birth)
values(1,'admin@domena.com','admin','password','Bob','Bobowski',DATE '1999-3-22');
insert into USER_LIBRARY (id,email,username,password,name,last_name,date_of_birth)
values(2,'user_test_01@domena.com','user_01','password','Jan','Nowak',DATE '1993-4-25');
------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------TRANSACTIONS------------------------------------------------------------
insert into TRANSACTION (id,date_transaction) values(1,DATE '2022-1-21');
insert into TRANSACTION (id,date_transaction) values(2,DATE '2022-1-22');
------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------SHOPPING_CART-----------------------------------------------------------
insert into SHOPPING_CART (id,user_id,transaction_id) values (1,1,1);
insert into SHOPPING_CART (id,user_id,transaction_id) values (2,1,2);
insert into SHOPPING_CART (id,user_id) values (3,1);
------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------CART_ITEM-------------------------------------------------------------
insert into CART_ITEM (id,book_id,shopping_cart_id) values(1,1,1);
insert into CART_ITEM (id,book_id,shopping_cart_id) values(2,2,1);
insert into CART_ITEM (id,book_id,shopping_cart_id) values(3,3,2);
insert into CART_ITEM (id,book_id,shopping_cart_id) values(4,4,3);
insert into CART_ITEM (id,book_id,shopping_cart_id) values(5,5,3);
------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------COMMENT--------------------------------------------------------------
insert into COMMENT (id,rating,content,created,book_id,user_id) values(1,4,'Nie jest zla', DATE '2022-1-21',1,1);
insert into COMMENT (id,rating,content,created,book_id,user_id) values(2,3,'Srednia ...', DATE '2022-1-21',2,1);