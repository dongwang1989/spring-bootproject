package cn.zzdz.usercontroller;

public class ta extends Thread {
    public ta(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this.getName() + i);
        }
    }
}
