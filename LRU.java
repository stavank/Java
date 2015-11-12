// Least recently used scheduling policy Using 2 Stacks - poor solution
// @uthor Stavan Karia
// 11/11/2015

import java.util.*;

public class LRU{
  public static void LRUpolicy(int[] pages, int window){
	Stack<Integer> pageStack = new Stack<Integer>();
	Stack<Integer> replacement = new Stack<Integer>();
  int index = 0, element = 0;
	pageStack.push(pages[0]);
    for(int i = 1; i < pages.length; i++){
    	// there is place in the stack
    	if(pageStack.size() < window){
    		pageStack.push(pages[i]);
    	}
    	// stack is full
    	else{
    		index = pageStack.search(pages[i]);
    		// element was not found
    		if(index==-1){
    			index = window;
    			while(index > 1){
    				replacement.push(pageStack.pop());
    				index--;
    			}
    			element = pageStack.pop();
    			while(replacement.size() > 0){
    				pageStack.push(replacement.pop());
    			}
    			pageStack.push(pages[i]);
    		}
    		// element was found
    		else{
    			while(index > 1){
    				replacement.push(pageStack.pop());
    				index--;
    			}
    			element = pageStack.pop();
    			while(replacement.size() > 0){
    				pageStack.push(replacement.pop());
    			}
    			pageStack.push(element);
    		}
    	}
    }
    // print results
    for(int k = pageStack.size(); k > 0; k--){
    	System.out.print(pageStack.pop()+" => ");
    }

  }
  public static void main(String[] args){
    int[] pages = {1,2,3,4,4,3,4,4};
	  int window = 4;
	  LRUpolicy(pages, window);
  }
}
