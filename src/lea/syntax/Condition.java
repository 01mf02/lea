package lea.syntax;

public class Condition extends Instruction 
{
	public Condition(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
	}
	
	public String toString()
	{
		return "If"+super.toString();
	}
	
	public String toDotString()
	{
		return "If";
	}
}
