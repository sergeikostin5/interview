package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 4/1/18.
 */
public class FrogJump {

    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) return false;
        Wrapper wrapper = new Wrapper(0,0);
        return canCross(stones, wrapper);
    }

    private boolean canCross(int[] stones, Wrapper wrapper ){
        if(wrapper.index == stones.length - 1) return true;
        if(stones[wrapper.index] + wrapper.units+1 < stones[wrapper.index+1] )return false;

        List<Wrapper> candidates = getCandidates(stones, wrapper);
        if(!candidates.isEmpty()){
            for(Wrapper w : candidates){
                if(canCross(stones, w)) return true;
            }
        }
        return false;
    }

    private List<Wrapper> getCandidates(int[] stones, Wrapper wrapper){
        List<Wrapper> result = new ArrayList<>();
        int current = stones[wrapper.index];
        for(int i = wrapper.index+1; i < stones.length && stones[i] <= current + wrapper.units+1; i++){
            if(stones[i] == current + wrapper.units){
                result.add(new Wrapper(wrapper.units , i));
            } else if (stones[i] == current + wrapper.units - 1){
                result.add(new Wrapper(wrapper.units - 1, i));
            } else if (stones[i] == current + wrapper.units+1){
                result.add(new Wrapper(wrapper.units + 1, i));
            }
        }
        return result;
    }

    private static class Wrapper{
        int units;
        int index;

        public Wrapper(int units, int index) {
            this.units = units;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        int[] stonesfail = {0,1,2,3,4,8,9,11};
        int[] reallylong = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,99999999};
        FrogJump fj = new FrogJump();
        System.out.println(fj.canCross(reallylong));
    }
}
