package sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {5,2,4,6,1,3};
		QuickSort qs = new QuickSort();
		qs.quicksort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	public void quicksort(int a[], int low, int high){
		if(low<high){
			int j = partition(a, low, high);
			quicksort(a, low, j-1);
			quicksort(a, j+1, high);
		}
	}
	
	public int partition(int a[], int low, int high){
		int p = a[low]; //initialize pivot element
		int i=low,j=high;
		
		while(i<j){
			while(i<a.length&&p>=a[i])
				i++;
			while(p<a[j])
				j--;
			if(i<j){
				int t = a[i];
				a[i]=a[j];
				a[j]=t;
			}
			else{
				a[low]=a[j];
				a[j]=p;
			}
		}
		return j;
	}
	
	

}
