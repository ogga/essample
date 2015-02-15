package jp.atlas.elasticsearch.sample;

import java.util.List;

/**
 * Elasticsearchへのデータ投入API 
 *
 */
public interface ElasticsearchWriter {
	/**
	 * データを登録
	 * @param items
	 * @return
	 * @throws Exception
	 */
	public int write(List<Restaurant> items) throws Exception ;
	/**
	 * Elasticsearchへ接続
	 */
	public void connect();
	/**
	 * 接続をクローズ
	 */
	public void close();
	/**
	 * Elasticsearchへの接続、書き込み、クローズ
	 * @param items
	 * @return
	 * @throws Exception
	 */
	public int writeWithClose(List<Restaurant> items) throws Exception;	
}
