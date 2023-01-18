import java.util.*;  
class UserInput
{
    public static void main(String[] args)  
    {
        int idx = 0;
        int arr[]={0,0,0,0};
        Scanner sc=new Scanner(System.in);
        String input = sc.nextLine();
        for (int i = 0 ; i<input.length(); i++)
        {
            if (input.charAt(i)>=48 && input.charAt(i)<57)
            {
                arr[idx] = input.charAt(i)-48; 
            } 
            else if (input.charAt(i) == 74 || input.charAt(i) == 106)
            {
                arr[idx] = 11;
            }
            else if (input.charAt(i) == 81 || input.charAt(i) == 113)
            {
                arr[idx] = 12;
            }
            else if (input.charAt(i) == 75 || input.charAt(i) == 107)
            {
                arr[idx] = 13;
            }
            else if (input.charAt(i) == 65 || input.charAt(i) == 97)
            {
                arr[idx] = 1;
            }
            else
            {
            idx++;
            }
        }
        for (int i = 0 ; i<4 ; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}

