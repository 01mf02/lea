package lea.syntax;

import lea.generator.CodeWriter;
import lea.types.StructType;
import lea.types.TupleType;

public class Assignment extends Instruction {
	Expression assignment_left, assignment_right;

	public Assignment(Expression a1, Expression a2) {
		super(a1, a2);
		assignment_left = a1;
		assignment_right = a2;
	}

	public String toString() {
		return "Assign" + super.toString();
	}

	public void toJava(CodeWriter w) {
		if (assignment_right != null)
		{
			String leftPart = assignment_left.toJava();
			String rightPart = assignment_right.toJava();
			
			if(assignment_left.getType() instanceof TupleType)
			{
				leftPart = "Object[] " + leftPart;
				if(assignment_right instanceof TupleNode)
					rightPart = "new Object[] {" + rightPart.substring(1).substring(0, rightPart.length() - 2) + "}";
			}
			else 
				leftPart = assignment_left.getType() + " " + leftPart;
			
			w.writeLine(leftPart + " = " + rightPart + ";");
		}
		else {
			if (assignment_left.getType() instanceof TupleType) {
				w.writeLine("Object[] " + assignment_left.toJava() + assignment_left.getType().toString() + ";");
			} 
			if (assignment_left.getType() instanceof StructType) {
				w.writeLine(((StructType) assignment_left.getType()).getName() + " " + assignment_left.toJava() + " = new " +  ((StructType) assignment_left.getType()).getName() + "();");
			}
			else
				w.writeLine(assignment_left.getType() + " "
						+ assignment_left.toJava() + ";");
		}

	}

	public String toDotString() {
		return "Assign";
	}
}
