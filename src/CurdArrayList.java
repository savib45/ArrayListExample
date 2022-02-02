
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
            while (rs.next()) {
                arrayList.add(rs.getString("name"));
                System.out.println("" + rs.getString("name"));

            }
            Scanner in = new Scanner(System.in);
            System.out.println("Entered I for Insert, U for update and D for delete ");
            String s = in.nextLine();

            switch (s) {
                case "I":
                    System.out.println("Insert option selected");
                    System.out.println("Entered Name to add");
                    String name = in.nextLine();
                    arrayList.add(name);
                    System.out.println(""+arrayList);
                    break;

                case "U":
                    System.out.println("update option selected");
                    System.out.println("Entered Name to change");
                    String updateName = in.nextLine();
                    System.out.println("Entered index ");
                    String updateIndex = in.nextLine();
                    arrayList.set(Integer.parseInt(updateIndex), updateName);
                    System.out.println("" + arrayList);
                    break;

                case "D":
                    System.out.println("delete option selected");
                    System.out.println("Entered index ");
                    int rIndex = in.nextInt();
                    arrayList.remove(rIndex);
                    System.out.println("" + arrayList);
                    break;

            }

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }

    public static void main(String[] args) {
        CurdArrayList ca = new CurdArrayList();
    }
}
