
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Evertex.java \
        Graph.java \
		MyLinkedList.java \
		MySet.java \
		Taxi.java \
		TaxiService.java \
		Vertex.java \
		checker.java
        

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
