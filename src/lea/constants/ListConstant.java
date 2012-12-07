package lea.constants;

import java.lang.reflect.Array;

import lea.types.*;
import lea.types.ListType;

public class ListConstant implements Constant 
{
	Array _value = null;
	ListType listType;
	
	public ListConstant(Array value, ListType t)
	{
		_value = value;
		listType = t;
	}
    
    public Type getType()
    {
    	return listType;
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
