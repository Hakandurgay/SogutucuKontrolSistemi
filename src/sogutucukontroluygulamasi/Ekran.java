/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sogutucukontroluygulamasi;

/**
 *
 * @author Hakan Durgay
 */
public class Ekran implements IEkran {
    
    private static IEkran instance;

    public static IEkran EkranOlustur()
    {
            if(instance==null)
            instance=new Ekran();
            return instance;
    }
    private Ekran()
    {
        
    }
    @Override
    public void ekranaYaz(String mesaj) {
        System.err.println(mesaj);
    }

}
