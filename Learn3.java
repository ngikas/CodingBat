import java.util.*;

public class Learn3 {
	public static void main(String[] args) {
		int[] array = {1, 9, 11, 13, 2, 3, 7};
		pairSum(array, 12);
	}

	static void pairSum(int[] ar, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ar.length; i++) {
			int complement = k - ar[i];
			map.put(ar[i], complement);
			//the complements of later i values are the original values (ar[i])
			if (map.containsKey(complement)) System.out.print(complement + " " + map.get(complement) + " ");
		}
	}

	static void primePrimeMap(int[] array){
		int max = 0;
		int primePrimeVal = 0;
		HashMap<Integer, Integer> primes = sieveForMaps(10000);
		for (int i = 0; i < array.length; i++) {
			for (int j = 2; j <= array[i]; j++) {
				if (primes.get(j) != null && array[i] % j == 0) {
					primes.put(j, primes.get(j) + 1);
					if (primes.get(j) > max) {
						max = primes.get(j);
						primePrimeVal = j;
					}
				}
			}
		}
		System.out.println(primePrimeVal);
	}
	
	static HashMap sieveForMaps(int n) {
		int[] primes = new int[n + 1];
		primes[0] = -1;
		primes[1] = -1;
		for (int i = 2; i <= n; i++) {
			if (primes[i] == 0) {
				for (int j = 2; i * j <= n; j++) {
					primes[i*j] = -1;
				}
			}
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int k = 2; k < primes.length; k++) {
			if (primes[k] == 0) map.put(k, 0);
		}
		return map;
	}

	static void countPrimes(int[] ar){
		int count = 0;
		HashSet<Integer> primes = sieveForSets(10000);
		for (int i = 0; i < ar.length; i++) {
			if (primes.contains(ar[i])) count++;
		}
		System.out.println(count);
	}

	static HashSet sieveForSets(int n) {
		int[] primes = new int[n + 1];
		primes[0] = -1;
		primes[1] = -1;
		for (int i = 2; i <= n; i++) {
			if (primes[i] == 0) {
				for (int j = 2; i * j <= n; j++) {
					primes[i*j] = -1;
				}
			}
		}
		HashSet<Integer> primeNumbers = new HashSet<Integer>();
		for (int k = 2; k < primes.length; k++) {
			if (primes[k] == 0) primeNumbers.add(k);
		}
		return primeNumbers;
	}
}