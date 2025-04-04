package p0021;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Valid {
    
    public static final Scanner sc = new Scanner(System.in);
    
    public int getInt(String msg, String rex){
//        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        while(true){
            String res = sc.nextLine().trim();
            if(res.matches(rex)){
                return Integer.parseInt(res);
            }else{
                System.out.println("Nhap sai dinh dang Int. Nhap lai: ");
            }
        }
    }
    
    public String getString(String msg, String rex){
//        Scanner sc
        System.out.println(msg);
        while(true){
            String res = sc.nextLine().trim();
            if(res.matches(rex)){
                return res;
            }else{
                System.out.println("Nhap sai dinh dang. Nhap lai");
            }
        }
    }
}
