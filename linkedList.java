import java.util.*;

public class linkedList extends SimpleLink {

    static ArrayList<Integer> dataList = new ArrayList<>(); 
    static int size;
    static int firstData;
    static int firstID;
    static linkedList linkedListObj;
    
    static Scanner readInput = new Scanner(System.in);

    public SimpleLink first;

    public linkedList(){
        first = null;     
    }
    public linkedList(int num , int data){
        super(num , data);
        first = null;
    }

    public void insertFist(int item , int data){
        SimpleLink newObj = new SimpleLink(item , data);
        newObj.next = first;
        first = newObj;
    }

    public SimpleLink Find(int neededItem){
        SimpleLink currentItem = first;
        
        while(currentItem.getData() != neededItem){
            if(currentItem.next == null){
                return null;
            }else{
                currentItem = currentItem.next;
            }
        }

        return  currentItem;
    }

    public SimpleLink deleteItem(int item){
        SimpleLink current = first;
        SimpleLink previous = first;

        while(current.getData() != item){
            if(current.next == null){
                return null;
            }else{
                previous = current;
                current = current.next;
            }
        }

        if(current == null){
            return null; // Item not found
        }else if(current == first){
            first = first.next;
        }else{
            previous.next = current.next;
        }

        return current;
    }

    public int sumItem(){
        int sum = 0;
        SimpleLink current = first;

        while(current.next != null){
            sum += current.getData();
            current = current.next;
            dataList.add(current.getData());
        }
        return sum;
    }

    public void duplicationItem(){
        for(int i = 0 ; i < dataList.size() ; i++){
            System.out.println(dataList.get(i) + " " + dataList.get(i));
        }
    }

    public void maxMin(){
        int min = sumItem();
        int max = dataList.get(0);

        for(int i = 0 ; i < dataList.size() ; i++){
            if(dataList.get(i) > max){
                max = dataList.get(i);
            }else if (dataList.get(i) < min){
                min = dataList.get(i);
            }
        }

        System.out.println("The maximum number be as : " + (max) + " and minimum number is: " + (min));
    }
    
    public void display(){
        SimpleLink current = first;
        System.out.print(" [ ");

        while(current.next != null){
            current.displayData();
            current = current.next;
        }
        System.out.print(" ] ");
    }


    public static void main(String[] args) {
        allFunction();
    }
    
    private static void allFunction() {
        userDefine();
        
        System.out.print("\nDo want to added more (Yes/No)? : ");
        String addItems = readInput.next();

        if(addItems.equalsIgnoreCase("YES")){
            System.out.print("\nEnter needed size to the items: ");
            size = readInput.nextInt();
            getItem(size,linkedListObj);
            options();           
        }else{
            System.out.println("Thank you for visit us!");
        }
    }

    private static void userDefine() {
        System.out.print("\nHello , please enter your name here: ");
        String name = readInput.nextLine();

        System.out.print("\nWelcome " + (name) + " please enter initial data in next form:\n");

        System.out.print("\nEnter first id here: ");
        firstID = readInput.nextInt();

        System.out.print("Enter first data here: ");
        firstData = readInput.nextInt();
        
        linkedListObj = new linkedList(firstID, firstData);
        linkedListObj.insertFist(firstID, firstData); // Insert the initial data
    }

    private static void getItem(int size, linkedList linkedListObj) {

        
        for(int i = 0 ; i < size ; i++){
            System.out.print("\nEnter id of data: ");
            int id = readInput.nextInt();

            System.out.print("Enter value of data: ");
            int value = readInput.nextInt();

            linkedListObj.insertFist(id,value);
        }
    }
    private static void optionShow(int option , linkedList linkedListObj) {
        switch(option){
            case 1:
                linkedListObj.maxMin();
                break;
            case 2:
                findOption(linkedListObj);
                break;
            case 3:
                deleteOption(linkedListObj);
                break;
            case 4:
                System.out.println("The summation of all items: " + (linkedListObj.sumItem() + "\n" ));
                break;
            case 5:
                linkedListObj.display();
                break;
            case 6:
                System.out.println("Thank you for visit us!");
                break;
            default:
                System.out.println("please enter correct number of option!");
                break;
        }
    }

    private static void findOption(linkedList linkedListObj) {
        System.out.print("Enter needed item for find it: ");
        int item = readInput.nextInt();
        showResult(item,"find" , linkedListObj);
    }
    
    private static void deleteOption(linkedList linkedListObj) {
        System.out.print("Enter needed item for deleted it: ");
        int element = readInput.nextInt();
        showResult(element,"delete" , linkedListObj);
    }

    private static void options() {
        System.out.println("\nSelect one of these options:\n");
        
        System.out.println("    1.max and min item");
        System.out.println("    2.find item");
        System.out.println("    3.delete item");
        System.out.println("    4.sum item");
        System.out.println("    5.show items");
        System.out.println("    6.None");

        System.out.print("\nEnter your needed option here: ");
        optionShow(readInput.nextInt(),linkedListObj);
    }

    private static void showResult(int element , String operation , linkedList linkedListObj){
        if(operation.equalsIgnoreCase("delete")){
        
            if(linkedListObj.deleteItem(element) == null){
                System.out.println("\nSorry but your needed item not found!");
            }else {
                System.out.println("\nYour element is deleted!");
            }
        
        }else{
            if(linkedListObj.Find(element) == null){
                System.out.println("Sorry but your needed item not found!");
            }else {
                System.out.println("Your element is exist!");
            }
        }
    }
}
