package lea;
import java.util.*;

public class FunctionTable implements Map<String, FunctionInfo>
{
	Map<String, FunctionInfo> arrMap;
	
	public FunctionTable()
	{
		arrMap = new TreeMap<String, FunctionInfo>();
	}
	
	public String toString()
	{
		String str = "";
		
		for (Map.Entry<String, FunctionInfo> entry : arrMap.entrySet())
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
	public Set<java.util.Map.Entry<String, FunctionInfo>> entrySet() {
		return arrMap.entrySet();
	}

	@Override
	public FunctionInfo get(Object key) {
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
	public FunctionInfo put(String key, FunctionInfo value) {
		return arrMap.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends FunctionInfo> m) {
		arrMap.putAll(m);
	}

	@Override
	public FunctionInfo remove(Object key) {
		return arrMap.remove(key);
	}

	@Override
	public int size() {
		return arrMap.size();
	}

	@Override
	public Collection<FunctionInfo> values() {
		return arrMap.values();
	}

}
