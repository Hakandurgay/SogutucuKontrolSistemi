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
public class Kullanici {
    private int id;
    private String adSoyad;
    private String sifre;

    public Kullanici(int id,String adSoyad,String sifre)
    {
        this.id=id;
        this.adSoyad=adSoyad;
        this.sifre=sifre;
        
    }
    public String getAdSoyad()
    {
        return this.adSoyad;
    }
    public String getSifre()
    {
        return this.sifre;
    }
}
