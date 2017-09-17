package sort;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {5,2,4,6,1,3};
		InsertionSort is = new InsertionSort();
		is.insertionSort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
	}

	public void insertionSort(int a[]){
		for(int j=1;j<a.length;j++){
			int key = a[j]; //key acts as a temp
			int i=j-1;
			while(i>=0&&a[i]>key){
				a[i+1]=a[i];
				i-=1;// to compare with all the values of left sorted hand
			}
			a[i+1]=key; //to keep the key value as is if the element being comapared is smaller than it
		}
	}
}
