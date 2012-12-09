package lea;
import java.util.*;
import lea.types.*;
import lea.syntax.*;

public class NativeFunctionTable implements Map<String, NativeFunctionInfo>
{
	Map<String, NativeFunctionInfo> arrMap;
	
	public NativeFunctionTable()
	{
		arrMap = new TreeMap<String, NativeFunctionInfo>();
	}
	
	public void generateList()
	{
		//Length (accessible string et liste)
		NativeFunctionInfo nfi = new NativeFunctionInfo();
		
		nfi.setOutputType(new IntType());
		nfi.pushType(new StringType());
		nfi.pushType(new ListType(null));
		
		this.put("length", nfi);

		//write
		nfi = new NativeFunctionInfo();
		nfi.pushArg("str", new StringType());
		
		this.put("write", nfi);

		//writeln
		nfi = new NativeFunctionInfo();
		nfi.pushArg("str", new StringType());
		
		this.put("writeln", nfi);

		//read
		nfi = new NativeFunctionInfo();
		nfi.setOutputType(new StringType());
		
		this.put("read", nfi);
	}
	
	public boolean isCallPermitted(String id, Expression e, Type from)
	{
		boolean isPermitted = false;
		
		NativeFunctionInfo nfi = this.get(id);
		LinkedList<Type> args = new LinkedList<Type>();
		
		if ((e.getLeft() != null) || (e.getRight() != null))
		{
		    if (e.getLeft() != null)
		    	args.add(e.getLeft().getType());
		    if (e.getRight() != null)
		    	args.add(e.getLeft().getType());
		}

		if(nfi != null)
		{			
			if(nfi.containsAccessibleFrom(from))
			{				
				boolean argumentsFit = true;
				LinkedList<ArgumentInfo> funcArgs = nfi.getArgs();
				
				if(args.size() == funcArgs.size())
				{
					for(int i = 0; i < args.size(); i++)
					{
						if(args.get(i).getType() != funcArgs.get(i).getType())
						{
							argumentsFit = false;
							break;
						}
					}
				}
				else
					argumentsFit = false;
				
				if(argumentsFit)
				{
					isPermitted = true;
				}
			}
		}
		
		return isPermitted;
	}
	
	public String toString()
	{
		String str = "";
		
		for (Map.Entry<String, NativeFunctionInfo> entry : arrMap.entrySet())
		{
		    str += entry.getKey() + " " + entry.getValue().toString() + "\n";
		}
		
		return str;
	}
	
	@Override
	public void clear() 
	{
		arrMap.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return arrMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return arrMap.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<String, NativeFunctionInfo>> entrySet() {
		return arrMap.entrySet();
	}

	@Override
	public NativeFunctionInfo get(Object key) {
		return arrMap.get(key);
	}

	@Override
	public boolean isEmpty() {
		return arrMap.isEmpty();
	}

	@Override
	public Set<String> keySet() {
		return arrMap.keySet();
	}

	@Override
	public NativeFunctionInfo put(String key, NativeFunctionInfo value) {
		return arrMap.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends NativeFunctionInfo> m) {
		arrMap.putAll(m);
	}

	@Override
	public NativeFunctionInfo remove(Object key) {
		return arrMap.remove(key);
	}

	@Override
	public int size() {
		return arrMap.size();
	}

	@Override
	public Collection<NativeFunctionInfo> values() {
		return arrMap.values();
	}

}
