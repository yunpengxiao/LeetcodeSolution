/*
* Main function for all the class
*/

public class JavaMain {
	public static void main(String args[]) {
		SameTree st = new SameTree();
		TreeNode p = null, q = null;
		if (st.isSameTree(p, q))
			System.out.println("Yes");
		else
			System.out.println("No");	
	}
}