package lea.types;

import lea.constants.*;

public class ComplexType extends Type 
{
	public ComplexType(Type t1, Type t2)
	{
		this.left = t1;
		this.right = t2;
		
		type = EnumType.COMPLEX;
	}

	@Override
	public boolean equals(Type t1) 
	{
		if(t1 instanceof ComplexType)
		{
	    	boolean equals = true;
	    	
	    	//Comparaison a gauche
	    	if(t1.left != null && this.left != null)
	    		equals = t1.left.equals(this.left);
	    	else if(!(t1.left == null && t1.left == null))
	    		equals = false;
	    	
	    	//Comparaison a droite
	    	if(t1.right != null && this.right != null)
	    		equals = t1.right.equals(this.right);
	    	else if(!(t1.right == null && t1.right == null))
	    		equals = false;
	    		
	    	return equals;		    
		}
		
		return false;
	}

	@Override
	public boolean equals(Constant c1) 
	{
		return false;
	}
}
