package lea;

public class EnvException extends Exception{

    private static final long serialVersionUID = 1L;
    
    public EnvException(String mess){
    	System.out.println(mess);
    }

}
