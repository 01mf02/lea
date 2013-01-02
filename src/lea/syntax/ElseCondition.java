package lea.syntax;

public class ElseCondition extends Instruction {
	public ElseCondition(SyntaxTree a1, SyntaxTree a2) {
		super(a1, a2);
	}

	public String toString() {
		return "Else" + super.toString();
	}

	public String toDotString() {
		return "Else";
	}

	public String toJava() {
		return "else";
	}
}
