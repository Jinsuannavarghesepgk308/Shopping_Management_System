package Shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.Statement;
import java.util.Scanner;
import java.util.Scanner;



public class Admindata {
	connectionmanager2 con=new connectionmanager2();
	public void admindetails() throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int flag=0,flag1=0;
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		Pattern pswNamePtrn = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
		Pattern pattern = Pattern.compile(regex);
		System.out.println("Enter the username");
		String user=s.next();
		Matcher m=pattern.matcher(user);
		System.out.println("Enter the password");
		String pass=s.next();
		Matcher o=pswNamePtrn.matcher(pass);
		if(m.matches())
		{
			System.out.println("Valid Adminname");
			flag=1;
		}
		else
		{
			System.out.println("Invalid Adminname");
		}
		if(o.matches())
		{
			System.out.println("Valid password");
			flag1=1;
		}
		else
		{
			System.out.println("Invalid password");
		}
		if(flag==1 && flag1==1)
		{
			//for store data in database we use preparedstatement
			PreparedStatement st=(PreparedStatement) con.getConnection().prepareStatement("insert into" +" adminlogin(Username,Password) values(?,?);");
			st.setString(1,user);//1 means index value
			st.setString(2,pass);
			
			st.executeUpdate();//value will be updated to database
			//con.getConnection().close();
			System.out.println("Successfully verified");
			}
			else
			{
				System.out.println("Admin data insertion failed");
			}
	
	Admindata ch=new Admindata();
	ch.choice();

}
	public void choice() throws ClassNotFoundException,SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("1) Add product");
		System.out.println("2) Display");
		System.out.println("3) Remove");
		System.out.println("4) Update Quantity");
        System.out.println("5) Exit");
        System.out.println("Enter the choice");
		int d=sc.nextInt();
		switch(d)
		{
		case 1:
			System.out.println("Enter the product id");
			int id=sc.nextInt();
			System.out.println("Enter the product name");
			String name=sc.next();
			System.out.println("Enter the minsell quantity");
			int quantity=sc.nextInt();
			System.out.println("Enter the price");
			int price=sc.nextInt();
			PreparedStatement sd=(PreparedStatement) con.getConnection().prepareStatement("insert into" +" addproduct(Productid,Productname,minsellquantity,Price) values(?,?,?,?);");
			
			sd.setInt(1,id);//1 means index value
			sd.setString(2,name);
			sd.setInt(3,quantity);
			sd.setInt(4, price);
			sd.executeUpdate();//value will be updated to database
			//con.getConnection().close();
			System.out.println("Product added successfully");
			choice();
			break;
		case 2:
			
				
				Statement s1=(Statement)con.getConnection().createStatement();
				ResultSet r=s1.executeQuery("select * from addproduct;");
				while(r.next())//for get values one by one
				{
					System.out.println("######################");
					
					System.out.println("Product ID:  "+r.getInt(1)+"\n"+"Product name:       "+r.getString(2)+"\n"+"Quantity:        "+r.getInt(3)+"\n"+"Price:      "+r.getInt(4));
					System.out.println("######################");
				}
				
				choice();
				break;
		case 3:
			Statement s3=(Statement)con.getConnection().createStatement();
			ResultSet r3=s3.executeQuery("select * from addproduct;");
				while(r3.next())//for get values one by one
				{
					System.out.println("Product ID:  "+r3.getInt(1)+"\n"+"Product name:       "+r3.getString(2));
				}
				System.out.println("enter the id");
				int id2=sc.nextInt();
				PreparedStatement st4=(PreparedStatement) con.getConnection().prepareStatement("delete  from addproduct  where Productid=?;");
				st4.setInt(1,id2);
				st4.executeUpdate();
				con.getConnection().close();
				System.out.println("Product  Deleted Successfully");
				// fp=new FirstApp();
				choice();
				break;

	case 4:
		int up_id;
		String up_name;
		int u_qty=0;
		int update_id;
		Statement s4=(Statement)con.getConnection().createStatement();
		ResultSet r5=s4.executeQuery("Select * from addproduct");
		while(r5.next())
		{
		System.out.println("Product Id:      "+r5.getInt(1)+" \n"+"Product Name:      "+r5.getString(2));

		}
		System.out.println("Enter Id");
		update_id=sc.nextInt();
		int iddd=0;
		Statement s5=(Statement)con.getConnection().createStatement();
		ResultSet r4=s5.executeQuery("Select * from addproduct ");
		//s4.setInt(1,update_id);
		while(r4.next())
		{
		System.out.println("Product Id:      "+r4.getInt(1)+" \n"+"Product Name:      "+r4.getString(2));
		// up_id=r2.getInt(1);
		// up_name=r2.getString(2);
		if(r4.getInt(1)==update_id)
		{
		iddd=r4.getInt(1);
		u_qty=r4.getInt(3);
		}
		}
		System.out.println("Enter New Quantity");
		int qtyy=sc.nextInt();
		int q=qtyy+u_qty;
		PreparedStatement st2=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set minsellquantity=? where Productid=?;");
		//st2.setInt(1,up_id);
		//st2.setString(2, up_name);
		// st2.setInt(3, q);
		st2.setInt(1, q);
		st2.setInt(2,iddd);
		//
		st2.executeUpdate();
		con.getConnection().close();
		System.out.println("Product  Updated Successfully");
		// fp=new FirstApp();
		choice();
		break;



	case 5:
		shoppingapp sn=new shoppingapp();
		sn.choice();
		break;
		default:
		break;

		}
		con.getConnection().close();
		//Shopping sp=new Shopping();
		//sp.choices();
		Admindata ad=new Admindata();
		ad.choice();


		}
		}


		


