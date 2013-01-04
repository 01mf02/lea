package lea;

import java.util.Map;
import java.util.TreeMap;

import lea.generator.CodeWriter;
import lea.generator.Generator;
import lea.types.StructType;

public class Environment extends TreeMap<String, VariableInfo> {
	private static final long serialVersionUID = 1446503626999797042L;

	public String toString() {
		String str = "";

		for (Map.Entry<String, VariableInfo> entry : entrySet()) {
			str += entry.getKey() + " " + entry.getValue().toString() + "\n";
		}

		return str;
	}
	
    public void toJava(CodeWriter cw) {
        for (Map.Entry<String, VariableInfo> entry : entrySet()) {
        	if (entry.getValue().getType() instanceof StructType)
        		cw.writeLine("public "+ entry.getValue().toJava() + " " + Generator.generateName(entry.getKey()) + " = new " + entry.getValue().toJava() +"();");
        	else
        		cw.writeLine(entry.getValue().toJava() + " " + Generator.generateName(entry.getKey()) + ";");
        }
    }
}
