package cooperation;
/**
 * 信号灯 借助标志位
 * @author Trail
 *
 */
public class CoTest1 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		new Player(tv).start();
		new Watcher(tv).start();
	}
}

//生产者  演员
class Player extends Thread{
	Tv tv;

	public Player(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20 ;i++) {
			if(i%2 ==0) {
				this.tv.play("哈哈哈");
			}else {
				this.tv.play("立白");
			}
		}
	}
	
}
//消费者  观众
class Watcher extends Thread{
	Tv tv;

	public Watcher(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for(int i=0;i<20 ;i++) {
			tv.watch();
		}
	}
}

//同一个资源 电视
class Tv{
	String voice;
	//信号灯
	//t 演员表演 观众等待  F观众观看 演员等待
	boolean flag= true;
	
	public synchronized void play(String voice) {
		
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("表演了-->"+voice);
		this.voice = voice;
		
		this.notifyAll();
		this.flag= ! this.flag;
	}
	
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("听到了-->"+voice);
		
		this.notifyAll();
		this.flag=!this.flag;
	}
	
	
}