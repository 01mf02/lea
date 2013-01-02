package lea.syntax;

import lea.generator.CodeWriter;

public class ElseCondition extends Instruction {
	private Instruction if_instruction = null;
	private Instruction else_instruction = null;

	public ElseCondition(Instruction a1, Instruction a2) {
		super(a1, a2);
		if_instruction = a1;
		else_instruction = a2;
	}

	public String toString() {
		return "Else" + super.toString();
	}

	public String toDotString() {
		return "Else";
	}

	public void toJava(CodeWriter w) {
		if_instruction.toJava(w);
		// block was opened before by "if"
		w.closeBlock();

		w.writeLine("else");
		w.openBlock();
		else_instruction.toJava(w);
		// block doesn't need to be closed, "if" cares about that
	}
}
