package lea;

import java.util.Map;
import java.util.TreeMap;

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
	
    public String toJava() {
        String str = "";

        for (Map.Entry<String, VariableInfo> entry : entrySet()) {
        	if (entry.getValue().getType() instanceof StructType)
        		str += "public "+ entry.getValue().toJava() + " " + entry.getKey() + " = new " + entry.getValue().toJava() +"();\n\t\t";
        	else
        		str += entry.getValue().toJava() + " " + entry.getKey() + ";\n\t\t";
        }

        return str;
    }
}
