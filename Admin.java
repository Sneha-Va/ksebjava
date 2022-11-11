import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Admin {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");

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
                        System.out.println("Generate Bill");
//getting current month and year
                        GregorianCalendar date = new GregorianCalendar();
                        int currentMonth = date.get(Calendar.MONTH);
                        int currentYear = date.get(Calendar.YEAR);
                        currentMonth = currentMonth+1;
                        try {
                            //
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                            String sql = "DELETE FROM `bills` WHERE `month`= '" + currentMonth + "'AND `year`= '" + currentYear + "'";
                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(sql);
                            System.out.println("Previous data deleted");
                            String sql1 = "SELECT `id` FROM `consumer` ";
                            Statement stmt1 = con.createStatement();
                            ResultSet rs = stmt1.executeQuery(sql1);
                            while (rs.next()) {
                                int id = rs.getInt("id");
                                String sql2 = "select SUM(`unit`) from `usage` where month(date) = '"+currentMonth+"' AND year(date) = '"+currentYear+"' AND `consumerid` ='"+id+"'";
                                Statement stmt2 = con.createStatement();
                                ResultSet rs1 = stmt2.executeQuery(sql2);
                                while (rs1.next()) {
                                    int add = rs1.getInt("SUM(`unit`)");
                                    int status = 0;
                                    int totalBill = add * 5;
                                    //generating random number for invoice
                                    int min = 10000;
                                    int max = 99999;
                                    int invoice = (int)(Math.random() * (max - min + 1) + min);
                                    // String sql3 = "INSERT INTO `bill`(`User_Id`, `month`, `year`, `bill`, `paid status`, `bill date`, `total_unit`) VALUES (%s,%s,%s,%s,%s,now(),%s)";
                                    String sql3 = "INSERT INTO `bills`(`consumerid`, `month`, `year`, `bill`, `billstatus`, `billdate`, `totalunit`, `duedate`, `invoice`) VALUES (?,?,?,?,?,now(),?,now()+ interval 14 day,?)";
                                    PreparedStatement stmt3 = con.prepareStatement(sql3);
                                    stmt3.setInt(1, id);
                                    stmt3.setInt(2, currentMonth);
                                    stmt3.setInt(3, currentYear);
                                    stmt3.setInt(4, totalBill);
                                    stmt3.setInt(5, 0);
                                    stmt3.setInt(6, add);
                                    stmt3.setInt(7, invoice);
                                    stmt3.executeUpdate();
                                }
                            }

                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        break;

                    case 7:
                        System.out.println("view all bill");
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                            String sql = "SELECT  b.`consumerid`, b.`month`, b.`year`, b.`bill`, b.`billstatus`, b.`billdate`, b.`totalunit`, b.`duedate`, b.`invoice`,c.consumerid,c.name FROM `bills` b JOIN consumer c ON b.consumerid=c.id";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            while (rs.next()){
                                String getconsumerid = rs.getString("consumerid");
                                String getmonth= rs.getString("month");
                                String getyear = rs.getString("year");
                                String getbill = rs.getString("bill");
                                String getbillstatus = rs.getString("billstatus");
                                String getbilldate = rs.getString("billdate");
                                String gettotalunit = rs.getString("totalunit");
                                String getdueDate = rs.getString("duedate");
                                String getinvoice = rs.getString("invoice");
                                String getConsumerCode = rs.getString("consumerid");
                                String getConsumerName = rs.getString("name");
                                System.out.println("Consumer Id="+getconsumerid);
                                System.out.println("Month="+getmonth);
                                System.out.println("Year="+getyear);
                                System.out.println("Bill ="+getbill);
                                System.out.println("PaidStatus ="+getbillstatus);
                                System.out.println("Bill Date ="+getbilldate);
                                System.out.println("Total Unit ="+gettotalunit);
                                System.out.println("Due Date ="+getdueDate);
                                System.out.println("Invoice ="+getinvoice);
                                System.out.println("Consumer Code ="+getConsumerCode);
                                System.out.println("Consumer Name="+getConsumerName+"\n");
                            }

                        }
                        catch (Exception e){
                            System.out.println(e);
                        }

                        break;

                    case 8:
                        System.out.println("top two bill");
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                            String sql = "SELECT c.name,c.address,b.`bill`, b.`totalunit` FROM `bills` b JOIN consumer c ON b.consumerid=c.id ORDER BY b.`bill`DESC LIMIT 2";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            while(rs.next()){
                                name = rs.getString("c.name");
                                address = rs.getString("c.address");
                                int bill = rs.getInt("b.bill");
                                int total = rs.getInt("totalunit");
                                System.out.println("name ="+name);
                                System.out.println("address ="+address);
                                System.out.println("total bill = "+bill);
                                System.out.println("total unit ="+total+'\n');
                            }
                        }
                        catch (Exception e){
                            System.out.println(e);
                        }
                        break;

                    case 9:
                        System.out.println("exit");
                        break;



                }
            }
        }

    }