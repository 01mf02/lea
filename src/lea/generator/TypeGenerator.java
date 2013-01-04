package lea.generator;

import java.util.Map;

import lea.TypeTable;
import lea.types.*;

public class TypeGenerator {

	TypeTable typeTable;

	public TypeGenerator(TypeTable typeTable) {
		this.typeTable = typeTable;
	}

	public void generate(CodeWriter cw) {
		for (Map.Entry<String, Type> entry : typeTable.entrySet()) {
			cw.writeLine("");
			
			if(entry.getValue() instanceof TupleType)
			{
				cw.writeLine("public static " + entry.getValue().toJava() + " " + entry.getKey() + entry.getValue().toString() + ";");
			}
			else if(entry.getValue() instanceof EnumType)
			{
				cw.writeLine("public static enum " + entry.getKey() + " " + entry.getValue().toJava() + ";");
			}
			else
			{
				cw.writeLine("public static class " + entry.getKey() + " () {");
				cw.openBlock();
				cw.writeLine(entry.getValue().toString());
				cw.writeLine(entry.getValue().toJava());
				if (entry.getValue().getLeft() != null)
					cw.writeLine("LEFT " + entry.getValue().getLeft().toString());
				if (entry.getValue().getRight() != null)
					cw.writeLine("RIGHT " + entry.getValue().getRight().toString());
	
				cw.writeLine(entry.toString());
				cw.closeBlock();
			}
		}

	}

}
