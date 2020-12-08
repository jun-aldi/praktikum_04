
package datamahasiswa;

//import libraries
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataArray {
    //Buat ArrayList
    ArrayList<String> nama = new ArrayList<String>();
    ArrayList<String> nim = new ArrayList<String>();
    ArrayList<Date> tgl = new ArrayList<Date>();
    ArrayList<Integer> gender = new ArrayList<>();
    ArrayList<Integer> found = new ArrayList<>();


    public void menu() throws ParseException{
        //Menu Progam
        System.out.println("----------");
        System.out.println("Menu");
        System.out.println("----------");
        System.out.println("1. Tambah Data");
        System.out.println("2. Hapus Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Tampil Data");
        System.out.println("5. Keluar");
        Scanner in = new Scanner(System.in);
        System.out.print("Pilih no menu : ");
        String menu = in.nextLine();
        //pilih menu
        switch (menu){
            case "1":
                addData();
                break;
            case "2":
                deleteData();
                break;
            case "3":
                cariData();
                break;
            case "4":
                showData();
                break;
            case "5":
                System.exit(0);
            default:
                menu();
        }
    }
    void addData() throws ParseException{
        //method menambahkan data data ke arrayList masing-masing
        int y = 0;
        while (y==0){
        System.out.println("---------");
        System.out.println("Tambah Data");
        System.out.println("-------------");
        //masukan Nama
        Scanner in = new Scanner(System.in);
        int a = 0;
            System.out.println("Masukan Nama Lengkap : ");
            String innama = in.nextLine();
            //masukan nama ke araayList
            nama.add(innama);
            //Masukan nim
            int i = 0;
            while (i == 0){           
                System.out.println("Masukan NIM : ");
                String innim = in.nextLine();
                Pattern p = Pattern.compile("^[A-Z0-9]{8}$"); //regex input NIM
                Matcher m = p.matcher(innim);
                //Cek nim sesuai dengan pattern
                if (m.matches()) {
                    //cek nim belum dipakai
                    if (nim.contains(innim)){
                        System.out.println("NIM sudah terpakai !");
                        i = 0;
                    }
                    else {
                        //masukan ke ArayList
                        nim.add(innim);
                        i = 1;
                    }

                } else {
                    //format tidak sesuai patern
                    System.out.printf("%s format tidak cocok.", innim);
                    System.out.println("");
                    i = 0;
                }  
            }
            //Masukan tanggal lahir
            i=0;
            while (i==0){    
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                //format tanggal yang dipakai (hari-bulan-tahun) contoh : 01-01-2000
                Scanner sc = new Scanner(System.in);                
                System.out.print("Masukan Tanggal Lahir (dd-mm-yyyy): ");
                String str = sc.nextLine();
                Pattern p = Pattern.compile("^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$"); //regex input untuk tanggak
                Matcher m = p.matcher(str);
                //cek inputan sesuai patern
                if (m.matches()) {     //jika sesuai patern
                    try {
                       Date date = sdf.parse(str); 
                       tgl.add(date);
                       i=1;
                    } catch (ParseException e) { 
                       System.out.println("Format Tanggal salah");// jika format tanggal
                       i = 0;
                    } 
                    i = 1;
                } else {
                    System.out.printf("Format tidak cocok"); //format input tidak sesuai
                    System.out.println("");
                    i = 0;
                } 
   
            }
            
            i=0;
            //Masukan jenis kelamin
            while (i==0){
            System.out.println("Masukan jenis kelamin  (0 = Laki-Laki / 1 = Perempuan: ");
            String in_gender = in.nextLine();
            Pattern p = Pattern.compile("[0-1]?"); //regex input untuk 0 / 1
            Matcher m = p.matcher(in_gender);
            if (m.matches()) {
                  int in_gender2 = Integer.parseInt(in_gender);
                  gender.add(in_gender2);                 
                  i = 1;
            } else {
                  System.out.printf("format tidak cocok.");
                  System.out.println("");
                  i = 0;
                }
            }
            //ulangi perulangan mengisi data
            System.out.println("Ulangi mengisi data (y / n) : ");
            String loop = in.nextLine();
            String loop2 = loop.toLowerCase();
            if (loop2.equals("y") || loop2.equals("n")){
                if (loop2.equals("y")){
                     addData();
                     break;
                } else{
                     menu();
                     break;
                }
            }else{
                System.out.println("format Tidak cocok");
            }
                

        }
    }
    
    void deleteData()throws ParseException{
        int y = 0;
        System.out.println("---------");
        System.out.println("Hapus Data");
        System.out.println("-------------");
        //Masukan nim yang akan dihapus @Juniar
        int i = 0;
        while (i == 0){           
        Scanner in = new Scanner(System.in);
        System.out.println("Masukan NIM : ");
        String look_nim = in.next();
        Pattern p = Pattern.compile("^[A-Z0-9]{8,8}$"); //regex input @Juniar
            Matcher m = p.matcher(look_nim);
               if (m.matches()) {
                   int index_look = nim.indexOf(look_nim);
                   if(index_look == -1){
                       System.out.println(look_nim+" Tidak Ditemukan");
                       break;

                        
                   }else{
                       System.out.println("Data NIM "+look_nim+" Telah dihapus !");
                       //penghapusan data di arrayList
                       nama.remove(index_look);
                       nim.remove(index_look);
                       tgl.remove(index_look);
                       gender.remove(index_look);
                   }

                       i=1;
               } else {
                   i=0;
                }
        }
        i=0;
        while (i==0){
            System.out.println("Ulangi menghapus data (y / n) : ");
            Scanner in = new Scanner(System.in);
            String loop = in.nextLine();
            String loop2 = loop.toLowerCase();
            if (loop2.equals("y") || loop2.equals("n")){
                if (loop2.equals("y")){
                    deleteData();
                    break;
                } else{
                    menu();
                    break;
                }
            }else{
                i = 0;
            }

        }

    }
    
    void cariData()throws ParseException{
            System.out.println("--------------");
            System.out.println("Cari Data ");
            System.out.println("---------------");
            System.out.println("Menu : ");
            System.out.println("a. Gender");
            System.out.println("b. NIM");
            System.out.println("c. Ke Menu");
            Scanner in = new Scanner(System.in);
            System.out.println("Pemilihan berdasarkan : ");
            String method_cari = in.nextLine();
            String method_cari2 = method_cari.toLowerCase();
            //pencarian berdasarkan gender
            if (method_cari2.equals("a")) {
                    System.out.println("Masukan jenis gender (0 = Laki-Laki / 1 = Perempuan)");
                    String cari_gender = in.nextLine();
                    Pattern p = Pattern.compile("[0-1]?"); //regex input
                    Matcher m = p.matcher(cari_gender);
                    if (m.matches()) {
                        int i;
                        int cari_gender2 = Integer.parseInt(cari_gender);
                        ArrayList<Integer> matchingIndices = new ArrayList<>();
                        int x = 1;

                        for (i = 0; i < gender.size(); i++) {
                            int element = gender.get(i);
                            if (cari_gender2 == (element)) {
                                System.out.println("No : " + x);
                                System.out.println("Nama            : " + nama.get(i));
                                System.out.println("NIM             : " + nim.get(i));
                                //format date ke string
                                Format formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                                String s = formatter.format(tgl.get(i));
                                DateFormat parser = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                                Date date2 = parser.parse(s);
                                DateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyy");
                                System.out.println("Tanggal Lahir   : " +formatter2.format(date2));
                                //replace gender dari 1/0 atau laki-laki / perempuan
                                String gender_str1 = Integer.toString(gender.get(i));
                                if (gender_str1.equals("0")){
                                    System.out.println("Jenis Kelamin   : "+gender_str1.replaceFirst("0(.*)", "laki-Laki"));
                                }else{
                                    System.out.println("Jenis Kelamin   : "+gender_str1.replaceFirst("1(.*)","Perempuan"));
                                }
                                System.out.println("");

                                found.add(1);
                                x = x + 1;
                            }
                            else if (cari_gender2 != (element)){

                            }
                        }
                    }
                    else if (!found.contains(1)){
                        System.out.println("Tidak ditemukan");
                        cariData();

                    }
                    else {
                        System.out.println("format salah");
                        cariData();
                    }

            }
            else if (method_cari2.equals("b")) {
                //pencarian berdasarkan NIM
                int i = 0;
                while (i == 0){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Masukan NIM : ");
                    String look_nim = sc.next();
                    Pattern p = Pattern.compile("^[A-Z0-9]{1,8}$"); //regex input
                    Matcher m = p.matcher(look_nim);
                    if (m.matches()) {
                        int index_look = nim.indexOf(look_nim);
                        if(index_look == -1){
                            System.out.println(look_nim+" Tidak Ditemukan");
                            cariData();


                        }else{
                            System.out.println("Data NIM "+look_nim+" Telah ditemukan !");
                            System.out.println("Nama            : "+ nama.get(index_look));
                            System.out.println("NIM             : "+nim.get(index_look));
                            Format formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                            String s = formatter.format(tgl.get(index_look));
                            DateFormat parser = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                            Date date2 = parser.parse(s);
                            DateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyy");
                            System.out.println("Tanggal Lahir   : " +formatter2.format(date2));
                            String gender_str1 = Integer.toString(gender.get(index_look));
                            if (gender_str1.equals("0")){
                                String genderReplaceString2=gender_str1.replaceFirst("0(.*)","Laki-Laki");
                                System.out.println("Jenis Kelamin   : "+genderReplaceString2);
                            }else{
                                String genderReplaceString2=gender_str1.replaceFirst("1(.*)","Perempuan");
                                System.out.println("Jenis Kelamin   : "+genderReplaceString2);
                            }

                        }
                        i=1;
                        cariData();
                    } else {
                        i=0;
                        cariData();
                    }


                }


            }
            else if (method_cari2.equals("c")){
                menu();

            }
            else{
                cariData();
            }
            cariData();
    }

    void showData() throws ParseException {
        int u = 1;
        int i;
        System.out.println("--------------------");
        System.out.println("Tampilkan semua Data");
        System.out.println("--------------------");
        //menampilkan jumlah total mahasiswa yang diinputkan
        System.out.println("Jmlh Mahasiswa  : "+nama.size());
        System.out.println("********************");
        //Perulangan sesuai size dari size ArrayList nama
        for (i = 0; i < nama.size(); i++){
            System.out.println("No : " + u);
            System.out.println("Nama            : " + nama.get(i));
            System.out.println("NIM             : " + nim.get(i));
            Format formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
            String s = formatter.format(tgl.get(i));
            DateFormat parser = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
            Date date2 = parser.parse(s);
            DateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyy");
            System.out.println("Tanggal Lahir   : " +formatter2.format(date2));
            String gender_str1 = Integer.toString(gender.get(i));
            if (gender_str1.equals("0")){
                System.out.println("Jenis Kelamin   : "+gender_str1.replaceFirst("0(.*)", "laki-Laki"));
            }else{
                System.out.println("Jenis Kelamin   : "+gender_str1.replaceFirst("1(.*)","Perempuan"));
            }
            System.out.println("");
            u = u+1;
        }
        menu();

    }

}
                
    

