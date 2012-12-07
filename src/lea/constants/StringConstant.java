package lea.constants;

import lea.types.*;

public class StringConstant implements Constant 
{
	String _value = "";
	Type t;
	
	public StringConstant(String value)
	{
		_value = value;
		t = new StringType();
	}
    
    public Type getType()
    {
    	return t;
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
