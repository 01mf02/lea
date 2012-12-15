package lea.generator;

import lea.syntax.*;

public class InstructionGenerator {
	String str;
	SyntaxTree node;
	/*TODO
	 * Créer une variable pour les tabulation*/
	public InstructionGenerator(SyntaxTree st)
	{
		str ="";
		str+= st.toString();
		
		
		
		
		
		
	}
	
	public String generate()
	{
		return str;
	}
}
