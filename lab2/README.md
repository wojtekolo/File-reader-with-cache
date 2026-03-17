**Uruchomienie**
1. Wygenerowanie jarów:
   `mvn clean package`
2. Należy pobrać jmods 25.0.2 ze strony https://gluonhq.com/products/javafx/ a następnie wypakować zawartość do folderu C:\javafx-jmods
3. Linkowanie:
   `jlink 
--module-path "target\lab2-1.0-SNAPSHOT.jar;C:\javafx-jmods\javafx-jmods-25.0.2" 
--add-modules lab2
--launcher przegladacz=lab2/pl.wojtekolo.studia.ApplicationLauncher 
--output custom-jre 
--strip-debug 
--compress zip-6 
--no-header-files 
--no-man-pages`
4. Uruchomienie
   `custom-jre\bin\przegladacz.bat`
5. Uruchomienie z parametrami wirtualnej maszyny - 1G
`.\custom-jre\bin\java -Xmx1G -m lab2/pl.wojtekolo.studia.ApplicationLauncher`
6. Uruchomienie z parametrami wirtualnej maszyny - 16M
   `.\custom-jre\bin\java -Xmx16M -m lab2/pl.wojtekolo.studia.ApplicationLauncher`