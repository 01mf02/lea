package lea;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import lea.syntax.Expression;
import lea.syntax.SyntaxTree;
import lea.types.BoolType;
import lea.types.CharType;
import lea.types.FloatType;
import lea.types.IntType;
import lea.types.ListType;
import lea.types.StringType;
import lea.types.StructType;
import lea.types.TupleType;
import lea.types.Type;

public class NativeFunctionTable extends TreeMap<String, NativeFunctionInfo> {
	private static final long serialVersionUID = -7081722780266458658L;

	public NativeFunctionTable() {
		// Length (accessible string et liste)
		NativeFunctionInfo nfi = new NativeFunctionInfo();

		nfi.setOutputType(new IntType());
		nfi.pushType(new StringType());
		nfi.pushType(new ListType(null));

		this.put("length", nfi);

		// write
		nfi = new NativeFunctionInfo();
		nfi.pushArg("str", new StringType());

		this.put("write", nfi);

		// writeln
		nfi = new NativeFunctionInfo();
		nfi.pushArg("str", new StringType());

		this.put("writeln", nfi);

		// read
		nfi = new NativeFunctionInfo();
		nfi.setOutputType(new StringType());

		this.put("read", nfi);

		// toString
		nfi = new NativeFunctionInfo();
		nfi.setOutputType(new StringType());
		nfi.pushType(new StringType());
		nfi.pushType(new ListType(null));
		nfi.pushType(new BoolType());
		nfi.pushType(new FloatType());
		nfi.pushType(new CharType());
		nfi.pushType(new IntType());
		nfi.pushType(new TupleType(null, null));
		nfi.pushType(new StructType(null));

		this.put("toString", nfi);
	}

	public boolean isCallPermitted(String id, Expression e, Type from) {
		boolean isPermitted = false;

		NativeFunctionInfo nfi = this.get(id);
		LinkedList<Type> args = new LinkedList<Type>();

		SyntaxTree tmp = e;
		
		if(tmp != null)
		{
			if (tmp.getLeft() == null && tmp.getRight() == null)
				args.add(tmp.getType());
			else {
				while ((tmp.getLeft() != null) || (tmp.getRight() != null)) {
					if (tmp.getRight() != null) {
						if (tmp.getRight().getLeft() == null
								&& tmp.getRight().getRight() == null)
							args.add(0, tmp.getRight().getType());
					}
					if (tmp.getLeft() != null) {
						if (tmp.getLeft().getLeft() == null
								&& tmp.getLeft().getRight() == null)
							args.add(0, tmp.getLeft().getType());
					}
					tmp = tmp.getLeft();
				}
			}
		}

		if (nfi != null) {
			if (nfi.containsAccessibleFrom(from)) {
				boolean argumentsFit = true;
				LinkedList<ArgumentInfo> funcArgs = nfi.getArgs();

				if (args.size() == funcArgs.size()) {
					for (int i = 0; i < args.size(); i++) {
						if (!args.get(i).getType()
								.equals(funcArgs.get(i).getType())) {
							argumentsFit = false;
							break;
						}
					}
				} else
					argumentsFit = false;

				if (argumentsFit) {
					isPermitted = true;
				}
			}
		}

		return isPermitted;
	}

	public String toString() {
		String str = "";

		for (Map.Entry<String, NativeFunctionInfo> entry : entrySet()) {
			str += entry.getKey() + " " + entry.getValue().toString() + "\n";
		}

		return str;
	}
}
