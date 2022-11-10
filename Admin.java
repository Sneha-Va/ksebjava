import java.sql.*;
import java.util.Scanner;

public class Admin {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");

        } catch (Exception e) {
            System.out.println(e);
        }
            int choice;
            String name, address, phoneno;
            int consumerid;
            Scanner s = new Scanner(System.in);
            while (true) {
                System.out.println("1.select any option");
                System.out.println("1.Add consumer");
                System.out.println("2.search consumer");
                System.out.println("3.delete consumer");
                System.out.println("4.update consumer");
                System.out.println("5.view all consumer");
                System.out.println("6. generate bill");
                System.out.println("7.view bill");
                System.out.println("8.top 2 bill");
                System.out.println("9.exit");
                System.out.println("enter the choice");
                choice = s.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("add consumer");
                        System.out.println("enter name:");
                        name=s.next();
                        System.out.println("enter address");
                        address=s.next();
                        System.out.println("enter consumer id");
                        consumerid=s.nextInt();
                        System.out.println("enter phone number");
                        phoneno=s.next();
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                            String sql="INSERT INTO `consumer`( `name`, `address`, `consumerid`, `phone`) VALUES (?,?,?,?)";
                            PreparedStatement stmt = con.prepareStatement(sql);
                            stmt.setString(1,name);
                            stmt.setString(2,address);
                            stmt.setInt(3,consumerid);
                            stmt.setString(4,phoneno );

                        }
                        catch (Exception e){
                            System.out.println(e);
                        }
                    case 2:
                        System.out.println("search consumer");
                    case 3:
                        System.out.println("delete consumer");
                        System.out.println("enter consumer id:");
                        String consumer=s.next();
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                            String sql="DELETE FROM `consumer` WHERE `consumerid`="+consumer;
                            Statement stmt =con.createStatement();
                            stmt.executeUpdate(sql);
                            System.out.println("deleted successfully");
                        }
                        catch (Exception e){
                            System.out.println((e));
                        }
                    case 4:



                    case 5:
                        System.out.println("view all consumer");
                    case 6:
                        System.out.println("generate bill");
                    case 7:
                        System.out.println("view all bill");
                    case 8:
                        System.out.println("top two bill");
                    case 9:
                        System.out.println("exit");
                        break;



                }
            }
        }

    }