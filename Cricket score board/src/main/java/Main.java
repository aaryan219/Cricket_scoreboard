import java.util.*;
import java.sql.*;
public class Main {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        //Load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root");
        Statement St = con.createStatement();
        while(true){
            System.out.println("Enter the choice");
            System.out.println(("1. View the scorecard "));
            System.out.println("2. Insert the new record");
            System.out.println("3. Update the record");
            System.out.println("4. Dlt the record");
            System.out.println("5. Exit");

            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    viewtable(St);
                    break;
                case 2:
                    //INSERT
                    System.out.println("Enter the id");
                    int id=sc.nextInt();
                    System.out.println("Enter the name of the player");
                    String name=sc.next();
                    System.out.println("Enter the runs");
                    int run=sc.nextInt();
                    System.out.println("Enter how many balls");
                    int ball=sc.nextInt();
                    String insert="INSERT INTO SCORETABLE Values("+id+",'"+name+"',"+run+","+ball+")";
                    int rows=St.executeUpdate(insert);
                    System.out.println(rows+"Rows inserted");

                    break;
                case 3:
                    System.out.println("Enter the id of pl");
                    id=sc.nextInt();
                    System.out.println("Enter new Run");
                     run=sc.nextInt();
                    System.out.println("How many ball");
                     ball=sc.nextInt();
                    String update= "Update scoretable set runs ="+run+", balls="+ball+" where id="+id+";";
                     rows=St.executeUpdate(update);
                    System.out.println(rows+ " row updated ");
                    System.out.println("---------------------------------------------------");
                    break;
                case 4:
                    System.out.println("Enter the id of pl");
                    id=sc.nextInt();
                    String dltquery="Delete from scoretable where id="+id+";";
                    rows=St.executeUpdate(dltquery);
                    System.out.println(rows+" row updated ");
                    System.out.println("---------------------------------------------------");

                    break;
                default:
                    boolean flag=false;

                    break;



            }



        }

    }
    public static void viewtable(Statement St) throws Exception{
        String sql="select* from scoretable";
        ResultSet rs =St.executeQuery(sql);
        System.out.println("---------------------------------------------------");

        System.out.println("Id\t|Name\t|runs\t|Balls\t");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+
                    rs.getInt(3)+"\t"+
                    rs.getInt(4));
            System.out.println("---------------------------------------------------");

        }
    }
}
