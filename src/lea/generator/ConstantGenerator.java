package lea.generator;

import java.io.IOException;
import java.util.Map;

import lea.ConstantTable;
import lea.constants.Constant;
import lea.types.EnumType;
import lea.types.TupleType;

public class ConstantGenerator {

	ConstantTable cstTable;
	NameGenerator ng;

	public ConstantGenerator(ConstantTable cstTable) throws IOException {
		this.cstTable = cstTable;
		this.ng = new NameGenerator();
	}

	public void generate(CodeWriter cw) throws IOException {
		for (Map.Entry<String, Constant> entry : cstTable.entrySet()) {
			
			if(entry.getValue().getType().toString().equals(new EnumType().getType().toString()))
				cw.writeLine("//public final " + entry.getValue().getType().toJava()
					+ " " + ng.generateName(entry.getKey()) + " = "
					+ entry.getValue().toJava() + ";");
			else if(entry.getValue().getType().toString().equals(new TupleType().getType().toString()))
				cw.writeLine("public static class " + ng.generateName(entry.getKey()) + " { "
					+ entry.getValue().toJava() + "}");
			else 
				cw.writeLine("public final " + entry.getValue().getType().toJava()
						+ " " + ng.generateName(entry.getKey()) + " = "
						+ entry.getValue().toJava() + ";");
			//cw.writeLine(entry.getValue().getType().toString());
			
		}
		//cw.writeLine(new TupleType().getType().toString());
	}
}