/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.mp.ast.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nac.mp.ObjectStore;
import nac.mp.ast.Expression;
import nac.mp.ast.Scope;
import nac.mp.ast.TokenAwareExpression;
import nac.mp.type.Creator;
import nac.mp.type.MPObject;
import nac.mp.type.instance.MPFunc;

/**
 *
 * @author camomon
 */
public class NewOptsExpr extends TokenAwareExpression {

  private final Expression expression;
  private final List<Expression> args = new ArrayList<>();
  private final Map<String, Expression> opts = new HashMap<>();

  public NewOptsExpr(Expression expression) {
    this.expression = expression;
  }

  public List<Expression> getArgs() {
    return args;
  }

  public Map<String, Expression> getOpts() {
    return opts;
  }

  @Override
  public MPObject eval(Scope scope, ObjectStore store) {
    Creator creator = (Creator) expression.eval(scope, store);
    MPObject c;

    List<MPObject> argValues = new ArrayList<>();
    for (Expression exp : args) {
      argValues.add(exp.eval(scope, store));
    }
    Map<String, MPObject> optsValues = new HashMap<>();
    for (String key : opts.keySet()) {
      optsValues.put(key, opts.get(key).eval(scope, store));
    }

    c = creator.newInstance(store);
    if (c.containsVar("__init__", store)) {
      MPFunc ctor = (MPFunc) c.getVar("__init__", store);
      ctor.call(c, argValues, store);
    }
    return c;
  }
}
