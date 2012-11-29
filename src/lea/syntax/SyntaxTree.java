package lea.syntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import lea.Environment;
import lea.constants.*;
import lea.types.*;

// Abstract Syntax Tree
// decorated with attributs 

public class SyntaxTree 
{
    private SyntaxTree left;
    private SyntaxTree right;
    private Environment env;	    // current environnement
    private Type type;
    
    protected SyntaxTree()
    {
    	this.left = null;
    	this.right = null;
    }
    
    public SyntaxTree(SyntaxTree left, SyntaxTree right, Type t) 
    {
    	this.left=left;
    	this.right=right;
    	this.env= new Environment();
    	this.type=t;
    	//System.out.print(toString()+"\n"); 
    }
    
    public SyntaxTree(SyntaxTree left, SyntaxTree right) 
    {
    	this(left, right, null);
    }
    
    public SyntaxTree getLeft() 
    {
    	return left;
    }
    
    public void setLeft(SyntaxTree left) 
    {
    	this.left = left;
    }
    
    public SyntaxTree getRight() 
    {
    	return right;
    }
    
    public void setRight(SyntaxTree right) 
    {
    	this.right = right;
    }
    
    public Type getType() 
    {
    	return type;
    }
    
    public void setEnvironment(Environment e)
    {
    	env = e;
    }
    
    public Environment getEnvironment()
    {
    	return env;
    }
    
    public String toString() 
    {
		String result = new String();
		if ((left != null) || (right != null)){
		    result +="(";
		    if (left != null)
		    	result += left.toString();
		    if (right != null){
	                result+=",";
	                if (right instanceof Succ)
	                    result+="\n\n\t";
		    	result += right.toString();
	            }
		    result+=")";
		}
		return result;
    }
    
    /*
    public void toDot(StringBuffer str) {
	str.append(this.id+" [label=\""+tag.toString());
	switch (tag){
	case INTEGER:
	case REAL:
	case STRING:
	case VAR:      
	    str.append(": "+this.str); 
	    break;
	}
	if (type!=null){
	    str.append(" (");
	    str.append(type.toString());
	    str.append(")");
	}
	str.append("\"];\n");
	if (left != null){
	    left.toDot(str);
	    str.append(this.id+" -> "+left.id+";\n");
	}
	if (right != null){
	    right.toDot(str);
	    str.append(this.id+" -> "+right.id+";\n");
	}
	if (env != null && env.getRoot()!=null){
	    if (tag==EnumTag.VAR){
		str.append(env.getNum()+" [shape=\"box\", label=\"s"+env.getNum()+"\"];\n");
		str.append(this.id+" -> "+env.getNum()+" [color=\"yellow\"];\n");
	    }
	}
    }
    
    public void toDot(String file) {
	try {
	    BufferedWriter out = new BufferedWriter(new FileWriter("./"+file+".dot"));
	    out.write("digraph ArbreSyntAbstr {");
	    StringBuffer str = new StringBuffer();
	    toDot(str);
	    out.write(str.toString());
	    out.write("}");
	    out.close();
	} catch (IOException e) {
	    System.out.println("ERROR: build dot");
	}		
    }*/
}
