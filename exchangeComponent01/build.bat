"C:\Program Files\Java\jdk1.8.0_73\bin\javac" -Xlint:all -g:none -classpath src;build -d build src\Component.java

cd build
"C:\Program Files\Java\jdk1.8.0_73\bin\jar" -cvf ..\Component.jar IComponent.class
"C:\Program Files\Java\jdk1.8.0_73\bin\jar" -uvf ..\Component.jar Component.class
"C:\Program Files\Java\jdk1.8.0_73\bin\jar" -uvf ..\Component.jar Component$Port.class

"C:\Program Files\Java\jdk1.8.0_73\bin\jar" -tvf ..\Component.jar
pause