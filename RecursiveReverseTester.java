// Recursively Reverse a LinkedList Java
// @uthor Stavan Karia
// 11/11/2015


public class RecursiveReverseTester{
  // reverse the linked list
  public static ListNode reverse(ListNode ll){
    if(ll == null ){
      return null;
    }
    if(ll.next == null){
      return ll;
    }
    ListNode second = ll.next;
    ll.next = null;
    ListNode finalNode = reverse(second);
    second.next = ll;
    return finalNode;
  }
  public static void main(String[] args){
	// create the linked list
    ListNode l1 = new ListNode('a');
    ListNode l2 = new ListNode('b');
    ListNode l3 = new ListNode('c');
    ListNode l4 = new ListNode('d');
    ListNode l5 = new ListNode('e');
    ListNode l6 = new ListNode('f');
    ListNode l7 = new ListNode('g');
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    l6.next = l7;
    l7.next = null;
    ListNode reversed = reverse(l1);
    // print the reversed list
    while(reversed!=null){
        System.out.print(reversed.data+" => ");    	
        reversed = reversed.next;
    }
  }
}
class ListNode{
  char data;
  ListNode next;
  public ListNode(char input){
    this.data = input;
  }
}
