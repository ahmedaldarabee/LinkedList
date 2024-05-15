public class SimpleLink {
    
    private int data;
    private int numOFData;
    public SimpleLink next;
    
    public SimpleLink(){        
    }
    public SimpleLink(int numOFItem , int dataNeeded){
        this.numOFData = numOFItem;
        this.data = dataNeeded;
    }

    public void displayData(){
        System.out.print(" [ " + (this.numOFData) + " -> " + (this.data) + " ] ");
    }

    public int getData(){
        return this.data;
    }

    public int getID(){
        return this.numOFData;
    }
}
