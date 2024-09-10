import java.io.*;
import java.util.*;

public class InhouseCalc {
    public static void main(String[] args) throws NumberFormatException, IOException {

        // get all the players that could be playing
        ArrayList<Player> players = getPlayers("input.txt");

        // create all teams
        ArrayList<Team> teams = getTeams(players);

        // create all matchups
        ArrayList<Matchup> matchups = createMatchups(teams);

        // sort by elo difference
        matchups = quickSort(matchups);

        // return all the matchups
        outputMatchups(matchups);
    }

    public static ArrayList<Player> getPlayers(String fileName) throws NumberFormatException, IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<Player> players = new ArrayList<Player>();
        String line;

        while ((line = br.readLine()) != null) {
            String[] input = line.split("\t");
            players.add(new Player(input[0], Integer.parseInt(input[1])));
        }

        br.close();

        return players;
    }

    private static ArrayList<Team> getTeams(ArrayList<Player> players) {

        // store the number of players
        int length = players.size();

        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < length - 4; ++i) {
            for (int j = i + 1; j < length - 3; ++j) {
                for (int k = j + 1; k < length - 2; ++k) {
                    for (int l = k + 1; l < length - 1; ++l) {
                        for (int m = l + 1; m < length; ++m) {
                            teams.add(new Team(players.get(i), players.get(j), players.get(k),
                                    players.get(l), players.get(m)));
                        }
                    }
                }
            }
        }

        return teams;
    }

    private static ArrayList<Matchup> createMatchups(ArrayList<Team> teams) {
        ArrayList<Matchup> matchups = new ArrayList<>();

        for (int i = 0; i < teams.size(); ++i) {
            for (int j = i + 1; j < teams.size(); ++j) {
                Matchup lookAt = new Matchup(teams.get(i), teams.get(j));
                if (lookAt.isAllowed()) {
                    matchups.add(lookAt);
                }
            }
        }

        return matchups;
    }

    private static ArrayList<Matchup> quickSort(ArrayList<Matchup> matchups) {
        int length = matchups.size();
        if (length <= 1)
            return matchups;

        Matchup pivot = matchups.get(length - 1);
        ArrayList<Matchup> left = new ArrayList<>();
        ArrayList<Matchup> right = new ArrayList<>();

        for (int i = 0; i < length - 2; ++i) {
            if (matchups.get(i).eloDiff() < pivot.eloDiff())
                left.add(matchups.get(i));
            else
                right.add(matchups.get(i));
        }

        left = quickSort(left);
        right = quickSort(right);

        ArrayList<Matchup> output = new ArrayList<>();
        for (Matchup matchup : left) {
            output.add(matchup);
        }

        output.add(pivot);

        for (Matchup matchup : right) {
            output.add(matchup);
        }

        return output;
    }

    private static void outputMatchups(ArrayList<Matchup> matchups) throws IOException {
        FileWriter fileWriter = new FileWriter("Output.txt");

        for (Matchup matchup : matchups) {
            fileWriter.write(matchup.toString());
        }
        fileWriter.close();
    }
}
