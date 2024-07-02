package miniroulette.model.player;

public class StrategicPlayer {

    private Integer id;

    private String strategy;

    private Integer betInitial;

    private Integer bet;

    private String comb;

    private Double bankroll;

    private Double balance;

    private Integer launches;

    public StrategicPlayer(Integer id, String strategy,
                           Integer betInitial, Integer bet, String comb, Double bankroll, Double balance, Integer launches) {
        this.id = id;
        this.strategy = strategy;
        this.betInitial = betInitial;
        this.bet = bet;
        this.comb = comb;
        this.bankroll = bankroll;
        this.balance = balance;
        this.launches = launches;
    }

    public Integer getId()  {
        return id;
    }

    public Integer getBetInitial() {
        return betInitial;
    }


    public Integer getBet() {
        return bet;
    }

    public String getComb() {
        return comb;
    }

    public Double getBankroll() {
        return bankroll;
    }

    public Integer getLaunches() {
        return launches;
    }


    public String getStrategy() {
        return strategy;
    }

    public Double getBalance() {
        return balance;
    }


    @Override
    public String toString() {
        return "StrategicPlayer{" +
                "id=" + id +
                ", strategy='" + strategy + '\'' +
                ", betInitial=" + betInitial +
                ", bet=" + bet +
                ", comb='" + comb + '\'' +
                ", bankroll=" + bankroll +
                ", balance=" + balance +
                ", launches=" + launches +
                '}';
    }
}
