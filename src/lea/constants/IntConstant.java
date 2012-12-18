package lea.constants;

import lea.types.*;

public class IntConstant implements Constant 
{
	int value = 0;
	Type t;
	
	public IntConstant(String v)
	{
		value = Integer.parseInt(v);
		t = new IntType();
	}
    
    public Type getType()
    {
    	return t;
    }
    
    public int getValue()
    {
    	return value;
    }
    
    public String toString()
    {
    	return Integer.toString(value);
    }
    
    public String toJava() {
		return toString();
	}
}