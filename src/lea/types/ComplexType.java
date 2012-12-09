package lea.types;

import lea.constants.*;

public class ComplexType extends Type 
{
	public ComplexType(Type t1, Type t2)
	{
		this.left = t1;
		this.right = t2;
		
		type = EnumType.COMPLEX;
	}

	@Override
	public boolean equals(Type t1) 
	{
		if(t1 instanceof ComplexType)
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
		return "complex";
	}
}
