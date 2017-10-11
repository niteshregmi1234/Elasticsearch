#!/usr/bin/python2.7

import sys
import elasticsearch

uniqueIdsList=[]
firstNamesList=[]
lastNamesList=[]
res=[]
def main():
    print("* Choose Any One *")
    print("1. Search Through Unique Id")
    print("2. Search Through First Name")
    print("3. Search Through Last Name")
    print("4. Exit")
    choice = raw_input("Your Choice: ")

    if choice=='1':
        uniqueIdSearch()
        connect_es()
        printRes()
    if choice=='2':
        firstNameSearch()
        connect_es()
        printRes()
        print 2
    if choice=="3":
        lastNameSearch()
        connect_es()
        printRes()
        print 3
    if choice=='4':
        sys.exit()

def uniqueIdSearch():
    uniqueIds=raw_input("Enter unique id's: ")
    global uniqueIdsList
    uniqueIdsList=uniqueIds.split(",")

def firstNameSearch():
    firstNames=raw_input("Enter first names's")
    global firstNamesList
    firstNamesList=firstNames.split(",")

def lastNameSearch():
    lastNames=raw_input("Enter last names's")
    global lastNamesList
    firstNamesList=lastNames.split(",")

def connect_es():
    esSourceIndex = elasticsearch.Elasticsearch('localhost:9200')
    global res
    for uid in uniqueIdsList:
        result=esSourceIndex.search(index='user',q='uniqueId:'+'\"'+uid+'\"',doc_type='UserMapping',fields='firstName,lastName,dob,location,age',size=100,request_timeout=60)
        res.append(result["hits"]["hits"][0]["fields"])
    print res

def printRes():
    print("*********************************************************")
    print 'First Name       Last Name       Dob                  Location                      Age'
    print("")
    for r in res:
        print r["firstName"][0]+"          ",r["lastName"][0]+"          ",r["dob"][0]+"          ",r["location"][0]+"             ",r["age"][0]

if __name__ == "__main__": main()