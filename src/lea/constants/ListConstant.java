package lea.constants;

import java.util.LinkedList;

import lea.syntax.*;
import lea.types.*;

public class ListConstant implements Constant 
{
	LinkedList<String> value = null;
	ListType listType;
	
	public ListConstant(ListNode ln, ListType t)
	{
		Expression tmp = (Expression)ln.getLeft();
		LinkedList<String> nodesValues = new LinkedList<String>();

		//Obtient tous les noeuds
		if (tmp.getLeft() != null || tmp.getRight() != null)
		{
			while ((tmp.getLeft() != null) || (tmp.getRight() != null)) 
			{
				if (tmp.getRight() != null) 
				{
					if (tmp.getRight().getLeft() == null && tmp.getRight().getRight() == null)
					{
						ConstantLeaf c = (ConstantLeaf)tmp.getRight();
						nodesValues.add(0, c.getValue());
					}
				}
				if (tmp.getLeft() != null) 
				{
					if (tmp.getLeft().getLeft() == null && tmp.getLeft().getRight() == null)
					{
						ConstantLeaf c = (ConstantLeaf)tmp.getLeft();
						nodesValues.add(0, c.getValue());
					}
				}
				tmp = (Expression)tmp.getLeft();
			}
		}
		value = nodesValues;
		listType = t;
	}
    
    public Type getType()
    {
    	return listType;
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
