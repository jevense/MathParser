/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.mp.type;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import nac.mp.EvalException;
import nac.mp.ast.Scope;
import nac.mp.ast.statement.ModelDecl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author camomon
 */
public class MPModel extends MPObject implements Creator {

  private static final Logger log = LogManager.getLogger(MPModel.class);
  private final ModelDecl modelDecl;
  private final Map<String, MPAttribute> attributes = new LinkedHashMap<>();

  public MPModel(Scope parent, ModelDecl modelDecl) {
    super(parent, null);
    this.modelDecl = modelDecl;
  }

  public String getName() {
    return modelDecl.getName();
  }

  @Override
  public Hint getHint() {
    return Hint.MODEL;
  }

  @Override
  public String toString() {
    return "model:" + modelDecl.getName();
  }

  public Map<String, MPAttribute> getAttributes() {
    return attributes;
  }
//
//  @Override
//  public MPObject isEqual(MPObject right) {
//    return new MPBoolean(((MPModel) right).getName().equals(getName()));
//  }
//
//  @Override
//  public MPObject notEqual(MPObject right) {
//    return new MPBoolean(!((MPModel) right).getName().equals(getName()));
//  }

  @Override
  public MPObject newInstance() throws EvalException {
    MPObject obj = new MPModelObj(parent, this);
    for (MPAttribute attr : attributes.values()) {
      obj.declareLocalVar(attr.getName(), attr.newInstance());
    }
    return obj;
  }

  @Override
  public void setLocalVar(String name, MPObject value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void setLocalVars(Map<String, MPObject> vars) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void declareLocalVar(String name, MPObject defaultValue) throws EvalException {
    attributes.put(name, (MPAttribute) defaultValue);
  }

  @Override
  public Set<String> getLocalVarKeys() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Collection<MPObject> getLocalVarValues() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean containsVar(String name) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public MPObject getVar(String name) {
    return attributes.get(name);
  }

  @Override
  public void setVar(String name, MPObject value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
