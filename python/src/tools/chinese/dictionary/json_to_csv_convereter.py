import json
import uuid

row_type = "Q"  # Q or A


def convert_to_csv():
    with open(r'E:\Dropbox\backup\chinese\Questions.json', encoding='UTF-8') as json_file:
        data = json.load(json_file)
    for item in data:
        item_id = int(item['_id']) + 363
        chinese = item['chinese_char']
        pinyin = item['chinese_pinyin']
        english = item['english']
        polish = item['polish']
        # id;;Hash;;type(S -sentence Q - question);;Chinese;;Pinyin;;Englishl;;Polish;;Word id;;Notes
        print(
            f'{item_id};;{str(uuid.uuid4())[0:8]};;${row_type};;{chinese[0:len(chinese) - 2]};;{pinyin[0:len(pinyin) - 2]};;{english[0:len(english) - 2]};;{polish[0:len(polish) - 2]};;none;;none')


if __name__ == '__main__':
    convert_to_csv()
