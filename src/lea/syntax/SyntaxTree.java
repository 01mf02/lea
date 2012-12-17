package lea.syntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import lea.*;
import lea.types.*;

// Abstract Syntax Tree
// decorated with attributes 

public class SyntaxTree 
{
    private int id;   // used in toDot
    private SyntaxTree left;
    private SyntaxTree right;
    private EnvironmentStack env;	    // current environment
    private Type type;
    
    private static int numID = 0;
    
    protected SyntaxTree()
    {
    	this.left = null;
    	this.right = null;
    }
    
    public SyntaxTree(SyntaxTree left, SyntaxTree right, Type t) 
    {
    	this.left=left;
    	this.right=right;
    	this.env= new EnvironmentStack();
    	this.type=t;
    	this.id=numID++;
    	
    	env.push(new Environment());
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
    
    public void setEnvironmentStack(EnvironmentStack e)
    {
    	env = e;
    }
    
    public Environment getFirstEnvironment()
    {
    	return env.lastElement();
    }
    
    public EnvironmentStack getEnvironmentStack()
    {
    	return env;
    }
    
    public VariableInfo findInEnvironment(String id)
    {
    	return env.getVariable(id);
    }
    
    public void pushEnvironment(Environment e)
    {
    	if(env == null)
    		env = new EnvironmentStack();
    	
    	env.push(e);
    }
    
    public Environment popEnvironment()
    {
    	if(!env.isEmpty())
    		return env.pop();
    	
    	return null;
    }
    
    public boolean containsReturn()
    {
    	boolean result = false;
    	
    	if(this instanceof ReturnNode)
    		return true;
    	
		if ((left != null) || (right != null))
		{		    
		    if (left != null)
		    	result = left.containsReturn() || result;
		    if (right != null)
		    	result = right.containsReturn() || result;
		}
		
		return result;
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

	
	public String toDotString()
	{
		return "Root";
	}
    
    public void toDot(StringBuffer str) {
	str.append(id + " [label=\""+this.toDotString());
	
		if (getType()!=null){
		    str.append(" (");
		    str.append(getType().toString());
		    str.append(")");
		}
		str.append("\"];\n");
		if (left != null)
		{
		    left.toDot(str);
		    str.append(id+" -> "+left.id+";\n");
		}
		if (right != null)
		{
		    right.toDot(str);
		    str.append(id+" -> "+right.id+";\n");
		}
    }
    
    public void toDot(String file) {
	try {
	    BufferedWriter out = new BufferedWriter(new FileWriter("./"+file+".dot"));
	    out.write("digraph SyntaxTree {");
	    StringBuffer str = new StringBuffer();
	    toDot(str);
	    out.write(str.toString());
	    out.write("}");
	    out.close();
	} catch (IOException e) {
	    System.out.println("ERROR: build dot");
	}		
    }
}
