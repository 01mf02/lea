package lea.syntax;

public class ElseCondition extends SyntaxTree 
{
	public ElseCondition(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
	}
	
	public String toString()
	{
		return "Else"+super.toString();
	}
}
