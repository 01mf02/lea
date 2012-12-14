package lea.constants;

import lea.types.*;

public class EnumConstant implements Constant 
{
	String value = "";
	String name = "";
	Type t;
	
	public EnumConstant(String v, String n)
	{
		value = v;
		name = n;
		t = new EnumType();
	}
    
    public Type getType()
    {
    	return t;
    }
    
    public String getValue()
    {
    	return value;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public String toString()
    {
    	return getValue();
    }
}
