package linkedlist;

import java.util.Scanner;

public class DoubleLinkedList {
	
	public Nodes start,end;
	public int size;
	
	public  DoubleLinkedList(){
		start=null;
		end=null;
		size=0;
	}
	
	public boolean isEmpty(){
		return start==null;
	}
	
	public int getSize(){
		return size;
	}
	
	public int readData(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data");
		int data = sc.nextInt();
		return data;
	}
	
	public void addAtStart(){
		int data = readData();
		Nodes add=new Nodes(data,null,null);
		size++;
		if(isEmpty()){
			start=add;
			end=start;
		}
		else{
			start.setPrev(add);
			add.setNext(start);
			start=add;
		}
	}
	
	public void addAtEnd(){
		int data = readData();
		Nodes add=new Nodes(data,null,null);
		size++;
		if(isEmpty()){
			start=add;
			end=start;
		}
		else{
			add.setPrev(end);
			end.setNext(add);
			end=add;
		}
	}
	
	public void addAtPosition(){
		int data = readData();
		Nodes add=new Nodes(data,null,null);
		int pos = readData();
		if(pos==1){
			addAtStart();
			return;
		}
		Nodes ptr = start;//use this pointer to traverse list from start
		for(int i=2;i<=size;i++){
			if(i==pos){
				Nodes temp=ptr.getNext();//store this link in temp
				ptr.setNext(add);
				add.setPrev(ptr);
				add.setNext(temp);
				temp.setPrev(add);
				break;
			}
			ptr=ptr.getNext();
		}
		size++;
	}
	
	//To remove from start perform removeAtPos(0)
	//To remove from end perform removeAtPos(size-1)
	public void removeAtPos(){
		int pos=readData();
		if(pos==1){
			if(size==1){
				start=null;
				end=null;
				size=0;
				return;
			}
			start=start.getNext();
			start.setPrev(null);
			size--;
			return;
		}
		//to keep a track of last and second last node two pointers are used
		if(pos==size){
			end=end.getPrev();
			end.setNext(null);
			size--;
			return;
		}
		Nodes ptr = start.getNext();
		for(int i=2;i<=size;i++){
			if(i==pos){
				Nodes p=ptr.getPrev();
				Nodes n=ptr.getNext();
				p.setNext(n);
				n.setPrev(p);
				size--;
				break;
			}
			ptr=ptr.getNext();
		}
	}
	
	public void display(){
		if(size==0){
			System.out.println("Empty List");
			return;
		}
		if(start.getNext()==null){
			System.out.println("Data is "+start.getData());
			return;
		}
		Nodes ptr = start;
		System.out.println(ptr.getData());
		ptr=start.getNext();
		while(ptr.getNext()!=null){
			System.out.println(ptr.getData());
			ptr=ptr.getNext();
		}
		System.out.println(ptr.getData());
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		DoubleLinkedList dl = new DoubleLinkedList();
		int ch;
		do{
			System.out.println("==========MENU==========");
			System.out.println("1. Add at Start 2. Add at end 3. Add at Position 4. Reomove at Position 5. Display all elements");
			System.out.println("========Enter choice========");
			ch = sc.nextInt();
			switch(ch){
				case 1: dl.addAtStart();
						break;
				case 2: dl.addAtEnd();
						break;
				case 3: dl.addAtPosition();
						break;
				case 4: dl.removeAtPos();
						break;
				case 5: dl.display();
						break;
			}
		}while(ch>0&&ch<6);
	}
	
	
	
	

}

class Nodes{
	
	Nodes next,prev;
	int data;
	
	Nodes(){
		next=null;
		prev=null;
		data=0;
	}
	Nodes(int data, Nodes next, Nodes prev){
		this.data=data;
		this.next=next;
		this.prev=prev;
	}
	public Nodes getNext() {
		return next;
	}
	public void setNext(Nodes next) {
		this.next = next;
	}
	public Nodes getPrev() {
		return prev;
	}
	public void setPrev(Nodes prev) {
		this.prev = prev;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}