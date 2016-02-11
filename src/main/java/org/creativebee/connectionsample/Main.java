package org.creativebee.connectionsample;

import org.creativebee.connectionsample.connection.dummy.DummyConnecter;
import org.creativebee.connectionsample.connection.pool.ConnectionFactory;

public class Main {
	public static void main(String[] args) throws Exception {

		Runnable runner = new Runnable() {

			@Override
			public void run() {

				DummyConnecter con = null;
				try {

					// インスタンスの取得
					con = ConnectionFactory.getPooledInstance();

					// 実行
					con.send("test");

				} finally {

					con.close();
				}
			}
		};

		// 複数スレッドの準備
		Thread th1 = new Thread(runner);
		th1.start();
		Thread th2 = new Thread(runner);
		th2.start();
		Thread th3 = new Thread(runner);
		th3.start();
		Thread th4 = new Thread(runner);
		th4.start();
		Thread th5 = new Thread(runner);
		th5.start();
		Thread th6 = new Thread(runner);
		th6.start();
		Thread th7 = new Thread(runner);
		th7.start();
		Thread th8 = new Thread(runner);
		th8.start();
		Thread th9 = new Thread(runner);
		th9.start();
		Thread th10 = new Thread(runner);
		th10.start();
		Thread th11 = new Thread(runner);
		th11.start();
		Thread th12 = new Thread(runner);
		th12.start();
		Thread th13 = new Thread(runner);
		th13.start();
		Thread th14 = new Thread(runner);
		th14.start();
		Thread th15 = new Thread(runner);
		th15.start();
		Thread th16 = new Thread(runner);
		th16.start();
		Thread th17 = new Thread(runner);
		th17.start();
		Thread th18 = new Thread(runner);
		th18.start();
		Thread th19 = new Thread(runner);
		th19.start();
		Thread th20 = new Thread(runner);
		th20.start();

		Thread.sleep(1000);

		Thread th21 = new Thread(runner);
		th21.start();
		Thread th22 = new Thread(runner);
		th22.start();
		Thread th23 = new Thread(runner);
		th23.start();
		Thread th24 = new Thread(runner);
		th24.start();
		Thread th25 = new Thread(runner);
		th25.start();
		Thread th26 = new Thread(runner);
		th26.start();
		Thread th27 = new Thread(runner);
		th27.start();
		Thread th28 = new Thread(runner);
		th28.start();
		Thread th29 = new Thread(runner);
		th29.start();
		Thread th30 = new Thread(runner);
		th30.start();
		Thread th31 = new Thread(runner);
		th31.start();
		Thread th32 = new Thread(runner);
		th32.start();
		Thread th33 = new Thread(runner);
		th33.start();
		Thread th34 = new Thread(runner);
		th34.start();
		Thread th35 = new Thread(runner);
		th35.start();
		Thread th36 = new Thread(runner);
		th36.start();
		Thread th37 = new Thread(runner);
		th37.start();
		Thread th38 = new Thread(runner);
		th38.start();
		Thread th39 = new Thread(runner);
		th39.start();
		Thread th40 = new Thread(runner);
		th40.start();

	}
}
