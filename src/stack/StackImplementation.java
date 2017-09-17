package stack;

import java.util.Scanner;

public class StackImplementation {
	
	public int TOP=-1;
	int arr[];
	
	public void initialize(){
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements to store in stack");
		int n = sc.nextInt();
		arr = new int[n];
	}
	
	public boolean stack_empty(){
		if(TOP==-1)
			return true;
		else 
			return false;
	}
	
	public void push(){
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter element to push");
		int n=sc.nextInt();
		TOP+=1;
		arr[TOP]=n;
	}
	
	public void pop(){
		if(stack_empty())
			System.out.println("Empty stack, Nothing to pop");
		else
			TOP-=1;
	}
	
	public void display(){
		for(int i=0;i<=TOP;i++)
			System.out.println(arr[i]);
	}
	
	public static void main(String[] args) {
		StackImplementation st = new StackImplementation();
		st.initialize();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int ch;
		do{
			System.out.println("==========MENU==========");
			System.out.println("1. Add element 2. Remove element 3. Display all elements");
			System.out.println("========Enter choice========");
			ch = sc.nextInt();
			switch(ch){
				case 1: st.push();
						break;
				case 2: st.pop();
						break;
				case 3: st.display();
						break;
			}
		}while(ch>0&&ch<4);
	}

}
