package gol;

public final class MainThread extends Thread {
    private static volatile MainThread thread;
    private Game game;
    private boolean isStarted=false;
    public static  MainThread getInstance(){
        if (thread == null) {
            synchronized (MainThread.class){
                if (thread == null) {
                    thread=new MainThread();
                }
            }
        }
        return thread;
    }
    private MainThread(){

    }
    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                long time = System.currentTimeMillis();
                if (GameOfLife.isRunning) {
                    GameOfLife.game.run();
                    GameOfLife.gameFrame.update();
                }
                Thread.sleep((long)
                        Math.max(5, (Vars.refreshRate * 1000) - (System.currentTimeMillis() - time)));
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }


    @Override
    public synchronized void start() {
        if(isStarted)
            return;
        super.start();
        isStarted=true;
    }
}
