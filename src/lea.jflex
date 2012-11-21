package org.tp;

import java_cup.runtime.*;
import java.io.*;

%%
%class TpLexer
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
%}

Identifier	= [a-zA-Z][a-zA-Z0-9_]*
LineTerminator	= \r|\n|\r\n
WhiteSpace	= {LineTerminator} | [ \t\f]
Integer		= [0-9]+
Float		= [0-9]*"."[0-9]+
String		= \"[^\"]*\"

%%
lea sy,bol
/* -------------------------------------------------
	Separateurs Operateurs
   ------------------------------------------------- */


"("		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.LPAR); }
")"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.RPAR); }
"{"		{System.out.print(yytext());/**/  return symbol(LeaSymbol.LBRACE); }
"}"		{System.out.print(yytext());/**/  return symbol(LeaSymbol.RBRACE); }
"["		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.LBRACKET); }
"]"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.RBRACKET); }
"&&"	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.AND); }
"||"	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.OR); }
"<"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.LT); }
">"		{System.out.print(yytext());/**/  return symbol(LeaSymbol.GT); }
"<="	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.LE); }
">="	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.GE); }
"!="	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.DIFF); }
"="		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.EQ); }
"+"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.PLUS); }
"-"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.MINUS); }
"*"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.MULT); }
"/"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.DIV); }
"%"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.MODULO); }
","		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.COMMA); }
";"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.SEMIC); }
":"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.COLON); }
":="	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.AFF); }
"."		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.SLOT); }
".."	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.TO); }


/* ----------------------- Types elementaires ------------------------------*/
"int"		{System.out.print(yytext());/**/  return symbol(LeaSymbol.INT); }
"float"  	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.FLOAT); }
"char"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.CHAR); }
"string"	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.STRING); }
"bool"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.BOOL); }

/* ----------------------- Autres types ------------------------------*/
"struct"  	{System.out.print(yytext());  return symbol(LeaSymbol.STRUCT); }
"list"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.LIST); }
"of"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.OF); }

/* ----------------------- Instructions ------------------------------*/
"if"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.IF); }
"else"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.ELSE); }
"case"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.CASE); }
"while"		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.WHILE); }
"repeat"	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.REPEAT); }

/* ----------------------- Boolean ------------------------------*/
"True"	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.TRUE); }
"False"	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.FALSE); }


/* -------------------------------------------------
	Variables, Entiers
   ------------------------------------------------- */

{Identifier}	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.IDENTIFIER, yytext()); }
{Integer}	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.INTEGER, yytext()); }
{Float}		{/*System.out.print(yytext());*/  return symbol(LeaSymbol.FLOATING, yytext()); }
{String}	{/*System.out.print(yytext());*/  return symbol(LeaSymbol.STRINGEXP, yytext().substring(1, yytext().length()-1)); }

/* -------------------------------------------------
	Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */
{WhiteSpace}                   { /*System.out.print(yytext());*/  /* ignore */ }

/* -------------------------------------------------
	Autres signes
   ------------------------------------------------- */
.	{ /* ignore */ }
