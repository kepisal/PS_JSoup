package IO;
import java.io.*;
import java.security.Permissions;
import java.util.*;
public class writemyobjects {
	File file;
	ArrayList<persons> personlist;
	
	public writemyobjects(String filename){
		file=new File(filename);
		personlist=new ArrayList<persons>();
	}
	public void createListObjects(int numbers){
		for(int i=0; i<numbers; i++){
			personlist.add(new persons("A"+i, 27, "Male", "IT"));			
		}
		//System.out.println(personlist.size());
	}
	public void writeToFile(){
		try {
			FileOutputStream fout=new FileOutputStream(file);
			ObjectOutputStream objout=new ObjectOutputStream(fout);
			//BufferedOutputStream bjout=new BufferedOutputStream(fout);
			objout.writeObject(personlist);
			objout.close();
			fout.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void readFromFile(){
		try {
			FileInputStream fin=new FileInputStream(file);
			ObjectInputStream objin=new ObjectInputStream(fin);
			
			/*while(true){
				personlist1.add((persons)objin.readObject());
			}			*/
			
			System.out.println();
			objin.close();
		} catch (EOFException e) {
			// TODO: handle exception
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		writemyobjects b=new writemyobjects("objecttest.txt");
		b.createListObjects(10);
		//b.writeToFile();
		b.readFromFile();
		
	}
}

