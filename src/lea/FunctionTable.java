package lea;

import java.util.Map;
import java.util.TreeMap;

public class FunctionTable extends TreeMap<String, FunctionInfo> {
	private static final long serialVersionUID = -2198438635232540509L;

	public String toString() {
		String str = "";

		for (Map.Entry<String, FunctionInfo> entry : entrySet()) {
			str += entry.getKey() + " " + entry.getValue().toString() + "\n\n";
		}

		return str;
	}
	
	public void saveDotToDir(String directory) {
		for (Map.Entry<String, FunctionInfo> entry : entrySet())
		{
		    entry.getValue().getSyntaxTree().toDot(directory + "/" + entry.getKey());
		}
	}
}