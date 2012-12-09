package lea.syntax;

public class ListNode extends Expression 
{
	public ListNode(Expression a1)
	{
		super(a1, null);
	}
	
	public String toString()
	{
		return "ListNode"+super.toString();
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
