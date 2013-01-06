package lea;

import java.io.File;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import lea.syntax.BoolExp;
import lea.syntax.Expression;
import lea.syntax.List;
import lea.syntax.NumberExp;
import lea.syntax.Pair;
import lea.syntax.StringConcatenation;
import lea.syntax.SyntaxTree;
import lea.types.IntType;
import lea.types.ListType;
import lea.types.StringType;
import lea.types.StructType;
import lea.types.TupleType;
import lea.types.Type;

public class FunctionTable extends TreeMap<String, FunctionInfo> {
	private static final long serialVersionUID = -2198438635232540509L;

	public String toString() {
		String str = "";

		for (Map.Entry<String, FunctionInfo> entry : entrySet()) {
			str += entry.getKey() + " " + entry.getValue().toString() + "\n\n";
		}

		return str;
	}

	public boolean findFunction(String id) {
		for (Map.Entry<String, FunctionInfo> entry : entrySet()) {
			if (entry.equals(id))
				return true;
		}

		// TODO: find writeln etc. too!

		return false;
	}

	public void saveDotToDir(String directory) {
		for (Map.Entry<String, FunctionInfo> entry : entrySet()) {
			entry.getValue().getSyntaxTree()
					.toDot(directory + File.separator + entry.getKey());
		}
	}

	public FunctionInfo getFunction(String id, Pair argumentsPair,
			Type objectType) {

		LinkedList<Expression> givenArguments;

		if (argumentsPair == null)
			givenArguments = new LinkedList<Expression>();
		else
			givenArguments = argumentsPair.toList();

		switch (id) {
		case "write":
		case "writeln":
			if (givenArguments.size() == 1
					&& givenArguments.getFirst().getType() instanceof StringType
					&& objectType == null)
				return new FunctionInfo(null, null, null);
		case "read":
			if (givenArguments.isEmpty() && objectType == null)
				return new FunctionInfo(null, null, null);
		case "length":
			if (givenArguments.isEmpty()
					&& (objectType instanceof ListType
							|| objectType instanceof TupleType || objectType instanceof StringType))
				return new FunctionInfo(null, new IntType(), null);
		case "toString":
			if (givenArguments.isEmpty() && objectType instanceof StructType)
				return new FunctionInfo(null, new StringType(), null);
		}

		FunctionInfo fi = this.get(id);
		if (fi == null)
			return null;

		LinkedList<ArgumentInfo> functionArguments = fi.getArgs();

		if (functionArguments.size() != givenArguments.size())
			return null;

		for (int i = 0; i < functionArguments.size(); i++) {
			Type t1 = functionArguments.get(i).getType();
			Type t2 = givenArguments.get(i).getType();

			if (!(t1.equals(t2)))
				return null;
		}

		return fi;
	}

	public boolean isCallPermitted(String id, Expression arguments) {

		// TODO: This code is SO ugly --- redo it!

		boolean isPermitted = false;

		FunctionInfo nfi = this.get(id);
		LinkedList<Type> args = new LinkedList<Type>();
		SyntaxTree tmp = arguments;

		if (tmp != null) {
			if (tmp.getLeft() == null && tmp.getRight() == null)
				args.add(tmp.getType());
			else {
				while ((tmp.getLeft() != null) || (tmp.getRight() != null)) {
					Expression ex = (Expression) tmp.getLeft();
					Expression ex2 = (Expression) tmp.getRight();

					if (ex instanceof List || ex instanceof NumberExp
							|| ex instanceof BoolExp
							|| ex instanceof StringConcatenation) {
						args.add(0, ex.getType());

						tmp = tmp.getRight();
						if (tmp != null) {
							if (tmp.getLeft() == null && tmp.getRight() == null)
								args.add(1, tmp.getType());
						}
					} else if (ex2 instanceof List || ex2 instanceof NumberExp
							|| ex2 instanceof BoolExp
							|| ex2 instanceof StringConcatenation) {
						args.add(0, ex2.getType());

						tmp = tmp.getLeft();
						if (tmp != null) {
							if (tmp.getLeft() == null && tmp.getRight() == null)
								args.add(1, tmp.getType());
						}
					} else {
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
		}

		if (nfi != null) {
			boolean argumentsFit = true;
			LinkedList<ArgumentInfo> funcArgs = nfi.getArgs();

			if (args.size() == funcArgs.size()) {
				for (int i = 0; i < args.size(); i++) {
					if (!args.get(i).equals(funcArgs.get(i).getType())) {
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
		return isPermitted;
	}

}