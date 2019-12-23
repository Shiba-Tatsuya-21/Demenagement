JC = javac
#FLAGS = -cp ".;C:\SourcesJava\Demenagement\dist\lib\mariadb-java-client-2.3.0.jar" Demenagement
pt=demenagement

$(pt)/Demenagement.class: $(pt)/Demenagement.java $(pt)/ConfirmerInfo.class       
	$(JC) $(pt)/Demenagement.java #$(JFLAGS) avanat le nom classe

	
$(pt)/ConfirmerInfo.class:  $(pt)/ConfirmerInfo.java $(pt)/Inventaire.class $(pt)/Outil.class

$(pt)/Inventaire.class: $(pt)/Inventaire.java $(pt)/Meubles.class $(pt)/Cartons.class   $(pt)/OptionBudget.class 

$(pt)/Outil.class: $(pt)/Outil.java

$(pt)/Cartons.class: $(pt)/Cartons.java $(pt)/Inventaire.class $(pt)/Outil.class

$(pt)/Meubles.class: $(pt)/Meubles.java $(pt)/MeublesDemontable.class $(pt)/Outil.class $(pt)/Inventaire.class

$(pt)/MeublesDemontable.class: $(pt)/MeublesDemontable.java $(pt)/Meubles.class $(pt)/Outil.class
 
$(pt)/OptionBudget.class: $(pt)/OptionBudget.java $(pt)/Inventaire.class $(pt)/Outil.class


clean:
	$(RM) *.class

