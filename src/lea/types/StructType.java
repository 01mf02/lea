package lea.types;

import lea.constants.*;
import lea.Environment;

public class StructType extends Type 
{
	public Environment env;
	private String name;
	
	public StructType(String s)
	{
		name = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Environment getEnvironment()
	{
		return env;
	}
	
	public void setEnvironment(Environment e)
	{
		env = e;
	}
	
	@Override
	public boolean equals(Type t1) 
	{
		if(t1 instanceof StructType)
		{
			return aux_equals(t1, this);
		}
		
		return false;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return false;
	}
	
	public String toString()
	{
		return "struct";
	}
}
