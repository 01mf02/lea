package lea.generator;

import java.io.IOException;
import java.util.Map.Entry;

import lea.Environment;
import lea.FunctionInfo;
import lea.FunctionTable;
import lea.syntax.*;

public class SyntaxTreeGenerator {

	SyntaxTree node;
	Environment env;
	FileWriterT fwt;
	String str;

	public SyntaxTreeGenerator(FunctionTable fctTable) throws IOException {

		this.fwt = new FileWriterT();

		for (Entry<String, FunctionInfo> entry : fctTable.entrySet()) {
			str += "\n\n\n\n*********************************************************************\n"
					+ entry.getKey() + "\n\n\n"; // Nom de la fonction
			node = entry.getValue().getSyntaxTree();
			// str += node.toString();

			str += treeTranslator(node);
		}
		fwt.generate(str);

	}

	public String treeTranslator(SyntaxTree st) throws IOException {
		// str += node.toString();

		String result = new String();
		
		result += "(";
		
		if (st == null)
			return "end";
		
		if (st instanceof Assignment)
			result += "\t lAssignment \n";
		else if (st instanceof BoolExp)
			result += "\t lBoolExp \n" + st.toString();
		else if (st instanceof Condition)
			result += "\t lCondition \n";
		else if (st instanceof ConstantLeaf)
			result += "\t lConstantLeaf \n";
		else if (st instanceof ElseCondition)
			result += "\t lElseCondition \n";
		else if (st instanceof Expression)
			result += "\t lExpression " + st.getType() + "\n";
		else if (st instanceof FunctionCall)
			result += "\t lFunctionCall \n";
		else if (st instanceof FunctionRef)
			result += "\t lFunctionRef \n";
		else if (st instanceof ListAccessor)
			result += "\t lListAccessor \n";
		else if (st instanceof ListNode)
			result += "\t lListNode \n";
		else if (st instanceof Loop)
			result += "\t lLoop \n";
		else if (st instanceof NumberExp)
			result += "\t lNumberExp \n";
		else if (st instanceof Repeat)
			result += "\t lRepeat \n";
		else if (st instanceof ReturnNode)
			result += "\t lRepeat \n";
		else if (st instanceof StructAccessor)
			result += "\t lStructAccessor \n";
		else if (st instanceof Succ) 
		{
			result += "\t lSucc \n";
			result += "left" + treeTranslator(st.getLeft());
			result += "right" +treeTranslator(st.getRight());
		}
			
		else if (st instanceof SyntaxTree)
			result += "\t lSyntaxTree \n";
		else if (st instanceof TupleNode)
			result += "\t lTupleNode \n";
		else if (st instanceof VariableLeaf)
			result += "\t lVariableLeaf \n";
		else if (st instanceof While)
			result += "\t lWhile \n";
		else
			result += "lUNKNOWN";

		result += ")";

		return result;
		

	}

}
