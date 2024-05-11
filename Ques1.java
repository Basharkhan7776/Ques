public class Ques1 {
    public static int search(int[] arr, int key) {
        if (arr.length == 0 || (arr.length == 1 && arr[0] != key)) {
            return -1;
        } else if (arr.length == 1 && arr[0] == key) {
            return 0;
        }
        int start = 0, end = arr.length - 1, mid, p = 0;
        // finding rotated index
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                p = i + 1;
                break;
            }
        }
        while (start <= end) {
            mid = (start + end) / 2;
            int rotatedMid = (mid + p) % arr.length;
            if (arr[rotatedMid] == key) {
                return rotatedMid;
            } else if (arr[rotatedMid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, };
        System.out.println(search(arr, 10));
    }
}
