package lea.syntax;

import lea.FunctionInfo;
import lea.NativeFunctionInfo;
import lea.NativeFunctionTable;
import lea.generator.Generator;
import lea.types.Type;
import lea.types.UnknownType;

public class FunctionRef extends Expression {
	private String name;
	private FunctionInfo info;
	private NativeFunctionInfo nfi;

	public FunctionRef(String n, FunctionInfo fi) {
		name = n;
		info = fi;
	}

	public FunctionRef(String n, NativeFunctionInfo fi) {
		name = n;
		nfi = fi;
	}

	public String getName() {
		return name;
	}

	public FunctionInfo getFunctionInfo() {
		return info;
	}

	public NativeFunctionInfo getNativeFunctionInfo() {
		return nfi;
	}

	public Type getType() {
		if (info != null)
			return info.getOutputType();
		else if (nfi != null)
			return nfi.getOutputType();

		return new UnknownType();
	}

	public String toString() {
		if (info != null)
			return "FunctionRef(" + name + /* ", " + info.toString()+ */")";
		else if (nfi != null)
			return "FunctionRef(" + name + /* ", " + nfi.toString()+ */")";

		return "FunctionRef(" + name + ", INVALID)";
	}

	public String toDotString() {
		return this.toString();
	}

	public String toJava() {
		String result = "";
		if (nfi != null) {
			NativeFunctionTable nft = new NativeFunctionTable();
			result += nft.toJava(name);

			if (result != null)
				return result + "(";
			
		} 
		else if (info != null) {
				return result + Generator.generateName(name) + "(";
		}

		return "FunctionRef Unknown !";

	}
}
