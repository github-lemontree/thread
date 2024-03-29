package com.example.thread.base.one.thread_interrupt_6;

/**
 * @author ZhangNan
 * @date 2019/11/2 14:53
 */
public class ThreadInterruptDemo1 {
	/**
	 * java中的线程中断是一种线程间的协助模式,
	 * 通过设置线程的中断标志并不能直接终止该线程的执行,而是被中断的线程根据中断状态自行处理
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()->{
			//当前线程被中断退出循环
			while(!Thread.currentThread().isInterrupted()){
				System.out.println(Thread.currentThread() + "hello");
			}
		});
		thread.start();
		Thread.sleep(1000);
		System.out.println("main thread interrupt thread");
		thread.interrupt();
		thread.join();
		System.out.println("main is over");
	}
}
