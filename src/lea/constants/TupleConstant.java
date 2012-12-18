package lea.constants;

import java.util.LinkedList;

import lea.types.*;
import lea.syntax.*;

public class TupleConstant implements Constant 
{
	LinkedList<String> value = null;
	TupleType tupleType;
	
	public TupleConstant(TupleNode tn, TupleType t)
	{
		Expression tmpL = (Expression)tn.getLeft();
		Expression tmpR = (Expression)tn.getRight();
		
		LinkedList<String> nodesValues = new LinkedList<String>();

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
							nodesValues.add(0, c.getValue());
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
							nodesValues.add(0, c.getValue());
						}
					}
				}
				tmpL = (Expression)tmpL.getLeft();
			}
		}	
		
		if(tmpL.getRight() instanceof ConstantLeaf)
		{
			ConstantLeaf c = (ConstantLeaf)tmpR;
			nodesValues.add(c.getValue());
		}
		
		value = nodesValues;
		tupleType = t;
	}
    
    public Type getType()
    {
    	return tupleType;
    }
    
    public LinkedList<String> getValue()
    {
    	return value;
    }
    
    public String toString()
    {
    	return value.toString();
    }
    
    public String toJava() {
		return toString();
	}
}
