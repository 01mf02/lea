package lea.syntax;
import lea.types.*;

public class BoolExp extends Expression 
{
	Expression bool_left, bool_right;
	
	protected BoolExp()
	{
		
	}
	
	public BoolExp(Expression a1, Expression a2, EnumTagExp tag)
	{
		super(a1, a2);
		expTag = tag;
	}
	
	public String toString()
	{
		return "BooleanExp("+expTag.toString()+")"+super.toString();
	}
	
	public String toJava()
	{
		return bool_left.toJava() + " " + expTag.toString() + " " + bool_right.toJava();
	}
	
	public Type getType()
	{
		return new BoolType();
	}
	
	public String toDotString()
	{
		return "BooleanExp("+expTag.toString()+")";
	}

	public EnumTagExp getTag()
	{
		return expTag;
	}
}
