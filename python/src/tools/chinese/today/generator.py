#!/usr/bin/env python
# -*- coding: utf-8 -*-
import datetime
import random

import bs4
import pyperclip
import requests

date = datetime.datetime.now()

dot = '。\n'
weather_option = {
    'sunny': '晴朗',
    'rain': '雨',
    'cold': '冷',
    'hot': '热',
    'cloudy': '多云的',
    'windy': '刮风',
    '': ''
}

color_options = {
    'brown': '棕色',
    'blue': '蓝色',
    'green': '绿色',
    'black': '黑色',
    'purple': '紫色',
    'grey': '灰色'
}

rating_options = {
    'horrible': '恐怖',
    'not good': '不好',
    'so-so': '马马虎虎',
    'good': '好',
    'excellent': '优秀'
}

wear_option = {
    't-shirt': 'Ť恤',
    'jeans': '牛仔裤',
    'shoes': '',
    '': '睡衣'
}

food_option = {
    'beef': '牛肉',
    'chicken': '鸡肉',
    'fish': '鱼',
    'rice': '米饭',
    'potato': '土豆',
    'fries': '薯条',
    'soup': '汤',
    'vegetable': '菜'
}

drink_option = {
    'orange juice': '橙汁',
    'tea': '茶',
    'coffee': '咖啡',
    'beer': '啤酒',
    'water': '水',
    'red wine': '红酒'
}

breakfast_option = {
    'coffee': drink_option['coffee'],
    'kefir': 'kefir',
    'british': '英国的早饭(香肠,烽火,拼字蛋,烤豆,番茄,蘑菇和炸土豆饼).',
    'sandwich': '三明治(火腿,起司,番茄,黄瓜和生菜)'
}

