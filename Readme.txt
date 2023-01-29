---------------------------  ENDPOINTY  ---------------------------

GET:
http://localhost:8080/bookGenres - Zwraca liste wszystkich Gatunków
http://localhost:8080/user - Zwraca dane uzytkownika (Headers:Username,Password)
-------
http://localhost:8080/cart - Zwraca liste książek z koszyka (Headers:Token)
http://localhost:8080/books?c=0 - Zwraca liste wszystkich lub przefiltrowanych książek z BAZY
http://localhost:8080/categories - Zwraca liste kategorii/Gatunków
http://localhost:8080/mybooks - Zwraca liste książek uzytkownika (Headers:Token)

POST:

http://localhost:8080/pay - Zmienia koszyk na transakcje i tworzy nowy koszyk
(Headers:Username,Password), body:
{
    "method": "blik",
    "blikCode": "123456",
    "cardData": "Bartek M"
}
----------------
http://localhost:8080/login
http://localhost:8080/register    body:
{
"name":"Adam",
"surname":"Kowalski",
"username":"kowalskiZiom2",
"email":"kowalski@kowalski.pl",
"password":"haslo1",
"confirm":"haslo1"
}
http://localhost:8080/addtocart - Dodaje ksiązke do koszyka (Headers:Token), (body: {"book":id})
http://localhost:8080/removefromcart - Usuwa 1 ksiązke z koszyka (Headers:Token), (body: {"book":id})

DELETE:

