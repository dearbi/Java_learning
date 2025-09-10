package 排序;

import java.util.Stack;

public class Sort {

    void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param array
     */
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：最好O(nlogn)，最坏O(n^2)
     * 空间复杂度：最好O(logn)，最坏O(n)
     * 稳定性：不稳定
     *
     * @param array
     */
    public void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private void quick(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        //优化——三数取中
//        int index=mid_three(array,start,end);

        int pivot = partition1(array, start, end);

        quick(array, start, pivot - 1);
        quick(array, pivot + 1, end);
    }

    //优化——三数取中
    private int mid_three(int[] array, int start, int end) {
        int mid = start + (end - start) / 2;
        if (array[start] > array[end]) {
            swap(array, start, end);
        }
        if (array[mid] > array[end]) {
            swap(array, mid, end);
        }
        if (array[mid] > array[start]) {
            swap(array, mid, start);
        }
        return mid;
    }

    //1.挖坑法
    private int partition1(int[] array, int left, int right) {
        int i = left;
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }


    //2.交换法
    private int partition2(int[] array, int left, int right) {
        int i = left;
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }

            while (left < right && array[left] <= temp) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, left, i);
        return left;
    }

    //3.快慢指针法
    private int partition3(int[] array, int left, int right) {
        int prev = left;
        int cur = left + 1;
        while (cur <= right) {
            if (array[cur] < array[left] && array[++prev] != array[cur]) {
                swap(array, cur, prev);
            }
            cur++;
        }
        swap(array, prev, left);
        return prev;
    }

    //最终_非递归
    public void quickSortNonR(int[] array, int left, int right) {
        Stack<Integer> st = new Stack<>();
        st.push(left);
        st.push(right);
        while (!st.empty()) {
            right = st.pop();
            left = st.pop();
            if (right - left <= 1) {
                continue;
            }
            int div = partition1(array, left, right);
            // 以基准值为分割点，形成左右两部分：[left, div) 和 [div+1, right)
            st.push(div + 1);
            st.push(right);
            st.push(left);
            st.push(div);
        }

    }

    /**
     * 归并排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     *
     * @param array
     */
    public static void mergeSort(int[] array) {
        mergeChild(array, 0, array.length - 1);
    }

    public static void mergeChild(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeChild(array, left, mid);
        mergeChild(array, mid + 1, right);

        //合并
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;

        //临时数组
        int[] tempArray = new int[right - left + 1];
        //临时数组的下标
        int k = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] <= array[s2]) {
                tempArray[k++] = array[s1++];
            } else {
                int temp = array[s2];
                for (int i = s2; i > s1; i--) {
                    array[i] = array[i - 1];
                }
                array[s1] = temp;
                s1++;
                e1++;
                s2++;
            }
        }
        while (s1 <= e1) {
            tempArray[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tempArray[k++] = array[s2++];
        }
        //将临时数组中的元素拷贝到原数组中
        for (int i = 0; i < tempArray.length; i++) {
            array[left + i] = tempArray[i];
        }
        //释放临时数组
        tempArray = null;
    }
}
