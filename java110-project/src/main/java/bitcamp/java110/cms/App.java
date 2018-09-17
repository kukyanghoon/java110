package bitcamp.java110.cms;

public class App {
    public static void main(String[] args) throws Exception {
        Thread main = Thread.currentThread();
        //System.out.println(main.getName());
        
        ThreadGroup mainGroup = main.getThreadGroup();
        //System.out.println(tg.getName());
        
        ThreadGroup systemGroup = mainGroup.getParent();
        System.out.println(systemGroup.getName());
        
        
        System.out.println("[thred]");
        Thread[] threads = new Thread[20];
        
        int count = systemGroup.enumerate(threads, false);
        for(int i=0;i<count;i++)
            {
                System.out.println(threads[i].getName());
            }
        
        System.out.println("thred group");
        ThreadGroup[] tgs = new ThreadGroup[20];
        
        int count1 = systemGroup.enumerate(tgs, false);
        for(int i=0;i<count1;i++)
            {
                System.out.println(tgs[i].getName());
            }
        
        System.out.println("main thread group");
         count = mainGroup.enumerate(threads, false);
        for(int i=0;i<count;i++)
            {
                System.out.println(threads[i].getName());
            }
        
        System.out.println("[Inno~그룹의 스레드]");
        count = tgs[1].enumerate(threads, false);
       for(int i=0;i<count;i++)
           {
               System.out.println(threads[i].getName());
           }
        

    }

}






















