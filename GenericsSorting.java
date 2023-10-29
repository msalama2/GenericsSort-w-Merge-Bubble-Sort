package GenericsSort;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
   
    
    public class GenericsSorting<T extends Comparable<T>> {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.println("Enter Length for Array:\n");
            int ALength = scanner.nextInt();
    
            ArrayList<Integer> Alist = createRandomArray(ALength);
    
            ArrayList<Integer> AListMergeS = new ArrayList<>(Alist);
            ArrayList<Integer> AListBubbleS = new ArrayList<>(Alist);
    
            long STimeMergeS = System.currentTimeMillis();
            mergeSort(AListMergeS);
            long ETimeMergeSort = System.currentTimeMillis();
            long MergeSortTime = ETimeMergeSort - STimeMergeS;
    
            long STimeBubbleS = System.currentTimeMillis();
            bubbleSort(AListBubbleS);
            long ETimeBubbleSort = System.currentTimeMillis();
            long BubbleSortTime = ETimeBubbleSort - STimeBubbleS;
    
            System.out.println("\nImplemented MergeSort Time is " + MergeSortTime + " milliseconds\n");
            System.out.println("\nImplemented BubbleSort Time is " + BubbleSortTime + " milliseconds\n");
    
            scanner.close();
    
        }
    
        private static ArrayList<Integer> createRandomArray(int arrayLength) {
            Random random = new Random();
            ArrayList<Integer> randomArray = new ArrayList<>();
    
            for (int i = 0; i < arrayLength; i++) {
                randomArray.add(random.nextInt(101));
            }
    
            return randomArray;
        }
    
        private static <T extends Comparable<T>> void bubbleSort(ArrayList<T> list) {
            int n = list.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                        T temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }
        }
    
        private static <T extends Comparable<T>> void mergeSort(ArrayList<T> list) {
            if (list.size() <= 1) {
                return;
            }
    
            int middleArray = list.size() / 2;
            ArrayList<T> left = new ArrayList<>(list.subList(0, middleArray));
            ArrayList<T> right = new ArrayList<>(list.subList(middleArray, list.size()));
    
            mergeSort(left);
            mergeSort(right);
            merge(list, left, right);
        }
    
        private static <T extends Comparable<T>> void merge(ArrayList<T> list, ArrayList<T> left, ArrayList<T> right) {
            int leftIndex = 0;
            int rightIndex = 0;
            int arrayIndex = 0;
    
            while (leftIndex < left.size() && rightIndex < right.size()) {
                if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
                    list.set(arrayIndex++, left.get(leftIndex++));
                } else {
                    list.set(arrayIndex++, right.get(rightIndex++));
                }
            }
    
            while (leftIndex < left.size()) {
                list.set(arrayIndex++, left.get(leftIndex++));
            }
    
            while (rightIndex < right.size()) {
                list.set(arrayIndex++, right.get(rightIndex++));
            }
        }
    }

    



    




