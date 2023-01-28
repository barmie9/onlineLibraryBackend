---------------------------  ENDPOINTY  ---------------------------

GET:
http://localhost:8080/books - Zwraca liste wszystkich książek z BAZY
http://localhost:8080/bookGenres - Zwraca liste wszystkich Gatunków

http://localhost:8080/myBooks - Zwraca liste książek uzytkownika (Headers:Username,Password)
http://localhost:8080/user - Zwraca dane uzytkownika (Headers:Username,Password)
-------
http://localhost:8080/cart - Zwraca liste książek z koszyka (Headers:Token)

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

DELETE:
http://localhost:8080/deleteCartItem - Usuwa ksiązke z koszyka (Headers:Username,Password), (body: {"book":id})
