package lea;

import java.util.*;

import lea.types.*;

public class NativeFunctionInfo
{
	private LinkedList<ArgumentInfo> args;
	private Type outputType;
	private LinkedList<Type> accessibleFrom;
	
	public NativeFunctionInfo()
	{
		this(new LinkedList<ArgumentInfo>(), null, new LinkedList<Type>());
	}
	
	public NativeFunctionInfo(LinkedList<ArgumentInfo> lArgs, Type outputT, LinkedList<Type>accessible)
	{
		args = lArgs;
		outputType = outputT;
		accessibleFrom = accessible;
	}
	
	public boolean containsAccessibleFrom(Type t)
	{		
		if(t == null)
		{
			return accessibleFrom.isEmpty();
		}
		else
		{
			for(int i = 0; i < accessibleFrom.size(); i++)
			{
				if(accessibleFrom.get(i).toString() == t.toString())
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String toString()
	{
		String str = "(" + args.toString() + ")";
		if(outputType != null)
			str += " : "  + outputType.toString();
		
		str += "from : [ " + accessibleFrom.toString() + " ] ";
		
		return str;
	}
	
	public void pushArg(String name, Type t)
	{
		args.add(new ArgumentInfo(name, t));
	}
	
	public void pushType(Type t)
	{
		accessibleFrom.add(t);
	}
	
	public void setOutputType(Type t)
	{
		outputType = t;
	}
	
	public LinkedList<ArgumentInfo> getArgs()
	{
		return args;
	}
	
	public Type getOutputType()
	{
		return outputType;
	}
	
	public LinkedList<Type> getAccessibleFrom()
	{
		return accessibleFrom;
	}
}
