package lea.syntax;

public class While extends Instruction 
{
	public While(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
	}
	
	public String toString()
	{
		return "While"+super.toString();
	}
	
	public String toDotString()
	{
		return "While";
	}
	
	public String toJava()
	{
		return "while";
	}
}
