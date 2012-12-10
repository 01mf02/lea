package lea.syntax;

public class Succ extends Instruction 
{
	public Succ(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
	}
	
	public String toString()
	{
		return "Succ"+super.toString();
	}
	
	public String toDotString()
	{
		return "Succ";
	}
}
