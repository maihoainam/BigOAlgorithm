import java.io.*;
import java.util.*;



public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int count = 1;
    while(true) {
        int p = reader.nextInt();
        int n = reader.nextInt();
        if(p ==0 && n == 0) break;
    	ArrayList<Command> commands = new ArrayList<>();
        for(int i =0 ; i < n; i++) {
        	String c = reader.next();
        	if(c.equals("N")) {
        		commands.add(new Command(c));
        	}
        	else {
        		int citizen = reader.nextInt();
        		commands.add(new Command(c,citizen));
        	}
        }
        System.out.println("Case " + count + ":");
        System.out.println(queue(commands, p));
        count++;
    }
  }
  
  public static String queue(ArrayList<Command> commands, int p) {
	  LinkedList<Integer> populations = new LinkedList<>();
	  for(int i = 1; i <= Math.min(p, 1000); i++) {
		  populations.add(i);
	  }
	  StringBuilder sb = new StringBuilder();
	  for(Command c : commands) {
		  if("N".equals(c.command)) {
			  int treat = populations.remove();
			  populations.add(treat);
			  sb.append(treat+"\n");
		  }
		  else if("E".equals(c.command)) {
			  populations.remove(new Integer(c.citizen));
			  populations.push(c.citizen);
		  }
	  }
	  return sb.toString().trim();
  }
  
}
class Command{
	String command;
	int citizen;
	public Command(String command, int citizen) {
		this.command = command;
		this.citizen = citizen;
	}
	public Command(String command) {
		this.command = command;
	}
}
