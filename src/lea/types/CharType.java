package lea.types;

import lea.constants.*;

public class CharType extends Type 
{
	public CharType()
	{
		type = EnumType.CHAR;
	}

	@Override
	public boolean equals(Type t1) 
	{
		return t1 instanceof CharType;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return c1 instanceof CharConstant;
	}
}
