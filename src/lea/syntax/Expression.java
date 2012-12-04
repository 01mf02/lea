package lea.syntax;

public class Expression extends SyntaxTree 
{
	protected EnumTagExp expTag;
	
	protected Expression()
	{
		
	}
	
	public Expression(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
	}
	
	public EnumTagExp getTag()
	{
		return expTag;
	}
}
