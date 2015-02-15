package jp.atlas.elasticsearch.sample;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * livedoor グルメのデータセットのrestaurants.csvファイルをElasticsearchの
 * livedoor グルメのデータセットは
 * https://github.com/livedoor/datasets からldgourmet.tar.gzをダウンロードして使用してください。
 */
public class ElasticsearchWriteSample {
	/**
	 * インポート用のファイルをフルパス指定
	 */
	private static final String DATA_FILE_NAME = "/Users/naoyuki/Documents/workspace/ElasticsearchSample/data/restaurants.csv";
	
	//保存先のインデックス
	private static final String ES_HOST = "192.168.33.10";
	//保存先のタイプ
	private static final int ES_PORT = 9200;
	//保存先のインデックス
	private static final String ES_INDEX = "ldgourmet";
	//保存先のタイプ
	private static final String ES_TYPE = "restaurant";
		
	public static void main(String[] args) {
		ElasticsearchWriter writer = new ESWriterJestClient(ES_HOST, ES_PORT, ES_INDEX, ES_TYPE);
		CSVReader reader = null;
		 try {
	    	reader = new CSVReader(new FileReader(DATA_FILE_NAME), ',');
			List<Restaurant> list = new ArrayList<Restaurant>();
	        String [] line;
			int lineNumber = 0;
			while ((line = reader.readNext()) != null) {
			    if (lineNumber != 0){//1行目は除外
	        		list.add(new Restaurant(line));
	        	}
	        	lineNumber++;
	        	if(lineNumber % 100 == 0){//100件ずつ登録
	        		writer.writeWithClose(list);
	        		list.clear();
	        	}
	        }
	        if (!list.isEmpty()) {
	        	writer.writeWithClose(list);
	        }
	    } catch (Exception e) {
	    	//例外あればトレースで確認
	        e.printStackTrace();
	    } finally {
	        try {
	        	reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
        System.out.println( "完了" );
    }
}