# move this to separate file or even pick up from my sqlite database
sentences = [
    '如果你可以传送到那里去，那是哪？',
    '如果你能赢得任何奖项，是什么奖？',
    '今天工作中发生的最有趣的事情是什么？SZW2S1',
    '谁是你最亲密的朋友？',
    '你们两个怎么会成为朋友？',
    '告诉我谁是你最好的朋友?',
    '你最喜欢的笑话是什么？',
    '最受欢迎的歌曲是什么？',
    '你最喜欢的运动形式是什么？',
    '你在手机上的最后一张照片是什么？',
    '你最想做的事情是什么?',
    '你相信业力吗？',
    '你有隐藏的天赋吗？',
    '你做过的最愚蠢的事是什么？',
    '你为什么迟到？',
    '因为路上堵车。',
    '路上发生车祸了。',
    '我想要买它。',
    '这条牛仔裤多少钱？',
    '二十块英镑。',
    ' 这条牛仔裤多少钱？',
    '你要加糖吗？',
    '我要青茶。',
    '你们今天想喝什么茶?',
    ' 我有青茶，绿茶和香片。',
    '你每天几点上班？',
    '你每天八点上班。',
    '你每天几点下班？',
    '你每天四点半上班。',
    '这是第二天罢工的。',
    '今天，平台和地铁危险人满为患。',
    '我的地铁是开放的。',
    '我要打印几张文件。',
    '打印机坏了。',
    '电影并不像我想象的那么好。',
    '你从事的是高强度工作吗？',
    '我看了网络视频。',
    '什么样的电影呢？',
    '它是喜剧和电视剧。',
    '你喜欢吃辛辣食物吗？',
    '我喜欢吃辛辣食物。',
    '我经常吃的四川菜。',
    '在苏格兰这儿冬天不下雪。',
    '我现在有大麻烦了。',
    '你会推荐它吗？为什么呢？',
    '是的。它有一个惊人的情节。',
    '你喜欢什么样的电影？',
    '我喜欢科幻电影。',
    '七点一刻：慢跑',
    '七点三刻：早饭',
    '天气多云和且刮风。',
    '谁放的屁？',
    '我做到了。',
    '今天,我吃了太多的豆类和坚果。',
    '它闻起来如此之差。',
    '我要晕倒。',
    '我觉得自己像是冰激凌在烤箱。',
    '餐厅在中国比欧洲大得多。',
    '餐厅在中国有少数 地板 。',
    '你可以保留你自己的房间，与自己的服务。',
    '我到中国来庆祝春節.',
    '我看到了烟花。',
    '你最喜欢的笑话是什么？',
    '我不浪漫了。',
    '火锅在村。',
    '我的生活的时刻是了移民到UK.',
    '服务员態度好。',
    '你喜欢喝酒和饮料吗？',
    '你喜欢喝什么？',
    '我早饭时喝一瓶/杯水。',
    '我午饭时喝一罐啤酒。',
    '你的手机上最喜欢的歌曲是什么？',
    '你喜欢去哪里度假？',
    '你喜欢什么样的节日？',
    '你喜欢旅行吗？',
    '你会在火星上做什么好玩的游戏？',
    '这周末你打算做什么？',
    '你喜欢浪漫吗？',
    '我没有妹妹,但是我觉得有妹妹一定很好 ，因为我哥哥有个妹妹',
    '你回英国了吗？',
    '上周日我回到英国。',
    '你上次吃火锅是什么时候？',
    '我一个星期前吃了火锅。',
    '这本书是关于什么的？',
    '这是关于醉酒的学生。',
    '我想睡更多但是我必须起床，否则工作我会迟到的。',
    '唐人街看起来很漂亮因为很多地方都为即将到来的中秋节而装扮一新。',
    '上周二我收到通知函。我将在十一月份开始新的工作。',
    '我要换工作，因为我要学习新技能。',
    '我应该在6.30醒来，因为我要跑。',
    '我又在晚上跑了两公里。',
    '我读了书，喝了咖啡。',
    '修建地铁在伦敦是很昂贵的。',
    '新闻报道了什么/哪些有趣的事情？',
    '科学技术中最酷的事项是什么',
    '你看的最后一部电影是什么？',
    '怎么样？好看吗？',
    '电影马马虎虎。我喜欢但它并不像我想象的那么好。',
    '她考上驾驶证吗？',
    '我的肚子比你的大得多。',
    '我觉得我生病了，但我还是去工作了。',
    '它是了我的最喜欢的饭馆。',
    '如果你能传送你去哪里，为什么？',
    '如果你能赢得任何奖励，那会是什么？为什么？',
    '今年我不能去中国庆祝春節，因为我开始了新的工作。',
    '我在中午吃了香肠三明治。',
    '我的朋友在下午六点半拜访了我。',
    '如果你能学会做任何事情，它会是什么？',
    '如果你不得不改变你的名字，你会改变它到什么地方？',
    '这本书是关于什么的？',
    '这书是关于醉酒的学生。',
    '我晚饭喝一杯茶。',
    '我很睏。昨天我回天津。天津的天气很好。',
    '我睡了十个小时。',
    '我妹妹有狗。',
    '我喜欢走路的狗。',
    '你曾经去过的最棒的派对之一是什么？',
    '你不想放弃的食物是什么？',
    '什么是你最喜欢的报价之一？',
    '我要会打扫卫生。',
    '能帮我照张相吗？',
    '它是了好电影。',
    '你小时候最喜欢的食物是什么？',
    '你睡了几个小时昨晚',
    '你最骄傲的成就是什么？',
    '我搬到了英国。',
    '你的最好的假期？',
    '你的更糟的假期？',
    '星期六，我会做很多家务。',
    '星期天，我会去游泳和学习中文。',
    '我要在超市买一瓶白酒。',
    '我在咖啡厅喝拿铁咖啡。',
    '这周你期待什么？',
    '你最骄傲的个人习惯是什么？',
    '我最骄傲的成就是慢跑每天。',
    '你在生活中的最终目标是什么？',
    '我想享受日常生活，我想让人们开心。',
]


def get_chinese_number(num):
    numbers = ['零', '一', '二', '三', '四', '五', '六', '七', '八', '九', '十',
               '十一', '十二', '十三', '十四', '十五', '十六', '十七', '十八', '十九', '二十',
               '二十一', '二十二', '二十三', '二十四', '二十五', '二十六', '二十七', '二十八', '二十九', '三十',
               '三十一'
               ]
    return numbers[num]


def get_distance_from_steps(steps_counter):
    return str(round(steps_counter / 1225, 2))


