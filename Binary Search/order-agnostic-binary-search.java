// Source: Educative

class BinarySearch {

    public static int search(int[] arr, int key) {
        if (arr.length == 0)
            return -1;

        int start = 0, end = arr.length - 1;

        // is the array sorted ascending or descending?
        boolean isAsc = arr[end] > arr[start];

        while (start <= end) {
            // calculate middle
            int mid = start + (end - start) / 2;

            // found a match
            if (arr[mid] == key)
                return mid;

            // adjust start or end as needed
            if (isAsc) {
                if (arr[mid] > key)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (arr[mid] > key)
                    start = mid + 1;
                else
                    end = mid - 1;

            }
        }

        return -1;
    }
}