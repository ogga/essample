package jp.atlas.elasticsearch.sample;

import java.util.List;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ESWriterClient implements ElasticsearchWriter {
	
	private Client _client;
	private TransportClient _transport;
	
	private final String _host;
	private final int _port;
	private final String _index;
	private final String _type;
	
	public ESWriterClient(String host, int port,  String index, String type) {
		_host = host;
		_port = port;
		_index = index;
		_type = type;
	}
	
	public int writeWithClose(List<Restaurant> items) throws Exception {
		connect();
		int count = write(items);
		close();
		return count;
	}
	
	public int write(List<Restaurant> items) throws Exception {
		BulkRequestBuilder bulkRequest = _client.prepareBulk();
		
		for (Restaurant item : items) {
			ObjectMapper mapper = new ObjectMapper();
			String json = null;
			
			try {
				json = mapper.writeValueAsString(item);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			bulkRequest.add(_client.prepareIndex(_index, _type, item.id+"").setSource(json));
		}
		BulkResponse bulkResponse = bulkRequest.execute().actionGet();
		if (bulkResponse.hasFailures()) {
			throw new Exception(bulkResponse.buildFailureMessage());
		}		
		return items.size();
	}
	
	public void connect(){
		_transport = new TransportClient();
		_client = _transport.addTransportAddresses(new InetSocketTransportAddress(_host, _port));		
	}

	/* (non-Javadoc)
	 * @see jp.atlas.elasticsearch.sample.ElasticsearchWriter#close()
	 */
	public void close() {
		_client.close();
		_client = null;
	}
}
