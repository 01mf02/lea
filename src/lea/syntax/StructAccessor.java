package lea.syntax;
import lea.VariableInfo;
import lea.types.*;

public class StructAccessor extends Expression 
{
	public StructAccessor(Expression a1, Expression a2)
	{
		super(a1, a2);
	}
	
	public String toString()
	{
		return "StructAccess"+super.toString();
	}
	
	public String toVariableString()
	{
		String str = "";

		SyntaxTree st = this;
		
		while(st != null)
		{
			if(st.getLeft() != null)
			{
				if(st.getLeft() instanceof StructAccessor)
					str += ((StructAccessor)st.getLeft()).toVariableString() + ".";
				else if(st.getLeft() instanceof VariableLeaf)
					str += ((VariableLeaf)st.getLeft()).getName() + ".";
			}
			
			st = st.getRight();
			
			if(st != null)
			{
				if(st instanceof VariableLeaf)
					str += ((VariableLeaf)st).getName();
			}
		}

		return str;
	}
	
	public Type getType()
	{
		return this.getRight().getType();	
	}
	
	public void initializeVar()
	{
		SyntaxTree st = this;
		StructAccessor lastAccessor = this;
		
		while(st.getRight() != null)
		{			
			if(st instanceof StructAccessor)
				lastAccessor = (StructAccessor)st;
			
			st = st.getRight();
		}	
		if(st instanceof VariableLeaf)
		{
			VariableLeaf vl = (VariableLeaf)st;
			VariableInfo vi = lastAccessor.findInEnvironment(vl.getName());
			
			if(vi != null)
			{
				vi.initialize();
			}
		}
	}	
	
	public boolean isVarInitialized()
	{
		SyntaxTree st = this;
		StructAccessor lastAccessor = this;
		
		while(st.getRight() != null)
		{			
			if(st instanceof StructAccessor)
				lastAccessor = (StructAccessor)st;
			
			st = st.getRight();
		}	
		if(st instanceof VariableLeaf)
		{
			VariableLeaf vl = (VariableLeaf)st;
			VariableInfo vi = lastAccessor.findInEnvironment(vl.getName());
			
			if(vi != null)
			{
				return vi.initialized();
			}
		}
		
		return false;
	}
}
