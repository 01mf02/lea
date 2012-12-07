package lea.syntax;
import lea.constants.*;
import lea.types.*;

public class ConstantLeaf extends Expression 
{
	private Constant constValue;
	
	public ConstantLeaf(Constant c)
	{
		constValue = c;
	}
	
	public String getValue()
	{
		return constValue.toString();
	}
	
	public Type getType()
	{
		return constValue.getType();
	}
	
	public String toString()
	{
		return "CONST("+constValue.toString() + ":" + constValue.getType().toString()+")";
	}
}
