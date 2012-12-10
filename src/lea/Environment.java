package lea;
import java.util.*;

public class Environment extends TreeMap<String, VariableInfo>
{
	private static final long serialVersionUID = 1446503626999797042L;

	public String toString()
	{
		String str = "";
		
		for (Map.Entry<String, VariableInfo> entry : entrySet())
		{
		    str += entry.getKey() + " " + entry.getValue().toString() + "\n";
		}
		
		return str;
	}
}
