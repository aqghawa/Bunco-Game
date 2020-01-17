public class Bunco {
	
	public static int diceRoll() {
		int num = (int) (Math.random()*6) + 1;
		return num;
	}
	
	public static int getScore(int r1, int r2, int r3, int round) {
		if(r1 == r2 && r2 == r3 && r3==round) {
			return 21;
		} else if (r1 == r2 && r2== r3) {
			return 5;
		} else if ((r1 == round && r2 ==round) || (r1 == round && r3 ==round) || (r2 == round && r3 ==round)) {
			return 2;
		} else if (r1 == round || r2 == round || r3 == round) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int playOneRound(String name, int round) {
		if(round >= 1 && round <= 6) {
			int r1 = diceRoll();
			int r2 = diceRoll();
			int r3 = diceRoll();
			int score = getScore(r1,r2,r3,round);
			System.out.println(name + " rolled " + r1 + " " + r2 +" "+ r3 +" and scored " + score + " in round " + round);
			return score;
		} else {
			System.out.println("Error, the rounds can only be 1 to 6");
			return -1;
		}
	}
	
	public static void playBunco(String name1, String name2) {
		int s1=0;
		int s2=0;
		for(int i=1; i<=6; i++) {
			s1 = playOneRound(name1, i)+ s1;
			s2 = playOneRound(name2, i) + s2;
		}
		if(s1 == s2) {
			System.out.println("It's a tie, both scored " + s1);
		} if (s1>s2) {
			System.out.println(name1 +" scored "+s1+" and " + name2 + " scored " + s2 + ". The winner is " +name1);
		} if (s1<s2) {
			System.out.println(name1 +" scored "+s1+" and " + name2 + " scored " + s2 + ". The winner is " +name2);
		}
	}
	
	public static void main(String[] args) {
		String name1 = args[0];
		String name2 = args[1];
		playBunco(name1, name2);
	}
}
