package lea.types;

import lea.constants.*;

public class TupleType extends Type 
{
	public TupleType(Type t1, Type t2)
	{
		this.left = t1;
		this.right = t2;
	}

	@Override
	public boolean equals(Type t1) {
		if(t1 instanceof TupleType)
		{
			return aux_equals(t1, this);
		}
		
		return false;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return c1 instanceof TupleConstant && equals(c1.getType());
	}
	
	public String toString()
	{
		return "tuple";
	}
}
