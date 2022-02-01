import java.util.*;
import java.sql.*;
/**
 *
 * @author savibpandey
 */
public class CurdHashMap {
    Map<Integer,String> number=new HashMap<>();
    CurdHashMap(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db", "root", "");
            PreparedStatement pstm = con.prepareStatement("select * from trial_db");
            ResultSet rs = pstm.executeQuery();
            System.out.println("hello there");
            Scanner in = new Scanner(System.in);
            System.out.println("Insert option");
                    while (rs.next()) {
                        number.put(rs.getInt("id"),rs.getString("name"));
                        System.out.println("id is " +rs.getInt("id")+"name is"+ rs.getString("name"));
                    }
                    System.out.println("Do you want to update or add(y/n)?");
                    String check = in.nextLine();
                    if (check.equals("y")) {
                        System.out.println("update option");
                        System.out.println("Entered Name to change");
                        String updateName = in.nextLine();
                        System.out.println("Entered index ");
                        String updateIndex = in.nextLine();
                        number.put(Integer.parseInt(updateIndex), updateName);
                        System.out.println(""+number);
                    }else{
                        System.out.println(" No data updated");
                    }
                     
                     System.out.println("Do you want to remove any index(y/n)?");
                    String d = in.nextLine();
                     if(d.equals("y")){
                         System.out.println("Entered index ");
                        int rIndex = in.nextInt();
                        number.remove(rIndex);
                         System.out.println(""+number);
                    }
        }catch(Exception e){
            
        }
    }
    public static void main(String[] args) {
        CurdHashMap c=new CurdHashMap();
    }
}
