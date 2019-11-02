package com.example.thread.base.thread_wait_2;

/**
 * @author ZhangNan
 * @date 2019/11/2 13:09
 */
public class NotifyDisNotifyAll {
	public static volatile Object resourceA = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread threadA =new Thread(()->{
			synchronized (resourceA){
				System.out.println("threadA get resourceA lock");
				try {
					System.out.println("threadA begin wait");
					resourceA.wait();
					System.out.println("threadA end wait");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread threadB = new Thread(()->{
			synchronized(resourceA){
				System.out.println("threadB get resourceA lock");
				try {
					System.out.println("threadB begin wait");
					resourceA.wait();
					System.out.println("threadB end wait");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread threadC = new Thread(()->{
			synchronized(resourceA){
				System.out.println("threadC begin notify");
				//resourceA.notify();
				resourceA.notifyAll();
			}
		});

		threadA.start();
		threadB.start();
		Thread.sleep(1000);
		threadC.start();


		//等待线程结束
		threadA.join();
		threadB.join();
		threadC.join();
		System.out.println("main is over");
	}
}
