package lea.constants;

import lea.types.*;

public class CharConstant implements Constant 
{
	char _value = ' ';
	Type t;
	
	public CharConstant(String value)
	{
		_value = value.charAt(0);
		t = new CharType();
	}
    
    public Type getType()
    {
    	return t;
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
