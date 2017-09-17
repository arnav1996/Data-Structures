package linkedlist;

import java.util.Scanner;

public class SingleLinkedList {
	
	public Node start,end;
	public int size;
	
	public  SingleLinkedList(){
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
		Node add=new Node(data,null);
		size++;
		if(isEmpty()){
			start=add;
			end=start;
		}
		else{
			add.setLink(start);
			start=add;
		}
	}
	
	public void addAtEnd(){
		int data = readData();
		Node add=new Node(data,null);
		size++;
		if(isEmpty()){
			start=add;
			end=start;
		}
		else{
			end.setLink(add);;
			end=add;
		}
	}
	
	public void addAtPosition(){
		int data = readData();
		Node add=new Node(data,null);
		Node ptr = start;//use this pointer to traverse list from start
		int pos = readData();
		pos--;
		for(int i=1;i<size-1;i++){
			if(i==pos){
				Node temp=ptr.getLink();//store this link in temp
				ptr.setLink(add);
				add.setLink(temp);
				break;
			}
			ptr=ptr.getLink();
		}
		size++;
	}
	
	//To remove from start perform removeAtPos(0)
	//To remove from end perform removeAtPos(size-1)
	public void removeAtPos(){
		int pos=readData();
		if(pos==1){
			start=start.getLink();
			size--;
			return;
		}
		//to keep a track of last and second last node two pointers are used
		if(pos==size){
			Node s = start;
			Node t = start;
			while(s!=end){
				t=s;
				s=s.getLink();
			}
			end=t;
			end.setLink(null);
			size--;
			return;
		}
		Node ptr = start;
		pos--;
		for(int i=1;i<size-1;i++){
			if(i==pos){
				Node temp=ptr.getLink();
				temp=temp.getLink();
				ptr.setLink(temp);
				break;
			}
			ptr=ptr.getLink();
		}
		size--;
	}
	
	public void display(){
		if(size==0){
			System.out.println("Empty List");
			return;
		}
		if(start.getLink()==null){
			System.out.println("Data is "+start.getData());
			return;
		}
		Node ptr = start;
		System.out.println(ptr.getData());
		ptr=start.getLink();
		while(ptr.getLink()!=null){
			System.out.println(ptr.getData());
			ptr=ptr.getLink();
		}
		System.out.println(ptr.getData());
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		SingleLinkedList sl = new SingleLinkedList();
		int ch;
		do{
			System.out.println("==========MENU==========");
			System.out.println("1. Add at Start 2. Add at end 3. Add at Position 4. Reomove at Position 5. Display all elements");
			System.out.println("========Enter choice========");
			ch = sc.nextInt();
			switch(ch){
				case 1: sl.addAtStart();
						break;
				case 2: sl.addAtEnd();
						break;
				case 3: sl.addAtPosition();
						break;
				case 4: sl.removeAtPos();
						break;
				case 5: sl.display();
						break;
			}
		}while(ch>0&&ch<6);
	}
	
}


class Node{
	
	int data;
	Node link;
	
	Node(){
		data=0;
		link=null;
	}
	
	Node(int data, Node link){
		this.data=data;
		this.link=link;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
	
}
