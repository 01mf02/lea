package lea.constants;

import java.lang.reflect.Array;
import lea.types.*;

public class TupleConstant implements Constant 
{
	Array value = null;
	TupleType tupleType;
	
	public TupleConstant(Array v, TupleType t)
	{
		value = v;
		tupleType = t;
	}
    
    public Type getType()
    {
    	return tupleType;
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
