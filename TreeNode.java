// Code to find the next highest node in a BST.
// The tree is constructed as a BST in the main function.
// This code does not work for a tree that is not a BST.
// Also this BST stores the parent
// @uthor Stavan Karia
// 11/9/2015
//          20
//          /\
//        10  30
//       /\    /\
//      5 13  25 40 
//
public class Tester{
  public static void main(String[] args){
    // construct the BST
    TreeNode node1 = new TreeNode(20);
    TreeNode node2 = new TreeNode(10);
    TreeNode node3 = new TreeNode(30);
    TreeNode node4 = new TreeNode(5);
    TreeNode node5 = new TreeNode(13);
    TreeNode node6 = new TreeNode(25);
    TreeNode node7 = new TreeNode(40);
    node1.assignChildrenAndParent(node2,node3);
    node2.assignChildrenAndParent(node4,node5);
    node3.assignChildrenAndParent(node6,node7);
    // Find result of code
    TreeNode result;
    result = node1.findNextHighest(node1);
    System.out.println("testing node "+node1.data+" next highest "+result.data);
    result = node2.findNextHighest(node1);
    System.out.println("testing node "+node2.data+" next highest "+result.data);
    result = node3.findNextHighest(node1);
    System.out.println("testing node "+node3.data+" next highest "+result.data);
    result = node4.findNextHighest(node1);
    System.out.println("testing node "+node4.data+" next highest "+result.data);
    result = node5.findNextHighest(node1);
    System.out.println("testing node "+node5.data+" next highest "+result.data);
    result = node6.findNextHighest(node1);
    System.out.println("testing node "+node6.data+" next highest "+result.data);
  }
}
class TreeNode{
	  int data;
	  TreeNode left;
	  TreeNode right;
	  TreeNode parent;
	  public TreeNode(int val){
	    this.data = val;
	  }
	  // assign children and parent to a node
	  public void assignChildrenAndParent(TreeNode leftNode, TreeNode rightNode){
	    this.left = leftNode;
	    this.right = rightNode;
	    this.parentOf(leftNode,rightNode);
	  }
	  // say who is the parentof the children
	  public void parentOf(TreeNode leftNode, TreeNode rightNode){
	    leftNode.parent = this;
	    rightNode.parent = this;
	  }
	  // function to find next highest node
	  public TreeNode findNextHighest(TreeNode root){
	    // for cases that have no right child
	    // i.e. the next highest element is a parent such that this node is on its left sub tree
	    if(this.right == null){
	      return this.findBiggerParent(root);
	    }
	    // if right sub tree exists, then rsult is the left most element at the bottom of the sub tree
	    else{
	      return this.right.findSmallestInTree();
	    }
	  }
	  // find next highest parent such that this node is on its left sub tree
	  public TreeNode findBiggerParent(TreeNode root){
		  TreeNode temp = this;
		  while(temp.parent != null){
			  if (temp.parent.left == temp){
				  return temp.parent;  
			  }
			  temp = temp.parent;
		  }
		  return new TreeNode(-1);
	  }
	  // get smallest element in the sub tree
	  public TreeNode findSmallestInTree(){
	    TreeNode temp = this;
	    while(temp.left != null){
	      temp = temp.left;
	    }
	    return temp;
	  }

}
