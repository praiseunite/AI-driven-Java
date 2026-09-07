import com.aptech.vote.Candidate;

public class VotingMachine {
    public static void main(String[] args) {
        Candidate[] ballot = {
            new Candidate("Ada"), new Candidate("Bode"), new Candidate("Chi")
        };
        String[] votes = {"Ada", "Chi", "Ada", "Bode", "Ada", "Chi", "Chi", "Chi", "Ada"};

        for (String v : votes) {
            for (Candidate c : ballot) {
                if (c.getName().equals(v)) { c.addVote(); break; }
            }
        }

        Candidate winner = ballot[0];
        System.out.println("=== RESULTS ===");
        for (Candidate c : ballot) {
            System.out.println(c);
            if (c.getVotes() > winner.getVotes()) winner = c;
        }
        System.out.println("Winner: " + winner.getName());
    }
}
