package lea.types;

import lea.constants.Constant;

/* tree implementing a type*/

public abstract class Type {
    
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
    
    public abstract boolean equals(Type t1);
    public abstract boolean equals(Constant c1);

	protected boolean aux_equals(Type t1, Type t2)
	{
		boolean equals = true;
    	
    	//Comparaison a gauche
    	if(t1.left != null && t2.left != null)
    		equals = aux_equals(t1.left, t2.left);
    	else if(!(t1.left == null && t1.left == null))
    		equals = false;
    	
    	//Comparaison a droite
    	if(t1.right != null && t2.right != null && equals)
    		equals = aux_equals(t1.right, t2.right);
    	else if(!(t1.right == null && t1.right == null))
    		equals = false;
    	
    	if(t1.left == null && t1.right == null && equals)
    		equals = t1.equals(t2);
    		
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
    
    /*public Type getType()
    {
    	return this.type;
    }*/
    public Type getType()
    {
    	return this;
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
