package lea.types;

public class ComplexType extends Type 
{
	public ComplexType(Type t1, Type t2)
	{
		this.left = t1;
		this.right = t2;
		
		type = EnumType.COMPLEX;
	}
}
