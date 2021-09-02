public class SpireAttack {
    private int n, max;
    private int[] a;
    private int[] b;

    private void f(int idx, int actSum, int damSum) {
        max = Math.max(max, damSum);
        for (int i = idx+1; i < n; i++) {
            if (actSum + a[i] > 3) continue;
            f(i, actSum + a[i], damSum + b[i]);
        }
    }

    public int dealMostDamage(int N, int[] actions, int[] damage) {
        n = N;
        a = actions;
        b = damage;

        if (N == 1) {
            return damage[0];
        }
        if (N == 2) {
            if (actions[0] + actions[1] <= 3) return damage[0] + damage[1];
            else return Math.max(damage[0], damage[1]);
        }

        f(-1, 0, 0);
        return max;
    }
}
