import java.util.*;

public class Main {
    public static void main(String[] args) {


        String s = "07:05:45PM";
        System.out.println(timeConversion(s));
        /*
        // Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //staircase(n);

        List<Integer> arr = new ArrayList<>(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625));
        miniMaxSuma(arr);

        List<Long> arr = new ArrayList<>();
        arr.add(1000000001L);
        arr.add(1000000002L);
        arr.add(1000000003L);
        arr.add(1000000004L);
        arr.add(1000000005L);
        System.out.println(arr + "array 1");
        System.out.println(aVeryBigSum(arr));


        List<Integer> arr4 = new ArrayList<>(Arrays.asList(11, 2, 0, -5, -6));


        List<Integer> arr5 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> arr6 = new ArrayList<>(Arrays.asList(10, 8, -12));
        List<List<Integer>> arr3 = new ArrayList<>(Arrays.asList(arr4, arr5, arr6));
        System.out.println(arr3 + "array 3");
        System.out.println(diagonalDifferences(arr3));


        plusMinus(arr4);



        List<Integer> arr2 = new ArrayList<>();
        arr2.add(3);
        arr2.add(2);
        arr2.add(1);
        System.out.println(arr2 + "array 2");
        System.out.println(compareTriplets(arr, arr2));
        //simpleArraySum(arr);
        */


    }

    public static String timeConversion(String s) {
        int hh = Integer.parseInt(s.substring(0, 2));
        String mm = s.substring(3, 5);
        String ss = s.substring(6, 8);
        String meridian = s.substring(8, 10);

        if (meridian.equals("AM")) {
            if (hh == 12) {
                hh = 0;
            }
        } else { // PM
            if (hh != 12) {
                hh += 12;
            }
        }

        // Format hour to 2 digits
        String hhStr = String.format("%02d", hh);

        return hhStr + ":" + mm + ":" + ss;
    }


    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        List<Integer> mini = arr.subList(1, arr.size());
        System.out.println(mini);
        List<Integer> max = arr.subList(0, arr.size() - 1);
        System.out.println(max);
        long sumMini = mini.stream().mapToLong(Integer::longValue).sum();
        long sumMax = max.stream().mapToLong(Integer::longValue).sum();
        System.out.println(sumMax + "," + sumMini);

    }

    public static void miniMaxSuma(List<Integer> arr) {
        // Copy and sort the list to avoid mutating the original
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        long minSum = sorted.subList(0, sorted.size() - 1)
                .stream()
                .mapToLong(Integer::longValue)
                .sum();

        long maxSum = sorted.subList(1, sorted.size())
                .stream()
                .mapToLong(Integer::longValue)
                .sum();

        System.out.println(minSum + " " + maxSum);
    }


    public static void staircase(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("#");
            }


        }

    }


    public static void plusMinus(List<Integer> arr) {
        int n = arr.size();
        double pos = 0;
        double neg = 0;
        double zer = 0;
        for (int i = 0; i < n; i++) {
            int m = arr.get(i);
            if (arr.get(i) > 0) {
                pos++;
            } else if (arr.get(i) < 0) {
                neg++;
            } else {
                zer++;
            }
        }
        double posdouble = pos / n;
        double negdouble = neg / n;
        double zerdouble = zer / n;
        System.out.printf("%.6f%n", posdouble);
        System.out.printf("%.6f%n", negdouble);
        System.out.printf("%.6f%n", zerdouble);


    }

    public static void plusMinuss(List<Integer> arr) {
        int n = arr.size();
        int pos = 0, neg = 0, zero = 0;

        for (int num : arr) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            } else {
                zero++;
            }
        }

        System.out.printf("%.6f%n", pos / (double) n);
        System.out.printf("%.6f%n", neg / (double) n);
        System.out.printf("%.6f%n", zero / (double) n);
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


