#!/bin/bash

curl -XPUT ${1}:9200/_template/dw_template -d '{
  "template": "*",
  "order": 0,
  "settings": {
    "number_of_shards": '${2}',
     "index.mapping.nested_fields.limit": 1002,
    "index": {
      "analysis": {
        "analyzer": {
          "containsAnalyzer": {
            "type": "custom",
            "tokenizer": "standard",
            "filter": "standard,lowercase,containsFilter"
          },
          "standardAnalyzer": {
            "type": "custom",
            "tokenizer": "standard",
            "filter": "standard,lowercase"
          },
          "sortable": {
            "type": "custom",
            "tokenizer": "keyword",
            "filter": "lowercase"
          },
          "customAnalyzer" : {
            "type" : "custom",
            "tokenizer" : "whitespace",
            "filter" : ["standard","lowercase", "customFilter","containsFilter"]
          },
          "searchAnalyzer":{
            "type" : "custom",
            "tokenizer" : "keyword",
            "filter" : ["lowercase", "containsFilter"]
        }
        },
        "filter": {
          "containsFilter": {
            "type": "nGram",
            "min_gram": 1,
            "max_gram": 50
          },
          "customFilter" : {
            "type" : "word_delimiter",
            "preserve_original": true
          }
        }
      }
    }
  },
  "mappings":{
      "_default_": {
          "dynamic" : false,
          "_all":{
              "enabled": false
          }
      }
  }
}'