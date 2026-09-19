class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int cx;
        int cy;
        if(xCenter < x1) cx = x1;
        else if(xCenter > x2) cx = x2;
        else cx = xCenter;

        if(yCenter < y1) cy = y1;
        else if(yCenter > y2) cy = y2;
        else cy = yCenter;

        int xc = xCenter - cx;
        int xy = yCenter - cy;

        return xc*xc + xy*xy <= radius*radius;
    }
}