package lea.types;

import lea.constants.*;

public class IntType extends Type 
{
	public IntType()
	{
		type = EnumType.INT;
	}

	@Override
	public boolean equals(Type t1) 
	{
		return t1 instanceof IntType || t1 instanceof FloatType;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return c1 instanceof IntConstant || c1 instanceof FloatConstant;
	}
}
