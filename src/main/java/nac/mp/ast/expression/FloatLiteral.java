/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.mp.ast.expression;

import nac.mp.type.MPObject;
import nac.mp.ast.Expression;
import nac.mp.ast.Scope;
import nac.mp.type.natv.MPFloat;

/**
 *
 * @author natz
 */
public class FloatLiteral implements Expression {

  private final MPFloat value;

  public FloatLiteral(double value) {
    this.value = new MPFloat(value);
  }

  @Override
  public MPObject eval(Scope scope) {
    return value;
  }
}
