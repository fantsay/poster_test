# poster_test(early alfa)

Установка на чистую систему.

Зависимости   для запуска
JDK8, Tomcat8, MySQl 5.*, Maven 3.0

1. cd ~/ && mkdir poster && cd poster
2. Установить с помщью менеджера пакета Вашего дистрибутива : git maven mysql wget openjdk-8-jdk
3. Скачать Tomcat wget "http://apache.ip-connect.vn.ua/tomcat/tomcat-8/v8.0.28/bin/apache-tomcat-8.0.28.tar.gz"
4. tar -xvf apache-tomcat-8.0.28.tar.gz
5. удалить содержимое apache-tomcat-8.0.28/webapps 
6. скачать исходники git clone https://github.com/fantsay/poster_test.git
<!--7. Postgresql -->
<!--   service potgresql start -->
<!--   su -l root-->
<!--   su - postgres-->
<!--   psql-->
<!--   # \password postgres-->
<!--   ввести "poster"-->
<!--   #CREATE DATABASE poster;-->
<!--   #GRANT ALL privileges ON DATABASE poster TO postgres;-->
<!--   \q-->
<!--   Веернуться в свою учетную , exit exit .-->
7. Установите и запустите mysql, создайте пользователя mysql пароль mysql ,базу poster


8. cd ~/poster/poster_test/
9. Наполним чуток базу mvn -Dtest=PopulateDB#populate test
10.Соберем без тестов(не пройдут), mvn package -Dmaven.test.skip=true

11. Скопируем war и переименуем чтоб был доступен в корне,#cd target #cp poster-0.1.war ~/poster/apach*/webapps/ROOT.war/
12. cd ~/poster/apache*/bin/
    ./catalina.sh start/
13. В браузере  http://127.0.0.1:8080/
14. логин   admin пароль 111
   Поиск не отображаеться, не успел с ангуляром разобраться основательно.
   
  
