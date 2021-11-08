import java.io.*;
import java.util.*;

public class Main {

  public static void main(String args[]) throws Exception {
	ArrayList<Point> points = new ArrayList<>();
	  
    Scanner reader = new Scanner(System.in);
    for(int i = 0 ; i < 8; i++) {
    	int x = reader.nextInt();
    	int y = reader.nextInt();
    	Point p = new Point(x, y);
    	points.add(p);
    }
    
    System.out.println(check(points));
  }
  public static String check(ArrayList<Point> points) {
	  ArrayList<Integer> setX = new ArrayList<>();
	  ArrayList<Integer> setY = new ArrayList<>();

	  for(int i = 0; i < points.size(); i++) {
		  for(int j = i+1; j< points.size(); j++) {
			  if(points.get(i).compare(points.get(j))) {
				  return "ugly";
			  }
		  }
		  if(!setX.contains(points.get(i).x))
			  setX.add(points.get(i).x);
		  if(!setY.contains(points.get(i).y))
			  setY.add(points.get(i).y);
	  }
	  if(setX.size() != 3 || setY.size() != 3)
		  return "ugly";
	  Collections.sort(setX);
	  Collections.sort(setY);
	  Point midPoint = new Point(setX.get(1), setY.get(1));
	  for(Point p : points) {
		  if(p.x == midPoint.x && p.y == midPoint.y) {
			  return "ugly";
		  }
	  }
	  
	  return "respectable";
  }
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean compare(Point p) {
		return this.x == p.x && this.y == p.y;
	}
}
