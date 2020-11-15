import csv
import datetime
import json
import os

# create a new file
# add these lines:
foodList = """
4/5/2015 13:34,Apples,73\n
4/5/2015 3:41,Cherries,85\n
4/6/2015 12:46,Pears,14\n
4/8/2015 8:59,Oranges,52\n
4/10/2015 2:07,Apples,152\n
4/10/2015 18:10,Bananas,23\n
4/10/2015 2:40,Strawberries,98\n
"""
# save file

WRITABLE = 'w'

baseDir = os.getcwd() + "\\"
shoppingListFileName = "shopping.csv"

shopping_list_file_path = baseDir + shoppingListFileName

if os._exists(shopping_list_file_path):  # check for _exists
    os.remove(shopping_list_file_path)

shoppingListFile = open(shopping_list_file_path, WRITABLE)
shoppingListFile.write(foodList)
shoppingListFile.close()

csvFile = open(shopping_list_file_path)
csvFileContent = csv.reader(csvFile)
csvData = list(csvFileContent)
print(csvData)

print(csvData[1][0])
print(csvData[1][1])
print(csvData[1][2])

csvFile = open(shopping_list_file_path)
csvFileContent = csv.reader(csvFile)
print(str(type(csvFileContent)))

exampleFile = open(baseDir + 'example.csv', 'w+')
csv_reader = csv.reader(exampleFile)
for row in csv_reader:
    print(str(csv_reader.line_num) + '. > ' + str(row))

print('My list')
for row in csvFileContent:
    print(str(csvFileContent.line_num) + '. > ' + str(row))

now = datetime.datetime.now()

'''
On Windows, 
you’ll also need to pass a blank string for the open() function’s newline keyword argument.
 For technical reasons beyond the scope of  this book, 
 if you forget to set the newline='' argument,
  the rows in file will be double-spaced,
'''

exampleFile = open(baseDir + 'normal' + str(now.microsecond) + '.csv', WRITABLE, newline='')
csvWriter = csv.writer(exampleFile)
csvWriter.writerow(['garlic', 'cheesecake', 'kebab', 'milk'])
csvWriter.writerow(['ufo', 'train', '280'])
csvWriter.writerow([3, 4, 3, 6, 7, 7])
exampleFile.close()

crazyExampleFile = open(baseDir + 'crazyNewLinesAndDelimiter' + str(now.microsecond) + '.csv', WRITABLE, newline='')
csvWriter2 = csv.writer(crazyExampleFile, delimiter='\t', lineterminator='\n\n')
csvWriter2.writerow(['garlic', 'cheesecake', 'kebab', 'milk'])
csvWriter2.writerow(['ufo', 'train', '280'])
csvWriter2.writerow([3, 4, 3, 6, 7, 7])
crazyExampleFile.close()
print('goodbye!')

jsonDataAsString = '{"name":"Zophie", "isCat" : true, "miceCaught": 0, "felineIQ": null} '
jsonDataAsPython = json.loads(jsonDataAsString)
print(jsonDataAsPython)

"""
 json.dumps() function (which means “dump string,” not “dumps”)
 
 Recall that sys.argv will always have at least one element, sys.argv[0], which contains the Python script’s filename.
"""


1

import pandas as pd

2

import csv

3

Finded_URL = ['Finded_URL_1.csv', 'Finded_URL_501.csv','Finded_URL_1001.csv','Finded_URL_1501.csv','Finded_URL_2001.csv',

              4

              'Finded_URL_2501.csv','Finded_URL_3001.csv','Finded_URL_3501.csv','Finded_URL_4001.csv','Finded_URL_4501.csv',

              5

              'Finded_URL_5001.csv','Finded_URL_5501.csv','Finded_URL_6001.csv','Finded_URL_6501.csv','Finded_URL_7001.csv']

6

7

#combine all files in the list

8

combined_csv = pd.concat([pd.read_csv(f,header=None) for f in Finded_URL])

9

10

combined_csv.head()

11

12

combined_csv.to_csv( "Finded_URL_All.csv", quotechar='"',

                     13

quoting=csv.QUOTE_ALL, index=False, encoding='utf-8')

