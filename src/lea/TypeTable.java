package lea;
import java.util.*;

import lea.constants.Constant;
import lea.types.*;

public class TypeTable implements Map<String, Type>
{
	Map<String, Type> arrMap;
	
	public TypeTable()
	{
		arrMap = new TreeMap<String, Type>();
	}

	public String toString()
	{
		String str = "";
		
		for (Map.Entry<String, Type> entry : arrMap.entrySet())
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
	public boolean containsKey(Object key) 
	{
		return arrMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) 
	{
		return arrMap.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<String, Type>> entrySet() 
	{
		return arrMap.entrySet();
	}

	@Override
	public Type get(Object key) 
	{
		return arrMap.get(key);
	}

	@Override
	public boolean isEmpty() 
	{
		return arrMap.isEmpty();
	}

	@Override
	public Set<String> keySet() 
	{
		return arrMap.keySet();
	}

	@Override
	public Type put(String key, Type value) 
	{
		return arrMap.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Type> m) 
	{
		arrMap.putAll(m);
	}

	@Override
	public Type remove(Object key) 
	{
		return arrMap.remove(key);
	}

	@Override
	public int size() 
	{
		return arrMap.size();
	}

	@Override
	public Collection<Type> values() 
	{
		return arrMap.values();
	}
}
