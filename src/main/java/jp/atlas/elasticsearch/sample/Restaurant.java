package jp.atlas.elasticsearch.sample;

public class Restaurant {

	public int id;
	public String name;
	public String property;
	public String alphabet;
	public String name_kana;
	public int pref_id;
	public int area_id;
	
	public int station_id1;
	public int station_time1;
	public int station_distance1;

	public int station_id2;
	public int station_time2;
	public int station_distance2;

	public int station_id3;
	public int station_time3;
	public int station_distance3;

	public int category_id1;
	public int category_id2;
	public int category_id3;
	public int category_id4;
	public int category_id5;

	public String zip;
	
	public String address;
	public String north_latitude;
	public String east_longitude;
	public String description;
	public String purpose;
	public int open_morning;
	public int open_lunch;
	public int open_late;
	public int photo_count;
	public int special_count;
	public int menu_count;
	public int fan_count;
	public int access_count;
	public String created_on;
	public String modified_on;
	public int closed;
	
	
	/**
	 * 
	 * @param item
	 */
	public Restaurant (String[] item) {
		id = StringUtils.parse(item[0],0);
		name = item[1];
		property = item[2];
		alphabet = item[3];
		name_kana = item[4];
		pref_id = StringUtils.parse(item[5],0);
		area_id = StringUtils.parse(item[6],0);
		station_id1 = StringUtils.parse(item[7],0);
		station_time1 = StringUtils.parse(item[8],0);
		station_distance1 = StringUtils.parse(item[9],0);
		station_id2 = StringUtils.parse(item[10],0);
		station_time2 = StringUtils.parse(item[11],0);
		station_distance2 = StringUtils.parse(item[12],0);
		station_id3 = StringUtils.parse(item[13],0);
		station_time3 = StringUtils.parse(item[14],0);
		station_distance3 = StringUtils.parse(item[15],0);
		category_id1 = StringUtils.parse(item[16],0);
		category_id2 = StringUtils.parse(item[17],0);
		category_id3 = StringUtils.parse(item[18],0);
		category_id4 = StringUtils.parse(item[19],0);
		category_id5 = StringUtils.parse(item[20],0);
		zip = item[21];
		address = item[22];
		north_latitude = item[23];
		east_longitude = item[24];
		description = item[25];
		purpose = item[26];
		open_morning = StringUtils.parse(item[27],0);
		open_lunch = StringUtils.parse(item[28],0);
		open_late = StringUtils.parse(item[29],0);
		photo_count = StringUtils.parse(item[30],0);
		special_count = StringUtils.parse(item[31],0);
		menu_count = StringUtils.parse(item[32],0);
		fan_count = StringUtils.parse(item[33],0);
		access_count = StringUtils.parse(item[34],0);
		created_on = item[35];
		modified_on = item[36];
		closed = StringUtils.parse(item[37],0);
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", property="
				+ property + ", alphabet=" + alphabet + ", name_kana="
				+ name_kana + ", pref_id=" + pref_id + ", area_id=" + area_id
				+ ", station_id1=" + station_id1 + ", station_time1="
				+ station_time1 + ", station_distance1=" + station_distance1
				+ ", station_id2=" + station_id2 + ", station_time2="
				+ station_time2 + ", station_distance2=" + station_distance2
				+ ", station_id3=" + station_id3 + ", station_time3="
				+ station_time3 + ", station_distance3=" + station_distance3
				+ ", category_id1=" + category_id1 + ", category_id2="
				+ category_id2 + ", category_id3=" + category_id3
				+ ", category_id4=" + category_id4 + ", category_id5="
				+ category_id5 + ", zip=" + zip + ", address=" + address
				+ ", north_latitude=" + north_latitude + ", east_longitude="
				+ east_longitude + ", description=" + description
				+ ", purpose=" + purpose + ", open_morning=" + open_morning
				+ ", open_lunch=" + open_lunch + ", open_late=" + open_late
				+ ", photo_count=" + photo_count + ", special_count="
				+ special_count + ", menu_count=" + menu_count + ", fan_count="
				+ fan_count + ", access_count=" + access_count
				+ ", created_on=" + created_on + ", modified_on=" + modified_on
				+ ", closed=" + closed + "]";
	}
}
