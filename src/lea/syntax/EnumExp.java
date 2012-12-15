package lea.syntax;
import lea.types.*;

public class EnumExp extends SyntaxTree 
{
	protected String enumValue;
	
	protected EnumExp()
	{
		
	}
	
	public EnumExp(String value,Instruction a1, EnumExp a2)
	{
		super(a1, a2);
		enumValue = value;
	}
	
	public String getString()
	{
		return enumValue;
	}
	
	public Type getType()
	{
		return this.getLeft().getType();		
	}
	
	public String toString()
	{
		return "EnumExp"+super.toString();
	}
	
	public String toDotString()
	{
		return "EnumExp";
	}
}
