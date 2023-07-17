import java.util.Scanner;

public class Word {
    Node head;

    static class Node {
        String data;
        Node next;

        Node(String d) {
            this.data = d;
        }
    }

    public static Word Insert(Word list, String str) {
        Node new_node = new Node(str);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node tail = list.head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = new_node;
        }
        return list;
    }

    public static void Print(Word list) {
        Node ptr = list.head;
        System.out.println("LkdLst:");
        while (ptr != null) {
            char p[] = ptr.data.toCharArray();
            for (int i = 0; i < p.length; i++) {
                System.out.print(p[i] + " ");
            }
            System.out.println();
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Word list = new Word();
        int k = 0;
        list = Insert(list, "____");
        Print(list);
        String words[] = { "good", "late", "flux", "mate", "data", "word", "bold", "lord" };
        int random_index = (int) (Math.random() * words.length);
        while (true) {
            char tofind[] = words[random_index].toCharArray();
            String str = sc.nextLine();
            if (str.length() != 4) 
            {
                System.out.println("Please enter the valid word");
                continue;
            }

            char ch[] = str.toCharArray();

            int for_b = 0, for_c = 0;
            for(int i=0;i<str.length();i++)
            {
                if(ch[i]==tofind[i])
                {
                    for_b++;
                    tofind[i]='-';
                }
            }
            for (int i = 0; i < str.length(); i++) 
            {
                for (int j = 0; j < str.length(); j++) 
                {

                    if (ch[i] == tofind[j]) 
                    {
                        for_c++;
                        tofind[j]='-';
                    }
                }
            }
            if (for_b == 4) 
            {
                System.out.print("Won");
                break;
            }
            int temp=0;
            if (for_b != 0) 
            {
                str += "-";
                str += for_b;
                temp=1;
                str += "B";
            }
            if (for_c != 0) 
            {
                if(temp==0)
                str += "-";
                else
                str += ",";
                str += for_c;
                str += "C";
            }
            if (for_b == 0 && for_c == 0) 
            {
                str += "-";
                str += "N";
            }
            list = Insert(list, str);
            Print(list);
            System.out.println("\n");
        }

    }
}
