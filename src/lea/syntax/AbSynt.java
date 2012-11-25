package lea.syntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import lea.Env;
import lea.EnvException;
import lea.Main;
import lea.constants.*;
import lea.types.*;

// Abstract Syntax Tree
// decorated with attributs 

public class AbSynt 
{
    private int id;   // used in toDot
    private AbSynt left;
    private AbSynt right;
    private Env env;	    // current environnement
    private Type type;
    
    protected AbSynt()
    {
    	this.left = null;
    	this.right = null;
    }
    
    public AbSynt(AbSynt left, AbSynt right, Type t) {
    	this.left=left;
    	this.right=right;
    	this.id=Env.num;
    	this.env=Main.currentEnv;
    	this.type=t;
    	//System.out.print(toString()+"\n"); 
    }
    
    public AbSynt(AbSynt left, AbSynt right) 
    {
    	this(left, right, null);
    }
    
    public AbSynt getLeft() 
    {
    	return left;
    }
    
    public void setLeft(AbSynt left) 
    {
    	this.left = left;
    }
    
    public AbSynt getRight() 
    {
    	return right;
    }
    
    public void setRight(AbSynt right) 
    {
    	this.right = right;
    }
    
    public Type getType() 
    {
    	return type;
    }
    
    public Env getEnv() throws EnvException 
    {
        if (env == null)
        	throw new EnvException("current environnement is null");
        else
            return env;
    }
    
    /*
    public String toString() 
    {
	String result = new String();
	if ((left != null) || (right != null)){
	    result +="(";
	    if (left != null)
	    	result += left.toString();
	    if (right != null){
                result+=",";
                if (right.tag==EnumTag.SUCC || right.tag==EnumTag.THENELSE)
                    result+="\n\n\t";
	    	result += right.toString();
            }
	    result+=")";
	}
	return result;
    }
    
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
