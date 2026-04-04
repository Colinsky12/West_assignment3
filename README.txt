Colin West
cmw84331@uga.edu

Compile instructions:
    Just run ./run.sh (my compile script) in the project directory.

1: Pseudocode and Big-O for getSingleParent:
Define current reference //O(1)
Print "Single Parents: " //O(1)
getSingleParentHelper(current): //O(1)
    if currentNode isn't null:
        call getSingleParentHelper on the left //O(1)
        if there's only a right child and not a left child OR only a left child and not a right child
            print the current value //O(1)
        call getSingleParentHelper on the right //O(1)
Println to fix lines //O(1)

This method has at most 3 calls for every node that exists (1 for calling on left, one for printing, one for calling on right).
In addition to 4 calls that always happen, this method has 3n+4 calls, which is O(n).

2: Pseudocode and Big-O for getNumLeafNodes:
Run getNumLeafNodesHelper //O(1)
    if node is empty:
        return 0 //O(1)
    elif node has no children (AKA a leaf):
        return 1 //O(1)
    else:
        run getNumLeafNodesHelper on both left and right. //O(2)
Print line for numLeafNodes //O(1) 

This method has 2 calls for non-leaf nodes and 1 call for leaf nodes.
In addition to 2 calls that always happen, we can give this method 2x+y+2, x+y=n.
As n grows and assuming regular growth, there will be one more leaf node than all other nodes (ex: when n=15, y=8 and x=7).
This make y ~=x+1, giving the formula 2x+x+1+2=3x+3, which has O(n).

3: Pseudocode and Big-O for getCousins:

Define current reference //O(1)
Define parent reference //O(1)
Define grandparent reference //O(1)
if tree is empty:
    print that it's empty //O(1)
otherwise:
    while current isn't null: //O(log n)
        if item is smaller than current:
            make grandparent have parent reference //O(1)
            make parent have current reference //O(1)
            make current have its own left reference //O(1)
        elif item is larger than current:
            make grandparent have parent reference //O(1)
            make parent have current reference //O(1)
            make current have its own right reference //O(1)
        elif item is equal to current:
            item found; break //O(1)
        if item is null after searching:
            print that the item isn't in the tree //O(1)
            stop running //O(1)
    Print "X cousins: " //O(1)
    if grandparent reference is null, meaning the selected node is the head or a child of the head:
        stop running //O(1)
    otherwise:
        if grandparent's left child has a value that isn't parent:
            if that child has a left child:
                it's a cousin, print it //O(1)
            elif that child has a right child:
                it's a cousin, print it //O(1)
        elif grandparent's right child has a value that isn't parent:
            if that child has a left child:
                it's a cousin, print it //O(1)
            elif that child has a right child:
                it's a cousin, print it //O(1)
Println to fix lines //O(1)

This method really does two things:
Find the node you're looking for (while tracking on grandparent), and then get to cousins from grandparent.
Finding the node has 3log(n)-2 calls, as there are three calls for every level traveled with
the exception of finding the item.
Thanks to the nature of binary trees, having a grandparent means a node has at most two cousins,
so at most three calls will be made for the second part of the method.
Add 5 calls that always happen and you get 3log(n)-2+3+5 = 3log(n)+6.
Simplify and you O(log n).



NOTE: If the item isn't found then there is a total formula of 3log(n)+2.
This is because there's three calls for every level with the exception of no find, which is 2. (3log(n)-1).
Add the 3 calls already made and you get 3log(n)+2. This would also be O(log n), though.




    
        

