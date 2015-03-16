import static org.junit.Assert.*;


import org.junit.Test;
import java.util.*;

public class HashSetTester {

    @Test
    public void testConstructorsAndInitialization() {
        HashSet<String> hs= new HashSet<String>();
        assertEquals(0, hs.size());
        assertEquals(HashSet.Initial_Capacity, hs.capacity());
        assertEquals(0, hs.getRehashes());
    }
    
    @Test
    public void testSize1and2Set() {
        HashSet<String> hs= new HashSet<String>();
        hs.add("abc"); 
        assertEquals(1, hs.size());
        assertEquals(HashSet.Initial_Capacity, hs.capacity());
        assertEquals(0, hs.getRehashes());
        assertEquals(true, hs.contains("abc"));
        assertEquals(false, hs.contains("abcd"));
        
        hs.add("abc");  
        assertEquals(1, hs.size());
        assertEquals(HashSet.Initial_Capacity, hs.capacity());
        assertEquals(0, hs.getRehashes());
        assertEquals(true, hs.contains("abc"));
        assertEquals(false, hs.contains("abcd"));
        
        hs.add("abcd");  
        assertEquals(2, hs.size());
        assertEquals(HashSet.Initial_Capacity, hs.capacity());
        assertEquals(0, hs.getRehashes());
        assertEquals(true, hs.contains("abc"));
        assertEquals(true, hs.contains("abcd"));
    }
    
    @Test
    public void testIncreaseCapacity() {
        HashSet<String> hs= new HashSet<String>();
        hs.add("abc");  
        hs.add("abcd");
        hs.add("a"); 
        assertEquals(3, hs.size());
        // capacity should be 13 because size was 3, 3*4 is 12,
        // next prime is 13
        assertEquals(13, hs.capacity());
        assertEquals(1, hs.getRehashes());
        assertEquals(true, hs.contains("abc"));
        assertEquals(true, hs.contains("abcd"));
        assertEquals(true, hs.contains("a"));
        
        hs.add("1");
        hs.add("2");
        hs.add("3");
        assertEquals(13, hs.capacity());
        assertEquals(1, hs.getRehashes());
        
        hs.add("4");
        assertEquals(29, hs.capacity());
        assertEquals(2, hs.getRehashes()); 
    }
    
    @Test
    public void testRemove() {
        HashSet<String> hs= new HashSet<String>();
        for (int i= 0; i < 100; i= i+1) {
            hs.add(i + "");
        }
        
        for (int i= 0; i < 100; i= i+1) {
            boolean x= hs.remove(i + "");
            assertEquals(true, x);
            assertEquals(false, hs.contains(i + ""));
            if (i != 0) {
                x= hs.remove(i + "");
                assertEquals(false, x);
            }
        }
        
        assertEquals(5, hs.capacity());
        assertEquals(0, hs.size());
        assertEquals(10, hs.getRehashes());
    }
    

   
    @Test
    public void testAddInteger() {
        HashSet<Integer> hs= new HashSet<Integer>();
        for (int i= 0; i < 20; i= i+1) {
            hs.add(i);
        }
        for (int i= 0; i < 20; i= i+1) {
            assertEquals(true, hs.contains(i));
        }
        assertEquals(false, hs.contains(20));
    }
    
    
    
    
   

}
