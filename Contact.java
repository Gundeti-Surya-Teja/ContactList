import java.util.*;
import java.io.*;


class Employee implements Serializable
{
	int eid;
	String ename;
	long ephno;

	public Employee(int eid,String ename,long ephno)
	{
		this.eid=eid;
		this.ename=ename;
		this.ephno=ephno;
	}

	public String toString()
	{
		return "    ID : "+eid + "\tName : "+ename +"\t\t\tContact : "+ephno +"\n";
	}

}



class Contact
{
   public static void main(String args[])
   {
		Scanner s1 = new Scanner(System.in);
		Scanner s2 =new Scanner(System.in);
		Scanner s3 =new Scanner(System.in);

	Integer refid;
	boolean found=false;

	ArrayList<Employee> data = new ArrayList<Employee>();
	File file =new File("Employee-contactsList.txt");

		FileOutputStream fos=null;
		ObjectOutputStream oos=null;

		FileInputStream fis=null;
		ObjectInputStream ois=null;

		ListIterator<Employee> li = null;

	if(file.isFile())
	{
		try
		{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			data = (ArrayList<Employee>)ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	while(true)
	{
		System.out.println("------------------------------");
		System.out.println("\nWelcome to service\n");
		System.out.println("1.Insert Contact");
		System.out.println("2.Diplay Contacts");
		System.out.println("3.Update Contact");
		System.out.println("4.Delete Contact");
		System.out.println("5.Search Contact");
		System.out.println("6.Exit");
		
		
		System.out.print("\nChoose the option from above : ");
		int ch =s1.nextInt();


		switch(ch)
		{
		case 1:
		
		if(file.isFile())
		{
			System.out.println("\nEnter how many contacts do you want to store inside file");
			int n =s1.nextInt();
			
				for(int i =0;i<n;i++)
				{
					int eid =101 + data.size();
					//for id
					System.out.print("The Generated Id for the Employee is = "+ eid + "\tNOTE : Kindly Please! Remember the Id. ");

					//for name
					System.out.print("\nEnter the name  : ");
					String ename =s2.next();

					//for phone number
					System.out.print("Enter the Contact number : ");
					long ephno =s3.nextLong();

					data.add(new Employee(eid,ename,ephno));
					eid++;
					System.out.println("Data Inserted Sucessfully\n");
				}
			try
			{
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(data);
				oos.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Error - 404 :File not Found ! ");
		}
		break;

		case 2:
		
		if(file.isFile())
		{
			try
			{
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				data = (ArrayList<Employee>)ois.readObject();
				ois.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("------------------------------");
			li = data.listIterator();
				while(li.hasNext())
				{
					System.out.println(li.next());
				}
			System.out.println("------------------------------");
		}
		else
		{
			System.out.println("Error - 404 :File not Found ! ");
		}
		break;

		case 3:
		
		if(file.isFile())
		{
			try
			{
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				data = (ArrayList<Employee>)ois.readObject();
				ois.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			System.out.print("Enter the ID nmber which do you want to update : ");
			refid = s1.nextInt();
			li = data.listIterator();
				while(li.hasNext())
				{
					Employee E = (Employee)li.next();
					
					if(refid.equals(E.eid))
					{
						//for name
						System.out.print("\nEnter the new name : ");
						String n_name =s2.next();

						//for phone number
						System.out.print("\nEnter the new Contact number : ");
						long n_phno =s3.nextLong();
						
						li.set(new Employee(refid,n_name,n_phno));
						found=true;
						break;
					}
					
				}
				
				if(found)
				{
					System.out.println("The record is updated. ");
				}
				else
				{
					System.out.println("Record not found ");
				}
			try
			{
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(data);
				oos.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Error - 404 :File not Found ! ");
		}
		break;

		case 4:
		
		if(file.isFile())
		{
			try
			{
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				data = (ArrayList<Employee>)ois.readObject();
				ois.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			System.out.print("Enter the ID nmber which do you want to update : ");
			refid = s1.nextInt();
			li = data.listIterator();
				while(li.hasNext())
				{
					Employee E = (Employee)li.next();
					
					if(refid.equals(E.eid))
					{	
						li.remove();
						found=true;
						break;
					}
					
				}
				
				if(found)
				{
					System.out.println("The record is Deleted Sucessfully. ");
				}
				else
				{
					System.out.println("Record not found ");
				}
			try
			{
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(data);
				oos.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Error - 404 :File not Found ! ");
		}	
		break;

		case 5:
		
		if(file.isFile())
		{
			try
			{
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				data = (ArrayList<Employee>)ois.readObject();
				ois.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.print("Enter the ID nmber which do you want to Search : ");
			refid = s1.nextInt();
			li = data.listIterator();
				while(li.hasNext())
				{
					Employee E = (Employee)li.next();
					
					if(refid.equals(E.eid))
					{	
						System.out.println("------------------------");
						System.out.println(E);
						found=true;
						break;
					}
					
				}
				
				if(!found)
				{
					System.out.println("Record not found. ");
				}
			try
			{
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(data);
				oos.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Error - 404 :File not Found ! ");
		}
		break;
		
		case 6:
			System.out.println("\nThank you for using Service");
			System.out.println("------------------------");
			System.exit(0);
		break;
		}
		
	}

   }
}