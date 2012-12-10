package lea.syntax;

import lea.types.*;

public class VariableLeaf extends Expression 
{
	private String name;
	private Type objectType;
	
	public VariableLeaf(String s, Type t)
	{
		name = s;
		
		if(t != null)
			objectType = t;
		else
			objectType = new UnknownType();
	}
	
	public String getName()
	{
		return name;
	}
	
	public Type getType()
	{
		return objectType.getType();
	}
	
	public String toString()
	{
		return "Variable("+name+":"+objectType.toString()+")";
	}
	
	public String toDotString()
	{
		return this.toString();
	}
}
