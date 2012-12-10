package lea;

import java.util.Map;
import java.util.TreeMap;

import lea.constants.Constant;

public class ConstantTable extends TreeMap<String, Constant> {
	private static final long serialVersionUID = -6429252973311155229L;

	public String toString() {
		String str = "";

		for (Map.Entry<String, Constant> entry : entrySet()) {
			str += entry.getKey() + " " + entry.getValue().toString() + "\n";
		}

		return str;
	}
}
