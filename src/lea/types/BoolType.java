package lea.types;

import lea.constants.*;

public class BoolType extends Type 
{
	public BoolType()
	{
		type = EnumType.BOOLEAN;
	}

	@Override
	public boolean equals(Type t1) 
	{
		return t1 instanceof BoolType;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return c1 instanceof BoolConstant;
	}
}
