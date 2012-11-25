package lea.types;
public enum EnumType {
	CHAR ("char"), 
	INT ("int"), 
	FLOAT ("float"),
	STRING ("string"), 
	BOOLEAN ("bool"), 
	ARRAY ("array"),  
	TUPLE ("tuple"),
	COMPLEX ("object"),
	ERROR ("error");
	
    private final String tag;

    EnumType(String s){
            tag = s;
    }

    public String toString(){
            return tag;
    }

}
