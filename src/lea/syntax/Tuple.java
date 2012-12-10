package lea.syntax;

public class Tuple extends SyntaxTree 
{
	public Tuple(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
	}
	
	public String toString()
	{
		return "Tuple"+super.toString();
	}
	
	public String toDotString()
	{
		return "Tuple";
	}
}
