// Shortest job first scheduling policy
// @uthor Stavan Karia
// 11/11/2015

import java.util.*;

public class Tester{
  public static void main(String[] args){
    ArrayList<Task> tasks = new ArrayList<Task>();
    // add tasks
    tasks.add(new Task(1,11));
    tasks.add(new Task(2,13));
    tasks.add(new Task(3,17));
    tasks.add(new Task(4,10));
    tasks.add(new Task(5,16));
    tasks.add(new Task(6,7));
    tasks.add(new Task(7,1));
    tasks.add(new Task(8,15));
    tasks.add(new Task(9,20));
    Task[] taskArray = tasks.toArray(new Task[tasks.size()]);
    // create a comparator to sort tasks according to execution time
    Comparator<Task> comp = new Comparator<Task>(){
    	public int compare(Task t1, Task t2){
    		return t1.burst-t2.burst;
    	}
    }; 
    // sort the tasks
    Arrays.sort(taskArray, comp);
    System.out.println("order of execution");
    int execTime = 0;
    // print results
    for(int i = 0; i < tasks.size(); i++ ){
    	execTime += taskArray[i].burst;
    	System.out.println("task index => "+taskArray[i].index+" total execTime => "+execTime);
    	
    }
  }
}
class Task{
	int index;
	int burst;
	public Task(int ind, int bur){
		this.index = ind;
		this.burst = bur; 
	}
}
