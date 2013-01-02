package lea;

import lea.types.Type;

public class ArgumentInfo {
	private String name;
	private Type t;

	public ArgumentInfo(String argName, Type type) {
		name = argName;
		t = type;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return t;
	}

	public String toString() {
		return name + ":" + t.toString();
	}
}
