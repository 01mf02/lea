package lea.constants;

import java.text.*;

import lea.types.EnumType;

public class FloatConstant implements Constant 
{
	float _value = 0;
	
	public FloatConstant(String value)
	{
		_value = Float.parseFloat(value);
	}
    
    public EnumType getType()
    {
    	return EnumType.FLOAT;
    }
    
    public float getValue()
    {
    	return _value;
    }
    
    public String toString()
    {
	    DecimalFormat decimalFormat = (DecimalFormat)DecimalFormat.getInstance();
	    decimalFormat.applyPattern("# ##0.00###########");
	    
	    return decimalFormat.format(_value);
    }
}