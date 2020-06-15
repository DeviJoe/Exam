public class SimpleTree<T> {

    protected class TreeItem {
        public T value;
        public TreeItem left;
        public TreeItem right;

        public TreeItem(T value, TreeItem left, TreeItem right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeItem(T value) {
            this(value, null, null);
        }
    }

    protected TreeItem root = null;
    protected int size = 0;

    public void add(T value)
    {
        if (root == null) {
            root = new TreeItem(value);
        }
        else {
            addTo(root, value);
        }

        size++;
    }

    /**
     * Рекурсивная вставка
     * @param node
     * @param value
     */
    private void addTo(TreeItem node, T value)
    {
        if (value.toString().compareTo(node.value.toString()) < 0) {
            if (node.left == null)
            {
                node.left = new TreeItem(value);
            } else {
                addTo(node.left, value);
            }
        } else {
            if (node.right == null)
            {
                node.right = new TreeItem(value);
            }
            else
            {
                addTo(node.right, value);
            }
        }
    }

    public int heightOfBinaryTree(TreeItem node) {
        if (node == null) {
            return 0;
        }
        else {
            return 1 + Math.max(heightOfBinaryTree(node.left), heightOfBinaryTree(node.right));
        }
    }
}
