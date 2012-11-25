package lea.types;

/* tree implementing a type*/

public class Type {
    
    protected Type left;
    protected Type right;
    protected EnumType type;	
    
    protected Type()
    {
    	this.left = null;
    	this.right = null;
    }

    protected Type(Type left, Type right) 
    {
		this.left=left;
		this.right=right;
    }
    
    public static boolean typeAreEquals(Type t1, Type t2)
    {
    	boolean equals = true;
    	
    	//Comparaison a gauche
    	if(t1.left != null && t2.left != null)
    		equals = typeAreEquals(t1.left, t2.left);
    	else if(!(t1.left == null && t1.left == null))
    		equals = false;
    	
    	//Comparaison a droite
    	if(t1.right != null && t2.right != null)
    		equals = typeAreEquals(t1.right, t2.right);
    	else if(!(t1.right == null && t1.right == null))
    		equals = false;
    		
    	//Si on arrive aux noeuds
    	if(t1.left == null && t1.right == null && equals)
    		equals = (t1.getType() == t2.getType());
    		
    	return equals;
    }
    
    public Type getLeft() 
    {
    	return left;
    }
    
    public void setLeft(Type left) 
    {
    	this.left = left;
    }
    
    public Type getRight() 
    {
    	return right;
    }
    
    public void setRight(Type right) 
    {
    	this.right = right;
    }
    
    public EnumType getType()
    {
    	return this.type;
    }
    
    /*public String toString() {
	String result = new String();
	switch (type) {
	case INT:
	case FLOAT:
	case STRING:
	case BOOLEAN:
		result += type.toString();break;
	case ARRAY:result += "ARRAY ["+integer+"] OF "+left.toString(); break;
	case POINTER:result += "POINTER OF "+left.toString(); break;
	    //case ERROR:result += "ERROR"; break;
	};
	return result;
    }*/
}
