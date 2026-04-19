# File reader utilizing Weak Reference
## Wrocław University of Science and Technology - Laboratory Assignment. Project developed as part of Advanced Techniques in Java course. Focused on Weak References and jlink practice
A Java-based utility for file reading. The system utilizes `WeakReference` to implement cache mechanism allowing the Garbage Collector to reclaim memory. This prevents `OutOfMemoryError` when handling large files. Used jlink to create a minimal JRE.
\
Implemented a `Strategy Pattern` allowing to proccess different file formats without modyfing the core engine.

**Launching the app**
1. Generate jars:
   `mvn clean package`
2. Download jmods 25.0.2: https://gluonhq.com/products/javafx/ a następnie wypakować zawartość do folderu C:\javafx-jmods
3. Linking:
   `jlink 
--module-path "target\lab2-1.0-SNAPSHOT.jar;C:\javafx-jmods\javafx-jmods-25.0.2" 
--add-modules lab2
--launcher przegladacz=lab2/pl.wojtekolo.studia.ApplicationLauncher 
--output custom-jre 
--strip-debug 
--compress zip-6 
--no-header-files 
--no-man-pages`
4. Launch
   `custom-jre\bin\przegladacz.bat`
5. Launch with JVM parameters - 1G
`.\custom-jre\bin\java -Xmx1G -m lab2/pl.wojtekolo.studia.ApplicationLauncher`
6. Launch with JVM parameters - 16M
   `.\custom-jre\bin\java -Xmx16M -m lab2/pl.wojtekolo.studia.ApplicationLauncher`
