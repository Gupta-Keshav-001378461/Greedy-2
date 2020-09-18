// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] result = new int[n];
        Arrays.fill(result , 1);
        //forward pass
        for(int i = 1; i < n; i++)
        {
            if(ratings[i-1] < ratings[i])
            {
                result[i] = result[i-1] + 1;
            }
        }
        
        //backward pass
        for(int i = n-2; i>=0; i--)
        {
            if(ratings[i+1] < ratings[i] && result[i] <= result[i+1])
            {
                result[i] = result[i+1] + 1;
            }
        }
        int output = 0;
        for(int i : result){
            output += i;
        }

        return output;
    }
}