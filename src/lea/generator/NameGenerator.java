package lea.generator;

public class NameGenerator {

	public String generateName(String id) {
		String str = "";
		str += "lea_" + id;
		
		return str;
	}
}