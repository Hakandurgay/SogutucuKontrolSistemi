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
public class AgArayuzu implements IAgArayuzu{

    IEyleyici eyleyici;
    ISıcaklıkAlgılayıcı sicaklik;
   private static IAgArayuzu instance;

    private AgArayuzu()
    {
        eyleyici=Eyleyici.EyleyiciOlustur();
        sicaklik=SıcaklıkAlgılayıcı.SicaklikOlustur();
    }
    public static IAgArayuzu AgArayuzuOlustur()
    {
       if(instance==null)
           instance=new AgArayuzu();
       return instance;
    }
    @Override
    
    public void sogutucuAc() {
        _sogutucuAc();
    }
    @Override
    public void sogutucuKapat() {
        _sogutucuKapat();
    }
    @Override
    public void sicaklikGonder() {
        _sicaklikGonder();
    }
    private void _sogutucuAc()
    {
        eyleyici.sogutucuAc();
        System.out.println("Sogutucu Acildi");   
    }
    private void _sogutucuKapat()
    {
        eyleyici.sogutucuKapat();
        System.out.println("Sogutucu Kapatildi");
    }
    private void _sicaklikGonder()
    {
          System.out.println("Sistemin Sicakligi "+sicaklik.sicaklikOku());
    }
}
