package generated;

import java_cup.runtime.*;
import java.io.*;
import generated.*;
import lea.*;

%%
%class LeaLexer
%public
%line
%column
%cupsym LeaSymbol
%cup

%state IN_STRING
%state COMMENT

%{
	StringBuffer str = new StringBuffer();
  
	private Symbol symbol (int type) {
		return new Symbol (type, yyline, yycolumn);
	}

	private Symbol symbol (int type, Object value) {
		return new Symbol (type, yyline, yycolumn, value);
	}

	public boolean hasCompileErrors = false;

	public void printError(String message, int level) {
		String prefix = "";

		switch (level) {
		case 0:
			prefix += "Warning";
			break;
		case 1:
			prefix += "Error";
			hasCompileErrors = true;
			break;
		case 2:
			prefix += "Fatal error";
			hasCompileErrors = true;
			break;
		default:
			break;
		}

		if (level >= 0 && level <= 2)
			prefix += " at line " + (yyline + 1) + ", column " + (yycolumn + 1)
					+ ": ";

		System.out.println(prefix + message);
	}
%}

%eof{ 
	if(yystate() == IN_STRING)
		printError("End string character not found", 2);
	else if(yystate() == COMMENT)
		printError("End comment character not found", 2);
%eof}

Identifier	= [a-zA-Z][a-zA-Z0-9_]*
LineTerminator	= \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace	= {LineTerminator} | [ \t\f]
Integer		= [0-9]+
Float		= [0-9]*"."[0-9]+
Char		= \'[^\']\'
True		= true
False		= false

SingleLineComment = "//".*

BeginString = \"
EndString = \"

BeginComment = "/*"
EndComment = "*/"

%%

/* -------------------------------------------------
	Separateurs Operateurs
   ------------------------------------------------- */

<YYINITIAL>
{
	"("		{  return symbol(LeaSymbol.LPAR); }
	")"		{  return symbol(LeaSymbol.RPAR); }
	"{"		{  return symbol(LeaSymbol.LBRACE); }
	"}"		{  return symbol(LeaSymbol.RBRACE); }
	"["		{  return symbol(LeaSymbol.LBRACKET); }
	"]"		{  return symbol(LeaSymbol.RBRACKET); }
	"&&"	{  return symbol(LeaSymbol.AND); }
	"||"	{  return symbol(LeaSymbol.OR); }
	"<"		{  return symbol(LeaSymbol.LT); }
	">"		{  return symbol(LeaSymbol.GT); }
	"<="	{  return symbol(LeaSymbol.LE); }
	">="	{  return symbol(LeaSymbol.GE); }
	"!="	{  return symbol(LeaSymbol.DIFF); }
	"="		{  return symbol(LeaSymbol.EQ); }
	"+"		{  return symbol(LeaSymbol.PLUS); }
	"-"		{  return symbol(LeaSymbol.MINUS); }
	"*"		{  return symbol(LeaSymbol.MULT); }
	"/"		{  return symbol(LeaSymbol.DIV); }
	"%"		{  return symbol(LeaSymbol.MODULO); }
	","		{  return symbol(LeaSymbol.COMMA); }
	";"		{  return symbol(LeaSymbol.SEMIC); }
	":"		{  return symbol(LeaSymbol.COLON); }
	":="	{  return symbol(LeaSymbol.AFF); }
	"."		{  return symbol(LeaSymbol.SLOT); }
	//".."	{  return symbol(LeaSymbol.TO); }
	
	
	/* ----------------------- Types elementaires ------------------------------*/
	"int"		{  return symbol(LeaSymbol.INT); }
	"float"  	{  return symbol(LeaSymbol.FLOAT); }
	"char"		{  return symbol(LeaSymbol.CHAR); }
	"string"	{  return symbol(LeaSymbol.STRING); }
	"bool"		{  return symbol(LeaSymbol.BOOL); }
	
	/* ----------------------- Autres types ------------------------------*/
	"enum"  	{  return symbol(LeaSymbol.ENUM); }
	"struct"  	{  return symbol(LeaSymbol.STRUCT); }
	"list"		{  return symbol(LeaSymbol.LIST); }
	"of"		{  return symbol(LeaSymbol.OF); }
	
	/* ----------------------- Instructions ------------------------------*/
	"if"		{  return symbol(LeaSymbol.IF); }
	"else"		{  return symbol(LeaSymbol.ELSE); }
	"case"		{  return symbol(LeaSymbol.CASE); }
	"while"		{  return symbol(LeaSymbol.WHILE); }
	"repeat"	{  return symbol(LeaSymbol.REPEAT); }
	
	/* ----------------------- Constantes ------------------------------*/
	{True}	{ return symbol(LeaSymbol.TRUEEXP);		 }
	{False}	{  return symbol(LeaSymbol.FALSEEXP); }
	
	/* ----------------------- Mots réservé ------------------------------*/
	"function"	{  return symbol(LeaSymbol.FUNCTION); }
	"procedure"	{  return symbol(LeaSymbol.PROCEDURE); }
	"return" 	{  return symbol(LeaSymbol.RETURN); }
	
	/* -------------------------------------------------
		Variables, Entiers
	   ------------------------------------------------- */
	
	{Identifier}	{   return symbol(LeaSymbol.IDENTIFIER, yytext()); }
	{Integer}	{   return symbol(LeaSymbol.INTEGER, yytext()); }
	{Float}		{  return symbol(LeaSymbol.FLOATEXP, yytext()); }
	{Char}			{  return symbol(LeaSymbol.CHAREXP, yytext().substring(1, yytext().length()-1)); }
	
	/* ---------- Commentaires & Strings ------------- */
  	{BeginString}	{str.setLength(0); yybegin(IN_STRING);}
  	{BeginComment}	{str.setLength(0); str.append(yytext()); yybegin(COMMENT);}
}

<IN_STRING> 
{
  "\\\""						{ str.append( yytext() ); }
  {EndString}                   { yybegin(YYINITIAL);
									return symbol(LeaSymbol.STRINGEXP, str.toString());
                                }
  {InputCharacter}				{ str.append( yytext() ); }
}


/* -------------------------------------------------
	Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */
   
<COMMENT>
{
	{EndComment}		{ 	yybegin(YYINITIAL);
                        }
	.					{}
	{LineTerminator}	{}
}
<YYINITIAL>
{
	{WhiteSpace} 			{/*  ignore  */}
	{SingleLineComment}	 	{}
}

/* -------------------------------------------------
	Autres signes
   ------------------------------------------------- */
<YYINITIAL> .	{ /* ignore */ }
