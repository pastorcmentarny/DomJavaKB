"""
Examples of various methods and modules when dealing with file.
"""
import os
import pprint
import shelve
import shutil
import zipfile
from datetime import datetime
from pathlib import Path

import send2trash

TEST_PATH = r'B:/test/python'
if os.path.exists(TEST_PATH):
    shutil.rmtree(TEST_PATH)
else:
    os.makedirs(TEST_PATH)

configFile = shelve.open('programData')
print(type(configFile))
cats = ['Zophie', 'Pooka', 'Simon']
configFile['cats'] = cats
print(list(configFile.keys()))
print(list(configFile.values()))
print(configFile['cats'])
configFile.close()

dogs = [
    {'name': 'Puszek', 'age': 13},
    {'name': 'Reksio', 'age': 9}
]

print('Normal print')
print(dogs)
print('Pretty print')
pprint.pprint(dogs)

dogFile = open('dogFile.py', 'w')
print(type(dogFile))

dogFile.write('cats = ' + pprint.pformat(dogs) + '\n')
dogFile.close()

path = os.path.join('ds', 'dsHQ')
print(path)

hq = 'B:\\jdk\\'

files = ['itHQ.html', 'daily.html', 'index.html']
for file in files:
    print(os.path.join(hq, file))

print(os.getcwd())  # cwd stands for current working directory
os.chdir(hq)
print(os.getcwd())

dirPath = r'B:\test\python\examples\chapter8'

'''
# os.remove(dirPath)
os.makedirs(dirPath)
os.chdir(dirPath)
print(os.getcwd())
'''

print(os.path.abspath(dirPath))
print(os.path.isabs(dirPath))
print(os.path.isabs('.'))
print(os.path.isabs(os.path.abspath('.')))

print(os.path.relpath(r'C:\Windows', 'C:\\'))

path = r'C:\Windows\System32\calc.exe'
print(os.path.basename(path))
print(os.path.dirname(path))
print(os.path.split(path))
print(path.split(os.path.sep))
print(str(os.path.getsize(path)))

dsPath = r'B:\jdk'
print(dsPath)
print(os.listdir(dsPath))
totalSize = 0
for file in os.listdir(dsPath):
    fileSize = os.path.getsize(os.path.join(dsPath, file))
    print('file: ' + file + ' ' + str(fileSize))
    totalSize = totalSize + fileSize
print(str(totalSize))

doNotExistPath = r'C:\i\am\not\here'
filePath = r'C:\ds\DomLauncher.bat'
dirPath = r'C:\ds'

print('Is non existing path exist :) ' + str(os.path.exists(doNotExistPath)))
print('Is existing path exist :) ' + str(os.path.exists(filePath)))
print('Is file a dir? :) ' + str(os.path.isdir(filePath)))
print('Is dir :) ' + str(os.path.isdir(dirPath)))
print('Is file? :) ' + str(os.path.isfile(filePath)))
print('Is dir a file :) ' + str(os.path.isfile(dirPath)))

filePath = r'B:\test\file.txt'
file = None
if os.path.exists(filePath):
    file = open(filePath, encoding='UTF-8')
else:
    print("ERROR\n\n\tpath is crap\n\n\tprogram will crash\n\n\t\t:)\n\n")

content = file.read()

print(content)

file = open(filePath, "r")
content = file.readlines()
print('text with line counter')
count = 1
for line in content:
    print(str(count) + ': ' + line)
    count += 1

file = open(filePath, 'w')
file.write('Beacon , I love beacon')
file.close()

file = open(filePath, 'a')
result = file.write('nothing to note at the moment\nI am hungry\nI wish to smile\nI just need change 5000 nappies')
print('The number of characters written, including the newline' + str(result))
file.close()

data = 'programData'
shelveFile = shelve.open(data)
cats = ['Zophie', 'Pooka', 'Simon']
shelfKey = 'cats'
shelveFile[shelfKey] = cats
shelveFile.close()

readFromShelve = shelve.open(data)
print(str(type(readFromShelve)))
print(str(readFromShelve[shelfKey]))

cats = [{
    'name': 'Zophie',
    'desc': 'chubby'
}, {
    'name': 'Pooka',
    'desc': 'fluffy'
}]

print(pprint.pformat(cats))
fileObj = open(r'B:\test\file.txt', 'w')
fileObj.write('cats = ' + pprint.pformat(cats) + '\n')
fileObj.close()

os.chdir('B:\\')
baseDir = 'B:\\test\\python\\'
destination = baseDir + "destination"
treeDir = baseDir + 'tree\\'

copied_file = "\\copied.x"

