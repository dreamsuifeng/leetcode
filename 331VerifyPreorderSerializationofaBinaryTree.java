public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack=new Stack<>();
        String[] s=preorder.split(",");
        for (String t:s){
            if (!t.equals("#")){
                stack.push(t);
            }else if (t.equals("#") && !stack.peek().equals("#")){
                stack.push(t);
            }else{
                stack.pop();
                stack.pop();
                while(stack.peek().equals("#")){
                    stack.pop();
                    stack.pop();
                }
                stack.push("#");
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}