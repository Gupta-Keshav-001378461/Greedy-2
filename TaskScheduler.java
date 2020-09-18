// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character , Integer> map= new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        for(int i = 0; i < tasks.length; i++)
        {
            map.put(tasks[i] , map.getOrDefault(tasks[i] , 0) + 1);
            maxFreq = Math.max(maxFreq , map.get(tasks[i])); //getting the max Frequency task
        }
        
        for(char c : map.keySet())
        {
            if(map.get(c) == maxFreq)
            {
                
                maxCount++;
            }
        }
        
        int partition = maxFreq - 1;
        int emptySpots = (n - maxCount + 1) * partition;
        int pendingTasks = tasks.length - (maxCount * maxFreq);
        int idle = Math.max(0 , emptySpots - pendingTasks);
        return idle + tasks.length;
    }
}