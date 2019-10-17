import org.junit.Test;

/**
 * Created by Administrator on 2019/6/24.
 */
public class SortTest {

    @Test
    public void test1(){ //冒泡排序
        int[] arrs = {1,22,23,54,8,56,10,7,12};

        for(int i=0 ;i< arrs.length - 1; i++){
            for(int j = 0;j <arrs.length - 1 - i;j++){
                if(arrs[j] > arrs[j+1]){
                    int a = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = a;
                }
            }
        }

        for (int a: arrs) {
            System.out.print(a + " ");
        }
    }

    @Test
    public void test2(){
        int[] arrs = {1,22,23,54,8,56,10,7,12};
        quickSort(arrs,0,arrs.length - 1);
        for ( int i:arrs ) {
            System.out.print(i + " ");
        }
    }

    /**
     * @param arr  待排序数组
     * @param low
     * @param high
     */
    public void quickSort(int[] arr,int low,int high){ //快速排序
        int i,j,temp,t;
        i = low;
        j = high;

        if(low > high){
            return;
        }

        //设置一个基准位
        temp = arr[low];

        while (i<j){
            //先看右边，依次往左递减
            while (temp <= arr[j] && i<j ){
                j--;
            }

            //再看左边，依次往右递增
            while (temp >= arr[i] && i<j ){
                i++;
            }
            //如果满足条件则交换
            if(i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;

        //递归调用左半数组
        quickSort(arr,low,i-1);
        //递归调用右半数组
        quickSort(arr,i+1,high);
    }



}
