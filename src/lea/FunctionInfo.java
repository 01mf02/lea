package lea;

import java.util.*;
import lea.types.*;
import lea.syntax.*;

public class FunctionInfo 
{
	private Map<String, Type> args;
	private Type outputType;
	private SyntaxTree sTree;
	
	public FunctionInfo()
	{
		args = new TreeMap<String, Type>();
		outputType = null;
		sTree = null;
	}
	
	public String toString()
	{
		String str = "(" + args.toString() + ") : " + outputType.toString();
		str += " { " + sTree.toString() + " } ";
		
		return str;
	}
	
	public void pushArg(String name, Type t)
	{
		args.put(name, t);
	}
	
	public void setOutputType(Type t)
	{
		outputType = t;
	}
	
	public void setSyntaxTree(SyntaxTree s)
	{
		sTree = s;
	}
	
	public Map<String, Type> getArgs()
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
