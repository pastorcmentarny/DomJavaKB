import ast
import base64
import logging
import sys

import pyperclip
from Crypto.Cipher import AES

'''
    This is just tool I wrote for learning purposes
    DO NOT JUDGE THIS CODE ON QUALITY OR SECURITY as you will not find any of this here

tag-crypto
tag-bytes

LEARN:
    how to it uses PyCrypto Module
    Use ast.literal_eval to convert the bytes literal to bytes.
    
TODO
    if args has del key what it will delete this property

'''

usage = '''

Usage: python locker.py command (add,get) secret_key other_properties 
add key url user password
get key url
del key url
'''


def validate():
    if len(sys.argv) < 3:
        print(usage)
        sys.exit()
    if sys.argv[0] is 'add':
        if len(sys.argv) is not 5:
            print(usage)
            sys.exit()
    if sys.argv[1] is ('get' or 'del'):
        if len(sys.argv) is not 3:
            print(usage)
            sys.exit()


# SETTINGS
app_name = 'Very insecure password locker program.'
print('Welcome in: ' + app_name)
path = 'data.dfs'
splitter = ':=:'
log_file = '../../../../../log.txt'
logging.basicConfig(level=logging.INFO, format=' %(asctime)s - %(levelname)s - %(message)s', filename=log_file)

for arg in sys.argv:
    logging.debug(arg)

validate()
cmd = sys.argv[1]
what = sys.argv[3]
cipher = AES.new(sys.argv[2].rjust(32), AES.MODE_ECB)  # ECB used for learning purposes
username = None
pwd = None
data = None
if cmd == 'add':
    username = sys.argv[4]
    pwd = sys.argv[5]
    data = open(path, 'a')
else:
    data = open(path, 'r')

if cmd == 'add':
    logging.info('adding ' + what + ' to store')
    encoded = base64.b64encode(cipher.encrypt((what + splitter + username + splitter + pwd).rjust(32)))
    # save file
    data.write(str(encoded) + '\n')

    data.close()
elif cmd == 'del':
    print('not supported yet')
elif cmd == 'get':
    logging.info('looking for ' + what)
    lines = data.readlines()
    for account in lines:
        print('password: ' + account)
        decoded = str(cipher.decrypt(base64.b64decode(ast.literal_eval(account).rjust(32)))).lstrip()
        decoded = decoded[2:len(decoded) - 1].split(splitter)
        print(decoded[0].lstrip())
        for line in data.readlines():
            if decoded[0].lstrip() == what:
                logging.info('getting' + what + ' for ' + decoded[1])
                pyperclip.copy(decoded[2])
                print('Password for user: ' + decoded[1] + ' on ' + decoded[0].lstrip() + ' copied to clipboard.')
            else:
                print('SORRY , there is no account named ' + account + ' in the system')

print('thank you for using ' + app_name)
