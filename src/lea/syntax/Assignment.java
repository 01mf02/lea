package lea.syntax;

import lea.generator.CodeWriter;
import lea.generator.Generator;

public class Assignment extends Instruction {
	Expression left, right;

	public Assignment(Expression a1, Expression a2) {
		super(a1, a2);
		left = a1;
		right = a2;
	}

	public String toString() {
		return "Assign" + super.toString();
	}

	public void toJava(CodeWriter w) {
		// variable assignment
		if (right != null)
			w.writeLine(left.toJava() + " = " + right.toJava() + ";");
		// variable declaration
		else
			w.writeLine(Generator.generateDeclaration(left.toJava(),
					left.getType()));

	}

	public String toDotString() {
		return "Assign";
	}
}
