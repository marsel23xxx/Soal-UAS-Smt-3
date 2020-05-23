package UAS;
import java.sql.*;
import java.io.*;
public class nomor_3{

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String yt,nama,jabatan;
        double gator,gaber,tunj,bns = 0,pj,absen,bpjs,gj;
        int pil,nik;
        Class.forName("org.sqlite.JDBC");
        Connection koneksi = DriverManager.getConnection("jdbc:sqlite:d:/SQLite/gaji.db");
        Statement stm = koneksi.createStatement();
        
            System.out.println("----------------------------------");
            System.out.println("      PROGRAM GAJI KARYAWAN       ");
            System.out.println("----------------------------------");
            System.out.println("1. Lihat Data ");
            System.out.println("2. Input Data ");
            System.out.println("3. Ubah Data ");
            System.out.println("4. Hapus Data ");
            System.out.println("5. Cari Data ");
            System.out.println("6. Keluar ");
            System.out.println("----------------------------------");
            System.out.println(" *Created By MR.BIRD(201843500038)");
            System.out.println("----------------------------------");
            System.out.print("Apakah Anda Ingin Memilih [y/t] : ");
           
            
            try{
                while((yt = br.readLine()).equalsIgnoreCase("y")){
                    System.out.print("Masukkan Pilihan Anda : ");
                    pil=Integer.parseInt(br.readLine());
                    
                switch(pil){
                    
                    case 1:
                        ResultSet rs = stm.executeQuery("select * from karyawan");
                        System.out.println("");
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("                                            Data Yang Dimiliki  (PT.MR BIRD Alone Company Programming :D)                                                              ");
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("id \t nama \t\t\t jabatan \t\t tunjangan \t\t bonus \t\t Gaji Kotor \t\t bpjs \t\t pajak \t\t gaji bersih ");
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        
                        while(rs.next()){
                            System.out.print(rs.getInt("no"));
                            System.out.print("\t"+rs.getString("nama"));
                            System.out.print(" \t\t "+rs.getString("jabatan"));
                            System.out.print(" \t\t "+rs.getDouble("tunjangan"));
                            System.out.print(" \t\t "+rs.getDouble("bonus"));
                            System.out.print(" \t "+rs.getDouble("Gaji_Kotor"));
                            System.out.print(" \t\t "+rs.getDouble("bpjs"));
                            System.out.print(" \t "+rs.getDouble("pajak"));
                            System.out.print(" \t "+rs.getDouble("Gaji_Bersih"));
                            System.out.println("");
                            
                        }
                        System.out.print("Ingin Menginput Data Lagi [y/t] : ");
                    break;
                    case 2:
                        System.out.println("");
                        System.out.println("-----------------------------");
                        System.out.println("  Anda Memilih Input Data    ");
                        System.out.println("-----------------------------");
                        System.out.print("Masukkan Nama Anda     : ");
                        nama = br.readLine();
                        System.out.print("Masukkan Jabatan Anda  : ");
                        jabatan = br.readLine();
                        System.out.print("Masukkan AbsenMu       : ");
                        absen = Integer.parseInt(br.readLine());
                        System.out.print("Masukkan Gaji Anda     : ");
                        gj = Integer.parseInt(br.readLine());
                        System.out.print("Masukkan ID Anda     : ");
                        nik = Integer.parseInt(br.readLine());
                        
                        bpjs = 85000;
                        pj=0.02*gj;
                        tunj=285000;
          
                        if(absen >= 28){
                            bns = 180000;
                        }
                        gator = gj+tunj+bns;
                        gaber = gator-pj-bpjs;
                        
                              
                        stm.executeUpdate("insert into karyawan (nama,jabatan,tunjangan,bonus,Gaji_Kotor,bpjs,pajak,Gaji_Bersih,no) values ('"+nama+"','"+jabatan+"','"+tunj+"','"+bns+"','"+gator+"','"+bpjs+"','"+pj+"','"+gaber+"','"+nik+"')");
                        System.out.print("Apakah Anda Ingin Menginput Lagi [y/t]: ");
                        
                    break;    
                    case 3:
                                System.out.println("");
                                System.out.println("----------------------------");
                                System.out.println("   ANDA MEMILIH UBAH DATA   ");
                                System.out.println("----------------------------");
                                System.out.print("Masukkan Nama Anda    : ");
                                nama = br.readLine();
                                System.out.print("Masukkan Jabatan Anda : ");
                                jabatan = br.readLine();
                                System.out.print("Id yang ingin diubah  : ");
                                nik = Integer.parseInt(br.readLine());
                                stm.executeUpdate("update karyawan set nama ='"+nama+"',jabatan='"+jabatan+"' where no='"+nik+"';");
                                System.out.println("Apakah Anda ingin Menginput Lagi : ");
                    break;
                    case 4:
                               System.out.println("");
                        
                               System.out.println("-----------------------------");
                               System.out.println("   ANDA MEMILIH HAPUS DATA   ");
                               System.out.println("-----------------------------");
                               System.out.print("Masukkan id yang ingin Dihapus : ");
                               nik = Integer.parseInt(br.readLine());
                               stm.executeUpdate("delete from karyawan where no='"+nik+"';");
                               System.out.println("Apakah Anda ingin Menginput Lagi : ");
                    break;
                    case 5:
                               System.out.println("");
                        
                               System.out.println("-----------------------------");
                               System.out.println("    ANDA MEMILIH CARI DATA   ");
                               System.out.println("-----------------------------");
                               System.out.print("Masukkan Id yang dicari : ");
                               nik = Integer.parseInt(br.readLine());
                               
                        rs = stm.executeQuery("select * from karyawan where no='"+nik+"';");                        
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("                                            Data Yang Dimiliki  (PT.MR BIRD Alone Company Programming )                                                              ");
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("id \t nama \t\t\t jabatan \t\t tunjangan \t\t bonus \t\t Gaji Kotor \t\t bpjs \t\t pajak \t\t gaji bersih ");
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        
                        while(rs.next()){
                            System.out.print(rs.getInt("no"));
                            System.out.print("\t"+rs.getString("nama"));
                            System.out.print(" \t\t "+rs.getString("jabatan"));
                            System.out.print(" \t\t "+rs.getDouble("tunjangan"));
                            System.out.print(" \t\t "+rs.getDouble("bonus"));
                            System.out.print(" \t "+rs.getDouble("Gaji_Kotor"));
                            System.out.print(" \t\t "+rs.getDouble("bpjs"));
                            System.out.print(" \t "+rs.getDouble("pajak"));
                            System.out.print(" \t "+rs.getDouble("Gaji_Bersih"));
                            System.out.println("");
                            
                        }
                               System.out.println("Apakah Anda ingin Menginput Lagi : ");
                    
                    break;    
                    case 6:
                               System.exit(0);
                    break;
                               
                    }
                }
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
        
        
    }
    
}
