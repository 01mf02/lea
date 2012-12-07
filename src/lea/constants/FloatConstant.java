package lea.constants;

import java.text.*;

import lea.types.*;

public class FloatConstant implements Constant 
{
	float _value = 0;
	Type t;
	
	public FloatConstant(String value)
	{
		_value = Float.parseFloat(value);
		t = new FloatType();
	}
    
    public Type getType()
    {
    	return t;
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