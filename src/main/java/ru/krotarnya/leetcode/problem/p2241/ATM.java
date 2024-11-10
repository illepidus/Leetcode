package ru.krotarnya.leetcode.problem.p2241;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */

@Problem(id = 2241, name = "design-an-atm-machine", className = "ATM", complexity = Complexity.MEDIUM)
public class ATM {
    private static final int[] REJECTED = new int[]{-1};
    private final Map<Banknote, Long> state;

    public ATM() {
        state = new HashMap<>();
    }

    public void deposit(int[] banknotesCount) {
        Arrays.stream(Banknote.values())
                .sorted(Comparator.comparingInt(banknote -> banknote.order))
                .forEach(banknote -> state.compute(banknote, (k, v) -> (v == null)
                        ? banknotesCount[banknote.order]
                        : banknotesCount[banknote.order] + v));
    }

    public int[] withdraw(int amount) {
        AtomicLong debt = new AtomicLong(amount);
        List<Banknotes> withdraw = state.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getKey().order))
                .map(entry -> {
                    long banknotes = Math.min(entry.getValue(), debt.get() / entry.getKey().value);
                    debt.addAndGet(-entry.getKey().value * banknotes);
                    return new Banknotes(entry.getKey(), banknotes);
                })
                .toList();

        if (debt.get() != 0) return REJECTED;

        //noinspection DataFlowIssue
        withdraw.forEach(banknotes -> state.compute(banknotes.banknote, (k, v) -> v - banknotes.amount()));

        return withdraw.stream()
                .sorted(Comparator.comparingInt(banknotes -> banknotes.banknote.order))
                .mapToInt(banknotes -> banknotes.amount.intValue())
                .toArray();
    }

    @Override
    public String toString() {
        return "ATM[total = " +
                state.entrySet().stream().map(b -> b.getKey().value * b.getValue()).reduce(0L, Long::sum) +
                " " +
                state.entrySet().stream().sorted(Comparator.comparingInt(e -> e.getKey().order)).toList() +
                "]";
    }

    private record Banknotes(Banknote banknote, Long amount) {}

    public enum Banknote {
        _20(20, 0),
        _50(50, 1),
        _100(100, 2),
        _200(200, 3),
        _500(500, 4);
        public final int value;
        public final int order;

        Banknote(int value, int order) {
            this.value = value;
            this.order = order;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }
}
