package generated;

import java_cup.runtime.*;
import java.io.*;
import lea.*;

%%
%class LeaLexer
%public
%line
%column
%cupsym LeaSymbol
%cup

%{
private Symbol symbol (int type) {
    return new Symbol (type, yyline, yycolumn);
}

private Symbol symbol (int type, Object value) {
    return new Symbol (type, yyline, yycolumn, value);
}

public int getLine() { return yyline+1; }
public int getColumn() { return yycolumn+1; }
%}

Identifier	= [a-zA-Z][a-zA-Z0-9_]*
LineTerminator	= \r|\n|\r\n
WhiteSpace	= {LineTerminator} | [ \t\f]
Integer		= [0-9]+
Float		= [0-9]*"."[0-9]+
String		= \"[^\"]*\"
Char		= \'[^\']\'

%%

/* -------------------------------------------------
	Separateurs Operateurs
   ------------------------------------------------- */


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
"="		{   return symbol(LeaSymbol.EQ); }
"+"		{  return symbol(LeaSymbol.PLUS); }
"-"		{  return symbol(LeaSymbol.MINUS); }
"*"		{  return symbol(LeaSymbol.MULT); }
"/"		{  return symbol(LeaSymbol.DIV); }
"%"		{  return symbol(LeaSymbol.MODULO); }
","		{  return symbol(LeaSymbol.COMMA); }
";"		{   return symbol(LeaSymbol.SEMIC); }
":"		{  return symbol(LeaSymbol.COLON); }
":="	{  return symbol(LeaSymbol.AFF); }
"."		{  return symbol(LeaSymbol.SLOT); }
".."	{  return symbol(LeaSymbol.TO); }


/* ----------------------- Types elementaires ------------------------------*/
"int"		{  return symbol(LeaSymbol.INT); }
"float"  	{  return symbol(LeaSymbol.FLOAT); }
"char"		{  return symbol(LeaSymbol.CHAR); }
"string"	{  return symbol(LeaSymbol.STRING); }
"bool"		{  return symbol(LeaSymbol.BOOL); }

/* ----------------------- Autres types ------------------------------*/
"struct"  	{  return symbol(LeaSymbol.STRUCT); }
"list"		{  return symbol(LeaSymbol.LIST); }
"of"		{  return symbol(LeaSymbol.OF); }

/* ----------------------- Instructions ------------------------------*/
"if"		{  return symbol(LeaSymbol.IF); }
"else"		{  return symbol(LeaSymbol.ELSE); }
"case"		{  return symbol(LeaSymbol.CASE); }
"while"		{  return symbol(LeaSymbol.WHILE); }
"repeat"	{  return symbol(LeaSymbol.REPEAT); }
"for"		{  return symbol(LeaSymbol.FOR); }

/* ----------------------- Constantes ------------------------------*/
"True"	{  return symbol(LeaSymbol.TRUEEXP); }
"False"	{  return symbol(LeaSymbol.FALSEEXP); }
//"null"  {  return symbol(LeaSymbol.FALSE); }

/* ----------------------- Mots réservé ------------------------------*/
"function"	{  return symbol(LeaSymbol.FUNCTION); }
"procedure"	{  return symbol(LeaSymbol.PROCEDURE); }
"return" 	{  return symbol(LeaSymbol.RETURN); }
"in"  		{  return symbol(LeaSymbol.IN); }

/* -------------------------------------------------
	Variables, Entiers
   ------------------------------------------------- */

{Identifier}	{   return symbol(LeaSymbol.IDENTIFIER, yytext()); }
{Integer}	{   return symbol(LeaSymbol.INTEGER, yytext()); }
{Float}		{  return symbol(LeaSymbol.FLOATEXP, yytext()); }
{String}	{  return symbol(LeaSymbol.STRINGEXP, yytext().substring(1, yytext().length()-1)); }
{Char}			{  return symbol(LeaSymbol.CHAREXP, yytext().substring(1, yytext().length()-1)); }

/* -------------------------------------------------
	Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */
{WhiteSpace}                   {   /* ignore */ }

/* -------------------------------------------------
	Autres signes
   ------------------------------------------------- */
.	{ /* ignore */ }
