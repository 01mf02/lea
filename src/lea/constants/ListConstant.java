package lea.constants;

import java.lang.reflect.Array;

import lea.types.*;
import lea.types.ListType;

public class ListConstant implements Constant 
{
	Array value = null;
	ListType listType;
	
	public ListConstant(Array v, ListType t)
	{
		value = v;
		listType = t;
	}
    
    public Type getType()
    {
    	return listType;
    }
    
    public Array getValue()
    {
    	return value;
    }
    
    public String toString()
    {
    	return value.toString();
    }
}
