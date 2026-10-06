class Solution {
    public int maxLength(List<String> arr) {
        List<Integer>masks=new ArrayList<>();
        masks.add(0);
        int max=0;
        for(String s:arr){
            int mask=0;
            for(char c:s.toCharArray()){
                int bit=1<<(c-'a');
                if((mask&bit)!=0){
                    mask=0;
                    break;
                }
                mask|=bit;

            }
            if(mask==0)
                continue;
                int size=masks.size();
                for(int i=0;i<size;i++){
                    if((masks.get(i)&mask)==0){
                        int newmask=masks.get(i)|mask;
                        masks.add(newmask);
                        max=Math.max(max,Integer.bitCount(newmask));
                    }
                }
            }

        
        return max;
    }
}