package lea.constants;
import lea.types.*;

public class BoolConstant implements Constant 
{
	boolean _value = false;
	
	public BoolConstant(boolean value)
	{
		_value = value;
	}
    
    public EnumType getType()
    {
    	return EnumType.BOOLEAN;
    }
    
    public boolean getValue()
    {
    	return _value;
    }
}
