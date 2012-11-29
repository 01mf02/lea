package lea.types;

import lea.constants.*;

public class FloatType extends Type 
{
	public FloatType()
	{
		type = EnumType.FLOAT;
	}

	@Override
	public boolean equals(Type t1) 
	{
		return t1 instanceof FloatType;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return c1 instanceof FloatConstant;
	}
}
