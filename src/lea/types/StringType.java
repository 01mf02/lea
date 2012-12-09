package lea.types;

import lea.constants.*;

public class StringType extends Type 
{
	public StringType()
	{
		type = EnumType.STRING;
	}

	@Override
	public boolean equals(Type t1) 
	{
		return t1 instanceof StringType;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return c1 instanceof StringConstant;
	}
	
	public String toString()
	{
		return "string";
	}
}
