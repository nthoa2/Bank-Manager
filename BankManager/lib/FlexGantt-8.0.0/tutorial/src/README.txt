The tutorial folder contains several Java files, which show the steps needed
to create a first basic Gantt chart.

Use the following command inside the tutorial folder:

    javac -cp ../lib/*.jar com/dlsc/flexgantt/examples/jumpstart/*.java
	
Each one has its own main() method and can be run via:

    java -cp .;../lib/*.jar com.dlsc.flexgantt.examples.jumpstart.Step1_Basic_Setup
    java -cp .;../lib/*.jar com.dlsc.flexgantt.examples.jumpstart.Step2_Tree_Nodes
	...
	...