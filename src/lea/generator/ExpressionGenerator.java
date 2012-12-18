package lea.generator;

import java.io.IOException;

import lea.syntax.*;

public class ExpressionGenerator extends SyntaxTreeGenerator{

	String str;

	public ExpressionGenerator(Expression exp) throws IOException {
		str += "";
		
		if (exp instanceof BoolExp)
		{
			//str += "\nBoolExp \n";
			str += "\n(";

			str += leftRightTest(exp.getLeft()) ;
			str += exp.getTag();
			if(exp.getRight() != null)
				str += leftRightTest(exp.getRight()) ;
		}
		else if (exp instanceof ConstantLeaf)
		{
			//str += "\nConstantLeaf \n";
			str += ((ConstantLeaf)exp).getValue();
		}
		else if (exp instanceof FunctionCall)
		{
			str += "\nFunctionCall \n";
			str += leftRightTest(exp.getLeft());
			if(exp.getRight() != null)
				str += leftRightTest(exp.getRight());
		}
		else if (exp instanceof FunctionRef)
		{
			str += "\nFunctionRef \n";
			//str += ((FunctionRef) exp).getName() + "( " + ((FunctionRef) exp).getFunctionInfo();
			str += "\n" + this.nativeFUnctionTable(((FunctionRef) exp).getName()) + " " + exp.getLeft();
		}
		else if (exp instanceof ListAccessor)
		{
			str += "\nListAccessor \n";
			str += ((ListAccessor)exp).getTag();
		}
		else if (exp instanceof ListNode)
		{
			str += "\nListNode \n";
			str += leftRightTest(exp.getLeft());
			if(exp.getRight() != null)
				str += leftRightTest(exp.getRight());
		}
		else if (exp instanceof NumberExp)
		{
			str += "\nNumberExp \n";
			str += leftRightTest(exp.getLeft());
			if(exp.getRight() != null)
				str += leftRightTest(exp.getRight());
		}
		else if (exp instanceof StructAccessor)
		{
			str += "\nStructAcessor \n";
		}
		else if (exp instanceof TypeExp)
		{
			str += "\nTypeExp \n";
			str += leftRightTest(exp.getLeft());
			str += leftRightTest(exp.getRight());
		}
		else if (exp instanceof TupleNode)
		{
			str += "\nTupleNode \n";
		}
		else if (exp instanceof StringExp)
		{
			str += "\nStringExp \n";
			str += leftRightTest(exp.getLeft());
			if(exp.getRight() != null)
				str += leftRightTest(exp.getRight());
		}
		else str =  "Exp Unknown";
	}
	
	public String leftRightTest(SyntaxTree st) throws IOException
	{
		String result = "";
		
		if (st != null)
		{
			if (st instanceof VariableLeaf)
				result += ((VariableLeaf)st).getName();
			else
				result += new SyntaxTreeGenerator().treeTranslator(st);
		}
		
		return result;
	}
	
	public String nativeFUnctionTable(String name)
	{
		String result ="";

		if (name.equals("write"))
		{
			result += "System.out.print(";
		}
		else if (name.equals("writeln"))
		{
			result += "System.out.println(";
		}
		else if (name.equals("toString"))
		{
			result += "toString();";
		}
		else
		{
			result += "\n NO FOUNDDD !";
		}
		return result;
	
		
		
	}
	
	public String generate() {

		return str;
	}
}
