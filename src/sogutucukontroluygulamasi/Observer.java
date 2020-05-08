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
public class Observer implements IObserver {

    private static IObserver instance;
  KullaniciRepositoryPostgreSql kayit;
    private Observer()
    {
         kayit=KullaniciRepositoryPostgreSql.KullaniciRepositoryPostgreSqlOlustur();
    }
    public static IObserver ObserverOlustur()
    {
       if(instance==null)
           instance=new Observer();
       return instance;
    }
    @Override
    public void subscribe() {
        
       
        kayit.getAboneKayit();
        
    }
    @Override
    public String notifyChanges(String mesaj) {
        return mesaj;
    }
   
}
