//команда для обновления всех версий
mvn versions:use-latest-versions

//вывод доступных версий
mvn versions:display-dependency-updates 
[INFO] No dependencies in Dependencies have newer versions.

//запуск всех тестов
mvn clean test
Tests run: 21, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 163.886 sec

//запуск одного класса
mvn clean test -Dtest=CheckoutTest
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 45.23 sec

//запуск одного отдельно взятого теста 
mvnc clean test -Dtest=CartTest#addItemToCartAndValidate
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 21.432 sec

//пробросил из CML внутрь теста
mvn clean test -Dtest=MvnTest -Dbrowser=chrome  -Duser=standard_user -Dpassword=secret_sauce

//запуск из альтернативного pom.xml
 mvn -f /Users/olenka/IdeaProjects/SauceDemo/pom2.xml clean test -DsuiteXmlFile=src/test/resources/SmokeTest.xml

