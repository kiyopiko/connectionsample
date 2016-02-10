package org.creativebee.connectionsample.connection.pool;

import java.util.ArrayList;
import java.util.List;

import org.creativebee.connectionsample.connection.dummy.DummyConnecter;

/**
 * 接続プール
 *
 * @author kiyoyuki
 *
 */
public class ConnectionFactory {

	/**
	 * プールされたインスタンスのリスト
	 */
	protected static List<DummyConnecter> _pooledInstances;

	/**
	 * スタティックイニシャライザ。<br>
	 * サーバの初期化処理などが利用できない場合、クラスローダで本クラスの読み込み時にプールを初期化する。<br>
	 * 初期化処理のインスタンスメソッドが作成可能で、本処理が不要な場合はコードを削除する。<br>
	 */
	static {

		// スレッドセーフなマップのインスタンス化
		_pooledInstances = init();
	}

	/**
	 * プールの作成
	 *
	 * @return
	 */
	protected static synchronized List<DummyConnecter> init() {

		// スレッドセーフなマップのインスタンス化
		List<DummyConnecter> pooledInstances = java.util.Collections.synchronizedList(new ArrayList<DummyConnecter>());

		// プールを初期化
		for (int i = 0; i < 10; i++) {

			// 新規インスタンスを作成
			DummyConnecter con = new DummyConnecter();

			// プールに追加
			pooledInstances.add(con);
		}

		return pooledInstances;
	}

	/**
	 * 接続インスタンスの取得
	 *
	 * @param parameter
	 * @return
	 */
	public DummyConnecter getPooledInstance() {

		DummyConnecter ret = null;
		synchronized (_pooledInstances) {

			// 全インスタンス利用中フラグ
			boolean allInstanceUsing = true;

			// プールされたインスタンス分繰り返す
			for (DummyConnecter connecter : _pooledInstances) {

				// プール済みインスタンスが利用中でない場合
				if (!connecter.isInUse()) {

					// インスタンスの取得
					ret = connecter.use();
				}
			}

			// すべてのインスタンスが利用中の場合
			if (allInstanceUsing) {

				// 新規インスタンスを作成
				DummyConnecter con = new DummyConnecter();

				// プールに追加
				_pooledInstances.add(con);
				ret = con;
			}
		}

		return ret;
	}
}
