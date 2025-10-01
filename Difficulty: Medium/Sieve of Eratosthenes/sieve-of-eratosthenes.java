class Solution {
    public int[] sieve(int n) {
        // code here
        
        if(n < 2) return new int[0];
        
        boolean[] primes = new boolean[n+1];
        for(int i=2;i<=n;i++){
            primes[i] = true;
        }
        
        
        for(int i=2;i*i<=n;i++){
            if(primes[i]){
                
                for(int j=2*i;j<=n;j+=i){ // i is prime
                                          // Mark multiples of i as non-prime
                  primes[j] = false;
              }
            }
        }
        
        List<Integer> primeList = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(primes[i]){
                primeList.add(i);
            }
        }
        
        int[] result = new int[primeList.size()];
        for(int i=0;i<primeList.size();i++){
            result[i] = primeList.get(i);
        }
        
        return result;
        
        
        
    }
}