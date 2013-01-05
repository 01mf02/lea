package lea.constants;

import lea.syntax.List;
import lea.types.Type;

public class ListConstant implements Constant {

	private List list;

	public ListConstant(List l) {
		list = l;
	}

	public Type getType() {
		return list.getType();
	}

	public String toString() {
		return list.toString();
	}

	public String toJava() {
		return list.toJava();
	}
}
