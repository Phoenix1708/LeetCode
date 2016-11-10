public class Solution {
    public boolean isValid(String s) {
        char [] stack = new char[s.length()];
        int head = 0;
        for (int i = 0; i < s.length(); ++i) {
        	char c = s.charAt(i);
        	switch(c) {
        		case '(':
        		case '{':
        		case '[':
        		    stack[head++] = c;
        		    break;
        		case ')':
        		    if (head == 0 || stack[--head] != '(') return false;
        		    break;
        		case '}':
        		    if (head == 0 || stack[--head] != '{') return false;
        		    break;
        		case ']':
        		    if (head == 0 || stack[--head] != '[') return false;
        		    break;
        	}
        }
        return head == 0;
    }
}