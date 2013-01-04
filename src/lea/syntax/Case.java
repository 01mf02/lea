package lea.syntax;

import lea.generator.CodeWriter;

public class Case extends Instruction {
	protected Expression left;
	protected EnumExp right;

	public Case(Expression a1, EnumExp a2) {
		super(a1, a2);
		left = a1;
		right = a2;
	}

	public String toString() {
		return "Case" + super.toString();
	}

	public String toDotString() {
		return "Case";
	}

	public void toJava(CodeWriter cw) {
		cw.writeLine("switch (" + left.toJava() + ")");
		cw.openBlock();

		EnumExp inst1 = right;

		while (inst1 != null) {
			cw.writeLine("case " + inst1.toJava());
			cw.openBlock();
			inst1.instTranslator(cw);
			cw.writeLine("break;");
			cw.closeBlock();

			if (inst1.getRight() != null)
				inst1 = (EnumExp) inst1.getRight();
			else
				break;
		}

		cw.closeBlock();
		cw.writeLine("");

	}
}
