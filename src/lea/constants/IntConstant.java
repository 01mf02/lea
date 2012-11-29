package lea.constants;

import lea.types.EnumType;

public class IntConstant implements Constant 
{
	int _value = 0;
	
	public IntConstant(int value)
	{
		_value = value;
	}
    
    public EnumType getType()
    {
    	return EnumType.INT;
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