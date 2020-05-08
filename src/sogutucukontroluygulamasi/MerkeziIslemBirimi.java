/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sogutucukontroluygulamasi;

import java.util.Scanner;

/**
 *
 * @author Hakan Durgay
 */
public class MerkeziIslemBirimi {
    private IEkran ekran;
    private IAgArayuzu agArayuzu;
    private IObserver observer;
    private KullaniciRepositoryPostgreSql yeniKayit;
    private static MerkeziIslemBirimi instance;
    private boolean bayrak=true;
    Scanner giris;
     private MerkeziIslemBirimi()
    {
        ekran=Ekran.EkranOlustur();
        agArayuzu=AgArayuzu.AgArayuzuOlustur();
        yeniKayit=KullaniciRepositoryPostgreSql.KullaniciRepositoryPostgreSqlOlustur();
        observer=Observer.ObserverOlustur();
        giris=new Scanner(System.in);
    }
    public static MerkeziIslemBirimi MerkeziIslemBirimiOlustur()
    {
       if(instance==null)
           instance=new MerkeziIslemBirimi();
       return instance;
    }
    public void basla()
    {

        if(kullaniciDogrulama())
        {    
           islemYap();
        }
        else
        {
            System.err.println("Kullanici kaydi bulunmuyor.");
            yeniKayit.getKullaniciKaydiOlustur();    
            System.err.println("Yeniliklerden haberdan olmak istiyorsaniz mail adresini giriniz. e-h");
            String cevap=giris.nextLine();
            if(cevap.equals("e"))
                observer.subscribe();      
        }
    }
    private void islemYap()
    {
        int secim;
      	 do{
             anaMenuyuGoster();
             secim=giris.nextInt();
	     switch (secim) {
			case 1:
                              agArayuzu.sogutucuAc();
	        		break;
			case 2:
                               agArayuzu.sogutucuKapat();
	         		break;    
			case 3:
		               agArayuzu.sicaklikGonder();
				break;

			}
		}while(secim!=4);
    }
    private void anaMenuyuGoster()
    {
                
		ekran.ekranaYaz("******************************************");
		ekran.ekranaYaz("Ana Menu");
		ekran.ekranaYaz("1-Sogutucuyu Ac");
		ekran.ekranaYaz("2-Sogutucuyu Kapat");
                ekran.ekranaYaz("3-Sicaklik Getir");
		ekran.ekranaYaz("4-Cikis");
		ekran.ekranaYaz("Seciminiz:");
		ekran.ekranaYaz("******************************************");
                
    }

     private boolean kullaniciDogrulama()
    {
         String adSoyad;
         String sifre;
        
        KullaniciRepositoryPostgreSql dogrula=KullaniciRepositoryPostgreSql.KullaniciRepositoryPostgreSqlOlustur();
      
        System.err.println("Kullanici adi giriniz");
        adSoyad=giris.nextLine();
        System.err.println("Sifre giriniz");
        sifre=giris.nextLine();
        if(dogrula.getKullaniciKontrol(adSoyad, sifre))
        {
           System.err.println("Giris Basarili");
            return true;
        }
        else
        {      
            System.err.println("Giris Basarisiz");
            return false;
        }
    }
}
