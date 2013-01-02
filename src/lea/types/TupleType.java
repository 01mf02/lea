package lea.types;

import lea.constants.*;

public class TupleType extends Type {
	public TupleType(Type t1, Type t2) {
		left = t1;
		right = t2;
	}

	public TupleType() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Type t1) {
		if (t1 instanceof TupleType) {
			return aux_equals(t1, this);
		}

		return false;
	}

	@Override
	public boolean equals(Constant c1) {
		return c1 instanceof TupleConstant && equals(c1.getType());
	}

	public String getAllType() {
		String str = "tuple(";
		if (this.getLeft() != null)
			str += this.getLeft().getType().toString();
		if (this.getRight() != null)
			str += ", " + this.getRight().getType().toString();

		return str + ")";
	}

	public String toString() {

		/*String str = "tuple(";
		if (this.getLeft() != null)
			str += this.getLeft().getType().toString();
		if (this.getRight() != null)
			str += ", " + this.getRight().getType().toString();

		return str + ")";*/
		return "tuple";
	}

	public String nameGen()
	{
		return "";
	}
	
	public String toJava() {
		String result ="";
		
		result += new TupleConstant(left, right);

		return result;
	}
}
