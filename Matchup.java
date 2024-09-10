public class Matchup {
    private Team team1;
    private Team team2;

    public Matchup(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    /*
     * Return: there is not a player on both teams
     */
    public boolean isAllowed() {

        for (int i = 0; i < team1.getPlayers().length; ++i) {
            for (int j = 0; j < team2.getPlayers().length; ++j) {
                if (team1.getPlayers()[i].equals(team2.getPlayers()[j])) {
                    return false;
                }
            }
        }

        return true;
    }

    // Return: The difference between the average elo of the two teams
    public double eloDiff() {
        return Math.abs(team1.getAverage() - team2.getAverage());
    }

    public String toString() {
        return "\n" + team1.printPlayers() + "\n" + team2.printPlayers() + "\n" + eloDiff() + "\n";
    }

}
