package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        SafetyList list = new SafetyList();

        Thread thread = new ListThread(list);
        Thread thread2 = new ListThread(list);

        thread.start();
        thread2.start();

        try {
            thread.join();
            thread2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list.getSize());
    }
    // END
    }

