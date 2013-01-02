package lea;

import java.util.Map;
import java.util.TreeMap;

import lea.types.Type;

public class TypeTable extends TreeMap<String, Type> {
	private static final long serialVersionUID = 8433001374480555698L;

	public String toString() {
		String str = "";

		for (Map.Entry<String, Type> entry : entrySet()) {
			str += entry.getKey() + " " + entry.getValue().toString() + "\n";
		}

		return str;
	}
}
