package lea.syntax;

public class BoolExp extends Expression 
{
	protected BoolExp()
	{
		
	}
	
	public BoolExp(SyntaxTree a1, SyntaxTree a2, EnumTagExp tag)
	{
		super(a1, a2);
		expTag = tag;
	}
}
