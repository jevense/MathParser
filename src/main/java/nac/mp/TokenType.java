/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.mp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author natz
 */
public enum TokenType {

  KW_VAR("var"),
  KW_FUNC("func"),
  KW_OBJECT("object"),
  KW_PRINT("print"),
  KW_INPUT("input"),
  KW_EXIT("exit"),
  KW_IF("if"),
  KW_ELSE("else"),
  KW_WHILE("while"),
  KW_RETURN("return"),
  KW_TRUE("true"),
  KW_FALSE("false"),
  KW_ASSERT("assert"),
  KW_CLASS("class"),
  KW_EXTENDS("extends"),
  KW_NEW("new"),
  PLUS("\\+"),
  MINUS("-"),
  STAR("\\*"),
  COMMENTS("//.*"),
  COMMENTS2("/*[\\s\\S]*\\*/"),
  SLASH("/"),
  LTE("<="),
  LT("<"),
  MTE(">="),
  MT(">"),
  EQUAL("=="),
  NOT_EQUAL("!="),
  ASSIGN("="),
  LBRACE("\\{"),
  RBRACE("\\}"),
  LPAREN("\\("),
  RPAREN("\\)"),
  LBRACKET("\\["),
  RBRACKET("\\]"),
  COLON(":"),
  COMMA(","),
  DOT("\\."),
  SEMICOLON(";"),
  FLOAT("\\d+\\.\\d+"),
  INT("\\d+"),
  STRING("\"[^\"]*\""),
  IDENTIFIER("[a-zA-Z_][a-zA-Z_\\d]*"),
  EOF(null);

  private final String regex;

  TokenType(String regex) {
    this.regex = regex;
  }

  public static TokenType[] getNonKeywords() {

    List<TokenType> l = new ArrayList<>();
    for (TokenType t : TokenType.values()) {
      if (!t.toString().contains("KW_")) {
        l.add(t);
      }
    }
    return l.toArray(new TokenType[1]);
  }

  public static Map<String, TokenType> getKeywordMap() {
    Map<String, TokenType> keywords = new HashMap<>();
    for (TokenType t : TokenType.values()) {
      if (t.toString().contains("KW_")) {
        keywords.put(t.regex, t);
      }
    }
    return keywords;
  }

  public static String getAllRegex() {

    String allRegex = "";
    boolean bar = false;

    for (TokenType t : TokenType.values()) {
      if (t != EOF && !t.toString().contains("KW_")) {
        if (bar) {
          allRegex += "|";
        }
        bar = true;
        allRegex += "(" + t.regex + ")";
      }
    }
    return allRegex;
  }
}
