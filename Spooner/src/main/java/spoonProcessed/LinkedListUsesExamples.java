package spoonProcessed;
import java.util.LinkedList;
public class LinkedListUsesExamples {

	private LinkedList<String> ls= new LinkedList<String>();

 public LinkedListUsesExamples() {
	
		
			ls = new LinkedList<String>();
		}

 
 
 public void linkedListClassicsUses(){
 	
	 this.ls.add("hello");
	 this.ls.addLast("Bye");
	 System.out.println("size: "+ this.ls.size()+"\nIsEmpty?: " + this.ls.isEmpty());
	
	 this.ls.iterator();
	 this.ls.removeFirst();
	 this.ls.remove();
	 System.out.println("size: "+ this.ls.size()+"\nIsEmpty?: " + this.ls.isEmpty());
 }
 
	}


