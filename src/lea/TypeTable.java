package lea;

import java.util.Map;
import java.util.TreeMap;

import lea.types.*;

public class TypeTable extends TreeMap<String, Type> {
	private static final long serialVersionUID = 8433001374480555698L;

	public String toString() {
		String str = "";

		for (Map.Entry<String, Type> entry : entrySet()) {
			str += entry.getKey() + " " + entry.getValue().toString() + "\n";
		}

		return str;
	}
	
	public Type getEnumType(String name)
	{
		for (Map.Entry<String, Type> entry : entrySet()) 
		{
			if(entry.getValue() instanceof EnumType)
			{
				EnumType et = (EnumType)entry.getValue();
				if(et.containsEnum(name))
					return et;
			}
		}
		
		return null;
	}
}
