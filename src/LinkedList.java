

public class LinkedList {
    Node root;
    public LinkedList(int data){
        root = new Node(data);
    }
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList(1500);
        linkedList.addLast(100);
        linkedList.addLast(30);
        linkedList.insertAt(0,50);
        linkedList.remove(1500);
        System.out.println(linkedList);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("root -> ");
        Node now = root;
        while (now != null){
           str.append(now.getData()).append(" -> ");
           now = now.getNext();
        }
        return str.append("null").toString();
    }
    public void addLast(int data){
        Node now = root;
        while (now.getNext() != null){
            now = now.getNext();
        }
        Node node = new Node(data);
        now.setNext(node);
    }
    public int getSize(){
        int size = 0;
        Node node = root;
        while (node!= null){
            size++;
            node = node.getNext();
        }
        return size;
    }
    public void insertAt(int index,int data){
        Node node = root;
        if (index>getSize()){
            int count = 1;
            while (node.getNext()!=null){
                count++;
                node  = node.getNext();
            }
            for (int i = count;i < index-1;i++){
                Node a = new Node(0);
                node.setNext(a);
                node = node.getNext();
            }
            Node b = new Node(data);
            node.setNext(b);
        }else {
            Node a = new Node(data);
            if (index == 0) {
                a.setNext(node);
                root = a;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    node = node.getNext();
                }
                a.setNext(node.getNext());
                node.setNext(a);
            }
        }
    }
    public void remove(int data){
        Node node = root;
        while (node.getNext() != null){
            if (node.getNext().getData() == data) {
                node.setNext(node.getNext().getNext());
                return;
            }
            node = node.getNext();
        }
    }
}
