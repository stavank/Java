// Just the functions to validate to a tree to be a BST
// @uthor Stava Karia
// 11/12/2015

private boolean isBST() { 
      return isBST(root, null, null); 
    }


 private boolean isBST(Node x, Key min, Key max) {
      if (x == null) 
          return true; 
      if (min != null && x.key.compareTo(min) <= 0) 
          return false; 
      if (max != null && x.key.compareTo(max) >= 0) 
          return false; 
      return isBST(x.left, min, x.key) && isBST(x.right, x.key, max); 
    }
