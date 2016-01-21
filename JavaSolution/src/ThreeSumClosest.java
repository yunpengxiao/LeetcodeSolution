import java.util.Arrays;

/**
 * Created by xyunpeng on 1/20/16.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            while(i>0 && nums[i]==nums[i-1] && i<nums.length-2) i++;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int tmp = nums[i]+nums[j]+nums[k]-target;
                if(tmp==0) return target;
                min=Math.abs(min)<Math.abs(tmp)?min:tmp;
                /*while(j<k && nums[j]==nums[j+1]) j++;                   //不能加这个, [4,4,4,7] 12 就过不了
                while(j<k && nums[k]==nums[k-1]) k--; */
                if(tmp<0) j++;
                else k--;
            }
        }
        return target+min;
    }
}
