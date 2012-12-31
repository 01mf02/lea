package lea.constants;

import java.util.LinkedList;

import lea.types.*;
import lea.syntax.*;

public class TupleConstant implements Constant 
{
	LinkedList<Object> value = null;
	TupleType tupleType;
	
	public TupleConstant(TupleNode tn, TupleType t)
	{
		Expression tmpL = (Expression)tn.getLeft();
		Expression tmpR = (Expression)tn.getRight();
		
		LinkedList<Object> nodesValues = new LinkedList<Object>();

		//Obtient tous les noeuds
		if (tmpL.getLeft() != null || tmpL.getRight() != null)
		{
			while ((tmpL.getLeft() != null) || (tmpL.getRight() != null)) 
			{
				if (tmpL.getRight() != null) 
				{
					if (tmpL.getRight().getLeft() == null && tmpL.getRight().getRight() == null)
					{
						if(tmpL.getRight() instanceof ConstantLeaf)
						{
							ConstantLeaf c = (ConstantLeaf)tmpL.getRight();
							nodesValues.add(0, c);
						}
					}
				}
				if (tmpL.getLeft() != null) 
				{
					if (tmpL.getLeft().getLeft() == null && tmpL.getLeft().getRight() == null)
					{
						if(tmpL.getRight() instanceof ConstantLeaf)
						{
							ConstantLeaf c = (ConstantLeaf)tmpL.getLeft();
							nodesValues.add(0, c);
						}
					}
				}
				tmpL = (Expression)tmpL.getLeft();
			}
		}	
		
	//	if(tmpL.getRight() != null)
		{
			ConstantLeaf c = (ConstantLeaf)tmpR;
			nodesValues.add(0, c);
		}
		
		value = nodesValues;
		tupleType = t;
	}
    
    public TupleConstant(Type left, Type right) {
		// TODO Auto-generated constructor stub
	}

	public Type getType()
    {
    	return tupleType;
    }
    
    public LinkedList<Object> getValue()
    {
    	return value;
    }
    
    public String toString()
    {
    	return value.toString();
    }
    
    public String listType()
    {
    	String result = "";
    	Type type = tupleType;
    	while (type.getLeft() != null)
    	{
    		result += "\n" + type;
    		type = type.getLeft();
    	}
    	result += "\n" + type.getLeft() + "\n";
    		
    		
    	return result;
    }
    
    public String toJava() {
    	int i;
    	String result ="";
    	int size = value.size();
    	for(i = 0; i < size; i++)
    	{
    		Object val = value.get(i);
    		result += ((ConstantLeaf) val).getType() + " var" + i + " = "  + ((ConstantLeaf) val).toJava() + "; ";
    	}
    	
    	return result;
		//return toString();
	}
}
