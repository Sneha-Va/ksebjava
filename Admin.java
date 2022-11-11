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
                        break;
                    case 2:
                        System.out.println("search consumer");
                        System.out.println("Enter the Consumer Code/Name/Phone to search: ");
                        String searchOption = s.next();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                            String sql = "SELECT `name`, `address`, `consumerid`, `phone` FROM `consumer` WHERE `consumerid` ='"+searchOption+"'  OR `name`='"+searchOption+"' OR `Phone` ='"+searchOption+"' ";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            while (rs.next()){
                                String getname = rs.getString("name");
                                String getaddress = rs.getString("address");
                                String getconsumerid = rs.getString("consumerid");
                                String getphoneno = rs.getString("phone");

                                System.out.println("name="+getname);
                                System.out.println("address="+getaddress);
                                System.out.println("consumerid="+getconsumerid);
                                System.out.println("phone="+getphoneno);

                            }
                        }
                        catch (Exception e){
                            System.out.println(e);
                        }

                        break;
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
                        System.out.println("update consumer");
                        System.out.println("enter consumer id");
                        consumerid=s.nextInt();
                        System.out.println("enter  name to be updated");
                        name=s.next();
                        System.out.println("enter address to be updated");
                        address=s.next();
                        System.out.println("enter consumer id to be updated");
                        int cid=s.nextInt();
                        System.out.println("enter phone number to be updated");
                        phoneno=s.next();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                            String sql="UPDATE `consumer` SET `name`='"+name+"',`address`='"+address+"',`consumerid`='"+String.valueOf(cid)+"',`phone`='"+phoneno+"' WHERE `consumerid`="+String.valueOf(consumerid);
                            Statement stmt =con.createStatement();
                            stmt.executeUpdate(sql);
                            System.out.println("update successfully");
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        break;
                        case 5:
                        System.out.println("view all consumer");
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                                String sql="SELECT `id`, `name`, `address`, `consumerid`, `phone` FROM `consumer`";
                                Statement stmt = con.createStatement();
                                ResultSet rs= stmt.executeQuery(sql);
                                while (rs.next()){
                                    String getname=rs.getString("name");
                                    String getaddress=rs.getString("address");
                                    String getconsumerid=rs.getString("consumerid");
                                    String getphone=rs.getString("phone");
                                    System.out.println("name="+getname);
                                    System.out.println("address="+getaddress);
                                    System.out.println("consumerid="+getconsumerid);
                                    System.out.println("phone="+getphone);

                                }

                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                    case 6:
                        System.out.println("generate bill");
                        break;

                    case 7:
                        System.out.println("view all bill");
                        break;
                    case 8:
                        System.out.println("top two bill");
                        break;
                    case 9:
                        System.out.println("exit");
                        break;



                }
            }
        }

    }