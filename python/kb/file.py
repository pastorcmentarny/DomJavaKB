# Chapter 8
import os
import pprint
import shelve

import myCats  # can be found in main folder
import send2trash

# shutil - shutil is a shell utilities
# There are also the dot (.) and dot-dot (..) folders.
# These are not real folders but special names that can be used in a path.
#  A single period (“dot”) for a folder name is shorthand for “this directory.”
#  Two periods (“dot-dot”) means “the parent folder.”
# os.path.abspath(path)will return a string of the absolute path of the argument.
# os.path.isabs(path) will return True if the argument is an absolute path and False if it is a relative path.
# os.path.relpath(path, start) will return a string of a relative path from the start path to path.
# If start is not provided, the current working directory is used as the start path.
# os.path.dirname(path) will return a string of everything that comes before the last slash in the path argument.
# os.path.basename(path) will return a string of everything that comes after the last slash in the path argument.
# If you need a path’s dir name and base name together,
# you can just call os.path.split() to get a tuple value with these two strings
# os.path.getsize(path) will return the size in bytes of the file in the path argument.
#  os.path.exists(path) will return True if the file or folder referred to in the argument exists
# os.path.isfile(path) will return True if the path argument exists and is a file
# os.path.isdir(path) will return True if the path argument exists and is a folder
#  Shelf values don’t have to be opened in read or write mode—they can do both once opened.
# just like dictionaries,
# shelf values have keys() and values() methods that will return list-like values of the keys and values in the shelf.
# The modules that an import statement imports are themselves just Python scripts.
# When the string from pprint.pformat() is saved to a .py file,
# the file is a module that can be imported just like any other.
# For most applications, however, saving data using the shelve module is the preferred way to save variables to a file.

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

hq = 'C:\\ds\\dsHQ\\'

files = ['itHQ.html', 'daily.html', 'index.html']
for file in files:
    print(os.path.join(hq, file))

print(os.getcwd())  # cwd stands for current working directory
os.chdir(hq)
print(os.getcwd())

# An absolute path, which always begins with the root folder
# A relative path, which is relative to the program’s current working directory
# A single period (“dot”) for a folder name is shorthand for “this directory.”
# Two periods (“dot-dot”) means “the parent folder.”

dirPath = r'C:\tmp\python\examples\chapter8'

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

# C:\Windiws\System32\calc.exe
# < DIR NAME         ><Base Name>

path = r'C:\Windows\System32\calc.exe'
print(os.path.basename(path))
print(os.path.dirname(path))
print(os.path.split(path))
print(path.split(os.path.sep))
print(str(os.path.getsize(path)))

dsPath = r'C:\ds'
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

# Plaintext files contain only basic text characters and do not include font, size, or color information.
# Text files with the .txt extension
# or Python script files with the .py extension are examples of plaintext files.

# There are three steps to reading or writing files in Python.
# Call the open() function to return a File object.
# Call the read() or write() method on the File object.
# Close the file by calling the close() method on the File object.

filePath = r'C:\ds\notes\note.txt'
file = None
if os.path.exists(filePath):
    file = open(filePath)
else:
    print("ERROR\n\n\tpath is crap\n\n\tprogram will crash\n\n\t\t:)\n\n")

content = file.read()

print(content)

file = open(filePath, 'r')
content = file.readlines()
print('text with line counter')
count = 1
for line in content:
    print(str(count) + ': ' + line)
    count += 1

# Pass 'w' as the second argument to open() to open the file in write mode.
# Pass 'a' as the second argument to open() to open the file in append mode.
# Pass 'r' as the second argument to open() to open the file in read mode.

file = open(filePath, 'w')
file.write('Beacon , I love beacon')
file.close()

file = open(filePath, 'a')
result = file.write('nothing to note at the moment\nI am hungry\nI wish to smile\nI just need change 5000 nappies')
print('The number of characters written, including the newline' + str(result))
file.close()

# You can save variables in your Python programs to binary shelf files using the shelve module.
# Plaintext is useful for creating files that you’ll read in a text editor such as Notepad or TextEdit,
# but if you want to save data from your Python programs, use the shelve module.

data = 'programData'
shelveFile = shelve.open(data)
cats = ['Zophie', 'Pooka', 'Simon']
shelfKey = 'cats'
shelveFile[shelfKey] = cats
shelveFile.close()

readFromShelve = shelve.open(data)
print(str(type(readFromShelve)))
print(str(readFromShelve[shelfKey]))

# Plaintext is useful for creating files that you’ll read in a text editor such as Notepad or TextEdit, but if you want to save data from your Python programs, use the shelve module.

cats = [{
    'name': 'Zophie',
    'desc': 'chubby'
}, {
    'name': 'Pooka',
    'desc': 'fluffy'
}]

