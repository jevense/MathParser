/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.mp.type;

import nac.mp.store.Creator;
import nac.mp.EvalException;
import nac.mp.ast.Scope;
import nac.mp.store.mysql.MySQLColumn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author camomon
 */
public class MPAttribute extends MPObject implements Creator {
  
  private static final Logger log = LogManager.getLogger(MPAttribute.class);
  private final String type;
  private final String name;
  
  public MPAttribute(Scope parent, String type, String name) {
    super(parent, null);
    this.type = type;
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  @Override
  public MPObject.Hint getHint() {
    return MPObject.Hint.ATTRIBUTE;
  }
  
  @Override
  public String toString() {
    return "attr:" + name;
  }
  
  @Override
  public MPObject notEqual(MPObject right) {
    switch (right.getHint()) {
      case ATTRIBUTE:
        return new MPBoolean(this != right);
    }
    return new MPBoolean(true);
  }
  
  public MySQLColumn getColumn() {
    MySQLColumn.ColumnType ct;
    MPModel refParent = null;
    switch (type) {
      case "string":
        ct = MySQLColumn.ColumnType.STRING;
        break;
      case "int":
        ct = MySQLColumn.ColumnType.INTEGER;
        break;
      case "bool":
        ct = MySQLColumn.ColumnType.BOOLEAN;
        break;
      case "float":
        ct = MySQLColumn.ColumnType.FLOAT;
        break;
      default:
        ct = MySQLColumn.ColumnType.REFERENCE;
        log.debug("type {}", type);
        refParent = (MPModel) parent.getVar(type);
        break;
    }
    MySQLColumn column = new MySQLColumn(refParent, name, ct);
    return column;
  }
  
  @Override
  public MPObject newInstance() throws EvalException {
    switch (type) {
      case "string":
        return new MPVoid();
      case "int":
        return new MPVoid();
      case "bool":
        return new MPVoid();
      case "float":
        return new MPVoid();
      case "list":
        return new MPVoid();
      default:
        return new MPVoid();
    }
  }
}
