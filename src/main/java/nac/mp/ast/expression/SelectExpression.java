/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.mp.ast.expression;

import nac.mp.ObjectStore;
import nac.mp.ast.Expression;
import nac.mp.ast.Scope;
import nac.mp.ast.TokenAwareExpression;
import nac.mp.type.MPModel;
import nac.mp.type.MPObject;
import nac.mp.type.instance.QueryPredicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author nathaniel
 */
public class SelectExpression extends TokenAwareExpression {

  private static final Logger log = LogManager.getLogger(SelectExpression.class);
  private final Expression modelName;
  private final Expression whereBlock;

  public SelectExpression(Expression modelName, Expression whereBlock) {
    this.modelName = modelName;
    this.whereBlock = whereBlock;
  }
  
  @Override
  public MPObject eval(Scope scope, ObjectStore store) {
    return store.select((MPModel) modelName.eval(scope, store), new QueryPredicate(scope, whereBlock));
  }
}
