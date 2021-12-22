# notes_manager

This is the work sample, a rest endpoint to manage notes in a database

##Starting

You need to start the database an run on the code "spring-boot:run" that should be everything to start sending requests

###Requirements

-XAMPP

-MYSQL

-POSTMAN

-INTELLIJ

-SPRINGBOOT

-SPRING WEB

-MAVEN

-JDK

-HIBERNATE

-JPA

-LOMBOK

##Tests

I used postman to send the requests and check if everything worked, the url is "http://localhost:8080/", you must change the type of request and complete the url to start sending requests

##Code tests

http://localhost:8080/api/notes DELETE  ---------this will delete all the information on the database

http://localhost:8080/api/notes POST    ---------this will add the new information to the database

http://localhost:8080/api/notes/{id} PUT --------this will update the information of one note

http://localhost:8080/api/notes/{id} DELETE -----this will delete the note with the id on the url

http://localhost:8080/api/notes{id} GET ---------this will show you the note with the id on the url

http://localhost:8080/api/notes GET -------------this will show you all notes

http://localhost:8080/api/bulkUpdate/notes PUT --this will update all the notes changed (you need to write the id too)

##Author

Isaac Balam Rodriguez Arellano
