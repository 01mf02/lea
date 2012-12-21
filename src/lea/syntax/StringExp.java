package lea.syntax;

public class StringExp extends Expression 
{
	Expression left, right;
	protected StringExp()
	{
		
	}
	
	public StringExp(Expression a1, Expression a2, EnumTagExp tag)
	{
		super(a1, a2);
		expTag = tag;
		left = a1;
		right = a2;
	}
	
	public String toString()
	{
		return "StringExp("+expTag.toString()+")"+super.toString();
	}
	
	public String toDotString()
	{
		return "StringExp("+expTag.toString()+")";
	}
	
	public String toJava()
	{
		return left.toJava() + " " + expTag + " " + right.toJava();
	}
}
