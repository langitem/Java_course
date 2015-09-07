 1 // Fig. 17.3: List.java
 2 // ListNode and List class definitions.
 4
 5 // class to represent one node in a list
 6 class ListNode
 7 {
 8    // package access members; List can access these directly
 9    Object data; // data for this node
10    ListNode nextNode; // reference to the next node in the list
11
12    // constructor creates a ListNode that refers to object
13    ListNode( Object object )
14    {
15       this ( object, null );
16    } // end ListNode one-argument constructor
17
18    // constructor creates ListNode that refers to
19    // Object and to next ListNode
20    ListNode( Object object, ListNode node )
21    {
22       data = object;
23       nextNode = node;
24    } // end ListNode two-argument constructor
25
26    // return reference to data in node
27    Object getObject()
28    {
29       return data; // return Object in this node
30    } // end method getObject
31
32    // return reference to next node in list
33    ListNode getNext()
34    {
35       return nextNode; // get next node
36    } // end method getNext
37 } // end class ListNode
38
