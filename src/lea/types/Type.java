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
