/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sogutucukontroluygulamasi;

/**

 * @author Hakan Durgay
 */
public interface IObserver {
    public void subscribe();
    public String notifyChanges(String mesaj);
}
