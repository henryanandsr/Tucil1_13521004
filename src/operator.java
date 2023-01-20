public class operator {
    public static void opr(int[][] matrix)
    {
        int idx = 0 ;
        for (int i = 0 ; i < 4 ; i++)
        {
            for (int j = 0 ; j < 4 ; j++)
            {
                for (int k = 0 ; k < 4 ; k++)
                {
                    matrix[idx][0] = i;
                    matrix[idx][1] = j;
                    matrix[idx][2] = k;
                    idx++;
                }
            }
        }
    }
    public static double calc(double a, int opr, double b)
    {
        if (opr == 0)
        {
            return a+b;
        } else if (opr == 1)
        {
            return (a-b);
        }
        else if (opr == 2)
        {
            return a*b;
        }
        else
        {
            return a/b;
        }
    }
    public static String converter(int a)
    {
        if(a==1)
        {
            return "1";
        }
        else if(a == 2)
        {
            return "2";
        }
        else if(a == 3)
        {
            return "3";
        }
        else if(a == 4)
        {
            return "4";
        }
        else if(a == 5)
        {
            return "5";
        }
        else if(a == 6)
        {
            return "6";
        }
        else if(a == 7)
        {
            return "7";
        }
        else if(a == 8)
        {
            return "8";
        }
        else if(a == 9)
        {
            return "9";
        }
        else if(a == 10)
        {
            return "10";
        }
        else if(a == 11)
        {
            return "11";
        }
        else if(a == 12)
        {
            return "12";
        }
        else
        {
            return "13";
        }
    }
}
