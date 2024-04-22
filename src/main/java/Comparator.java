import java.util.Scanner;

public class Comparator {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Player[] player = new Player[count];


        for (int i=0 ; i<count ; i++){
            player[i] = new Player(sc.next(), sc.nextInt());
        }
        sc.close();

    }
}
class Player{
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    String name;
    int score;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
class Checker implements java.util.Comparator<Player>{
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.score == o2.score) {
            return ((o1.name).compareTo(o2.name));
        } else {
            System.out.println("else method");
            System.out.println((o2.score - o1.score));
            return ((o2.score - o1.score));

        }
    }
}