print(pprint.pformat(cats))
fileObj = open(r'C:\myCats.py', 'w')
fileObj.write('cats = ' + pprint.pformat(cats) + '\n')
fileObj.close()

print(myCats.cats)

import shutil
import zipfile

import os

# The shutil (or shell utilities) module has functions to let you copy, move, rename, and delete files in your Python programs.

os.chdir('C:\\')
baseDir = 'C:\\tmp\\python\\'
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

# What is difference between copy and copytree. The shutil.copytree() call creates a new folder named bacon_backup with the same content as the original bacon folder.

result = shutil.move(copied_file, baseDir)
print(result)

result = shutil.move(baseDir + "\\" + ufo_txt, destination + "\\ufo.xx")
print(result)

# move() can’t find a folder named eggs in the C:\ directory
#  and so assumes that destination must be specifying a filename, not a folder.
#  So the bacon.txt text file is renamed to eggs (a text file without the .txt file extension),
# probably not what you wanted! This can be a tough-to-spot bug in your programs since the move()
#  call can happily do something that might be quite different from what you were expecting.
#  This is yet another reason to be careful when using move().


# Delete a single file or a single empty folder with functions in the os module, whereas to delete a folder and all of its contents, you use the shutil module.

# Walking a Directory Tree
baseDir = 'C:\\tmp\\python\\'
treeDir = baseDir + 'tree\\'

if os.path.exists(treeDir):
    shutil.rmtree(treeDir)

result = os.makedirs(treeDir)
print(result)

foodDir = treeDir + 'food\\'
result = os.makedirs(foodDir)
print(result)

polishDir = foodDir + "polish\\"
result = os.makedirs(polishDir)
print(result)

chineseDir = foodDir + "chinese\\"
result = os.makedirs(chineseDir)
print(result)

sichuanPath = chineseDir + 'sichuan.txt'
sichuanFile = open(sichuanPath, 'w')
sichuanFile.write('sichuan cai shi hao chi')
sichuanFile.close()

alienDir = treeDir + 'alien\\'
result = os.makedirs(alienDir)

for foldername, subfolders, filenames in os.walk(treeDir):
    print('Current folder is: ' + foldername)

    for subfolder in subfolders:
        print('subfolder: ' + subfolder + ' in folder' + foldername)

    for filename in filenames:
        print('file' + filename + ' in folder' + foldername)

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

os.chdir('D:\\')

trains = ['pendolino', 'shinkansen', 'ave']

# SETUP:

baseFolder = r'D:\temp\python'

if os.path.exists(baseFolder):
    os.remove(baseFolder)

os.makedirs(baseFolder)

path = baseFolder + r'\dogFile.txt'
dogFile = open(path, 'w')
print(type(dogFile))

dogFile.write('cats = ' + pprint.pformat(trains) + '\n')
dogFile.close()

destinationFolder = baseFolder + r'\dest'

if not os.path.exists(destinationFolder):
    os.makedirs(destinationFolder)

result = shutil.copy(path, destinationFolder)
print(result)
result = shutil.copy(path, destinationFolder + r'\copied.txt')
print(result)
result = shutil.copytree(destinationFolder, destinationFolder + r'\backup')
print(result)

destinationFolder = baseFolder + r'\dest2'

if not os.path.exists(destinationFolder):
    os.makedirs(destinationFolder)

result = shutil.move(path, destinationFolder)
print(result)

# previous examples worked under the assumption that there was a folder eggs in the C:\ directory. But if there is no eggs folder, then move() will rename bacon.txt to a file named eggs.
# Here, move() can’t find a folder named eggs in the C:\ directory and so assumes that destination must be specifying a filename, not a folder.

# os.unlink(path) will delete the file at path.
path = destinationFolder + "\dogFile.txt"
result = os.unlink(path)
print(result)

#  os.rmdir(path) will delete the folder at path. This folder must be empty of any files or folders.
result = os.rmdir(destinationFolder)
print(result)

# shutil.rmtree(path) will remove the folder at path, and all files and folders it contains will also be deleted.
shutil.rmtree(r'D:\temp\python')

path = 'hotpot.txt'
file = open(path, 'a')
file.write('Spicy HotPot is delicious.')
file.close()

send2trash.send2trash(path)

# os.walk()

baseFolder = r'D:\temp\python'

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

# os.walk() function will return three values on each iteration through the loop:
# 1. A string of the current folder’s name
# 2. A list of strings of the folders in the current folder
# 3. A list of strings of the files in the current folder


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
shutil.rmtree(r'D:\temp\python')

baseDir = 'C:\\tmp\\python\\'
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


backupToZip(backupDir)
print('Goodbye!')
