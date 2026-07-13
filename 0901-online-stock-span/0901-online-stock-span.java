class StockSpanner {

    class Pair{
        int price;
        int idx;
        Pair(int price, int idx){
            this.price = price;
            this.idx = idx;
        }
    }
    Stack<Pair> st;
    int idx;
    public StockSpanner() {
        st = new Stack<>();
        idx = 0;
    }
    
    public int next(int price) {
        while(st.size() > 0 && price >= st.peek().price) st.pop();
        int ans = 0;
        if(st.size() == 0) ans = idx+1;
        else ans = idx - st.peek().idx;
        st.push(new Pair(price,idx));
        idx++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */