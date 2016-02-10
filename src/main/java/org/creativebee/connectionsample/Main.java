package org.creativebee.connectionsample;

import org.creativebee.connectionsample.connection.dummy.DummyConnecter;
import org.creativebee.connectionsample.connection.pool.ConnectionFactory;

public class Main {
	public static void main(String[] args) {

		Runnable runner = new Runnable() {

			@Override
			public void run() {
				ConnectionFactory factory = new ConnectionFactory();
				DummyConnecter con = null;
				try {

					// インスタンスの取得
					con = factory.getPooledInstance();

					// 実行
					con.send("test");

				} finally {

					con.close();
				}
			}
		};

		// 複数スレッドの準備
		Thread th1 = new Thread(runner);
		Thread th2 = new Thread(runner);
		Thread th3 = new Thread(runner);
		Thread th4 = new Thread(runner);
		Thread th5 = new Thread(runner);
		Thread th6 = new Thread(runner);
		Thread th7 = new Thread(runner);
		Thread th8 = new Thread(runner);

		// 実行
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
		th7.start();
		th8.start();

	}
}
