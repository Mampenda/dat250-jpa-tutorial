# Experiment 2 

Implement the domain model for credit cards similar to the Person-Address-Examples in the lecture on object-relational 
mappings. Pay close attention to the bidirectional associations in the domain model.

![img.png](images/img.png)

#### Questions:
1. Explain the used database and how/when it runs. 
2. Provide the SQL used to create the table Customer
3. Find a way to inspect the database tables being created and create a database schema in your report. 
4. Do the created tables correspond to your initial thoughts regarding the exercise?

#### Answers:
1. If we look at the `build.gradle.kts(dat250-jpa-tutorial)` file, we can look at the dependencies, which lists the 
libraries and/or plugins on which Gradle and the build script depend on. We can see the line
`implementation("com.h2database:h2:2.2.220")`. When `implementation()` is used, the dependency is only included in the 
runtime classpath, as opposed to `compile()` which is included in both the compiletime- *and* the runtime-classpath.   
The string `"com.h2database:h2:2.2.220"` inside `implementation()` indicates that an _H2_ database is being used.
2. SQL used to create the table Customer: `CREATE TABLE Customer`.
3. MySQL can be used to inspect the tables being used and also to create schemas
4. When running the test I get the following tables in the database: 

![img_1.png](images/img1.png)

I had expected there to be a table for each class, but I did not expect there to be so many tables for the classes that point to each other.


I had some trouble getting the last test to pass, the main error I got was 
 
```
java.lang.NullPointerException: Cannot invoke "java.util.Collection.add(Object)" because "customerAdresses" is null
	at no.hvl.dat250.jpa.tutorial.creditcards.driver.CreditCardsMain.createObjects(CreditCardsMain.java:39)
	at no.hvl.dat250.jpa.tutorial.creditcards.driver.CreditCardsMain.main(CreditCardsMain.java:18)
	at no.hvl.dat250.jpa.tutorial.creditcards.driver.CreditCardsMainTest.testDomainModelPersistence(CreditCardsMainTest.java:31)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
```

I figured I had implemented the classes wrongly by not initializing the Collections as new HashSets. 
After I implemented them correctly I got a new error AssertionFailedError:
```
org.opentest4j.AssertionFailedError: expected: org.hibernate.collection.spi.PersistentBag@681d704e<[no.hvl.dat250.jpa.tutorial.creditcards.Customer@71262020]> but was: java.util.ImmutableCollections$Set12@39f93225<[no.hvl.dat250.jpa.tutorial.creditcards.Customer@71262020]>
	at app//org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
	at app//org.junit.jupiter.api.AssertionFailureBuilder.buildAndThrow(AssertionFailureBuilder.java:132)
	at app//org.junit.jupiter.api.AssertEquals.failNotEqual(AssertEquals.java:197)
	at app//org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:182)
	at app//org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:177)
	at app//org.junit.jupiter.api.Assertions.assertEquals(Assertions.java:1145)
	at app//no.hvl.dat250.jpa.tutorial.creditcards.driver.CreditCardsMainTest.testDomainModelPersistence(CreditCardsMainTest.java:47)
	at java.base@21.0.4/java.lang.reflect.Method.invoke(Method.java:580)
	at java.base@21.0.4/java.util.ArrayList.forEach(ArrayList.java:1596)
	at java.base@21.0.4/java.util.ArrayList.forEach(ArrayList.java:1596)
```
When I changed the types from `Collection` to `Set`, all the tests passed. 