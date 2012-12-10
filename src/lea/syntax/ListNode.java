package lea.syntax;
import lea.types.*;

public class ListNode extends Expression 
{
	public ListNode(Expression a1, Expression a2)
	{
		super(a1, a2);
	}
	
	public String toString()
	{
		return "ListNode"+super.toString();
	}
	
	public Type getType()
	{		
		return new TupleType(this.getLeft().getType(), this.getRight().getType());
	}
}


/*



parser code  {: 
 public void report_fatal_error(String message, Object info) 
  {
  	java_cup.runtime.Symbol symb = (java_cup.runtime.Symbol)info;
  	Main.printError("Ligne : " + symb.left + " Colonne : " + symb.right + "   : " + message, 2);
  }
  
  public void report_error(String message, Object info) 
  {
  	java_cup.runtime.Symbol symb = (java_cup.runtime.Symbol)info;
  	Main.printError("Ligne : " + symb.left + " Colonne : " + symb.right + "   : " + message, 1);
  }
:};
*/
