package lea.syntax;

public class Case extends Instruction 
{
	
	public Case(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
	}
	
	
	public String toString()
	{
		return "Case"+super.toString();
	}
	
	public String toDotString()
	{
		return "Case";
	}
	
	public String toJava()
	{
		return "switch";
	}
}
