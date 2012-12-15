package lea.generator;

import java.io.IOException;
import java.util.Map;

import lea.ConstantTable;
import lea.constants.Constant;

public class ConstantGenerator {

	ConstantTable cstTable;
	NameGenerator ng;

	public ConstantGenerator(ConstantTable cstTable) throws IOException {
		this.cstTable = cstTable;
		this.ng = new NameGenerator();
	}

	public String generate() throws IOException {
		String str = "";

		for (Map.Entry<String, Constant> entry : cstTable.entrySet()) {
			str += "\tpublic final " + entry.getValue().getType() + " "
					+ ng.generateName(entry.getKey()) + " = "
					+ entry.getValue().toString() + ";\n";
		}

		return str;
	}
}