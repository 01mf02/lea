package lea.generator;

import java.io.IOException;

import lea.syntax.*;

public class InstructionGenerator extends SyntaxTreeGenerator{
	String str;

	public InstructionGenerator(Instruction inst) throws IOException {
		str += "";
		str += "\n ** Classe : " + inst.getClass().getSimpleName();

		if (inst instanceof Assignment) {
			str += "\t Assignment \n";
			//str += "\n****code " + ((Assignment) inst).getLeft().toString() + " \n\t" 
			       //+ new VariableGenerator(inst.getLeft()).generate();
		} 
		else if (inst instanceof Case) {
			str += "\t Case \n";
			str += "\n****code " + inst.getLeft() + " = " + inst.getRight();
		}
		else if (inst instanceof ElseCondition) {
			str += "\t ElseCondition \n";
			str += "\n****code " + inst.getLeft() + " = " + inst.getRight();
		} 
		else if (inst instanceof Condition) {
			str += "\t Condition \n";
			str += "\n****code ";
			str += "\ntest " + leftRightTest(inst);
			str += inst.getLeft() + " = " + inst.getRight();
		} 
		else if (inst instanceof Loop) {
			str += "\t Loop \n";
			str += "\n****code " + inst.getLeft() + " = " + inst.getRight();
		} 
		else if (inst instanceof Repeat) {
			str += "\t Repeat \n";
			str += "\n****code " + inst.getLeft() + " = " + inst.getRight();
		} 
		else if (inst instanceof ReturnNode) {
			str += "\t ReturnNode \n";
		} 
		else if (inst instanceof Succ) {
			str += "\t Succ \n";
			str += new SyntaxTreeGenerator().treeTranslator(inst.getLeft());
			if (new SyntaxTreeGenerator().treeTranslator(inst.getRight()) != null)
			str += " \n---------- " + new SyntaxTreeGenerator().treeTranslator(inst.getRight());
		} 
		else if (inst instanceof While) {
			str += "\t While \n";
			str += "\n****code " + inst.getLeft() + " = " + inst.getRight();
		} 
		else if (inst instanceof Instruction)
		{
			str += "\t inst \n";
			str += leftRightTest(inst.getLeft());
		}
		else
		{
			str += "INST NO FOUND !";
			str += inst.getType() + "\n";
			str += "\n" +inst.toString();
			str += " \nnoFOund" + leftRightTest(inst);
		}
	}

	public String leftRightTest(SyntaxTree st) throws IOException
	{
		String result = "";
		if(st == null)
			return result;
		
		if (st.getLeft() != null)
		{
			result += " \n " + new SyntaxTreeGenerator().treeTranslator(st.getLeft());

		}
		if (st.getRight() != null)
		{
			result += " \n " +new SyntaxTreeGenerator().treeTranslator(st.getRight());

		}
		
		return result;
	}
	
	
	public String generate() {
		return str;
	}
}
