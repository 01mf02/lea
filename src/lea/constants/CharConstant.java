package lea.constants;

import lea.types.EnumType;

public class CharConstant implements Constant 
{
	char _value = ' ';
	
	public CharConstant(char value)
	{
		_value = value;
	}
    
    public EnumType getType()
    {
    	return EnumType.CHAR;
    }
    
    public char getValue()
    {
    	return _value;
    }
}
