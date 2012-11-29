package lea.types;

import lea.constants.*;

public class ListType extends Type 
{	
	public ListType(int length)
	{
		type = EnumType.ARRAY;
	}

	@Override
	public boolean equals(Type t1) 
	{
		if(t1 instanceof ListType)
		{
			return aux_equals(t1, this);
		}
		
		return false;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return c1 instanceof ListConstant && equals(((ListConstant)c1).getListType());
	}
}
