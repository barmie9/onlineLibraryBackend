---------------------------  ENDPOINTY  ---------------------------

GET:
http://localhost:8080/bookGenres - Zwraca liste wszystkich Gatunków
http://localhost:8080/myBooks - Zwraca liste książek uzytkownika (Headers:Username,Password)
http://localhost:8080/user - Zwraca dane uzytkownika (Headers:Username,Password)
-------
http://localhost:8080/cart - Zwraca liste książek z koszyka (Headers:Token)
http://localhost:8080/books?c=0 - Zwraca liste wszystkich lub przefiltrowanych książek z BAZY
http://localhost:8080/categories - Zwraca liste kategorii/Gatunków

POST:
http://localhost:8080/addCartItem - Dodaje ksiązke do koszyka (Headers:Username,Password), (body: {"book":id})
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

DELETE:
http://localhost:8080/deleteCartItem - Usuwa ksiązke z koszyka (Headers:Username,Password), (body: {"book":id})
