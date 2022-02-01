
import java.sql.*;
import java.util.*;

/**
 *
 * @author savibpandey
 */
public class CurdArrayList {

    CurdArrayList() {
        List<String> arrayList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db", "root", "");
            PreparedStatement pstm = con.prepareStatement("select * from trial_db");
            ResultSet rs = pstm.executeQuery();
            System.out.println("hello there");
            Scanner in = new Scanner(System.in);
            System.out.println("Entered string ");
            String s = in.nextLine();

            switch (s) {
                case "I":
                    System.out.println("Insert option");
                    while (rs.next()) {
                        arrayList.add(rs.getString("name"));
                        System.out.println("" + rs.getString("name"));

                    }

                    System.out.println("Do you want to update(y/n)?");
                    String check = in.nextLine();
                    if (check.equals("y")) {
                        System.out.println("update option");
                        System.out.println("Entered Name to change");
                        String updateName = in.nextLine();
                        System.out.println("Entered index ");
                        String updateIndex = in.nextLine();
                        arrayList.set(Integer.parseInt(updateIndex), updateName);
                        System.out.println(""+arrayList);
                       
                    }else{
                        System.out.println(" No data updated");
                    }
                     
                     System.out.println("Do you want to remove any index(y/n)?");
                    String d = in.nextLine();
                     if(d.equals("y")){
                         System.out.println("Entered index ");
                        int rIndex = in.nextInt();
                        arrayList.remove(rIndex);
                         System.out.println(""+arrayList);
                    }

                   

            }
//                int rs = pstm.executeUpdate();
//            pstm.setString(1, );

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }

    public static void main(String[] args) {
        CurdArrayList ca = new CurdArrayList();
    }
}
