import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class UserInput
{
    public static void makeMatrix(double[][] matrix)
    {
        int idx = 0;
        for (int a = 0; a<4 ; a++)
        {
            for (int b = 0 ; b<4 ; b++)
            {
                for (int c = 0 ; c<4 ; c++)
                {
                    for (int d = 0 ; d<4 ; d++)
                    {
                        if (isNotSame(a, b, c, d))
                        {
                            matrix[idx][0] = a;
                            matrix[idx][1] = b;
                            matrix[idx][2] = c;
                            matrix[idx][3] = d;
                            idx++;
                        }
                    }
                }
            }
        }
    }
    public static boolean isNotSame(int a,int b, int c,int d)
    {
        if ((a==b) || (a==c) || (a==d) || (b==c) || (b==d) || (c==d))
        {
            return false;
        }
        return true;
    }
    public static boolean allZero(int[] arr)
    {
        if (arr[0]==0 && arr[1]==0 && arr[2]==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int[][] kurung(int[] arrOpr)
    {
        int[][] temp = new int[11][3];
        for(int i = 0; i<11; i++)
        {
            for(int j = 0 ; j<3; j++)
            {
                if (arrOpr[j] == 0 || arrOpr[j]==1)
                {
                    temp[i][j] = 1;
                }
                else if (arrOpr[j]==2 || arrOpr[j]==3)
                {
                    temp[i][j] = 3;
                }
            }
            temp[1][0]+= 10;
            temp[2][1]+= 10;
            temp[3][2]+= 10;
            temp[4][0]+= 10;
            temp[4][1]+= 10;
            temp[5][1]+= 10;
            temp[5][2]+= 10;
            temp[6][0]+= 10;
            temp[6][2]+= 10;
            temp[7][0]+= 10;
            temp[7][1]+= 20;
            temp[8][0]+= 20;
            temp[8][1]+= 10;
            temp[9][1]+= 20;
            temp[9][2]+= 10;
            temp[10][1]+= 10;
            temp[10][2]+= 20;
        }
        return temp;
    }
    public static boolean isNotExist(double[][] matrix, double[] arr)
    {
        boolean r = true;
        for (int i = 0 ; i<24 ; i++)
        {
            if (matrix[i][0] == arr[0] & matrix[i][1] == arr[1] & matrix[i][2] == arr[2] & matrix[i][3] == arr[3])
            {
                r = false;
            }
        }
        return r;
    }
    public static double count(int[] arrOpr, double[] arrNumber, int[] temp)
    {
        double[] tempNum = new double[4];
        for (int i = 0 ; i<4; i++)
        {
            tempNum[i] = arrNumber[i];
        }
        int max = 0;
        int idmax = 0;
        double temp1 = 0;
        double temp2 = 0;
        double temp3 = 0;
        while (!allZero(temp))
        {
            for (int i = 0; i<3; i++)
            {
                if(temp[i]>max)
                {
                    max = temp[i];
                    idmax = i;
                }
            }
            if (idmax == 0)
            {
                //cari apakah angka kedua sudah pernah kehitung
                if (tempNum[1]==-1)
                {
                    temp1 = operator.calc(tempNum[0],arrOpr[idmax],temp2);
                    temp2 = temp1;
                    temp1 = 0;
                }
                else
                {
                    temp1 = operator.calc(tempNum[0], arrOpr[idmax], tempNum[1]);
                }
                tempNum[0] = -1;
                tempNum[1] = -1;
                temp[0] = 0;
            }
            else if (idmax == 1)
            {
                //kemungkinan ada temp1 atau temp3 atau keduanya
                if (tempNum[1]==-1 && tempNum[2]==-1)
                {
                    temp2 = operator.calc(temp1,arrOpr[idmax],temp3);
                    temp1 = 0;
                    temp3 = 0;
                }
                else if (tempNum[1] == -1)
                {
                    temp2 = operator.calc(temp1,arrOpr[idmax],tempNum[2]);
                    temp1 = 0;
                }
                else if (tempNum[2]==-1)
                {
                    temp2 = operator.calc(tempNum[1],arrOpr[idmax],temp3);
                    temp3 = 0;
                }
                else
                {
                    temp2 = operator.calc(tempNum[1],arrOpr[idmax],tempNum[2]);
                }
                temp[1] = 0;
                tempNum[1] = -1;
                tempNum[2] = -1;
            }
            else if (idmax==2)
            {
                if (tempNum[2]==-1)
                {
                    temp3 = operator.calc(temp2,arrOpr[idmax],tempNum[3]);
                    temp2 = temp3;
                    temp3 = 0;
                }
                else 
                {
                    temp3 = operator.calc(tempNum[2],arrOpr[idmax],tempNum[3]);
                }
                temp[2] = 0;
                tempNum[2] = -1;
                tempNum[3] = -1;
            }
            max = 0;
        }
        if (temp1 != 0 )
        {
            return temp1;
        }
        else if (temp2 != 0)
        {
            return temp2;
        }
        else 
        {
            return temp3;
        }
    }
    public static void main(String[] args)
    {
        int idx = 0;
        int arr[]={0,0,0,0};
        boolean valid = false;
        Scanner sc =new Scanner(System.in);
        System.out.println("                          .g8\"\"\"bgd                                                    ");
        System.out.println("                        .dP'     `M                                                    ");
        System.out.println(" pd*\"*b.      .AM       dM'       `  .6\"Yb.  `7MMpMMMb.pMMMb.  .gP\"Ya  ,pP\"Ybd         ");
        System.out.println("(O)   j8     AVMM       MM          8)   MM    MM    MM    MM ,M'   Yb 8I   `\"         ");
        System.out.println("    ,;j9   ,W' MM       MM.    `7MMF',pm9MM    MM    MM    MM 8M\"\"\"\"\"\" `YMMMa.         ");
        System.out.println(" ,-='    ,W'   MM       `Mb.     MM 8M   MM    MM    MM    MM YM.    , L.   I8         ");
        System.out.println("Ammmmmmm AmmmmmMMmm       `\"bmmmdPY `Moo9^Yo..JMML  JMML  JMML.`Mbmmd' M9mmmP'         ");
        System.out.println("               MM                                                                      ");
        System.out.println("               MM                                                                      ");
        boolean menuValid = false;
        String[] kartu = new String[4];
        while (!menuValid)
        {
            System.out.println("================================");
            System.out.println("1. Masukkan 4 kartu");
            System.out.println("2. Random 4 kartu");
            System.out.println("================================");
            System.out.print("Masukkan Menu : ");
            int menu = sc.nextInt();
            if (menu==1)
            {
                System.out.println("Masukkan 4 kartu");
                while(!valid)
                {
                    while (idx<4)
                    {
                        String input = sc.next();
                        if (input.equals("A"))
                        {
                            arr[idx] = 1;
                            kartu[idx] = "A";
                        } 
                        else if (input.equals("2"))
                        {
                            arr[idx] = 2;
                            kartu[idx] = "2";
                        }
                        else if (input.equals("3"))
                        {
                            arr[idx] = 3;
                            kartu[idx] = "3";
                        }
                        else if (input.equals("4"))
                        {
                            arr[idx] = 4;
                            kartu[idx] = "4";
                        }
                        else if (input.equals("5"))
                        {
                            arr[idx] = 5;
                            kartu[idx] = "5";
                        }
                        else if (input.equals("6"))
                        {
                            arr[idx] = 6;
                            kartu[idx] = "6";
                        }
                        else if (input.equals("7"))
                        {
                            arr[idx] = 7;
                            kartu[idx] = "7";
                        }
                        else if (input.equals("8"))
                        {
                            arr[idx] = 8;
                            kartu[idx] = "8";
                        }
                        else if (input.equals("9"))
                        {
                            arr[idx] = 9;
                            kartu[idx] = "9";
                        }
                        else if (input.equals("10"))
                        {
                            arr[idx] = 10;
                            kartu[idx] = "10";
                        }
                        else if (input.equals("J"))
                        {
                            arr[idx] = 11;
                            kartu[idx] = "J";
                        }
                        else if (input.equals("Q"))
                        {
                            arr[idx] = 12;
                            kartu[idx] = "Q";
                        }
                        else if (input.equals("K"))
                        {
                            arr[idx] = 13;
                            kartu[idx] = "K";
                        }
                        idx++;
                        if (arr[3]!=0)
                        {
                            valid = true;
                        }
                    }
                    if (!valid)
                    {
                        System.out.println("Masukan tidak valid, silahkan ulangi");
                        idx = 0;
                    }
                }
                menuValid = true;
            }
            else if (menu == 2)
            {
                int min = 1;
                int max = 13;
                for (int i = 0 ; i <4 ; i++)
                {
                    int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
                    arr[i] = random_int;
                    kartu[i] = operator.converter(random_int);
                }
                menuValid = true;
                System.out.println("List kartu");
                for (int i = 0 ; i < 4 ; i++)
                {
                    System.out.print(kartu[i]+ " ");
                }
                System.out.println();
            }
            else
            {
                System.out.println("Masukan salah, silahkan ulangi!");
            }
        }
        /*Matrix to Config */
        // CONFIG -> Konfigurasi dari semua susunan bilangan yang mungkin
        double start = System.currentTimeMillis();
        double[][] config = new double[24][4];
        makeMatrix(config);
        double[][] displayNum = new double[24][4];
        makeMatrix(displayNum);
        double[] tconfig = new double[4];
        for (int i = 0 ; i < 24; i++)
        {
            for (int j = 0; j<4; j++)
            {
                if (config[i][j]==0)
                {
                    tconfig[j] = arr[0];
                } else if (config[i][j]==1)
                {
                    tconfig[j] = arr[1];
                } else if (config[i][j]==2)
                {
                    tconfig[j] = arr[2];
                }
                else if (config[i][j]==3)
                {
                    tconfig[j] = arr[3];
                }
            }
            if (isNotExist(config, tconfig))
            {
                for (int j = 0 ; j<4 ; j++)
                {
                    if (config[i][j]==0)
                    {
                        config[i][j] = arr[0];
                    } else if (config[i][j]==1)
                    {
                        config[i][j] = arr[1];
                    } else if (config[i][j]==2)
                    {
                        config[i][j] = arr[2];
                    }
                    else if (config[i][j]==3)
                    {
                        config[i][j] = arr[3];
                    }
                }
            }
            else
            {
                for (int j = 0 ; j<4 ; j++)
                {
                    config[i][j] = 0;
                }
            }
        }
        

        // Matriks Operator
        
        int[][] optr = new int[64][3];
        operator.opr(optr);
        int jml = 0;
        List<String> ArrRes = new ArrayList<String>();
        System.out.println("================================");
        for(int i = 0; i<24 ; i++)
        {
            for (int j = 0 ; j<64; j++)
            {
                int[][] temp = kurung(optr[j]);
                for (int l = 0; l<11 ; l++)
                {
                    double res = count(optr[j],config[i],temp[l]);
                    int[][] displayOp = optr;
                    char[] tempOp = new char[3];
                    for (int k = 0 ; k< 3; k++)
                    {
                        if (displayOp[j][k]==0)
                        {
                            tempOp[k] = '+';
                        }
                        else if (displayOp[j][k]==1)
                        {
                            tempOp[k] = '-';
                        }
                        else if (displayOp[j][k]==2)
                        {
                            tempOp[k] = '*';
                        }
                        else if (displayOp[j][k]==3)
                        {
                            tempOp[k] = '/';
                        }
                    }
                    if (res==24 & l==0)
                    {
                        System.out.println(config[i][0] + " " + tempOp[0] + " " +config[i][1] + " " + tempOp[1] + " " + config[i][2] + " " + tempOp[2] + " " + config[i][3]);
                        ArrRes.add(config[i][0] + " " + tempOp[0] + " " +config[i][1] + " " + tempOp[1] + " " + config[i][2] + " " + tempOp[2] + " " + config[i][3]);
                    }
                    else if (res == 24 & l==1)
                    {
                        System.out.println("("+config[i][0] + " " + tempOp[0] + " " + config[i][1] + ")" + " " + tempOp[1] + " " + config[i][2] + " " + tempOp[2] + " " + config[i][3]);
                        ArrRes.add("("+config[i][0] + " " + tempOp[0] + " " + config[i][1] + ")" + " " + tempOp[1] + " " + config[i][2] + " " + tempOp[2] + " " + config[i][3]);
                    }
                    else if (res==24 & l==2)
                    {
                        System.out.println(config[i][0] + " " + tempOp[0] + " " +"(" +config[i][1] + " " + tempOp[1] + " " + config[i][2]+ ")" + " " + tempOp[2] + " " + config[i][3]);
                        ArrRes.add(config[i][0] + " " + tempOp[0] + " " +"(" +config[i][1] + " " + tempOp[1] + " " + config[i][2]+ ")" + " " + tempOp[2] + " " + config[i][3]);
                    }
                    else if (res==24 & l==3)
                    {
                        System.out.println(config[i][0] + " " + tempOp[0] + " " +config[i][1] + " " + tempOp[1] + " " + "(" + config[i][2] + " " + tempOp[2] + " " + config[i][3] + ")");
                        ArrRes.add(config[i][0] + " " + tempOp[0] + " " +config[i][1] + " " + tempOp[1] + " " + "(" + config[i][2] + " " + tempOp[2] + " " + config[i][3] + ")");
                    }
                    else if (res==24 & l==4)
                    {
                        System.out.println("("+config[i][0] + " " + tempOp[0] + " " +config[i][1] + " " + tempOp[1] + " " + config[i][2] + ")" + " " + tempOp[2] + " " + config[i][3]);
                        ArrRes.add("("+config[i][0] + " " + tempOp[0] + " " +config[i][1] + " " + tempOp[1] + " " + config[i][2] + ")" + " " + tempOp[2] + " " + config[i][3]);
                    }
                    else if (res==24 & l==5)
                    {
                        System.out.println(config[i][0] + " " + tempOp[0] + " " +"("+config[i][1] + " " + tempOp[1] + " " + config[i][2] + " " + tempOp[2] + " " + config[i][3] + ")");
                        ArrRes.add(config[i][0] + " " + tempOp[0] + " " +"("+config[i][1] + " " + tempOp[1] + " " + config[i][2] + " " + tempOp[2] + " " + config[i][3] + ")");
                    }
                    else if (res==24 & l==6)
                    {
                        System.out.println("("+config[i][0] + " " + tempOp[0] + " " +config[i][1]+ ")" + " " + tempOp[1] + " " + "(" + config[i][2] + " " + tempOp[2] + " " + config[i][3] + ")");
                        ArrRes.add("("+config[i][0] + " " + tempOp[0] + " " +config[i][1]+ ")" + " " + tempOp[1] + " " + "(" + config[i][2] + " " + tempOp[2] + " " + config[i][3] + ")");
                    }
                    else if (res==24 & l==7)
                    {
                        System.out.println("("+config[i][0] + " " + tempOp[0] + " " +"("+config[i][1] + " " + tempOp[1] + " "  + config[i][2] + "))" +" " + tempOp[2] + " " + config[i][3]);
                        ArrRes.add("("+config[i][0] + " " + tempOp[0] + " " +"("+config[i][1] + " " + tempOp[1] + " "  + config[i][2] + "))" +" " + tempOp[2] + " " + config[i][3]);
                    }
                    else if (res==24 & l==8)
                    {
                        System.out.println("(("+config[i][0] + " " + tempOp[0] + " " +config[i][1] + ")" +" " + tempOp[1] + " "  + config[i][2] + ")" +" " + tempOp[2] + " " + config[i][3]);
                        ArrRes.add("(("+config[i][0] + " " + tempOp[0] + " " +config[i][1] + ")" +" " + tempOp[1] + " "  + config[i][2] + ")" +" " + tempOp[2] + " " + config[i][3]);
                    }
                    else if (res==24 & l==9)
                    {
                        System.out.println(config[i][0] + " " + tempOp[0] + " " + "(("+config[i][1] + " " + tempOp[1] + " "  + config[i][2]  +")" +" " + tempOp[2] + " " + config[i][3] + ")");
                        ArrRes.add(config[i][0] + " " + tempOp[0] + " " + "(("+config[i][1] + " " + tempOp[1] + " "  + config[i][2]  +")" +" " + tempOp[2] + " " + config[i][3] + ")");
                    }
                    else if (res==24 & l==10)
                    {
                        System.out.println(config[i][0] + " " + tempOp[0] + " " + "("+config[i][1] + " " + tempOp[1] + " "  + "("+config[i][2]  +" " + tempOp[2] + " " + config[i][3] + "))");
                        ArrRes.add(config[i][0] + " " + tempOp[0] + " " + "("+config[i][1] + " " + tempOp[1] + " "  + "("+config[i][2]  +" " + tempOp[2] + " " + config[i][3] + "))");
                    }
                    if (res==24)
                    {
                        jml++;
                    }
                }
            }
        }
        System.out.println("================================");
        double end = System.currentTimeMillis();
        System.out.println("Total Time : " + (end-start)/1000 + " s" );
        System.out.println("TOTAL = " + jml);
        System.out.print("Apakah Anda ingin menyimpan jawaban ? (1/0) ");
        int save = sc.nextInt();
        if (save == 1)
        {
            System.out.print("Masukkan nama file : ");
            String name = sc.next();
            try (FileWriter fWriter = new FileWriter(
                "./test/" + name)) 
            {
                fWriter.write("===========================" + "\n");
                fWriter.write("LIST KARTU" + "\n");
                for (int i = 0 ; i<4; i++)
                {
                    fWriter.write(kartu[i] + " ");
                }
                fWriter.write("\n"+"===========================" + "\n");
                for(int i = 0 ; i<ArrRes.size();i++)
                {
                    try 
                    {
                        fWriter.write(ArrRes.get(i) + "\n");
                    } 
                    catch (IOException e) 
                    {
                        System.out.print(e.getMessage());
                    }
                }
                fWriter.write("===========================" + "\n");
                fWriter.write("Total = " + jml);
            } 
            catch (IOException e) 
            {
                System.out.print(e.getMessage());
            }
        }
    }
}