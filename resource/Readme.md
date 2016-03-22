# ldgourmetという名前のindexをmapping.jsonに書かれた内容に従って作成

curl -XPOST 192.168.33.10:9200/ldgourmet -d @mapping.json