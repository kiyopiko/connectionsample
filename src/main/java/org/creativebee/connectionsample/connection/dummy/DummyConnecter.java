package org.creativebee.connectionsample.connection.dummy;

import java.io.Closeable;

/**
 * 本コネクタを利用して、業務開発者は接続処理を行う。<br>
 * このクラスはアダプタパターン的に実装をしてください。
 *
 * @author kiyoyuki
 *
 */
public class DummyConnecter implements Closeable {

	/**
	 * 利用中フラグ
	 */
	protected boolean inUse = false;

	/**
	 * 実際の接続インスタンス
	 */
	protected Object obj;

	/**
	 * コンストラクタ
	 */
	public DummyConnecter() {

		inUse = false;
		obj = "インスタンスだよ";
	}

	/**
	 * 利用状態を取得
	 *
	 * @return
	 */
	public boolean isInUse() {
		return inUse;
	}

	/**
	 * 利用する。
	 *
	 * @return
	 */
	public DummyConnecter use() {

		// 利用中フラグを利用中にする
		inUse = true;

		// 自分を返却
		return this;
	}

	/**
	 * 送信する
	 */
	public void send(String parameter) {

		StringBuffer sb = new StringBuffer();
		sb.append(obj.toString());
		sb.append(":");
		sb.append(parameter);
		sb.append(":");
		sb.append(this);

		// 実際の送信処理を書く
		System.out.println(sb.toString());

	}

	/**
	 * インスタンスを閉じる
	 */
	@Override
	public void close() {

		this.inUse = false;
	}
}
