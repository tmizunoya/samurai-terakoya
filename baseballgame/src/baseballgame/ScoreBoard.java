package baseballgame;

public class ScoreBoard {
    private Team homeTeam;
    private Team awayTeam;
    private int[][] scores; // [2][9]

    public ScoreBoard(Team awayTeam, Team homeTeam) {
    	//コンストラクタ
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.scores = new int[2][9];
    }

    public void addScore(Team team, int inning, int runs) {
        int teamIndex = team.equals(awayTeam) ? 0 : 1;
        scores[teamIndex][inning - 1] += runs;
    }

    public int getTotalScore(Team team) {
        int index = team.equals(awayTeam) ? 0 : 1;
        int total = 0;
        for (int i = 0; i < 9; i++) total += scores[index][i];
        return total;
    }

    public void printScoreBoard() {
        System.out.println("🏟 SCOREBOARD");
        System.out.print("Inning    : ");
        for (int i = 1; i <= 9; i++) System.out.print(i + " ");
        System.out.println("| Total");

        System.out.print(awayTeam.getName() + ": ");
        for (int i = 0; i < 9; i++) System.out.print(scores[0][i] + " ");
        System.out.println("| " + getTotalScore(awayTeam));

        System.out.print(homeTeam.getName() + ": ");
        for (int i = 0; i < 9; i++) System.out.print(scores[1][i] + " ");
        System.out.println("| " + getTotalScore(homeTeam));
    }
}
