class serializeBT{
  private static final int MARKER = Integer.MIN_VALUE;

  public static void serialize(BinaryTreeNode node,
      ObjectOutputStream stream)
          throws java.io.IOException {
      
    if (node == null){
      stream.writeInt(MARKER);
      return;
    }
    
    stream.writeInt(node.data);
    serialize(node.left, stream);
    serialize(node.right, stream);
    
  }

  public static BinaryTreeNode deserialize(
      ObjectInputStream stream) throws java.io.IOException {
    
    int val = stream.readInt();
    
    if (val == MARKER){
      return null;
    }
    
    BinaryTreeNode node = new BinaryTreeNode(val);
    node.left = deserialize(stream);
    node.right = deserialize(stream);
    return node;
  }
}  