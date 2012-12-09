package lea.syntax;

public class ReturnNode extends Instruction 
{
	public ReturnNode(Expression a1)
	{
		super(a1, null);
	}
	
	public String toString()
	{
		return "Return"+super.toString();
	}
}
