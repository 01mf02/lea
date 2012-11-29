package lea.constants;

import lea.types.EnumType;

public class StringConstant implements Constant 
{
	String _value = "";
	
	public StringConstant(String value)
	{
		_value = value;
	}
    
    public EnumType getType()
    {
    	return EnumType.STRING;
    }
    
    public String getValue()
    {
    	return _value;
    }
    
    public String toString()
    {
    	return getValue();
    }
}
