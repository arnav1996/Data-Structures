/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;

/**
 *
 * @author student
 */
public class QuickSort2 {
    int j, pivot,pIndex;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[]={5,4,6,2,1,3};
        QuickSort2 J1 = new QuickSort2();
        J1.quicksort(a, 0, a.length-1);
        System.out.print(Arrays.toString(a));
    }
    public void quicksort(int a[],int start, int end){
        if(start<end){
            j = partition(a,start,end);
            quicksort(a, start, j-1);
            quicksort(a, j+1, end);
        }
    }
    
    public int partition(int a[], int start, int end){
        pivot=a[end];
        pIndex=start;
        for(int i=start;i<end;i++){
            if(a[i]<=pivot){
                int temp=a[i];
                a[i]=a[pIndex];
                a[pIndex]=temp;
                pIndex++;
            }
        }
        int t = a[pIndex];
        a[pIndex]=a[end];
        a[end]=t;
        
        return pIndex;
    }
    
}
