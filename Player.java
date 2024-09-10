public class Player {
    public String name;
    public int elo;

    public Player(String name, int elo) {
        this.name = name;
        this.elo = elo;
    }

    public boolean equals(Player player) {
        return player.getName().equals(this.getName()) && player.getElo() == this.getElo();
    }

    public String getName() {
        return name;
    }

    public int getElo() {
        return elo;
    }

    public String toString() {
        return name + " " + elo;
    }
}
