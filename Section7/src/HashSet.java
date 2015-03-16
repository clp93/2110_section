/** An instance is a set of elements of type T that is implemented using a hash table 
 * with quadratic probing. Null is not allowed in the set.
 * Matches are based on T.equals(T); and method hashCode must be consistently defined.
 * The implementation guarantees that the load factor is at most 1/2, so that
 * all operations take O(1) expected time --amortized over all operations performed. 
 */
public class HashSet<T> {
    /** Capacity of initial hash set. */
    public static final int Initial_Capacity= 5;

    private int numberOfRehashes= 0;  // Number of rehashes performed on this instance
    private HashEntry<T>[] b;        // The array in which the hashed elements are placed.
    // elements may not be null
    private int size= 0;             // The number of entries in the set
    private int occupied= 0;         // The number of array elements that are occupied
                                     // Elements removed from the set may remain in b)

    /**  Constructor: an empty HashSet. */
    @SuppressWarnings("unchecked")
    public HashSet() {
        b= new HashEntry[Initial_Capacity];
        clear();
    }

    /** = the number of items in this set. */
    public int size() {
        return size; 
    }

    /** = the capacity of this set
        --i.e. size of the array used to hold its elements. */
    public int capacity() {
        return b.length;
    }

    /** = the number of rehashes performed on this set
          since the last operation to set size to 0. */
    public int getRehashes() {
        return numberOfRehashes; 
    }

    /**  = "x is in the set".
        Precondition: x is not null. */
    public boolean contains(T x) {
        assert x != null;
        int pos= quadraticProbe(x);
        if (b[pos] == null)
            return false;

        return b[pos].isInSet;
    }

    /** Add item x to this set and return value of sentence
        "x was added because it was not yet in the set."
        Precondition: x is not null. */
    public boolean add(T x) {
        assert x != null;
        int pos= quadraticProbe(x);
        if (b[pos] != null  &&  b[pos].isInSet) { 
            return false;  // x is already in set
        }

        if (b[pos] == null) { // No entry in array for x. Add entry
            b[pos]= new HashEntry<T>(x, false);
            occupied= occupied+1;
        }

        b[pos].isInSet= true;
        size= size+1;

        if (occupied > b.length/2)        
            rehash();

        return true;                   
    }

    /** Rehash array b */
    @SuppressWarnings("unchecked")
    private void rehash( ) {
        HashEntry<T>[] oldb= b;  // copy of array

        // Create a new, empty array. This is used both for increasing and
        // decreasing the capacity; hence the Math.max expression.
        b= new HashEntry[nextPrime(Math.max(4*size, Initial_Capacity))];
        size= 0;
        occupied= 0;

        // Copy elements from oldb to b
        for (int i= 0; i != oldb.length; i= i+1)
            if (oldb[i] != null  &&  oldb[i].isInSet) 
                add((T)oldb[i].element);

        numberOfRehashes= numberOfRehashes+1;
    }

    /** Remove item x from this set (if it is in it) and return value of sentence
        "x was removed because it was in the set".
        Precondition: x is not null. */
    public boolean remove(T x) {
        assert x != null;
        int pos= quadraticProbe(x);
        if (b[pos] == null || !b[pos].isInSet)  // x is not in set
            return false;

        // x is in the set --remove it.
        b[pos].isInSet= false;
        size= size-1;   

        if(size < b.length/8)  // if load factor is really small
            rehash();          // use a smaller array

        return true;
    }

    /** Change the size of this set to zero --but do not rehash. */
    public void clear() {
        size= 0;
        occupied= 0;
        for (int i= 0; i != b.length; i= i+1) {
            b[i]= null;
        }
    }

    /** = the index in array b of x or where x will be put (using quadratic probing).
    Precondition: x may not be null. */
    private int quadraticProbe(T x) {
        assert x != null;
        // Remember: probe positions k+H(0), k+H(1), k+H(2), ... are defined by:
        // H(0) = 0  and  H(i+1)  =  H(i) + 2i + 1.
        int i= 0;
        int k= Math.abs(x.hashCode() % b.length);
        // inv: k = Hi, and x is not one of b[k+H(0)], ..., b[k+H(i)-1]
        while (b[k] != null  &&  !x.equals(b[k].element)) { 
            k= (k + 2*i + 1) % b.length; // Store H(i+1) --next probe position-- in k          
            i= i+1;
        }

        return k;
    }

    /** = a prime number at least as large as n.
    Precondition: 1 < n. */
    private static int nextPrime(int n) {
        assert 1 < n;
        // Ensure that n is odd
        if (n%2== 0)
            n= n+1;

        // increase n until it prime
        while (!isPrime(n)) {
            n= n+2;
        }

        return n;
    }

    /** = "n is prime".
     Precondition: n > 3 and n is odd. */
    private static boolean isPrime(int n) {
        assert 3 < n;

        for (int i= 3; i*i <= n; i= i+2)
            if (n % i == 0)
                return false;
        
        return true;
    }

    /** An instance is an entry that can go in the hash table */
    private static class HashEntry<T> {
        public T element;   // the element
        public boolean isInSet;   // = "the element is in the set""

        /** Constructor: an entry that is in the set */
        private HashEntry(T e) {
            this(e, true);
        }

        /** Constructor: an entry that is in the set iff b */
        private HashEntry(T e, boolean b) {
            element= e;
            isInSet= b;
        }
    }
}
