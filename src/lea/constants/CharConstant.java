package lea.constants;

import lea.types.EnumType;

public class CharConstant implements Constant 
{
	char _value = ' ';
	
	public CharConstant(String value)
	{
		_value = value.charAt(0);
	}
    
    public EnumType getType()
    {
    	return EnumType.CHAR;
    }
    
    public char getValue()
    {
    	return _value;
    }
    
    public String toString()
    {
    	return Character.toString(_value);
    }
}