def get_temp_from_internet():
    response = requests.get('http://www.google.co.uk/search?q=rickmansworth+weather')
    temp = ''
    try:
        response.raise_for_status()  # without try it will exit program
        html_manager = bs4.BeautifulSoup(response.text, "html.parser")
        response = html_manager.select('.wob_t')
        temp = response[0].get_text()

    except Exception as whoops:
        print('There was a problem: %s' % (whoops))
    return temp


def get_time_in_chinese(time):
    result = ''
    print(time)
    splited_time = time.split('.')
    result += get_chinese_number(int(splited_time[0]))

    return result


'''
    print()  # I woke up/went to sleep at [time]
    print()  # For breakast/lunch/dinner I ate (meat + filling ) and drink (beer,tea,coffee,wine)
'''


def get_text_based_on_time(time, meal):
    day_info = ''
    if time > 17:
        day_info += ''
        # went to sleep at 我在凌晨一点一分睡觉。
        # back from work at
        # ate at dinner
    elif time > 12:
        day_info += ''
        # woke up
        # went to work at
        # ate at lunch
    else:
        day_info += ''
        # woke up
        # ate at breakfast
    return day_info


year = ''

for i in list(str(date.year)):
    year += get_chinese_number(int(i))


def get_distance_from_run(run_distance):
    return str('{:.1f}'.format(run_distance / 1000))


def get_time_from_run(run_time):
    minuts = run_time // 60
    seconds = run_time % 60
    return str(minuts) + '分' + str(seconds) + '秒'


def generate_info_about_today(weather_rating,
                              weather_description_1, weather_description_2,
                              steps,
                              upper_wear_color_1, upper_wear_type_1,
                              upper_wear_color_2, upper_wear_type_2,
                              time, meal,
                              yesterday_diary,
                              run_distance,
                              run_time,
                              with_random_sentences,
                              entry: int
                              ):
    chinese_month = get_chinese_number(date.month)
    chinese_day = get_chinese_number(date.day)
    chinese_day_of_the_week = get_chinese_number(date.weekday() + 1)
    today_info = get_entry_number(entry)
    today_info += '今天是' + year + '年' + chinese_month + '月' + chinese_day + '日,星期' + chinese_day_of_the_week + dot
    if yesterday_diary:
        today_info += '这是昨天的日记。'

    today_info += '伦敦的天气' + weather_rating + '.这是' + weather_description_1
    if weather_description_2 is not '':
        today_info += '和' + weather_description_2
    today_info += dot + '今天气温是' + get_temp_from_internet() + dot
    #  today_info += get_text_based_on_time(time,meal)
    today_info += '我穿' + upper_wear_color_1 + upper_wear_type_1 + '和' + upper_wear_color_2 + upper_wear_type_2 + dot
    today_info += '我走了' + str(steps) + '步相当于' + get_distance_from_steps(steps) + '公里左右' + dot
    today_info += run_sentence(run_distance, run_time)
    today_info += generate_random_sentence(with_random_sentences)
    print(today_info)
    pyperclip.copy(today_info)  # copy to clipboard


def generate_random_sentence(with_random_sentence):
    if with_random_sentence:
        today_info = sentences[random.randint(0, get_last_element())] + '\n'
        today_info += sentences[random.randint(0, get_last_element())] + '\n'
        today_info += sentences[random.randint(0, get_last_element())] + '\n'
    else:
        today_info = ''
    return today_info


def get_last_element():
    return len(sentences) - 1


def run_sentence(run_distance, run_time):
    if run_distance > 0 and run_time > 0:
        return '我在晚上去了慢跑。我跑了' + get_distance_from_run(run_distance) + '公里。跑了这个距离花了我' + get_time_from_run(run_time) + dot
    else:
        return ''


def get_chinese_number_for(entry):
    number = ''
    thousands = entry // 1000
    if thousands > 0:
        number += get_chinese_number(thousands) + '千'

    entry = entry % 1000
    hundreds = entry // 100

    if hundreds > 0:
        number += get_chinese_number(hundreds) + '百'

    entry = entry % 100
    tens = entry // 10

    if tens > 0:
        number += get_chinese_number(tens) + '十'

    ones = entry % 10

    if ones > 0:
        number += get_chinese_number(ones)

    return number


def get_entry_number(entry: int) -> str:
    if entry != 0:
        return "Dom's entry: " + get_chinese_number_for(entry) + dot
    else:
        return ''
