# P9-candidate

Ce module est un microservice Rest API dédié au passage des tests des candidats.

Test de l’application :

Tests unitaires :  
Lancer les tests unitaires du module avec l’instruction gradle build.  
Le rapport de couverture de code par les tests est disponible au directory : 
build/jacocoHtml/index.html  
ou directement au path :   
test/java/report/index.html

Tests des microservices :
Ouvrir Postman et tester les endpoints suivants :

Methodes Post :   
Ajouter les candidats :  
172.23.0.4:8081/candidat/add  
Json :  
{
"id":"1",
"uuid":"237e9877-e79b-12d4-a765-321741963000",
"firstname":"John",
"lastname":"Doe",
"email":"johndoe@gmail.com",
"password":"F@4567890"
}  

172.23.0.4:8081/candidate/add  
{
"id":"2",
"uuid":"237e9877-e79b-12d4-a765-321741963001",
"firstname":"Jack",
"lastname":"Smith",
"email":"jacksmith@gmail.com", 
"password":"19@4567890"
}  

