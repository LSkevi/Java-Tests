import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        List<Long> arr = new ArrayList<>();
        arr.add(1000000001L);
        arr.add(1000000002L);
        arr.add(1000000003L);
        arr.add(1000000004L);
        arr.add(1000000005L);
        System.out.println(arr + "array 1");
        System.out.println(aVeryBigSum(arr));

        */
        List<Integer> arr4 = new ArrayList<>(Arrays.asList(11, 2, 4));
        List<Integer> arr5 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> arr6 = new ArrayList<>(Arrays.asList(10, 8, -12));
        List<List<Integer>> arr3 = new ArrayList<>(Arrays.asList(arr4, arr5, arr6));
        System.out.println(arr3 + "array 3");
        System.out.println(diagonalDifferences(arr3));


/*
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(3);
        arr2.add(2);
        arr2.add(1);
        System.out.println(arr2 + "array 2");
        System.out.println(compareTriplets(arr, arr2));
        //simpleArraySum(arr);
        */
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int result = 0;
        int j = 0;
        int k = 2;
        List<Integer> diagR = new ArrayList<>();
        List<Integer> diagL = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {

            List<Integer> currentList = arr.get(i);

            diagR.add(currentList.get(j));
            j++;


            diagL.add(currentList.get(k));
            k--;

        }
        System.out.println(diagR.stream().mapToInt(Integer::intValue).sum());
        System.out.println(diagL.stream().mapToInt(Integer::intValue).sum());
        int sum = diagR.stream().mapToInt(Integer::intValue).sum() - diagL.stream().mapToInt(Integer::intValue).sum();

        result += Math.abs(sum);
        return result;
    }

    public static int diagonalDifferences(List<List<Integer>> arr) {
        int n = arr.size();
        int sumPrimary = 0;
        int sumSecondary = 0;

        for (int i = 0; i < n; i++) {
            sumPrimary += arr.get(i).get(i);
            System.out.println(n);
            System.out.println(i);// Primary diagonal (top-left to bottom-right)
            sumSecondary += arr.get(i).get(n - 1 - i);    // Secondary diagonal (top-right to bottom-left)
        }

        return Math.abs(sumPrimary - sumSecondary);
    }


    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        long result = 0;
        for (int i = 0; i < ar.size(); i++) {
            long current = result + ar.get(i);
            result = current;
        }
        return result;

    }


    public static int simpleArraySum(List<Integer> ar) {
        int result = 0;
        for (int num : ar) {
            result = result + num;
        }
        System.out.println(result);
        return result;
    }

    public static List<Integer> compareTripletss(List<Integer> a, List<Integer> b) {
        List<Integer> resuList = new ArrayList<>();
        resuList.add(0);
        resuList.add(0);
        int i = 0;
        for (int numA : a) {
            System.out.println(numA + "numero A");

            int numB = b.get(i);
            i++;
            System.out.println(numB + "numero B");

            if (numA > numB) {
                System.out.println("Ponto da alice");
                int current = resuList.getFirst();
                resuList.set(0, current + 1);
            } else if (numA < numB) {
                System.out.println("Ponto do bob");
                int current = resuList.get(1);
                resuList.set(1, current + 1);
            } else {
                System.out.println("Ponto de ngm");
            }
        }
        return resuList;

    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                scoreA++;
            } else if (a.get(i) < b.get(i)) {
                scoreB++;
            }
        }

        return Arrays.asList(scoreA, scoreB);
    }


}


