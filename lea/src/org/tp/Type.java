package org.tp;

/* tree implementing a type*/

public class Type {
    
    private Type left;
    private Type right;
    private EnumType type;	
    private Integer integer; // array size
    

    public Type(Type left, Type right, Integer i, EnumType type) {
	this.left=left;
	this.right=right;
	this.integer=i;
	this.type=type;
    }
    
    public Type(Type left, Type right, EnumType type) {
    	this(left,right,0, type);
        }
        
    
    public Type(EnumType type) {
    	this(null,null,type);
    }
    
    public Type getLeft() {
	return left;
    }
    
    public void setLeft(Type left) {
	this.left = left;
    }
    
    public Type getRight() {
	return right;
    }
    
    public void setRight(Type right) {
	this.right = right;
    }
    
    public EnumType getEnumType() {
    	return this.type;
    }
    
    public String toString() {
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
    }
}