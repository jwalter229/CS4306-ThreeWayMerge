import java.util.*;

/* consulted stackoverflow,
   geeksforgeeks, and w3schools
*/


public class Main {

    public static void main(String args[]) {

        // creating a new array named data
        Integer[] data = new Integer[]
                {21, 53, 45, 12, 1, 3, 44, 11, 48, 9, 27, 76, 34, 5, 23, 19, 10, 32, 42, 56};

        // using Arrays.toString
        // to display the data in the array
        System.out.println("The data before the sort: " + "\n" + Arrays.toString(data));
        threeWayMerge(data);
        System.out.println(); // blank line for spacing
        // displaying the data after the merge sort
        System.out.println("The data after the merge sort: ");
        for (int i = 0; i < data.length; i++)
        System.out.print(data[i] + ", " );

    }// end of main block

    // start of three way merge function
    public static void threeWayMerge(Integer[] oneArray) {

        // if array is size 0
        // returns null
        if (oneArray == null)
            return;

        // creating duplicate of oneArray into twoArray
        Integer[] twoArray = new Integer[oneArray.length];

        // copying Elements of one Array
        // into duplicate twoArray
        for (int i = 0; i < twoArray.length; i++) {
            twoArray[i] = oneArray[i];
        }

        // sort function for threeWayMerge
        threeWayMergeRec(twoArray, 0, oneArray.length, oneArray);

        // coping back elements of
        // twoArray into oneArray
        for (int i = 0; i < twoArray.length; i++) {
            oneArray[i] = twoArray[i];
        }

    }// end of threeWayMerge function

    // start of threeWayMergeRec
    // performing the merge sort on the array.
    // low will be at the minimum index
    // high will be at the maximum index
    public static void threeWayMergeRec(Integer[] oneArray, int low, int high, Integer[] destArray) {

        // if array is size 1 do nothing,
        // it is already in order
        if (high - low < 2)
            return;

        // splitting array into 3 parts
        int middle1 = low + ((high - low) / 3);
        int middle2 = low + 2 * ((high - low) / 3) + 1;

        // Sorting  the 3 arrays recursively
        threeWayMergeRec(destArray, low, middle1, oneArray);
        threeWayMergeRec(destArray, middle1, middle2, oneArray);
        threeWayMergeRec(destArray, middle2, high, oneArray);

        // Merging the sorted
        // arrays back together
        merge(destArray, low, middle1, middle2, high, oneArray);

    }// end of threeWayMergeRec


    // start of merge function              [ inclusive
    // merging the sorted ranges            ) exclusive
    // [low, mid1), [mid1, mid2) and then [mid2, high]
    // first midpoint is middle1 in array
    // second midpoint is middle2 in array
    public static void merge(Integer[] oneArray, int low, int middle1, int middle2, int high, Integer[] destArray) {
        int i = low;
        int j = middle1;
        int k = middle2;
        int l = low;


        // selecting the smallest in the three ranges
        while ((i < middle1) && (j < middle2) && (k < high)) {

            if (oneArray[i].compareTo(oneArray[j]) < 0) {
                if (oneArray[i].compareTo(oneArray[k]) < 0)
                    destArray[l++] = oneArray[i++];

                else
                    destArray[l++] = oneArray[k++];
            }

            else {
                if (oneArray[j].compareTo(oneArray[k]) < 0)
                    destArray[l++] = oneArray[j++];
                else
                    destArray[l++] = oneArray[k++];
            }
        } // end of while

        // if first and second ranges
        // remaining values
        while ((i < middle1) && (j < middle2)) {

            if (oneArray[i].compareTo(oneArray[j]) < 0)
                destArray[l++] = oneArray[i++];
            else
                destArray[l++] = oneArray[j++];
        } // end of while

        // if second and third ranges have
        // remaining values
        while ((j < middle2) && (k < high)) {

            if (oneArray[j].compareTo(oneArray[k]) < 0)
                destArray[l++] = oneArray[j++];

            else
                destArray[l++] = oneArray[k++];
        }// end of while

        // if first and third ranges have
        // remaining values
        while ((i < middle1) && (k < high)) {

            if (oneArray[i].compareTo(oneArray[k]) < 0)
                destArray[l++] = oneArray[i++];
            else
                destArray[l++] = oneArray[k++];
        }// end of while

        // copy remaining values from the first range
        while (i < middle1)
            destArray[l++] = oneArray[i++];

        // copy remaining values from the second range
        while (j < middle2)
            destArray[l++] = oneArray[j++];

        // copy remaining values from the third range
        while (k < high)
            destArray[l++] = oneArray[k++];

    } // end of merge function

} // end of main class
