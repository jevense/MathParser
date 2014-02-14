/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.mp.ast;

import nac.mp.EvalException;
import nac.mp.Scope;
import nac.mp.type.MPObject;

/**
 *
 * @author camomon
 */
public abstract class LValue implements Expression {

  public abstract void setValue(Scope scope, MPObject value) throws EvalException;
}