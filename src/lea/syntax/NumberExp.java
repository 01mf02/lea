package lea.syntax;

public class NumberExp extends Expression 
{
	protected NumberExp()
	{
		
	}
	
	public NumberExp(SyntaxTree a1, SyntaxTree a2, EnumTagExp tag)
	{
		super(a1, a2);
		expTag = tag;
	}
}
