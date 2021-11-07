// Source: Educative

class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        if (arr.length == 0)
            return -1;

        int min = Integer.MAX_VALUE;
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key)
                return arr[mid];
            else if (arr[mid] > key)
                end = mid - 1;
            else
                start = mid + 1;

            min = Math.abs(arr[mid] - key) < Math.abs(min - key) ? arr[mid] : min;
        }
        return min;
    }
}