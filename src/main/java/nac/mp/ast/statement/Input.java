/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.mp.ast.statement;

import java.util.Scanner;
import nac.mp.ObjectStore;
import nac.mp.ast.Scope;
import nac.mp.ast.TokenAwareExpression;
import nac.mp.type.MPObject;
import nac.mp.type.instance.MPString;

/**
 *
 * @author nathaniel
 */
public class Input extends TokenAwareExpression {

  private final Scanner scanner = new Scanner(System.in);
  private final String identifier;

  public Input(String identifier) {
    this.identifier = identifier;
  }

  @Override
  public MPObject eval(Scope scope, ObjectStore store) {
    if (scope.containsVar(identifier, store)) {
      scope.setVar(identifier, new MPString(scanner.nextLine()), store);
    } else {
      scope.declareVar(identifier, new MPString(scanner.nextLine()));
    }
    return null;
  }
}
