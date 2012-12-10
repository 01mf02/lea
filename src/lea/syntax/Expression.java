package lea.syntax;
import lea.types.*;

public class Expression extends SyntaxTree 
{
	protected EnumTagExp expTag;
	
	protected Expression()
	{
		
	}
	
	public Expression(Expression a1, Expression a2)
	{
		super(a1, a2);
	}
	
	public EnumTagExp getTag()
	{
		return expTag;
	}
	
	public Type getType()
	{
		return this.getLeft().getType();		
	}
	
	public String toString()
	{
		return "Expression"+super.toString();
	}
	
	public String toDotString()
	{
		return "Expression";
	}
}
