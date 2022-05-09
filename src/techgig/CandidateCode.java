package techgig;

import java.io.*;
public class CandidateCode 
{ 
public static void main(String[] args)
{
no_of_path(new int[]{4,6}, new int[]{1,3,0,0,0,0,0,0,4,5,1,0,0,0,0,6,7,6,0,0,0,0,5,0});
}
    static int count=0;
 static int no_of_path(int input1[],int input2[])
{
    int mat[][] = new int[input1[0]][input1[1]];
    int c=0;
    for (int i=0;i<input1[0];i++)
    {
        for (int j=0;j<input1[1];j++){
            mat[i][j]=input2[c++];}
    }
    int nextElements=findNext(0,0,mat);
    System.out.println(nextElements);
    return 0;
}
static int findNext(int i,int j,int input[][])
{
    if(i==input.length-1 && j==input[0].length-1){
        return  count++;
    }
    switch (input[i][j]){
        case 0:
            if(i==input.length-1 && j==input[0].length-1){
                return  count;
            }
        case 1: //right
            if(j<input[0].length-1)
                return findNext(i,j+1,input);
        case 2: //lower
            if(i<input.length-1)
                return findNext(i+1,j,input);
        case 3: //diagonal
            if(i<input.length-1 && j<input[0].length-1)
                return findNext(i+1,j+1,input);
        case 4: //right,Lower
            if(i<input.length-1 && j<input[0].length-1)
                return findNext(i,j+1,input)+ findNext(i+1,j,input);
        case 5: //right,diagonal
            if(i<input.length-1 && j<input[0].length-1)
                return findNext(i,j+1,input)+findNext(i+1,j+1,input);
        case 6: //Lower , Diagonal
            if(i<input.length-1 && j<input[0].length-1)
                return findNext(i+1,j,input)+findNext(i+1,j+1,input);
        case 7: //right,diagonal lower
            if(i<input.length-1 && j<input[0].length-1)
                return findNext(i,j+1,input)+findNext(i+1,j+1,input)+findNext(i+1,j,input);
    }return count;
}
}