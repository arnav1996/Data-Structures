package sort;

public class MergeSort {

	public static void main(String[] args) {

		int a[] = {5,2,4,6,1,3};
		MergeSort ms = new MergeSort();
		int n = a.length;
		ms.merge_sort(a,0,n-1);
		ms.display(a);
	}
	
	public void merge_sort(int a[], int low, int high ){
		
		if(low<high){
			int mid = (low+high)/2;
			merge_sort(a,low,mid);
			merge_sort(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	public void merge(int a[],int low,int mid, int high){
		
		int temp[] = new int[high-low+1];
		int i=low,j=mid+1,k=0;
		
		while(i<=mid&&j<=high){
			if(a[i]<a[j]){
				temp[k++]=a[i++];
			}
			else{
				temp[k++]=a[j++];
			}
		}
		while(i<=mid)
			temp[k++]=a[i++];
		while(j<=high)
			temp[k++]=a[j++];
		
		System.arraycopy(temp, 0, a, low, temp.length);
	}
	
	public void display(int a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
	}
	
}
