import java.sql.Connection;
import java.sql.DriverManager;
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
                    case 2:
                        System.out.println("search consumer");
                    case 3:
                        System.out.println("delete consumer");
                    case 4:
                        System.out.println("update consumer");
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