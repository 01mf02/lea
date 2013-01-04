package lea.types;

import java.util.LinkedList;

import lea.constants.Constant;

public class EnumType extends Type {
	public LinkedList<String> enumElems;

	public EnumType(LinkedList<String> l) {
		enumElems = l;
	}

	public EnumType() {
		enumElems = new LinkedList<String>();
	}

	public LinkedList<String> getListEnum() {
		return enumElems;
	}

	public boolean containsEnum(String e) {
		return enumElems.contains(e);
	}

	@Override
	public boolean equals(Type t1) {
		if (t1 instanceof EnumType) {
			EnumType et = (EnumType) t1;
			return enumElems == et.getListEnum();
		}

		return false;
	}

	@Override
	public boolean equals(Constant c1) {
		return false;
	}

	public String toString() {
		return "enum (" + enumElems.toString() + ")";
	}

	public String toJava() {
		return "int";
	}
}
