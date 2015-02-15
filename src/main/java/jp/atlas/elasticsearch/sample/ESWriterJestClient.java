package jp.atlas.elasticsearch.sample;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.Bulk.Builder;

import java.util.List;

/**
 * ElasticsearchのClient APIは、TCP経由での接続なので、Vagrant環境へ接続する場合など、
 * 通常のElasticsearch APIで接続できない場合に使用します。
 * https://www.found.no/foundation/java-clients-for-elasticsearch/
 */
public class ESWriterJestClient implements ElasticsearchWriter {
	
	private JestClient _client;
	private final String _host;
	private final int _port;
	//インデックス
	private final String _index;
	//タイプ
	private final String _type;
	/**
	 * 
	 * @param host ホストのIP
	 * @param port 接続ポート
	 * @param index　インデックス
	 * @param type　タイプ
	 */
	public ESWriterJestClient(String host, int port,  String index, String type) {
		_host = host;
		_port = port;
		_index = index;
		_type = type;
	}
	/* (non-Javadoc)
	 * @see jp.atlas.elasticsearch.sample.ElasticsearchWriter#writeWithClose(java.util.List)
	 */
	public int writeWithClose(List<Restaurant> items) throws Exception {
		connect();
		int count = write(items);
		close();
		return count;
	}
	
	/* (non-Javadoc)
	 * @see jp.atlas.elasticsearch.sample.ElasticsearchWriter#connect()
	 */
	public void connect() {
		JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("http://" + _host+ ":" + _port)
                .multiThreaded(true)
                .build());
        _client = factory.getObject();		
	}

	/* (non-Javadoc)
	 * @see jp.atlas.elasticsearch.sample.ElasticsearchWriter#close()
	 */
	public void close() {
		_client.shutdownClient();
		_client = null;
	}

	/* (non-Javadoc)
	 * @see jp.atlas.elasticsearch.sample.ElasticsearchWriter#write(java.util.List)
	 */
	public int write(List<Restaurant> items) throws Exception {
		Builder bulkIndexBuilder = new Bulk.Builder();
        
		for (Restaurant item : items) {
		    bulkIndexBuilder.addAction(new io.searchbox.core.Index.Builder(item).index(_index).type(_type).build());
	        
			System.out.println("["+ item.id +"]----" + item.toString());
		}
		_client.execute(bulkIndexBuilder.build());
		return items.size();
	}
}
