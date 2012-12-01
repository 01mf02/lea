package lea.syntax;

import lea.types.Type;

public class VariableLeaf extends Expression 
{
	private String name;
	private Type objectType;
	
	public VariableLeaf(String s, Type t)
	{
		name = s;
		objectType = t;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Type getType()
	{
		return objectType;
	}
	
	public String toString()
	{
		return "Variable("+name+":"+objectType.toString()+")";
	}
}
