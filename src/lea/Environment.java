package lea;

import java.util.Map;
import java.util.TreeMap;

import lea.generator.CodeWriter;
import lea.generator.Generator;
import lea.types.Type;

public class Environment extends TreeMap<String, VariableInfo> {
	private static final long serialVersionUID = 1446503626999797042L;

	public String toString() {
		String str = "";

		for (Map.Entry<String, VariableInfo> entry : entrySet()) {
			str += entry.getKey() + " " + entry.getValue().toString() + "\n";
		}

		return str;
	}

	// TODO: move this to TypeGenerator!
	public void toJava(CodeWriter cw) {
		for (Map.Entry<String, VariableInfo> entry : entrySet()) {
			String name = Generator.generateName(entry.getKey());
			Type type = entry.getValue().getType();
			cw.writeLine("public " + Generator.generateDeclaration(name, type));
		}
	}
}
