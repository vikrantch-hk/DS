// https://www.geeksforgeeks.org/number-of-refills-to-complete-the-journey-of-n-km/
/*
*  Given a number N which represents the total distance in km to be covered
* by a car on a single road. There are N petrol pumps at a distance of 1 km
* each(1, 2, 3, ..N). The capacity of the fuel tank of the car is such that
* at full tank it goes till a distance of K km. The car has to compulsorily
* stop at M petrol tanks whose distance from the starting position is given
* as M integers. The task is to find the number of times, the car has to
* refill its tank including the compulsory stops to complete its journey of
* N km.
*
* Input: N = 10, K = 2, M = 3
arr[] = { 6, 7, 8 }
Output: 5

 * */
public class CountRefill {

    static int countRefill(int N, int K,
                           int M, int compulsory[])
    {
        int distCvrd = 0;
        int refill = 0;
        int i=0;
        while (distCvrd<N){
            if(i<M && compulsory[i]<=distCvrd+K){
                distCvrd=compulsory[i];
                i++;
            }else {
                distCvrd+=K;
            }
            if(distCvrd<N){
                refill++;
            }
        }
        return refill;
    }

    public static void main(String[] args) {
        int N = 10;
        int K = 2;
        int M = 3;
        // compulsory petrol
        // pumps to refill at
        int compulsory[] = { 6, 7, 8 };

        // function call that returns
        // the answer to the problem
        System.out.println(countRefill(N, K,
                M, compulsory));
    }
}
