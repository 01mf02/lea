package lea;
import java.util.*;

import lea.constants.*;

public class ConstantTable implements Map<String, Constant>
{
	Map<String, Constant> arrMap;
	
	public ConstantTable()
	{
		arrMap = new TreeMap<String, Constant>();
	}
	
	public String toString()
	{
		String str = "";
		
		for (Map.Entry<String, Constant> entry : arrMap.entrySet())
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
	public Set<java.util.Map.Entry<String, Constant>> entrySet() 
	{
		return arrMap.entrySet();
	}

	@Override
	public Constant get(Object key) 
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
	public Constant put(String key, Constant value) 
	{
		return arrMap.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Constant> m) 
	{
		arrMap.putAll(m);
	}

	@Override
	public Constant remove(Object key) 
	{
		return arrMap.remove(key);
	}

	@Override
	public int size() 
	{
		return arrMap.size();
	}

	@Override
	public Collection<Constant> values() 
	{
		return arrMap.values();
	}
}
