package lea.syntax;
import lea.constants.*;
import lea.types.*;

public class ConstantLeaf extends Expression 
{
	private Constant constValue;
	private Type constType;
	
	public ConstantLeaf(Constant c, Type t)
	{
		constValue = c;
		constType = t;
	}
	
	public String getValue()
	{
		return constValue.toString();
	}
	
	public Type getType()
	{
		return constType;
	}
	
	public String toString()
	{
		return "CONST("+constValue.toString() + ":" + constType.toString()+")";
	}
}
