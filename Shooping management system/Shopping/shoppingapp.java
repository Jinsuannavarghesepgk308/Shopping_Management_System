package Shopping;

import java.sql.SQLException;
import java.util.Scanner;


public class shoppingapp {
	connectionmanager2 con=new connectionmanager2();

	public static void main(String[] args)throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		shoppingapp sh=new shoppingapp();
		sh.choice();
			}

public void choice ()throws ClassNotFoundException,SQLException {
				Scanner s=new Scanner(System.in);
				System.out.println();
				System.out.println("1) Adminlogin");
				System.out.println("2) Agentlogin");
				
		        System.out.println("3) Exit");
		        System.out.println("Enter the choice");
				int p=s.nextInt();
			switch(p)
			{
			case 1:
				Admindata adm=new Admindata();
				adm.admindetails();
				break;
			
			case 2:
				Agentdata ag=new Agentdata();
				ag.agentdetails();
				break;
			case 3:
				System.out.println("Process will be completed");
				break;
			}
		
			
			}
}
