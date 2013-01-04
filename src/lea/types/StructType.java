package lea.types;

import lea.Environment;
import lea.constants.Constant;
import lea.generator.Generator;

public class StructType extends Type {
	public Environment env;
	private String name;

	public StructType() {
	}
	
	public StructType(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	public Environment getEnvironment() {
		return env;
	}

	public void setEnvironment(Environment e) {
		env = e;
	}

	@Override
	public boolean equals(Type t1) {
		if (t1 instanceof StructType) {
			StructType st = (StructType) t1;
			return st.getEnvironment() == env;
		}

		return false;
	}

	@Override
	public boolean equals(Constant c1) {
		return false;
	}

	public String toString() {
		return "struct (" + name + ")";
	}

	public String toJava() {
		return Generator.generateName(name);
	}
}
