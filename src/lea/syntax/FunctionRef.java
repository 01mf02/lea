package lea.syntax;

import lea.*;
import lea.types.*;

public class FunctionRef extends Expression 
{
	private String name;
	private FunctionInfo info;
	private NativeFunctionInfo nfi;
	
	public FunctionRef(String n, FunctionInfo fi)
	{
		name = n;
		info = fi;
	}
	
	public FunctionRef(String n, NativeFunctionInfo fi)
	{
		name = n;
		nfi = fi;
	}
	public String getName()
	{
		return name;
	}
	
	public FunctionInfo getFunctionInfo()
	{
		return info;
	}
	
	public NativeFunctionInfo getNativeFunctionInfo()
	{
		return nfi;
	}
	
	public Type getType()
	{
		if(info != null)
			return info.getOutputType();
		else
			return nfi.getOutputType();
	}
	
	public String toString()
	{
		if(info != null)
			return "FunctionRef("+name+", " + info.toString()+")";
		else
			return "FunctionRef("+name+", " + nfi.toString()+")";
	}
}
