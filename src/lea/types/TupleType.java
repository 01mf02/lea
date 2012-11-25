package lea.types;

public class TupleType extends Type 
{
	public TupleType(Type t1, Type t2)
	{
		this.left = t1;
		this.right = t2;
		
		type = EnumType.TUPLE;
	}
}
