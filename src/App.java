
public class App {

    public static void main(String[] args) throws Exception {

        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        c.print();
    }
}

class Counter {
    private int value = 0;

    public void print() {
        System.out.println("Counter : " + this.value);
    }

    // here we are using thread safety by creating method as synchronized.
    public synchronized void increment() {
        this.value++;
    }

    /*
     * We have several ways to achieve thread safety : -
     * 
     * -> we can use volatile keyword @time of variable declaration.
     * So the variable is created in main memory. i.e thread can either
     * perform read or write operation on it.
     * 
     * drawbacks : fails for multiple operator. like (++, --)
     * -----------
     * 
     * -> We can use Atomic datatypes inorder to overcome the above situation.
     * 
     * -> We can use / create synchronized block @place we required thredsafety in
     * the methods.
     * So at a time only one thread can access it.
     * 
     */

    /*
     * -> Ideal threadpool size = number of cores of the CPU.
     * ->
     */
}
