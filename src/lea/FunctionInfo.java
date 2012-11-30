package lea;

import java.util.*;

import lea.types.*;
import lea.syntax.*;

public class FunctionInfo 
{
	private LinkedList<ArgumentInfo> args;
	private Type outputType;
	private SyntaxTree sTree;
	
	public FunctionInfo()
	{
		this(new LinkedList<ArgumentInfo>(), null, null);
	}
	
	public FunctionInfo(LinkedList<ArgumentInfo> lArgs, Type outputT, SyntaxTree s)
	{
		args = lArgs;
		outputType = outputT;
		sTree = s;
	}
	
	public String toString()
	{
		String str = "(" + args.toString() + ")";
		if(outputType != null)
			str += " : "  + outputType.toString();
		
		str += " { " + sTree.toString() + " } ";
		
		return str;
	}
	
	public void pushArg(String name, Type t)
	{
		args.add(new ArgumentInfo(name, t));
	}
	
	public void setOutputType(Type t)
	{
		outputType = t;
	}
	
	public void setSyntaxTree(SyntaxTree s)
	{
		sTree = s;
	}
	
	public LinkedList<ArgumentInfo> getArgs()
	{
		return args;
	}
	
	public Type getOutputType()
	{
		return outputType;
	}
	
	public SyntaxTree getSyntaxTree()
	{
		return sTree;
	}
}
