package lea.types;

import lea.constants.*;

public class StructType extends Type 
{
	public StructType(Type t)
	{
		this.left = t;
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
}
