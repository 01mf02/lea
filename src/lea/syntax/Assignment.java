package lea.syntax;

import lea.generator.CodeWriter;

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
		else {
			String decl = left.getType().toJava() + " " + left.toJava();
			if (left.getType().requiresInitialisation())
				decl += " = new " + left.getType().toJava() + "()";

			w.writeLine(decl + ";");
		}
	}

	public String toDotString() {
		return "Assign";
	}
}
