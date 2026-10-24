class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] aa = arriveAlice.split("-");
        int aam = Integer.parseInt(aa[0]);
        int aad = Integer.parseInt(aa[1]);

        String[] al = leaveAlice.split("-");
        int alm = Integer.parseInt(al[0]);
        int ald = Integer.parseInt(al[1]);

        String[] ba = arriveBob.split("-");
        int bam = Integer.parseInt(ba[0]);
        int bad = Integer.parseInt(ba[1]);

        String[] bl = leaveBob.split("-");
        int blm = Integer.parseInt(bl[0]);
        int bld = Integer.parseInt(bl[1]);

        int sm, sd;
        if(aam > bam || (aam == bam && aad > bad)){
            sm = aam;
            sd = aad;
        }else{
            sm = bam;
            sd = bad;
        }

        int em, ed;
        if(alm > blm || (alm == blm && ald > bld)){
            em = blm;
            ed = bld;
        }else{
            em = alm;
            ed = ald;
        }

        int st = sd;
        int en = ed;
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=0;i<sm-1;i++){
            st += days[i];
        }

        for(int i=0;i<em-1;i++){
            en += days[i];
        }

        if(st > en) return 0;
        return en - st + 1;

    }
}