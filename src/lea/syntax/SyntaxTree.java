package lea.syntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import lea.*;
import lea.constants.*;
import lea.types.*;

// Abstract Syntax Tree
// decorated with attributs 

public class SyntaxTree 
{
    private SyntaxTree left;
    private SyntaxTree right;
    private EnvironmentStack env;	    // current environnement
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
    	this.env= new EnvironmentStack();
    	this.type=t;
    	//System.out.print(toString()+"\n"); 
    	
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
    
    public void setEnvironment(EnvironmentStack e)
    {
    	env = e;
    }
    
    public Environment getFirstEnvironment()
    {
    	return env.lastElement();
    }
    
    public EnvironmentStack getEnvironment()
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
	str.append(" [label=\""+this.toDotString());
	
		if (getType()!=null){
		    str.append(" (");
		    str.append(getType().toString());
		    str.append(")");
		}
		str.append("\"];\n");
		if (left != null)
		{
		    left.toDot(str);
		}
		if (right != null)
		{
		    right.toDot(str);
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
