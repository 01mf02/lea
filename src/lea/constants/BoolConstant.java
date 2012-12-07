package lea.constants;
import lea.types.*;

public class BoolConstant implements Constant 
{
	boolean _value = false;
	Type t;
	
	public BoolConstant(String value)
	{
		_value = Boolean.parseBoolean(value);
		t = new BoolType();
	}
    
    public Type getType()
    {
    	return t;
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
