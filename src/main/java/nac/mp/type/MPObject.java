/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.mp.type;

import java.util.Collection;
import java.util.Set;
import nac.mp.EvalException;
import nac.mp.ObjectStore;
import nac.mp.ast.Scope;
import nac.mp.type.instance.MPBoolean;
import nac.mp.type.instance.MPRef;

/**
 *
 * @author user
 */
public abstract class MPObject implements Scope {

  protected final Creator creator;
  protected Scope parent;

  public MPObject(Scope parent, Creator creator) {
    this.creator = creator;
    this.parent = parent;
  }

  public Creator getCreator() {
    return creator;
  }

  @Override
  public Scope getParent() {
    return parent;
  }

  public abstract Type getType();

  public boolean getBoolean() {
    throw new EvalException("No boolean representation", getType());
  }

  public long getInt() {
    throw new EvalException("No int representation", getType());
  }

  public double getFloat() {
    throw new EvalException("No float representation", getType());
  }

  public String getString() {
    throw new EvalException("No string representation", getType());
  }

  public boolean isVoid() {
    return getType() == Type.VOID;
  }

  public MPRef getReference() {
    throw new EvalException("No reference", getType());
  }
  
  public boolean canBeRef(){
    return false;
  }

  public MPObject notEqual(MPObject right) {
    return MPBoolean.valueOf(this != right);
  }

  public MPObject isEqual(MPObject right) {
    return MPBoolean.valueOf(this == right);
  }

  public MPObject plus(MPObject right) {
    throw new EvalException("Not supported", getType(), " + ", right.getType());
  }

  public MPObject dash(MPObject right) {
    throw new EvalException("Not supported", getType(), " - ", right.getType());
  }

  public MPObject star(MPObject right) {
    throw new EvalException("Not supported", getType(), " * ", right.getType());
  }

  public MPObject slash(MPObject right) {
    throw new EvalException("Not supported", getType(), " / ", right.getType());
  }

  public MPObject lte(MPObject right) {
    throw new EvalException("Not supported", getType(), " <= ", right.getType());
  }

  public MPObject lt(MPObject right) {
    throw new EvalException("Not supported", getType(), " < ", right.getType());
  }

  public MPObject mte(MPObject right) {
    throw new EvalException("Not supported", getType(), " >= ", right.getType());
  }

  public MPObject mt(MPObject right) {
    throw new EvalException("Not supported", getType(), " > ", right.getType());
  }

  public MPObject la(MPObject right) {
    throw new EvalException("Not supported", getType(), " && ", right.getType());
  }

  public MPObject lo(MPObject right) {
    throw new EvalException("Not supported", getType(), " || ", right.getType());
  }

  public MPObject pa(MPObject right) {
    throw new EvalException("Not supported", getType(), " += ", right.getType());
  }

  @Override
  public MPObject getVar(String name, ObjectStore store) {
    throw new EvalException("getVar not supported", this); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean containsVar(String name, ObjectStore store) {
    throw new EvalException("containsVar not supported", this); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void declareVar(String name, MPObject defaultValue) {
    throw new EvalException("declarVar not supported", this); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void setVar(String name, MPObject value, ObjectStore store) {
    throw new EvalException("setVar not supported", this); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Set<String> getLocalVarKeys() {
    throw new EvalException("getLocalVarKeys not supported", this); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Collection<MPObject> getLocalVarValues() {
    throw new EvalException("getLocalVarValues not supported", this); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void setLocalVar(String name, MPObject value) {
    throw new EvalException("setLocalVar not supported", this); //To change body of generated methods, choose Tools | Templates.
  }
}
