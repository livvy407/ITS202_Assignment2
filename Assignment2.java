import java.util.*;

public class Assignment2 <Key extends Comparable<Key>, Value > //Key extends Comparable represents an ordered symbol
															   //table of generic key-value pairs.It supports the 
															   //usual put, get, contains, remove, size and isEmpty 
															   //methods. 
{
	private Node root;       //created the Node called root.
	private int size = 0;	 //declared the size and initialized it to 0.

	private class Node       //created a private class called Node that has declared objects key, value, left, right. 
	{
		private Key key;          //declare's the sorted key.
		private Value val;		  //declare's the data associated with key. 
		private Node left, right; //declare's the key and value existing in left or right of the subtrees.

		public Node (Key key, Value val) //constructor Node is created to initialize the objects
										 //such as key and value of the ordered symbol table.
		{
			this.key = key;  // The key and value inserted by the user will be received and initialized.    
			this.val = val;
		}
	}

	public boolean isEmpty() // This function is to check wether the ordered symbol table is empty or not.
	{
		if(size == 0) //If the ordered symbol table is 0 then it will return ture.
		{
			return true;
		}
		return false; //Else if the symbol table is not empty it will return false.
	}

	public int size() // This function is to return the size of the ordered symbol table.
	{
		return size; // returns the size fo the ordered symbol table.
	}

	public boolean contains(Key key) //This function is to check weather the key input by the user is in the symbol table or not. 
	{
		Node curNode = root; // Create Node curnode that will contain the key and value of root.

		if(key == null)      // If the input key is null then it will display error.
		{
			throw new IllegalArgumentException("There is no key to be contained."); // Error that will be displayed.
		}
		else // when the input key is not null.
		{
			while(curNode.key != key) // If the input key is not same as the curNode key.
			{
				int cmp = key.compareTo(curNode.key); // Then the value of input key will be compared with the value of 
													  // value of cur.Node key.

				if(cmp < 0)  // If the value of input key is less than curNode key.
				{
					curNode = curNode.left; //Then the curNode will be corresponding left key and the input key 
											//will be further compared with new assigned curNode key. This process
											//will be repeated until the required key is found.   
				}
				else
				{
					curNode = curNode.right; //If the value of input key is more than the curNode key then the curNode 
											 //will be changed to the corresponding right key. Then the input key will
											 //further compared with the new assigned curNode key. This process will be
											 //repeated until the required input key is found. 

				}
			}
			return true; // If the required key is found in the ordered symbol table then it will return true.
		}
	}

	public Value get(Key key) //This function is used to get the required input key.
	{
		if(key == null) // if the input key is null then it will display error.
		{
			throw new IllegalArgumentException("Argument to get value is null.");
		}
		Node curNode = root; // create Node curNode that will contain the key and value of root. 
		while(curNode.key != key) //if the key of curNode is not same as the input key
		{
			int cmp = key.compareTo(curNode.key); //then the input key will be compared with curNode key.
			if(cmp < 0) //if the value of input key is less than the value of curNode key, then
			{
				curNode = curNode.left; //curNode will be assigned to the corresponding left key so that the value 
								        //of input key will be further compared until the required input key is found.
			}
			else if(cmp > 0) //if the value of input key is more than the value of curNode key, then
			{
				curNode = curNode.right; //the curNode be assigned to the corresponding right key so that the value 
										 //of input key will be further compared. This process will be repeated until
										 //the required input key is found in the ordered symbol table.
			}
		}
		if(curNode.key == key) // If the input key is same as the assigend curNode key, then
		{
			System.out.println(curNode.val); // It will print the value of the input key.
		}
		return curNode.val; //the value of curNode key will be displayed.
	}

	public void put(Key key, Value val) //This function will insert the key and value given by the user in the symbol
										//table.
	{
		Node newNode = new Node(key, val); //create newNode Node with the input key and value. 
		if(root == null) //if the size of the symbol table is null, then
		{
			root = newNode; //make the new input key and value as root.
		}
		else //if the symbol table is not null(condition).
		{
			Node curNode = root; // declare curNode as root.
			Node parent; // create new Node as parent.  
			while(true)  // if the condition is ture.
			{
				parent = curNode; // assign the curNode as parent.
				int cmp = key.compareTo(curNode.key); // compare the value of input key with the value of curNode key.
				if(cmp < 0) // if the value of input key is less than value of curNode(root), then
				{
					curNode = curNode.left; //the curNode will shift to next left key and declare that key as parent 
											//if the key that is to be inserted is still less than parent node.
					if(curNode == null) //if there is no further node after several comparision then  
					{
						parent.left = newNode; // newNode will assigned to the left position of the declared parent node..
						size = size + 1; //then the size of binary tree will be increase by 1.
						return;
					}
					else if(curNode.key == key) // if the key that is to be inserted is same with any of the existing
												// key then 
					{
						curNode.val = val; // the value of the existing key will be replaced by the value of new key.
						return;
					}
				}
				else if(cmp > 0) // if the value of that is to be inserted is more than the curNode(root).
				{
					curNode = curNode.right; // The curNode will shift to next right key and declare that key as parent
											 // if the key to be inserted is still more than the parent node.
					if(curNode == null) // if there no further node after several comparision then
					{
						parent.right = newNode; // newNode will be assigned to the right position of the declared
												// parent node.
						size = size + 1; // the size will increase by 1.
						return;
					}
					else if(curNode.key == key) //But if there is any matching key in the binary tree then
					{
						curNode.val = val; // the value of matching key will be replaced by the value of new key.
						return;
					}
				}
			}
		}
		size = size + 1; //the size of the tree will be increase by 1.
	}

	public Key min() //this function is to return the key with minimum value. 
	{
		if(size == 0) // if the size of the key is 0 then,
		{
			throw new NoSuchElementException("There is no element in the binary tree."); 
		}
		else //if the binary tree is not null then
		{
			Node curNode = root; // the root of the tree will be inserted in the temporary Node called curNode.
			while(curNode.left != null) //the curNode will move to the other left key unil the last left key is 
										//external key.
			{
				curNode = curNode.left;
			}
			return curNode.key; //if the set curNode is external node then that node will be minimum key.
		}
	}

	public Key max()
	{
		if(size == 0)
		{
			throw new NoSuchElementException("There is no element in the binary tree.");
		}
		else
		{
			Node curNode = root;
			while(curNode.right != null) //the curNode will move to the other right key unil the last right key is 
										//external key.
			{
				curNode = curNode.right;
			}
			return curNode.key; // will return the right most node of the tree.
		}
	}

	public Key floor(Key key) //This function is to return the floor of the input key.
	{
		if(size == 0) // if the size of the tree is null then is will throw error.
		{
			throw new IllegalArgumentException("There is no key in the tree.");
		}
		Node curNode = root; // initialize the root in the tempoary node called curNode.
		Node parent = null; // initialize the Node parent as null.
		while(curNode != null) // if the declared curNode is an internal node then
		{
			parent = curNode; // make that curNode as parent node.
			int cmp = key.compareTo(parent.key); // compare the input key with the parent key.

			if(cmp == 0) // if the value of input key is same as the value of parent node then
			{
				return parent.key; // it will return the parent key as floor.
			}
			if(key == null) // if the input key has null value then it will throw error.
			{
				throw new IllegalArgumentException("Cannot call floor function with the null key.");
			}
			if(cmp < 0) // if the value of input key is less than the parent key then,
			{
				curNode = parent.left; // it will return the left child of the declared parent key as floor.
			}
			else if(cmp > 0) // if the value of input key is more than the parent key then,
			{
				curNode = parent.right; // returns the previous parent as floor of the input key. 

				int cm = key.compareTo(curNode.key);
				if(cm < 0)
				{
					return parent.key;
				}
				else
				{
					curNode = parent.right; // this condition is repeated if the input key is still greater
											// than right parent key.
				}
			}
		}
		return parent.key;
	}

	public Key select(Key key)
	{
		if(size == 0)
		{
			throw new IllegalArgumentException("Cannot find the rank if the tree is null");
		}
		Node curNode = root;
		Node parent = null;

		while(curNode != null)
		{
			parent = curNode;

			int cmp = key.compareTo(parent.key);
			if(key == null)
			{
				throw new IllegalArgumentException("Cannot find the rank of input key if the key is null.");
			}

			if(cmp > 0) // if the input key is more than the parent key then it will move to next key until the
						// given key is found.
			{
				curNode = parent.right; 
			} 

			else if(cmp < 0) // if the input key is less than the parent key then it will move to next left key until the
						   	 // given key is found.
			{
				curNode = parent.left;

				int cm = key.compareTo(parent.key); //to check or compare wether the input key is greater than left parent key.
				if(cmp > 0) //if the input key is greater than left parent key then
				{
					return curNode.key; // it will return the rank of curNode.
				}
				else
				{
					curNode = parent.left; //if the key is sill less than the left parent then curNode will move
											// to left key until the input key is found.
				}
			}
		}
		return parent.key;
	}

	public void keys(Key lo, Key hi) //function to return the all keys in the symbol table in given range.
	{
		if(lo == null || hi == null) // lo to return the keys from minimum end point.
									 // hi to return the keys from maximum end point.
		{
			throw new IllegalArgumentException("calls keys() with null key."); //error will be displayed if the lo and hi key are null.
		}

		Node curNode = root; 
		Node parent;
		while(curNode != null) // if the size of the tree is not null. 
		{ 
		  	parent = curNode; // declare the curNode as parent.

			if(parent == null) // if the parent key is null then it will return nth. 
			{
				return;
			}
			int cmp = lo.compareTo(parent.key); //to compare lo key with parent key.
    		int cm = hi.compareTo(parent.key); //to compare hi key with parent key.
            if (cmp < 0) //if the lo key is less than the parent key then
            { 
            	curNode = parent.left; //the lo key will be displayed.
        	}
        	if (cmp <= 0 && cm >= 0) // if the lo key is small or equal to parent key and hi key is more or equal to parent key
        							 // then 
        	{ 
            	System.out.print(parent.key + " "); // the key between the lo key and hi key will be displayed in range form lo to hi.
        	} 
        	if (cm > 0) // if the hi key is more than the parent key then the curNode will be the next right key until the given hi key is found.
        	{ 
            	curNode = parent.right;
        	}
        }
	}
}