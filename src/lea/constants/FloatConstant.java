package lea.constants;

import lea.types.EnumType;

public class FloatConstant implements Constant 
{
	float _value = 0;
	
	public FloatConstant(float value)
	{
		_value = value;
	}
    
    public EnumType getType()
    {
    	return EnumType.FLOAT;
    }
    
    public float getValue()
    {
    	return _value;
    }
}