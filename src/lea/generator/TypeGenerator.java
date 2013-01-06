package lea.generator;

import java.util.Map;

import lea.Environment;
import lea.TypeTable;
import lea.VariableInfo;
import lea.types.StructType;
import lea.types.Type;

public class TypeGenerator {

	TypeTable typeTable;

	public TypeGenerator(TypeTable typeTable) {
		this.typeTable = typeTable;
	}

	public void generate(CodeWriter cw) {
		for (Map.Entry<String, Type> typeEntry : typeTable.entrySet()) {

			if (typeEntry.getValue() instanceof StructType) {
				String className = Generator.generateName(typeEntry.getKey());
				StructType st = (StructType) typeEntry.getValue();

				cw.writeLine("");
				cw.writeLine("public static class " + className);
				cw.openBlock();

				Environment env = st.getEnvironment();

				for (Map.Entry<String, VariableInfo> varEntry : env.entrySet()) {
					String varName = Generator.generateName(varEntry.getKey());
					String varType = varEntry.getValue().getType().toJava();
					cw.writeLine("public " + varType + " " + varName + ";");
				}

				// TODO: write equals() function for new class!

				cw.closeBlock();
			}
		}

	}
}