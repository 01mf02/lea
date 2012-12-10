package lea.types;

import lea.constants.*;

public class IntType extends Type 
{
	@Override
	public boolean equals(Type t1) 
	{
		return t1 instanceof IntType;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return c1 instanceof IntConstant;
	}
	
	public String toString()
	{
		return "int";
	}
}
