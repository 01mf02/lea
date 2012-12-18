package lea.constants;

import java.text.*;

import lea.types.*;

public class FloatConstant implements Constant 
{
	float value = 0;
	Type t;
	
	public FloatConstant(String v)
	{
		value = Float.parseFloat(v);
		t = new FloatType();
	}
    
    public Type getType()
    {
    	return t;
    }
    
    public float getValue()
    {
    	return value;
    }
    
    public String toString()
    {
	    DecimalFormat decimalFormat = (DecimalFormat)DecimalFormat.getInstance();
	    decimalFormat.applyPattern("# ##0.00###########");
	    
	    return decimalFormat.format(value);
    }
    
    public String toJava() {
		return toString();
	}
}