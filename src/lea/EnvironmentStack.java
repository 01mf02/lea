package lea;

import java.util.Enumeration;
import java.util.Stack;

public class EnvironmentStack extends Stack<Environment>
{
	private static final long serialVersionUID = 1638148854425095344L;

	public VariableInfo getVariable(String id)
	{
		VariableInfo vi = null;
		for (Enumeration<Environment> e = this.elements() ; e.hasMoreElements();) 
		{
			Environment env = e.nextElement();
			
			vi = env.get(id);
			if(vi != null)
				return vi;
	    }
		
		return null;
	}
	
	public String toString()
	{
		String str = "";
		int i = 0;
		
		for (Enumeration<Environment> e = this.elements() ; e.hasMoreElements();) 
		{
			Environment env = e.nextElement();
			str += "("+i+")" + env.toString() + "\n";
			i++;
	    }
		
		return str;
	}
}
