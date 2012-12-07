package lea.constants;

import lea.types.*;

public class IntConstant implements Constant 
{
	int _value = 0;
	Type t;
	
	public IntConstant(String value)
	{
		_value = Integer.parseInt(value);
		t = new IntType();
	}
    
    public Type getType()
    {
    	return t;
    }
    
    public int getValue()
    {
    	return _value;
    }
    
    public String toString()
    {
    	return Integer.toString(_value);
    }
}