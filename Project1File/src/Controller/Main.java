package Controller;

import java.sql.SQLException;
import java.util.Scanner;

import dao.Detailsdao;
import dao.Logindao;
import model.Details;
import model.Login;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	Scanner sc = new Scanner(System.in);
	int choice,product;
	
	Login l= new Login();
	Logindao ldao = new Logindao();
	Details d = new Details();
	Detailsdao ddao = new Detailsdao();
	do
	{
		System.out.println("1. Admin\n2. Student\n3. Exit");
		System.out.println("*****************************************************");
		System.out.println("Enter your choice");
		choice = sc.nextInt();
		switch(choice)
		{
		
		case 1:
			System.out.println("Admin Login!!!");
			System.out.println("Enter the username");
			String username = sc.next();
			System.out.println("Enter the password");
			String pass = sc.next();
			l.setUsername(username);
			l.setPass(pass);
			if(ldao.loginValidation(l))
			{
				System.out.println("Admin successfully logged in!!!");
				do
				{
					System.out.println("*****************************************************");
					System.out.println("1. Add details\n2. Update Details\n3. Display Details\n4. Logout");
					System.out.println("*****************************************************");
					System.out.println("Enter your choice");
					product = sc.nextInt();
					switch(product)
					{
					case 1:
						System.out.println("Add Details");
						System.out.println("Enter Student ID");
						int studentid = sc.nextInt();
						System.out.println("Enter Student Name");
						String studentname = sc.next();
						System.out.println("Enter Course");
						String course = sc.next();
						System.out.println("Enter Fees");
						int fees= sc.nextInt();
						
						d.setStudentid(studentid);
						d.setStudentname(studentname);
					    d.setCourse(course);
						d.setFees(fees);
						ddao.addDetails(d);
						ddao.updateDetails(d);
						System.out.println("Details added Successfully!!!");
						break;
					case 2:
						System.out.println("Update Details:");
						System.out.println("Enter the Student ID");
						int studentid1= sc.nextInt();
						System.out.println("Enter the Fees Paid");
						int paidfee= sc.nextInt();
						d.setStudentid(studentid1);
						d.setPaidfee(paidfee);
						if(ddao.updateDetails(d))
							System.out.println("Updated Successfully!!!");
						else
							System.out.println("Have to pay fees");
					case 3:
						System.out.println("Details are below:");
						ddao.display();
						break;
					case 4:
						System.out.println("Logged out successfully!!!");
						break;
					}
				}while(product!=4);
			}
			else
			{
				System.out.println("Admin failed to login!!!\nInvalid Username/Password");
			}
			break;
		case 2:
			System.out.println("Student Login!!!");
			System.out.println("Enter the username");
			String username1 = sc.next();
			System.out.println("Enter the password");
			String password1 = sc.next();
			l.setUsername(username1);
			l.setPass(password1);
			if(ldao.loginValidation(l))
			{
				System.out.println("Student successfully logged in!!!");
				do
				{
					System.out.println("*****************************************************");
					System.out.println("1. Display Details\n2. Logout");
					System.out.println("*****************************************************");
					System.out.println("Enter your choice");
					product = sc.nextInt();
					switch(product)
					{
					case 1:
						System.out.println("Details are below:");
						ddao.display();
						break;
					case 3:
						System.out.println("Logged out successfully!!!");
						break;
					}
				}while(product!=2);
			}
			else
			{
				System.out.println("Agent failed to login!!!\nInvalid Username/Password");
			}
			break;
		case 3:
			System.out.println("Exit");
			break;
		}
	}while(choice!=3);
	sc.close();
}
}

