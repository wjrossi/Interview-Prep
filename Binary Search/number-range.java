// Source: Educative

class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };

        if (arr.length == 0)
            return result;

        // search for min value of range
        result[0] = binarySearch(arr, key, 0, arr.length - 1, false);

        // if min value is found search for max using min as start
        if (result[0] != -1)
            result[1] = binarySearch(arr, key, result[0], arr.length - 1, true);

        return result;
    }

    private static int binarySearch(int[] arr, int key, int start, int end, boolean isMaxRange) {
        int keyIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // found a match
            if (arr[mid] == key) {
                // store the index of the match
                keyIndex = mid;
                if (!isMaxRange) {
                    // looking for min range, so search left
                    end = mid - 1;
                } else {
                    // looking for max range, so search right
                    start = mid + 1;
                }
            } else if (arr[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }

        // return match if we found it otherwise -1
        return keyIndex;
    }
}