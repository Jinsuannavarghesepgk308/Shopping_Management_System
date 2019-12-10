package Shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Addproduct {
	connectionmanager2 con=new connectionmanager2();
	public void adddetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("1) Add product");
		System.out.println("2) Display");
		System.out.println("3) Remove");
        System.out.println("4) Exit");
        System.out.println("Enter the choice");
		int d=s.nextInt();
		switch(d)
		{
		case 1:
			System.out.println("Enter the product id");
			int id=s.nextInt();
			System.out.println("Enter the product name");
			String name=s.next();
			System.out.println("Enter the minsell quantity");
			int quantity=s.nextInt();
			System.out.println("Enter the price");
			int price=s.nextInt();
			PreparedStatement sd=(PreparedStatement) con.getConnection().prepareStatement("insert into" +" addproduct(Productid,Productname,minsellquantity,Price) values(?,?,?,?);");
			
			sd.setInt(1,id);//1 means index value
			sd.setString(2,name);
			sd.setInt(3,quantity);
			sd.setInt(4, price);
			sd.executeUpdate();//value will be updated to database
			//con.getConnection().close();
			System.out.println("Product added successfully");
		case 2:
			
				
				Statement s1=(Statement)con.getConnection().createStatement();
				ResultSet r=s1.executeQuery("select * from addproduct;");
				while(r.next())//for get values one by one
				{
					System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getInt(3)+" "+r.getInt(4)+" ");
				}
				
			shoppingapp sh=new shoppingapp();
			sh.choice();
	
	}
	}

	}


