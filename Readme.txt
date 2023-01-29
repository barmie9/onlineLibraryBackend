---------------------------  ENDPOINTY  ---------------------------

GET:
http://localhost:8080/bookGenres - Zwraca liste wszystkich Gatunków

-------
-http://localhost:8080/cart - Zwraca liste książek z koszyka (Headers:Token)
-http://localhost:8080/books?c=0 - Zwraca liste wszystkich lub przefiltrowanych książek z BAZY
-http://localhost:8080/categories - Zwraca liste kategorii/Gatunków
-http://localhost:8080/mybooks - Zwraca liste książek uzytkownika (Headers:Token)
-http://localhost:8080/read.php?id=1 - Zwraca dane ksiazki:title,author,content (Headers:Token)
-http://localhost:8080/profile - Zwraca dane uzytkownika (Headers:Token)


POST:
----------------
-http://localhost:8080/login
-http://localhost:8080/register    body:
{
"name":"Adam",
"surname":"Kowalski",
"username":"kowalskiZiom2",
"email":"kowalski@kowalski.pl",
"password":"haslo1",
"confirm":"haslo1"
}
-http://localhost:8080/addtocart - Dodaje ksiązke do koszyka (Headers:Token), (body: {"book":id})
-http://localhost:8080/removefromcart - Usuwa 1 ksiązke z koszyka (Headers:Token), (body: {"book":id})
-http://localhost:8080/payblik - Zmienia koszyk na transakcje i tworzy nowy koszyk (Headers:Token), body:
{
"processor":"blik",
"code":"123456"
}
-http://localhost:8080/paycard - Zmienia koszyk na transakcje i tworzy nowy koszyk (Headers:Token), body:
{"processor":"card","numer":"6969696969696969","cvv":"420","holder":"Jan Kowalski"}
-http://localhost:8080/updateprofile (Headers:Token), body:
{"name":"Jan","surname":"Kowalski","email":"kowalski98@costam.com","dob":"1999/11/23"}
-http://localhost:8080/changepassword (Headers:Token), body:
{"old":"password","newPassword":"haslo1","confirm":"haslo1"}


