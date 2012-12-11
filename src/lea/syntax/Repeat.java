package lea.syntax;

public class Repeat extends Instruction 
{
	public Repeat(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
	}
	
	public String toString()
	{
		return "Repeat"+super.toString();
	}
	
	public String toDotString()
	{
		return "Repeat";
	}
}
