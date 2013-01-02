package lea.syntax;

import lea.generator.CodeWriter;
import lea.types.Type;

public class EnumExp extends SyntaxTree {
	protected String enumValue;
	protected Instruction inst;
	protected EnumExp enumExp;

	protected EnumExp() {

	}

	public EnumExp(String value, Instruction a1, EnumExp a2) {
		super(a1, a2);
		enumValue = value;
		inst = a1;
		enumExp = a2;
	}

	public String getString() {
		return enumValue;
	}

	public Type getType() {
		return this.getLeft().getType();
	}

	public String toString() {
		return "EnumExp" + super.toString();
	}

	public String toDotString() {
		return "EnumExp";
	}

	public EnumExp getNext() {
		if (enumExp.getLeft() != null)
			return enumExp;
		else
			return null;
	}

	public void instTranslator(CodeWriter cw) {
		inst.toJava(cw);
	}

	public String toJava() {
		String result = "";

		result += enumValue + " : ";

		return result;
	}
}
