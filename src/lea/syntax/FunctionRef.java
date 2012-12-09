package lea.syntax;

import lea.FunctionInfo;
import lea.types.*;

public class FunctionRef extends Expression 
{
	private String name;
	private FunctionInfo info;
	
	public FunctionRef(String n, FunctionInfo fi)
	{
		name = n;
		info = fi;
	}
	
	public String getName()
	{
		return name;
	}
	
	public FunctionInfo getFunctionInfo()
	{
		return info;
	}
	
	public Type getType()
	{
		return info.getOutputType();
	}
	
	public String toString()
	{
		return "FunctionRef("+name+", " + info.toString()+")";
	}
}
