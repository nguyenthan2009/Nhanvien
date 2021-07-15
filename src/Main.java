import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NhanVien[] nhanVien = new NhanVien[5];
        NhanVien[] newNhanVien = new NhanVien[nhanVien.length + 1];
        nhanVien[0] = new NhanVienFullTime("C4927", "HẢI", 023232323, "SSS.COM", 343, 32, 3232323);
        nhanVien[1] = new NhanVienFullTime("C4232", "TUẤN", 02323452, "ZZZ.COM", 200, 22, 2323232);
        nhanVien[2] = new NhanVienFullTime("C4928", "Phương", 023232232, "XXX.COM", 323, 35, 2323231);
        nhanVien[3] = new NhanVienPartTime("C2842", "Mai", 223232323, "phimmoi.com", 50);
        nhanVien[4] = new NhanVienPartTime("C2343", "KIN", 42343434, "ABC.COM", 232);
        System.out.println(ArrayNvSort(SortNvBySalary(nhanVien)));
        Scanner sc = new Scanner(System.in);
        int number = 1;
        while (number != 0) {
            System.out.println("Mời bạn thêm nhân viên");
            System.out.println("ẤN 1 để thêm nhân viên PartTime");
            System.out.println("ẤN 2 để thêm nhân viên FullTime");
            System.out.println("Ấn 3 để xem danh sách NVFulltime có lương trung bình nhỏ hơn lươngtbNhanvien");
            System.out.println("ẤN 4 để xem lương phải trả cho tất cả NvPartTime");
            System.out.println("ẤN 5 để xem danh nhân viên FullTime sau khi sắp xếp theo bảng lương");
            System.out.println("ẤN 0 để kết thúc :");

            int numbers = sc.nextInt();
            sc.nextLine();
            switch (numbers) {
                case 1:
                    System.out.println("Nhận code nhân viên mới");
                    String codeNV = sc.nextLine();
                    System.out.println("Nhập tên nhân viên mới");
                    String Name = sc.nextLine();
                    System.out.println("Nhập sđt nhân viên mới");
                    int Phone = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập EMAIL nhân viên mới");
                    String Email = sc.nextLine();
                    System.out.println("nhập thời gian làm việc");
                    int Time = sc.nextInt();
                    addNhanVien(newNhanVien, nhanVien);
                    newNhanVien[newNhanVien.length - 1] = AddNvPartTime(codeNV, Name, Phone, Email, Time);
                    break;
                case 2:
                    System.out.println("Nhập code nhân viên mới");
                    String codeNV1 = sc.nextLine();
                    System.out.println("Nhập tên nhân viên mới");
                    String Name1 = sc.nextLine();
                    System.out.println("Nhập sđt");
                    int Phone1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập Email nhân viên mới");
                    String Email1 = sc.nextLine();
                    System.out.println("Nhập bosnus nhân viên mới");
                    int Bonus = sc.nextInt();
                    System.out.println("Nhập tiền phạt nhân viên mới");
                    int Fine = sc.nextInt();
                    System.out.println("Nhập lương cứng nhân viên mới");
                    int Salary = sc.nextInt();
                    addNhanVien(newNhanVien, nhanVien);
                    newNhanVien[newNhanVien.length - 1] = AddNvFullTime(codeNV1, Name1, Phone1, Email1, Bonus, Fine, Salary);
                    break;
                case 3:
                    System.out.println("danh sách nhân viên fulltime có lương thấp hơn lương trung bình của Nv là" + ListNhanVienLessThanAvergaSalary(newNhanVien));
                    break;
                case 4:
                    System.out.println("lương phải trả cho tất cả nhân viên bán thời gian là" +sumSalaryPartTime(newNhanVien));
                    break;
                case 5:
                    System.out.println("List nhân viên sau khi sắp xếp theo lương tăng dần là"+ArrayNvSort(SortNvBySalary(nhanVien)));
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    public static NhanVien AddNvPartTime(String codeNV, String Name, int Phone, String Email, int Time) {
        return new NhanVienPartTime(codeNV, Name, Phone, Email, Time);
    }

    public static NhanVien AddNvFullTime(String codeNV, String Name, int Phone, String Email, int Bonus, int Fine, int Salary) {
        return new NhanVienFullTime(codeNV, Name, Phone, Email, Bonus, Fine, Salary);

    }


    public static NhanVien[] addNhanVien(NhanVien[] newNhanVien, NhanVien[] nhanVien) {


        for (int i = 0; i < newNhanVien.length; i++) {
            if (i < newNhanVien.length - 1) {
                newNhanVien[i] = nhanVien[i];
            }

        }
        return newNhanVien;
    }

    public static int getAverageSalary(NhanVien[] newNhanVien) {
        int sumSalaryPartTime = 0;
        int sumSalaryFullTime = 0;
        for (int i = 0; i < newNhanVien.length; i++) {
            if (newNhanVien[i] instanceof NhanVienPartTime) {
                sumSalaryPartTime += ((NhanVienPartTime) newNhanVien[i]).getLuongPartTime();
            } else if (newNhanVien[i] instanceof NhanVienFullTime) {
                sumSalaryFullTime += ((NhanVienFullTime) newNhanVien[i]).luongFulltime();
            }

        }
        int AverageSalary = (sumSalaryFullTime + sumSalaryPartTime) / newNhanVien.length;
        return AverageSalary;
    }

    public static String ListNhanVienLessThanAvergaSalary(NhanVien[] newNhanVien) {
        String List = "";
        for (int i = 0; i < newNhanVien.length; i++) {
            if (newNhanVien[i] instanceof NhanVienFullTime) {
                if (((NhanVienFullTime) newNhanVien[i]).luongFulltime() < getAverageSalary(newNhanVien)) {
                    List += ((NhanVienFullTime) newNhanVien[i]).toString();

                }
            }
        }
        return List;
    }

    public static int sumSalaryPartTime(NhanVien[] newNhanVien) {
        int sumSalaryPartTime = 0;
        for (int i = 0; i < newNhanVien.length; i++) {
            if (newNhanVien[i] instanceof NhanVienPartTime) {
                sumSalaryPartTime += ((NhanVienPartTime) newNhanVien[i]).getLuongPartTime();

            }
        }
        return sumSalaryPartTime;
    }
    public static NhanVien[] SortNvBySalary(NhanVien[] nhanVien){
        for (int i = 0; i < nhanVien.length; i++) {
            for (int j = 1; j < nhanVien.length - i; j++) {
               if(nhanVien[j] instanceof NhanVienFullTime){
                   if(((NhanVienFullTime) nhanVien[j-1]).luongFulltime()>((NhanVienFullTime) nhanVien[j]).luongFulltime()){
                       NhanVienFullTime temp = (NhanVienFullTime) nhanVien[j-1];
                          nhanVien[j-1]= (NhanVienFullTime) nhanVien[j];
                         nhanVien[j] = temp;

                   }
                }

            }
        }
       return nhanVien;
    }
    public static String ArrayNvSort(NhanVien[] nhanVien){
        String List = "";
       for(int i=0;i<nhanVien.length;i++){
            List +=  nhanVien[i].toString();
       }
        return List;
    }

}
