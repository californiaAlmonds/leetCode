public class SortColors {
    public static int[] sortSimple(int[] colors){
        int count0 = 0, count1 = 0, count2 = 0;
        for(int color: colors){
            if(color == 0) count0++;
            if(color == 1) count1++;
            if(color == 2) count2++;
        }
        for(int i=0; i<colors.length;i++){
            if(count0-->0) colors[i] = 0;
            else if(count1-->0) colors[i] = 1;
            else if(count2-->0) colors[i] = 2;
        }
        return colors;
    }
    public static int[] sortTwoPointer(int[] colors){
        int count = 0;
        for(int i=0; i<colors.length;i++){
            if(colors[i]==0) {
                int temp = colors[count];
                colors[count] = colors[i];
                colors[i] = temp;
                count++;
            }
        }
        for(int i=count;i<colors.length;i++){
            if(colors[i]==1) {
                int temp = colors[count];
                colors[count] = colors[i];
                colors[i] = temp;
                count++;
            }
        }
        return colors;
    }
    public static void main(String[] args) {
        int[] colors = {1,2,0,0,1,2,1};
        for(int i: sortTwoPointer(colors)) System.out.print("\s" + i);
    }
    private static int[] sort(int[] colors) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }
}
