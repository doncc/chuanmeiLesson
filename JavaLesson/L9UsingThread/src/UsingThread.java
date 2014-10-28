public class UsingThread {

	static class MyThread extends Thread {
		public void run() {
			System.out.println("My thread is started.");
		}
	}

	static int i = 5;

	public static void main(String args[]) {

		// MyThread t = new MyThread();
		// System.out.println(MyThread.currentThread());
		// Thread thread = new Thread("My current thread");
		// System.out.println(thread.getName());
		// t.run();

		Thread my = new Thread() {
			@Override
			public void run() {

				while (i > 0) {

					try {
						i--;
						System.out.println(i);
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				super.run();
			}
		};
		my.start();

	}

}