if os.path.exists(destination):
    shutil.rmtree(destination)
    shutil.rmtree(treeDir)

os.makedirs(destination)
copied_file = destination + copied_file
ufo_txt = '\\ufo.txt'
ufoFile = open(baseDir + ufo_txt, 'w')
ufoFile.write("dfdjioagdf")
ufoFile.close()
path = shutil.copy(baseDir + ufo_txt, copied_file)
print(path)

result = shutil.move(copied_file, baseDir)
print(result)

result = shutil.move(baseDir + "\\" + ufo_txt, destination + "\\ufo.xx")
print(result)

baseDir = 'C:\\tmp\\python\\'
treeDir = baseDir + 'tree\\'

if os.path.exists(treeDir):
    shutil.rmtree(treeDir)

os.makedirs(treeDir)

foodDir = treeDir + 'food\\'
polishDir = foodDir + "polish\\"
chineseDir = foodDir + "chinese\\"
os.makedirs(foodDir)
os.makedirs(polishDir)
os.makedirs(chineseDir)

sichuanPath = chineseDir + 'sichuan.txt'
sichuanFile = open(sichuanPath, 'w')
sichuanFile.write('sichuan cai shi hao chi')
sichuanFile.close()

alienDir = treeDir + 'alien\\'
os.makedirs(alienDir)

for folder_name, subfolders, filenames in os.walk(treeDir):
    print('Current folder is: ' + folder_name)

    for subfolder in subfolders:
        print('subfolder: ' + subfolder + ' in folder' + folder_name)

    for filename in filenames:
        print('file' + filename + ' in folder' + folder_name)

treeZip = zipfile.ZipFile(baseDir + 'tree.zip', 'w')
treeZip.write(treeDir, compress_type=zipfile.ZIP_DEFLATED)
treeZip.write(foodDir, compress_type=zipfile.ZIP_DEFLATED)
treeZip.write(chineseDir, compress_type=zipfile.ZIP_DEFLATED)
treeZip.write(sichuanPath, compress_type=zipfile.ZIP_DEFLATED)
treeZip.write(alienDir, compress_type=zipfile.ZIP_DEFLATED)
treeZip.close()

treeZip = zipfile.ZipFile(baseDir + 'tree.zip')
treeZip.extractall(baseDir + 'unzipped\\')
print(result)

os.chdir('B:\\')

trains = ['pendolino', 'shinkansen', 'ave']

path = TEST_PATH + r'\dogFile.txt'
dogFile = open(path, 'w')
print(type(dogFile))

dogFile.write('cats = ' + pprint.pformat(trains) + '\n')
dogFile.close()

destinationFolder = TEST_PATH + r'\dest'

if not os.path.exists(destinationFolder):
    os.makedirs(destinationFolder)

result = shutil.copy(path, destinationFolder)
print(result)
result = shutil.copy(path, destinationFolder + r'\copied.txt')
print(result)
result = shutil.copytree(destinationFolder, destinationFolder + r'\backup')
print(result)

destinationFolder = TEST_PATH + r'\dest2'

if not os.path.exists(destinationFolder):
    os.makedirs(destinationFolder)

result = shutil.move(path, destinationFolder)
print(result)

path = destinationFolder + "/dogFile.txt"
os.unlink(path)

#  os.rmdir(path) will delete the folder at path. This folder must be empty of any files or folders.
os.rmdir(destinationFolder)

# shutil.rmtree(path) will remove the folder at path, and all files and folders it contains will also be deleted.
shutil.rmtree(r'B:\test\python')

path = 'hotpot.txt'
file = open(path, 'a')
file.write('Spicy HotPot is delicious.')
file.close()

send2trash.send2trash(path)

# os.walk()

baseFolder = r'B:\test\python'

if os.path.exists(baseFolder):
    os.remove(baseFolder)

os.makedirs(baseFolder)
catsFolder = baseFolder + '/cats'
os.makedirs(catsFolder)
waffles_folder = baseFolder + '/walnut/waffles'
os.makedirs(waffles_folder)

path = catsFolder + '/catnames.txt'
file = open(path, 'a')
file.write('Spicy HotPot is delicious.')
file.close()

path = catsFolder + '/zophie.jpg'
file = open(path, 'a')
file.write('Spicy HotPot is delicious.')
file.close()

path = waffles_folder + "/butter.txt"
file = open(path, 'a')
file.write('Spicy HotPot is delicious.')
file.close()

baseFolder = r'D:\temp\python'

