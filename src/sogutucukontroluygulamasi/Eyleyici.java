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
public class Eyleyici implements IEyleyici{
    
    private boolean sogutucuDurumu;
    private static IEyleyici instance;

    
    private Eyleyici()
    {
        sogutucuDurumu=false;
    }
    
    public static IEyleyici EyleyiciOlustur()
    {
       if(instance==null)
           instance=new Eyleyici();
       return instance;
    }
    @Override
    
    public boolean sogutucuAc() {
       return _sogutucuAc();
    }

    @Override
    public boolean sogutucuKapat() {
    return _sogutucuKapat();
    }
    private boolean _sogutucuAc()
    {
        sogutucuDurumu=true;
       return sogutucuDurumu;
    }
    private boolean _sogutucuKapat()
    {
         sogutucuDurumu=false;
     return sogutucuDurumu;
    }
    
}
