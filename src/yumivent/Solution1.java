package yumivent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {

    static class Result implements Comparable<Result>{
        private int start;
        private int end;
        private int length;

        public Result(int start, int end, int length){
            this.start = start;
            this.end = end;
            this.length = length;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Result o) {
            // 길이 오름차순
            if(this.length != o.length){
                return Integer.compare(this.length, o.length);
            }

            // 시작 인덱스 오름차순순
            return Integer.compare(this.start, o.start);
        }
    }

    public int[] solution(int[] sequence, int k) {
        List<Result> resultList = new ArrayList<>();

        int length = sequence.length;
        for(int i=0;i<length;i++){
            int sum = sequence[i];
            if(sum == k){
                resultList.add(new Result(i,i,0));
                continue;
            }

            for(int j=i+1;j<length;j++){
                sum += sequence[j];

                if(sum > k){
                    break;
                }

                if(sum == k){
                    resultList.add(new Result(i,j,j-i));
                    break;
                }
            }
        }

        Collections.sort(resultList);
        Result result = resultList.get(0);
        return new int[]{result.getStart(), result.getEnd()};
    }

}
