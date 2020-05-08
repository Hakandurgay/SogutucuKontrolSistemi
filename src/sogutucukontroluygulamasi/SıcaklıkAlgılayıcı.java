/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sogutucukontroluygulamasi;

import java.util.Random;

/**
 *
 * @author Hakan Durgay
 */
public class SıcaklıkAlgılayıcı implements ISıcaklıkAlgılayıcı {
    
    private int sicaklik;
    private IObserver observer;
    private static ISıcaklıkAlgılayıcı instance;
    Random rand;
   public static ISıcaklıkAlgılayıcı SicaklikOlustur()
   {
       if(instance==null)
           instance=new SıcaklıkAlgılayıcı();
       return instance;
   }
    private SıcaklıkAlgılayıcı()
    {
        sicaklik=0;
        rand=new Random();
        observer=Observer.ObserverOlustur();
    }
    
    @Override
    
    public String sicaklikOku() {
       
       return _sicaklikOku();
    }
    private String _sicaklikOku()
    {
         sicaklik=rand.nextInt(100);
        if(sicaklik>50)
           return observer.notifyChanges("Sicaklik Degeri Yuksek. Sogutucuyu Bakima Gonderiniz");           
        else
        {
            String strSicaklik=String.valueOf(sicaklik);
            return strSicaklik;
        }
    }

    
}
