
public class ScoreCard {
	private int Point[] = { 0, 0 };
	private int Game[] = { 0, 0 };
	private int Set[] = { 0, 0 };
	private String finishedSet[] = { "", "" };
	private int noOfSets;
	boolean over;

	private boolean isGame() {
		return Math.max(Point[0], Point[1]) >= 4 && Math.abs(Point[1] - Point[0]) >= 2;
	}

	private boolean isSet() {
		return Math.max(Game[0], Game[1]) >= 6 && Math.abs(Game[0] - Game[1]) >= 2;
	}

	private boolean isMatch() {
		return Math.max(Set[0], Set[1]) > noOfSets / 2;
	}

	public ScoreCard() {
		noOfSets = 3;
		over = false;
	}

	public ScoreCard(int noOfSets) {
		this.noOfSets = noOfSets;
		over = false;
	}

	public void addScore(char player) {
		int playerIndex = player - 'A';
		if (!over) {
			Point[playerIndex]++;
			if (isGame()) {
				Point[0] = Point[1] = 0;
				Game[playerIndex]++;
				if (isSet()) {
					System.out.println("SET OVER!");
					finishedSet[playerIndex] = finishedSet[playerIndex] + "\t" + Integer.toString(Game[playerIndex]);
					finishedSet[(playerIndex + 1) % 2] = finishedSet[(playerIndex + 1) % 2] + "\t"
							+ Integer.toString(Game[(playerIndex + 1) % 2]);
					Game[0] = Game[1] = 0;
					Set[playerIndex]++;
					if (isMatch()) {
						over = true;
					}
				}
			}
		}
	}

	public char winner() {
		if (over) {
			if (Set[0] > Set[1])
				return 'A';
			else
				return 'B';
		} else
			return '-';
	}

	public boolean isOver() {
		return over;
	}

	public String getPoint(int playerIndex) {
		final String[] POINT_VALUES = { "0", "15", "30", "40" };
		String out = "";
		if (Point[playerIndex] <= 3)
			return POINT_VALUES[Point[playerIndex]];
		else {
			if (Point[playerIndex] > Point[(playerIndex + 1) % 2])
				return "A";
			else
				return "40";
		}
	}

	public void print() {
		if (over) {
			System.out.println("--------------------------------------------------");
			System.out.println("A\t" + getPoint(0) + "\t" + finishedSet[0]);
			System.out.println("B\t" + getPoint(1) + "\t" + finishedSet[1]);
			System.out.println("Match Over! Winner : " + winner());
		} else {
			System.out.println("--------------------------------------------------");
			System.out.println("A\t" + getPoint(0) + "\t" + finishedSet[0] + "\t" + Game[0]);
			System.out.println("B\t" + getPoint(1) + "\t" + finishedSet[1] + "\t" + Game[1]);
		}
	}

	public static void main(String[] args) {
		final String INPUT = "AAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		ScoreCard scorecard = new ScoreCard();
		for (char player : INPUT.toCharArray()) {
			if (!scorecard.isOver()) {
				scorecard.addScore(player);
				scorecard.print();
			}
		}

	}

}
