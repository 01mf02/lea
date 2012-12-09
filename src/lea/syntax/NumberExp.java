package lea.syntax;

public class NumberExp extends Expression 
{
	protected NumberExp()
	{
		
	}
	
	public NumberExp(Expression a1, Expression a2, EnumTagExp tag)
	{
		super(a1, a2);
		expTag = tag;
	}
	
	public String toString()
	{
		return "NumberExp("+expTag.toString()+")"+super.toString();
	}
}
