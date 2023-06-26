class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int n = costs.length;
        PriorityQueue<int[]> pqLeft = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[1]==b[1]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        PriorityQueue<int[]> pqRight = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[1]==b[1]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        int left = 0;
        int right = n-1;
        while(left<n&&right>=0){
            pqLeft.offer(new int[]{left, costs[left]});
            pqRight.offer(new int[]{right, costs[right]});
            left++;
            right--;
            if(pqLeft.size()==candidates){
                break;
            }
        }

        while(k>0){
            int[] leftMin = pqLeft.peek();
            int[] rightMin = pqRight.peek();
            if(leftMin[0]==rightMin[0]){
                res += leftMin[1];
                pqLeft.poll();
                pqRight.poll();
                costs[leftMin[0]] = 0;
                while(left<n&&costs[left]==0){
                    left++;
                }
                costs[rightMin[0]] = 0;
                while(right>=0&&costs[right]==0){
                    right--;
                }
                if(left<n&&right>=0){
                    pqLeft.offer(new int[]{left, costs[left]});
                    pqRight.offer(new int[]{right, costs[right]});
                    left++;
                    right--;
                }
            }else{
                if(leftMin[1]<=rightMin[1]){
                    res += leftMin[1];
                    pqLeft.poll();
                    costs[leftMin[0]] = 0;
                    while(left<n&&costs[left]==0){
                        left++;
                    }
                    if(left<n){
                        pqLeft.offer(new int[]{left, costs[left]});
                        left++;
                    }
                }else{
                    res += rightMin[1];
                    pqRight.poll();
                    costs[rightMin[0]] = 0;
                    while(right>=0&&costs[right]==0){
                        right--;
                    }
                    if(right>=0){
                        pqRight.offer(new int[]{right, costs[right]});
                        right--;
                    }                   
                }
            }
            k--;
        }

        return res;
    }
}