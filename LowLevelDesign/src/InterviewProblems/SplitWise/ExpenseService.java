package InterviewProblems.SplitWise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService {

    Map<String, User> users = new HashMap<>();
    Map<User, Map<User, Double>> balances = new HashMap<>();

    public void addExpense(User paidBy, double amount, List<Split> splits, ExpenseType type) {
        validateSplits(amount, splits, type);

        for (Split split : splits) {

            User user = split.user;
            double oweAmount = split.amount;

            if (user.equals(paidBy)) continue;

            balances.computeIfAbsent(paidBy, k -> new HashMap<>()).merge(user, oweAmount, Double::sum);
            balances.computeIfAbsent(user, k -> new HashMap<>()).merge(paidBy, -oweAmount, Double::sum);
        }
    }

    void validateSplits(double amount, List<Split> splits, ExpenseType type) {

        if (type == ExpenseType.EXACT) {
            double sum = splits.stream().mapToDouble(s -> s.amount).sum();
            if (sum != amount) throw new IllegalArgumentException();
        }

        if (type == ExpenseType.PERCENT) {
            double percentSum =
                    splits.stream()
                            .map(s -> ((PercentSplit)s).percent)
                            .mapToDouble(p -> p)
                            .sum();
            if (percentSum != 100) throw new IllegalArgumentException();
        }
    }

    void showBalances() {
        for (User u1 : balances.keySet()) {
            for (User u2 : balances.get(u1).keySet()) {
                double amount = balances.get(u1).get(u2);
                if (amount > 0) {
                    System.out.println(
                            u2.name + " owes " + u1.name + " : " + amount
                    );
                }
            }
        }

    }
}
