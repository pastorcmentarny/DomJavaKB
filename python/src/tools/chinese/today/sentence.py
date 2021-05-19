import datetime
import random

from src.tools.chinese.today import application_utils, chinese_number, file_loader, chinese_time

dot = file_loader.config()['dot']
next_line = '\n'
date = datetime.datetime.now()



def add_today_date() -> str:
    chinese_month = chinese_number.get_chinese_number(date.month)
    chinese_day = chinese_number.get_chinese_number(date.day)
    chinese_day_of_the_week = chinese_number.get_day_of_the_week_number(date.weekday() + 1)
    year = application_utils.get_year_in_chinese(str(date.year))
    return '今天是' + year + '年' + chinese_month + '月' + chinese_day + '日,星期' + chinese_day_of_the_week + dot


def add_weather_sentence(weather_description_1, weather_description_2, weather_rating):
    weather = '伦敦的天气' + weather_rating + '.这是' + weather_description_1
    if weather_description_2 != '':
        weather += '和' + weather_description_2
    return weather + dot + '今天气温是' + application_utils.get_temp_from_internet() + dot


def add_wear(upper_wear_color_1, upper_wear_color_2, upper_wear_type_1, upper_wear_type_2):
    return '我穿' + upper_wear_color_1 + upper_wear_type_1 + '和' + upper_wear_color_2 + upper_wear_type_2 + dot


def go_to_sleep() -> str:
    return "我在{}去了睡觉{}".format(chinese_time.get_random_sleep_time(), dot)


def steps(steps_count: int) -> str:
    return '我走了' + str(steps_count) + '步相当于' + application_utils.get_distance_from_steps(steps_count) + '公里左右' + dot


def generate_random_sentence(with_random_sentence):
    today_info = next_line
    if with_random_sentence:
        for i in range(0, 3):
            today_info += sentences[random.randint(0, application_utils.get_last_element(sentences))] + next_line
    return today_info


def walk_in_the_morning(distance: float):
    return '我早上时走了{}}公里。'.format(distance)


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
    '上周二我收到通知函。',
    '我将在十一月份开始新的工作。',
    '我要换工作，因为我要学习新技能。',
    '我应该在6.30醒来，因为我要跑。',
    '我又在晚上跑了两公里。',
    '我读了书，喝了咖啡。',
    '修建地铁在伦敦是很昂贵的。',
    '新闻报道了什么/哪些有趣的事情？',
    '科学技术中最酷的事项是什么',
    '你看的最后一部电影是什么？',
    '怎么样？好看吗？',
    '电影马马虎虎。',
    '我喜欢但它并不像我想象的那么好。',
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
    '我很睏。',
    '昨天我回天津。',
    '天津的天气很好。',
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
    '你为什么迟到？',
    '因为路上堵车。',
    '路上发生车祸了',
    '我想要买它。',
    '二十块英镑。',
    '这条牛仔裤多少钱?',
    '我要青茶。',
    '你要加糖吗',
    '你们今天想喝什么茶? 我有青茶，绿茶和香片。',
    '你想喝茶吗？',
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
    '什么样的视频呢？',
    '它是喜剧的电视剧。',
    '你喜欢吃辛辣食物吗？',
    '我喜欢吃辛辣食物。 ',
    '我经常吃四川菜。',
    '在苏格兰这儿/里/冬天不下雪。',
    '我现在有大麻烦了。',
    '你会推荐它吗？为什么呢？',
    '是的。它有一段惊人的情节。',
    '你喜欢什么样的电影？',
    '我待在家里。',
    '我和我的儿子一起玩。',
    '我待在家里。',
    '我和我的儿子一起玩。',
    '我是如此胖，以至于相机认为我是汽车。',
    '我喜欢在寒冷的时候跑步。 ',
    '我喜欢科幻电影。',  #
    '我想去跑步。',  # Wǒ xiǎng qù pǎobù. I want to go for a run.
    '我不能去参加比赛，因为这是风暴。',
    # Wǒ bùnéng qù cānjiā bǐsài, yīnwèi zhè shì fēngbào. I can't go for a run because it is a storm.
    '天气很糟糕。',  # Tiānqì hěn zāogāo. Weather is horrible.
    '明天，我会去跑步。',  # Míngtiān, wǒ huì qù pǎobù. Tomorrow, I will go for a run.
    '我想跑，因为我想减肥。'  # Wǒ xiǎng pǎo, yīnwèi wǒ xiǎng jiǎnféi. I want to run because I want to lose weight.
]