for folderName, subFolders, filenames in os.walk(baseFolder):
    print('The current folder is ' + folderName)

    for subFolder in subFolders:
        print('SUBFOLDER OF ' + folderName + ': ' + subFolder)
    for filename in filenames:
        print('FILE INSIDE ' + folderName + ': ' + filename)

    print('')

# ZIP FILE
xFile = zipfile.ZipFile('new.zip', 'w')
tempFile = open('dragons.txt', 'w')
tempFile.write("I can fly and burn you with fire")
tempFile.close()
xFile.write('dragons.txt', compress_type=zipfile.ZIP_DEFLATED)
xFile.close()
xFile = zipfile.ZipFile('new.zip')
print(xFile.filename)
print(xFile.namelist())
xInfo = xFile.getinfo('dragons.txt')
print(xInfo.file_size)
print(xInfo.compress_size)
xFile.extractall(r'D:\temp\unzipped')
xFile.close()

baseDir = 'B:\\test\\python\\'
backupDir = baseDir + 'backup\\'

if os.path.exists(backupDir):
    shutil.rmtree(backupDir)

os.makedirs(backupDir)
fileOne = open(backupDir + "one.txt", 'w')
fileOne.write('This is first file')
fileOne.close()

fileTwo = open(backupDir + 'two.txt', 'w')
fileTwo.write('this is second file')
fileTwo.close()

folderOne = backupDir + 'folder\\'
os.makedirs(folderOne)

fileThree = open(folderOne + 'third.txt', 'w')
fileThree.write('this is third file')
fileThree.close()

"""
#EXAMPLE USING ZIP
def backupToZip(folder):
    folder = os.path.abspath(folder)

    # generate next number for backup
    number = 1
    while True:
        zipFilename = os.path.basename(folder) + '_' + str(number) + '.zip'
        if not os.path.exists(zipFilename):
            break
        number = number + 1

    print('Creating %s...' % (zipFilename))
    backupZip = zipfile.ZipFile(zipFilename, 'w')

    for foldername, subfolders, filenames in os.walk(folder):
        print('Adding files in %s ...' % (foldername))
        backupZip.write(foldername)

        for filename in filenames:
            newBase = os.path.basename(folder) + "_"
            if filename.startsWith(newBase) and filename.endsWith('.zip'):
                continue
            backupZip.write(os.path.join(foldername, filename))
    backupZip.close()
    print('Mission complete')


# backupToZip(backupDir) #FIXME

# EXAMPLE OF USING PATH
p = Path.home()
shutil.copy(p / 'spam.txt', p / 'some_folder')
# 'C:\\Users\\Al\\some_folder\\spam.txt'
shutil.copy(p / 'eggs.txt', p / 'some_folder/eggs2.txt')
WindowsPath('C:/Users/Al/some_folder/eggs2.txt')

p = Path.home()
shutil.copytree(p / 'spam', p / 'spam_backup')
WindowsPath('C:/Users/Al/spam_backup')

shutil.move('C:\\bacon.txt', 'C:\\eggs')
# 'C:\\eggs\\bacon.txt'

shutil.move('C:\\bacon.txt', 'C:\\eggs\\new_bacon.txt')
# 'C:\\eggs\\new_bacon.txt'

shutil.move('C:\\bacon.txt', 'C:\\eggs')
# 'C:\\eggs'

shutil.move('spam.txt', 'c:\\does_not_exist\\eggs\\ham')
# Traceback (most recent call last):
# FileNotFoundError: [Errno 2] No such file or directory: 'c:\\does_not_exist\\


for filename in Path.home().glob('*.rxt'):
    os.unlink(filename)

for filename in Path.home().glob('*.rxt'):
    # os.unlink(filename)
    print(filename)

baconFile = open('bacon.txt', 'a')  # creates the file
baconFile.write('Bacon is not a vegetable.')
baconFile.close()
send2trash.send2trash('bacon.txt')

for folderName, subfolders, filenames in os.walk('C:\\delicious'):
    print('The current folder is ' + folderName)

    for subfolder in subfolders:
        print('SUBFOLDER OF ' + folderName + ': ' + subfolder)

    for filename in filenames:
        print('FILE INSIDE ' + folderName + ': ' + filename)

    print('')

"""

data_folder = Path("B:/test")

file_to_open = data_folder / "file.txt"

f = open(file_to_open)

print(f.read())

filename = Path("B:/test/file.txt")

print(filename.name)
print(filename.suffix)
print(filename.stem)

if not filename.exists():
    print("Oops, file doesn't exist!")
else:
    print("Yay, the file exists!")

# create random empty file example
dt = datetime.now()
random_data_file = Path(f"B:/test/" + str(dt) + ".txt")

open(random_data_file, 'a').close()

print('WELL DONE!')
