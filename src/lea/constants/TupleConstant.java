package lea.constants;

import java.lang.reflect.Array;

import lea.types.EnumType;
import lea.types.*;

public class TupleConstant implements Constant 
{
	Array _value = null;
	TupleType tupleType;
	
	public TupleConstant(Array value, TupleType t)
	{
		_value = value;
		tupleType = t;
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
    
    public TupleType getTupleType()
    {
    	return tupleType;
    }
}
