/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sogutucukontroluygulamasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hakan Durgay
 */
public class KullaniciRepositoryPostgreSql {

    private String sifre;
    private String adSoyad;
    ArrayList<Kullanici> kullanicilar;
    private static KullaniciRepositoryPostgreSql instance;

    private KullaniciRepositoryPostgreSql() {
        kullanicilar = new ArrayList<Kullanici>();
    }

    public static KullaniciRepositoryPostgreSql KullaniciRepositoryPostgreSqlOlustur() {
        if (instance == null) {
            instance = new KullaniciRepositoryPostgreSql();
        }
        return instance;
    }

    
    private Connection baglan() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SogutucuSistemi", "postgres", "hkn5773986");
            if (conn != null) {
                System.out.println("Veritabanina baglandi");
            } else {
                System.err.println("veritabanina bagalanamadi");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void getKullaniciKaydiOlustur() {
        this.setKullaniciKaydiOlustur();
    }

    private void setKullaniciKaydiOlustur() {
        Connection conn = null;
        try {

            Scanner giris = new Scanner(System.in);

            System.err.println("Kullanici kaydi olusturmak icin kullanici adi ve sifre giriniz giriniz");
            String adSoyad = giris.nextLine();
            String sifre = giris.nextLine();

            conn = this.baglan();

            String sql = "INSERT INTO  \"personeller\" (\"personel_ad_soyad\",\"personel_sifre\") VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, adSoyad);
            pstmt.setString(2, sifre);

            System.err.println("Kullanici kaydi Basarili");

            pstmt.executeUpdate();

            conn.close();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAboneKayit() {
        this.setAboneKayit();
    }

    private void setAboneKayit() {
        Connection conn = null;
        try {
            Scanner giris = new Scanner(System.in);

            System.err.println("Abone olmak icin mail adresini giriniz");
            String mail = giris.nextLine();

            conn = this.baglan();

            String sql = "INSERT INTO  \"aboneler\" (\"abone_ad\") VALUES(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, mail);

            System.err.println("Abone kaydi Basarili");

            pstmt.executeUpdate();

            conn.close();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Kullanici kullaniciKontrol() {

        String sql = "SELECT * FROM \"personeller\"";

        Connection conn = this.baglan();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            conn.close();

            while (rs.next()) {
                int id = rs.getInt("id");
                String adSoyad = rs.getString("personel_ad_soyad");
                String sifre = rs.getString("personel_sifre");

                Kullanici kullanici = new Kullanici(id, adSoyad, sifre);
                kullanicilar.add(kullanici);
                for (Kullanici k : kullanicilar) {
                    if (kullanici.getAdSoyad().equals(this.adSoyad) && kullanici.getSifre().equals(this.sifre)) {
                        return kullanici;
                    }
                }
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean getKullaniciKontrol(String adSoyad, String sifre) {
        this.adSoyad = adSoyad;
        this.sifre = sifre;
        if (this.kullaniciKontrol() != null) {
            return true;
        } else {
            return false;
        }
    }
}
