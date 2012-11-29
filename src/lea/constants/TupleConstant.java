package lea.constants;

import java.lang.reflect.Array;

import lea.types.EnumType;

public class TupleConstant implements Constant 
{
	Array _value = null;
	
	public TupleConstant(Array value)
	{
		_value = value;
	}
    
    public EnumType getType()
    {
    	return EnumType.ARRAY;
    }
    
    public Array getValue()
    {
    	return _value;
    }
    
    public String toString()
    {
    	return _value.toString();
    }
}
