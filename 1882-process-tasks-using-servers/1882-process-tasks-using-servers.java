class Solution {

    class Tri{
        int idx;
        int weight;
        long time;
        Tri(int idx, int weight, long time){
            this.idx = idx;
            this.weight = weight;
            this.time = time;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        PriorityQueue<Tri> pq1 = new PriorityQueue<>((a,b)->{
            if(a.weight != b.weight) return Integer.compare(a.weight,b.weight);
            return Integer.compare(a.idx,b.idx);
        });

        PriorityQueue<Tri> pq2 = new PriorityQueue<>((a,b)->{
            if(a.time != b.time) return Long.compare(a.time,b.time);
            return Integer.compare(a.idx,b.idx);
        });

        for(int i=0;i<n;i++){
            pq1.add(new Tri(i,servers[i],0));
        }

        long currtime = 0;

        for(int i=0;i<m;i++){
            currtime = Math.max(currtime,i);
            while(!pq2.isEmpty() && pq2.peek().time <= currtime){
                pq1.add(pq2.poll());
            }
            if(pq1.isEmpty()){
                currtime = pq2.peek().time;
                while (!pq2.isEmpty() && pq2.peek().time <= currtime) {
                    pq1.add(pq2.poll());
                }
            }

            Tri front = pq1.poll();
            ans[i] = front.idx;
            pq2.add(new Tri(front.idx,front.weight,currtime+tasks[i]));
        }
        return ans;
    }
}