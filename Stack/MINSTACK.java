package ayush.Stack;

import java.util.Stack;

public class MINSTACK {
    Stack<Integer>st = new Stack<>();
    int mini = Integer.MAX_VALUE;
    public void push(int value)
    {
        if(st.isEmpty())
        {
            mini= value;
            st.push(value);
        }
        else
        {
            if(mini>value)
            {
                st.push(2*value-mini);
                mini = value;
            }
            else
                st.push(value);
        }
    }
public void pop()
{
    if(st.isEmpty())
    {
        System.out.println("Stack Underflows");
    }
    else
    {
        if(mini>st.peek())
        {
            mini = 2*mini -st.peek();
            st.pop();
        }
        else
        {
            st.pop();
        }
    }
}
public int top()
{
    if(st.isEmpty())
        System.out.println("Stack Underflows");
    else
    {
        if(mini>st.peek())
        {
            return mini;
        }
        else
        {
            return st.peek();
        }
    }
    return -1;
}
public int getMin() {
    if (st.empty())
        System.out.println("Stack Underflows");
    return mini;
}
    public static void main(String[] args) {
MINSTACK obj = new MINSTACK();
obj.push(12);
obj.push(15);
obj.push(10);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        System.out.println(obj.top());
        obj.push(10);
        System.out.println(obj.top());
    }
}
