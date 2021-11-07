// Source: Educative

class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        // Base base
        if (arr.length == 0 || key > arr[arr.length - 1])
            return -1;

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            // get mid point
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                // perfect match
                return mid;
            } else if (arr[mid] > key) {
                // search lower half of array
                end = mid - 1;
            } else {
                // search upper half of array
                start = mid + 1;
            }
        }

        // start will be smallest number greater than key
        return start;
    }
}