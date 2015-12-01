Agenda
=======================

Presentation (2h)
----------------------
* Dependency injection
    * Constructor
    * Setter
    * Pitfall 1 - Duplicates / ambiguous results
* JDBC
    * Interact with database
* Hibernate
    * Pitfall 1 - Equals and Hashcode: https://developer.jboss.org/wiki/EqualsandHashCode?_sscc=t
    * Pitfall 2 - When we query for hibernate.complete.City we actually do very many request, because it also fetches the city's country
        * Lazy loading - Delaying the fetch until the value is required (perhaps never).
        * Fetch join - Rewriting our query to also fetch countries
* Web
    * Parameters


Exercise (1h 30m)
---------------------
* Pair up
* In exercise-folder create a simple web-application and use:
    * JPA/Hibernate annotated @Entity to map objects to tables
    * Controllers to process web request
    * Validate input with annotations @Valid @Min @NotNull
    * Services with transactions, to do composite operations
    * Repositories to keep persistence logic separate
    * Chose your own domain. Examples:
        * Lunch registration app
        * TODO-list
        * Timely-clone
* Run with:
    * gradlew web:exercise:runApp
        * app will -hopefully- start on http://localhost:8080/exercise


