package lea.constants;
import lea.types.*;

public class BoolConstant implements Constant 
{
	boolean _value = false;
	
	public BoolConstant(String value)
	{
		_value = Boolean.parseBoolean(value);
	}
    
    public EnumType getType()
    {
    	return EnumType.BOOLEAN;
    }
    
    public boolean getValue()
    {
    	return _value;
    }
    
    public String toString()
    {
    	if(_value)
    		return "TRUE";
    	else
    		return "FALSE";
    }
}
