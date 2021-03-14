package dms.pastor.examples.sorting;


public class MergeSort implements Sorter {


    public void sort(Comparable<Integer>[] items) {
        Comparable<Integer>[] temp = new Comparable[items.length];
        mergeSort(items, temp, 0, items.length - 1);
    }


    private void mergeSort(Comparable<Integer>[] a, Comparable<Integer>[] temp,
                           int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, temp, left, center);
            mergeSort(a, temp, center + 1, right);
            merge(a, temp, left, center + 1, right);
        }
    }

    private void merge(Comparable<Integer>[] a, Comparable<Integer>[] temp,
                       int left, int center, int right) {
        int aptr = left;
        int bptr = center;
        int cptr = 0;
        while (aptr < center || bptr <= right) {
            if (aptr >= center && bptr <= right) {
                temp[cptr] = a[bptr++];
            } else if (bptr > right && aptr <= center) {
                temp[cptr] = a[aptr++];
            } else {
                if (a[aptr].compareTo((Integer) a[bptr]) < 0) {
                    temp[cptr] = a[aptr];
                    aptr++;
                } else {
                    temp[cptr] = a[bptr];
                    bptr++;
                }
            }
            cptr++;
        }

        for (int index = left; index <= right; index++) {
            a[index] = temp[index - left];
        }
    }

}
