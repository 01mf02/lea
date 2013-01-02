package lea.syntax;

public class Loop extends Instruction {
	public Loop(SyntaxTree a1, SyntaxTree a2) {
		super(a1, a2);
	}

	public String toString() {
		return "Loop" + super.toString();
	}

	public String toDotString() {
		return "Loop";
	}

	public String toJava() {
		return "do";
	}
}
