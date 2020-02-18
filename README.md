# Fishky
An Internet application to help you train your language skills by imitating flashcards (Polish: fiszki). Main purpose of this project is to improve programming abilities but also to provide some useful functionality. Currently in early development phase. It is being created by [@Dimolek](https://github.com/Dimolek/) and [@MateuszSochacki](https://github.com/MateuszSochacki).

## Built with
* [IntelliJ](https://www.jetbrains.com/idea/) - IDE
* [Maven](https://maven.apache.org/) - Dependency management
* [Java 11](https://www.java.com) - Backend programming language
  * [Spring](https://spring.io/) - Application framework
  * [Hibernate](https://hibernate.org) - Object-relational mapping framework
  * [Lombok](https://projectlombok.org/) - External library to cleanup the code
  * [JUnit 5](https://junit.org/junit5/), [Mockito](https://site.mockito.org/) - Testing framework
* [MySql](https://www.mysql.com/) - Database
* [React](https://reactjs.org/) - Frontend

## Functionality
 - creating user accounts
 - user login
 - creating new dictionaries containing flashcards and storing them in database
 - managing dictionaries and flashcards (delete, modify)
 - choosing words in random manner in chosen language to allow practising
 
 ## Screenshots
 ![UI](https://cdn.discordapp.com/attachments/353086685002727425/679286235537342464/fishky.png)

## TODO:
- [x] adding, editing and removing users and flashcards
- [x] any form of GUI
- [ ] data validation
- [x] user authentication using Spring Security and JWT
- [ ] cover app with unit tests
- [ ] integrate with Google Translate API
