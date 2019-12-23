Pour lancer mon applicaton : 

J'ai malheureusement essayé avec le professeur pendant 2 heures de faire fonctionner mon makefile sans succès.
A cause de cela, pour executer mon application la commande make ne marche pas.

Donc il faut : 

se placer dans ce dossier : /src

puis tapper dans l'invite de commande(windows) ou bash(linux) : 

javac demenagement/*.java

puis l'executer avec la commande :

sur Windows:

java -cp ".;..\dist\lib\mariadb-java-client-2.3.0.jar" demenagement.Demenagement


sur Linux (je ne suis pas sur vous me l'aviez dit une seule fois en classe) :

java -cp ".:..\dist\lib\mariadb-java-client-2.3.0.jar" demenagement.Demenagement

j'ai tester cela fonctionne parfaitement, j'ai joint à mon projet la preuve, une capture décran de la 
compilation et de mon éxécution.

