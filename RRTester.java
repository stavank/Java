// Find Round Robin Schedule of jobs
// @uthor Stavan Karia
// 11/11/2015

import java.util.*;

public class RRTester{
  public static void RRpolicy(ArrayList<Task> taskList, int timeUnit){
	Task[] tasks = taskList.toArray(new Task[taskList.size()]);
  // number of exhausted jobs
	int count = 0;
	// whie there are still jobs left
	while(count < tasks.length){
		for(int i = 0; i < tasks.length; i++){
		    // if task has some time to execute
	      if(tasks[i].burst != 0){
	      // if task has time left worth the timeUnit
	        if(tasks[i].burst >= timeUnit){
	          tasks[i].burst -= timeUnit; 
	          System.out.println("task => "+tasks[i].index+"for =>"+timeUnit);
	        }
	        // if the time left for execution is less than timeUnit
	        else{
	          System.out.println("task => "+tasks[i].index+"for =>"+tasks[i].burst);
	          tasks[i].burst = 0;
	          count++;
	        }
	      }
	    }
	}
  }
  public static void main(String[] args){
    int timeUnit = 10;
    // add tasks
    ArrayList<Task> tasks = new ArrayList<Task>();
    tasks.add(new Task(1,11));
    tasks.add(new Task(2,13));
    tasks.add(new Task(3,17));
    tasks.add(new Task(4,10));
    tasks.add(new Task(5,16));
    tasks.add(new Task(6,7));
    tasks.add(new Task(7,1));
    tasks.add(new Task(8,15));
    tasks.add(new Task(9,20));
    RRpolicy(tasks, timeUnit);
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
