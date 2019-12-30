94.（BTInorderTraversal_94）二叉排序树的中序排序、先序遍历、后序遍历的非递归写法：
    非递归的先序遍历思想：
    1、入栈前先访问节点current的值（例如list.add（））
    2.节点current入栈，然后循环将current的左子树入栈，current = current.left，直到current为空；
    3.弹出栈顶结点，赋值给current，current = current.right
    4.循环123一直到不满足stack为空||current为空指针。

    非递归的中序遍历思想：
    1.当前节点current = root入栈，
    2.循环将current的左子树入栈，current = current.left直到current为空
    3.弹出栈顶节点，赋值current访问节点的值
    4.循环123一直到不满足stack为空||current为空指针。
    
    非递归的后序遍历思想：（与先序遍历、中序遍历稍有不同，根节点存在右子树会再次入栈），多一个lastNode；
    1、当前节点current = root入栈。
    2、循环将current的左子树入栈，current = current.left知道current为空
    3.弹出栈顶节点赋值给popNode，若popNode节点（popNode.right!=null||popNode.right==lastNode）满足条件4否则5
    4、读取该节点pop，lastNode = pop
    5、节点pop入栈current = popNode.right
------------------------------------------------------------
589、非递归N叉排序树的先序遍历（跟左右）
    读取根节点，节点的子树从右向左入栈，弹出可以一次取得该节点的左子树。
    读取节点，然后循环将该节点的子树从左到右入栈，弹出栈顶元素。
------------------------------------------------------------
590、非递归N叉排序树的后序遍历（左右根）
    跟左右是根右左的取逆，逆向可以使用addFirst（）。
    add根节点，节点的子树从左到右入栈，弹出栈顶元素并且add，循环将此节点的子树从左到右入栈，循环反复，直到栈为空。
