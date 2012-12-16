package lea.syntax;

public class StringExp extends Expression 
{
	protected StringExp()
	{
		
	}
	
	public StringExp(Expression a1, Expression a2, EnumTagExp tag)
	{
		super(a1, a2);
		expTag = tag;
	}
	
	public String toString()
	{
		return "StringExp("+expTag.toString()+")"+super.toString();
	}
	
	public String toDotString()
	{
		return "StringExp("+expTag.toString()+")";
	}
}
