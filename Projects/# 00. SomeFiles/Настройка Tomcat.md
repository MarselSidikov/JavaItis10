0. Скачать [Tomcat](https://tomcat.apache.org/download-90.cgi) и распаковать в нужную папку
1. Создать файл setenv.bat в папке bin.
2. Переписать файл tomcat-users.xml в папке conf.
3. Запустить GitBush из папки bin.
4. `./setenv.bat`
5. `./startup.bat`
6. Переходим на `http://localhost:8080/manager/html`
7. Работаем, при выключении набираем `./shutdown.bat`