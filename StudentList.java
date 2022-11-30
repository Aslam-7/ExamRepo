import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

		if(args.length!=1){
			System.err.println("Invalid number of arguments.");
			System.err.println("Exiting program");
			System.exit(1);

		}
		// check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader  bufferedReader= new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			String students[] = line.split(", ");			
			for(String student : students) { 
				System.out.println(student); 
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			//System.out.println(r);
			String students[] = line.split(",");	
			Random random = new Random();
				int index = random.nextInt(students.length);
					System.out.println(students[index]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter bufferedReader = new BufferedWriter(
					new FileWriter("students.txt", true));
			String new_data = args[0].substring(1);
	        Date data = new Date();
	        String date_format_pattern = "dd-mm-yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(date_format_pattern);
	        String formate_date= dateFormat.format(date);
			bufferedWriter.write(", "+new_data+"\nList last updated on "+fd);
			bufferedWriter.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			String students[] = line.split(", ");	
			boolean done = false;
			String new_data = args[0].substring(1);
			for(int idx = 0; idx<students.length && !done; idx++) {
				if(students[idx].equals(new_data)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			if(!done){
				System.out.println("could not found" + new_data);
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")){
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			char students[] = line.toCharArray();			
			boolean in_word = false;
			int count=0;
			for(char student : students) {
				if(student ==' ') {
					if (!in_word) {	
						count++; in_word =true;
					}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found ");
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
	}
	else{
		System.err.println("Invalid arguments.");
		System.err.println("Exiting program.");
		System.exit(2);
	}

}
