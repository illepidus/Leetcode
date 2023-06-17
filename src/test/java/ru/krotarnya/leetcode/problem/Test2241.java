package ru.krotarnya.leetcode.problem;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.problem.p2241.ATM;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test2241 {
    @Test
    void test() {
        ATM atm = new ATM();
        deposit(atm, List.of(10, 14, 6, 5, 5));
        assertArrayEquals(withdraw(atm,1001), new int[]{-1});
        assertArrayEquals(withdraw(atm,1000), new int[]{0,  0,  0, 0, 2});
        assertArrayEquals(withdraw(atm,1000), new int[]{0,  0,  0, 0, 2});
        assertArrayEquals(withdraw(atm,1000), new int[]{0,  0,  1, 2, 1});
        assertArrayEquals(withdraw(atm,1000), new int[]{0,  0,  4, 3, 0});
        assertArrayEquals(withdraw(atm,1000), new int[]{10, 14, 1, 0, 0});
        assertArrayEquals(withdraw(atm,1000), new int[]{-1});
    }
    
    private static void deposit(ATM atm, List<Integer> banknotesCount) {
        System.out.println("----------------DEPOSIT  OPERATION----------------");
        System.out.println("STATE = " + atm);
        System.out.println("DEPOSIT " + 
                Arrays.stream(ATM.Banknote.values())
                        .map(b -> b.value * banknotesCount.get(b.order))
                        .reduce(0, Integer::sum) + " " + banknotesCount);
        atm.deposit(banknotesCount.stream().mapToInt(i->i).toArray());
        System.out.println("STATE = " + atm);
    }

    private static int[] withdraw(ATM atm, int amount) {
        System.out.println("----------------WITHDRAW OPERATION----------------");
        System.out.println("STATE = " + atm);
        System.out.println("WITHDRAW " + amount);
        int[] withdraw = atm.withdraw(amount);
        System.out.println("RECEIVED " + Arrays.toString(withdraw));
        System.out.println("STATE = " + atm);
        return withdraw;
    }
}
