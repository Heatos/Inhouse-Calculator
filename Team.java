public class Team {

    public Player[] players = new Player[5];
    public double average;

    public Team(Player player1, Player player2, Player player3, Player player4, Player player5) {
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;
        players[4] = player5;
        average();
    }

    /*
     * Player: The player being looked for
     * Return: if this player is within this team
     */
    public boolean containsPlayer(Player player) {
        for (int i = 0; i < players.length; ++i) {
            if (players[i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // returns the average elo of team
    private void average() {
        average = (players[0].getElo() + players[1].getElo() + players[2].getElo() + players[3].getElo()
                + players[4].getElo()) / players.length;
    }

    // returns the average elo of team
    public double getAverage() {
        return average;
    }

    public String toString() {
        return players[0] + " " + players[1] + " " + players[2] + " " + players[3] + " " + players[4] + " " + average;
    }

    // return: the array of the players
    public Player[] getPlayers() {
        return players;
    }

    // returns the length of how many players are on the team
    public int length() {
        return players.length;
    }

    // Return: All the players names with a space between
    public String printPlayers() {
        return players[0].getName() + " " + players[1].getName() + " " + players[2].getName() + " "
                + players[3].getName() + " " + players[4].getName();
    }

}
