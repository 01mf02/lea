package lea;

import lea.types.Type;

public class VariableInfo {
	private boolean isInitialized;
	private Type type;

	public VariableInfo(Type t, boolean initialized) {
		type = t;
		isInitialized = initialized;
	}

	public void initialize() {
		isInitialized = true;
	}

	public boolean initialized() {
		return isInitialized;
	}

	public Type getType() {
		return type;
	}

	public String toString() {
		return type.toString();
	}
	
	public String toJava(){
		
		return type.toJava();
	}
}
