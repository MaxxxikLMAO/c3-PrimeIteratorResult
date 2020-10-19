import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


public class PrimesIterator implements Iterator<Integer> {

    private List<Integer> primesCache = new ArrayList<>();
    private int i = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        do {
            i++;
        } while (!isPrime(i));
        return i;
    }

    private boolean isPrime(int i) {
        //int sqroot = (int) Math.sqrt(i);
        for (int j : primesCache) {
            if (i % j == 0) {
                return false;
            }
        }
        primesCache.add(i);
        return true;
    }
    public static void main(String[] args) {
        Iterable<Integer> primes = new PrimesIterable();
        for (int prime : primes) {
            if (prime > 100) break;
            System.out.println(prime);
        }
    }
}
