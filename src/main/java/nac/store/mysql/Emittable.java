/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.store.mysql;

/**
 *
 * @author user
 */
public interface Emittable {

  public void emit(StringBuilder query);
}
