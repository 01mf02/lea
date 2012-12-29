package lea.constants;
import lea.types.*;

public class BoolConstant implements Constant 
{
	boolean value = false;
	Type t;
	
	public BoolConstant(String v)
	{
		value = Boolean.parseBoolean(v);
		t = new BoolType();
	}
    
    public Type getType()
    {
    	return t;
    }
    
    public boolean getValue()
    {
    	return value;
    }
    
    public String toString()
    {
    	if (value)
    		return "TRUE";
    	else
    		return "FALSE";
    }
    
    public String toJava()
    {
    	if (value)
    		return "true";
    	else
    		return "false";
    }
}
