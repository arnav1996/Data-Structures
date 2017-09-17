/*
 This is a single queue where elements are added from rear side 
 and removed from front side. Therefore mocking the LIFO behavior
*/

package queue;

import java.util.Scanner;

public class QueueImplementaion {

	public int HEAD,TAIL;
	public int arr[];
	
	public void initialize(){
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements to store in stack");
		int n = sc.nextInt();
		arr = new int[n];
		HEAD=-1;
		TAIL=-1;
	}
	
	public boolean queue_empty(){
		if(HEAD==-1)
			return true;
		else 
			return false;
	}
	
	public boolean queue_full(){
		if(HEAD==0 && TAIL==arr.length-1)
			return true;
		else
			return false;
	}
	
	public void enqueue(){
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter element to push");
		int n=sc.nextInt();
		if(TAIL==-1){
			HEAD=0;
			TAIL=0;
			arr[TAIL]=n;
		}
		else if(TAIL+1==arr.length)
			throw new IndexOutOfBoundsException();
		else{
			arr[++TAIL]=n;
		}
	}
	
	public void dequeue(){
		if(queue_empty())
			throw new IndexOutOfBoundsException();
		else
			if(HEAD==TAIL){
				HEAD=-1;
				TAIL=-1;
			}
			else
				HEAD+=1;
	}
	
	public void display(){
		for(int i=HEAD;i<=TAIL;i++){
			System.out.println(arr[i]);
		}
	}
	
	
	public static void main(String[] args) {
		QueueImplementaion qu = new QueueImplementaion();
		qu.initialize();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int ch;
		do{
			System.out.println("==========MENU==========");
			System.out.println("1. Add element 2. Remove element 3. Display all Elements");
			System.out.println("========Enter choice========");
			ch = sc.nextInt();
			switch(ch){
				case 1: qu.enqueue();
						break;
				case 2: qu.dequeue();
						break;
				case 3: qu.display();
						break;
			}
		}while(ch>0&&ch<4);
	}

}
