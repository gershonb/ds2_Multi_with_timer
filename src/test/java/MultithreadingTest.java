import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//ANY EDITS WILL RESULT IN POINT REDUCTION

class MultithreadingTest {

    Multithreading m;
    int[] nums;
    long expectedTotal = 0;

    void setUp(){
        nums = new int[1000];
        for(int i = 0; i < nums.length; i++){
            nums[i] = (1 + (int) (Math.random() * 100));
        }
        for(int i : nums){
            expectedTotal += i;
        }
    }

    @Test
    void TestListSum(){
        setUp();
        m = new Multithreading();
        for(int i =1; i<= 512; i*=2){
            assertEquals(String.format("Test Failed for %d threads", i),expectedTotal, m.listSum(nums, i));
        }
    }
}
