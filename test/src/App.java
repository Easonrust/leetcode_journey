import java.util.*;

public class App{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(){}
    }
    public static int res=0;
    public static void main(String[] agrs){
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // String[] inOrderStrArr = sc.nextLine().split(" ");
        int[] inArr = {4,2,1,5,7,3,6};
        // String[] postOrderStrArr = sc.nextLine().split(" ");
        int[] postArr = {4,2,7,5,6,3,1};
        int lastIdx = postArr.length-1;
        int rootIdx = 0;
        int rootVal = postArr[lastIdx];
        for(int i=0;i<inArr.length;++i){
            if(inArr[i]==rootVal){
                rootIdx = i;
            }
        }
        int leftIdx = rootIdx-1;
        int rightIdx = rootIdx+1;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inArr, postArr, leftIdx);
        root.right = buildTree(inArr, postArr, rightIdx);
        getMaxLength(root);
        System.out.println(res);
    }
    public static TreeNode buildTree(int[] inArr, int[] postArr, int lastIdx){
        if(lastIdx<0||lastIdx>=inArr.length){
            return new TreeNode();
        }
        int rootIdx = 0;
        int rootVal = postArr[lastIdx];
        for(int i=0;i<inArr.length;++i){
            if(inArr[i]==rootVal){
                rootIdx = i;
            }
        }
        int leftIdx = rootIdx-1;
        int rightIdx = rootIdx+1;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inArr, postArr, leftIdx);
        root.right = buildTree(inArr, postArr, rightIdx);
        return root;
    }
    
    public static int getMaxLength(TreeNode node){
        if(node==null){
            return 0;
        }
        System.out.println(node.val);
        int leftLength = getMaxLength(node.left);
        int rightLength = getMaxLength(node.right);
        res = Math.max(res, leftLength+rightLength+1);
        return Math.max(leftLength+1,rightLength+1);
    }
}