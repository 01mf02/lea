package lea;
import java.util.*;

public class Environment implements Map<String, VariableInfo>
{
	Map<String, VariableInfo> arrMap;
	
	public Environment()
	{
		arrMap = new TreeMap<String, VariableInfo>();
	}

	public String toString()
	{
		String str = "";
		
		for (Map.Entry<String, VariableInfo> entry : arrMap.entrySet())
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
	public Set<java.util.Map.Entry<String, VariableInfo>> entrySet() 
	{
		return arrMap.entrySet();
	}

	@Override
	public VariableInfo get(Object key) 
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
	public VariableInfo put(String key, VariableInfo value) 
	{
		return arrMap.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends VariableInfo> m) 
	{
		arrMap.putAll(m);
	}

	@Override
	public VariableInfo remove(Object key) 
	{
		return arrMap.remove(key);
	}

	@Override
	public int size() 
	{
		return arrMap.size();
	}

	@Override
	public Collection<VariableInfo> values() 
	{
		return arrMap.values();
	}
}
