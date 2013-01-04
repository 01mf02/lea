package lea.syntax;

import lea.generator.CodeWriter;
import lea.generator.Generator;

public class Assignment extends Instruction {
	Expression left, right;

	public Assignment(Expression a1, Expression a2) {
		super(a1, a2);
		left = a1;
		right = a2;
	}

	public String toString() {
		return "Assign" + super.toString();
	}

	public void toJava(CodeWriter w) {
		/*TODO :
		  Il faut faire en sorte que quand on initialise et affecte une valeur ça soit traité correctement.
		  ex : i : int := 5;
		  
		  Quelqu'un a une idée ?
		  
		  Ce qu'on peut faire c'est déclarer toutes les variables au début de la fonction,
		  et par la suite, plus besoin de le faire... Nous n'aurons à traiter que les affectations.
		  Il faudra alors récupérer l'environnement et faire la déclaration au début du bloc...
		  
		  Je pense que c'est à faire dans le FunctionGenerator... Mais je n'arrive pas à afficher quoi que ce soit...
		  */
		
		// variable assignment
		if (right != null)
			w.writeLine(left.toJava() + " = " + right.toJava() + ";");
		// variable declaration
		else
			w.writeLine(Generator.generateDeclaration(left.toJava(),
					left.getType()));

	}

	public String toDotString() {
		return "Assign";
	}
}
