package lea.syntax;

public class FunctionCall extends Expression 
{
	public FunctionCall(FunctionRef a1,Expression a2)
	{
		super(a1,a2);
	}
	
	public String toString()
	{
		return "Call"+super.toString();
	}
}
