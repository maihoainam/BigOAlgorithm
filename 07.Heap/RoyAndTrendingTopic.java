import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int N = reader.nextInt();
		ArrayList<Topic> topics = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			topics.add(new Topic(reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt(),
					reader.nextInt(), reader.nextInt()));
		}
		System.out.println(trending(topics));
	}
	public static String trending(ArrayList<Topic> topics) {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Topic> pq = new PriorityQueue<Topic>();
		pq.addAll(topics);
		for(int i = 0 ; i < 5; i++) {
			Topic topic = pq.remove();
			sb.append(topic.id + " " + topic.getNewZscore() + "\n");
		}
		return sb.toString().trim();
	}
}

class Topic implements Comparable<Topic> {
	int id, zScore, posts, likes, comments, shares;

	public Topic(int id, int z, int p, int l, int c, int s) {
		this.id = id;
		this.zScore = z;
		this.posts = p;
		this.likes = l;
		this.comments = c;
		this.shares = s;
	}

	public int getNewZscore() {
		return this.posts * 50 + this.likes * 5 + this.comments * 10 + this.shares * 20;
	}

	@Override
	public int compareTo(Topic o1) {
		if (o1.getNewZscore() - o1.zScore > this.getNewZscore() - this.zScore
				|| (o1.getNewZscore() - o1.zScore == this.getNewZscore() - this.zScore && o1.id > this.id))
			return 1;
		else {
			return -1;
		}

	}
}

