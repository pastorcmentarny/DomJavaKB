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
    '我想跑，因为我想减肥。',  # Wǒ xiǎng pǎo, yīnwèi wǒ xiǎng jiǎnféi. I want to run because I want to lose weight.
    "你多久游一次泳？ Nǐ duōjiǔ yóu yīcì yǒng? How often do you swim for a swim?",
    "我想做急救课程。 Wǒ xiǎng zuò jíjiù kèchéng.I want to do a first aid course.",
    "我去过曾做过急救课程。 Wǒ qùguò céng zuòguò jíjiù kèchéng.I have been to a first aid course.",
    "今天有人晕倒了。 Jīntiān yǒurén yūn dǎo le.Someone fainted today.",
    "我帮助这个人，但我知道我可以做得更好。Wǒ bāngzhù zhège rén, dàn wǒ zhīdào wǒ kěyǐ zuò dé gèng hǎo. I help this person, but I know that I can do better.",
    "火车坏了。",
    "她没有离开车站。",
    "她前往下一站。",
    "她迟到了75分钟。",
    "身体健",
    "我家养狗和二",
    "我喜欢奶酪蛋糕",
    "我喜欢黑",
    "我的生日是一九八〇年，四月，四",
    "我是波",
    "这是我",
    "这是我的笔记本",
    "这是一",
    "那是",
    "我不是电脑",
    "她是不是德",
    "这不是我的笔记本电",
    "它不是你的",
    "这不是一",
    "她能说英",
    "我能用汉语打电",
    "我能开",
    "他能游",
    "我能跳",
    "好的，谢",
    "我很渴",
    "我喜欢绿",
    "两元一",
    "我喜欢跑",
    "我听电子音",
    "我学汉语是因为我的妻子是中国",
    "对不起，我迟到",
    "我学的是计算机科",
    "我早上十点起",
    "天气怎么",
    "我听不",
    "我不知",
    "我喜欢我的工",
    "我没有宠物,但是我以后想养一",
    "我没有驾驶执",
    "我有点不舒服",
    "谢谢你的",
    "保持联",
    "我住在弗罗茨瓦",
    "我讨厌清",
    "我有很多事情要",
    "我在写电子邮",
    "我喜欢辣食",
    "我会说汉",
    "我很",
    "我喜欢啤酒，红葡萄酒和威士",
    "我没有纹",
    "这是我的臭袜子",
    "我去过中国，德国,西班牙和英",
    "你去过波",
    "我在地铁上",
    "我要见我的爱",
    "昨天我在天津看了咖世家咖啡",
    "你可以说：我又累又困",
    "我的专业是计算机科",
    "我有一个妹",
    "我降落在北京首都机",
    "我失去了我的耳",
    "我觉得在火车上很无",
    "圣诞快乐",
    "我吃了鸡肉，米饭 和蔬菜",
    "劳动节快",
    "我喜欢逛公园，慢跑和爬",
    "我太胖了，跑不动，但我能走很长的距离（十五公里）",
    "我在2013年跑了半程马拉松。",
    "我绕着山走了四十公里",
    "我最喜欢的喜剧演员是Gabriel Iglesias, 、Michael McIntyre和 Abelard Giz",
    "我喜歡Denzel Washington 和 Morgan Freeman",
    "我需要刮胡子和理发，因为我看起来像无家可",
    "我不喜欢我现在的工作，因为我的工作很无",
    "我这次的旅程平时只需45分钟却花了90分",
    "我的儿子开始哭了，因为他饿了。在四点",
    "我喜欢单口喜剧，因为演员说的是日常生",
    "我要买’Colombian'咖啡但已經卖完",
    "我试图打电话给你，但是我的电池没电",
    "我不喜欢KFC但我的爱人要吃KFC的鸡",
    "因为外面正在下雪，所以我无法跑步",
    "昨天我买了一本书，但我今天弄丟了它",
    "我搭的地铁因有些信号问题导致误点",
    "我计划走二十五公里，但是下雨了",
    "我想去厕所，但是火车上没有厕所",
    "我没有去上班，因为我感觉不舒服",
    "我喜欢中国的茶但我也喜欢浓咖啡",
    "改变我的生活的时刻是了移民到UK",
    "我仍然感到累，因为我的工作很忙",
    "我现在正在学习Python编程语言",
    "伦敦的地铁并不像中国那样拥挤",
    "现在只是九点一刻但我已经累了",
    "因为下大雨，所以火车被取消了",
    "英国的公共交通很混亂所以误点",
    "我的朋友在下午六点半拜访了我",
    "昨天Stephen Hawking去世了",
    "我在晚饭时吃了丸子用和米饭",
    "我今早吃了火腿和奶酪三明治",
    "他是一位充满灵感的残疾人士",
    "我想去游泳，但我忘了帶裤子",
    "我四点去公园。我走了5公里",
    "我很困了，我需要更多睡眠",
    "我吃了三明治和火腿和乳酪",
    "我要去餐馆，因为我很饿了",
    "在英国我喜欢去酒吧喝啤酒",
    "昨天，我去了伦敦的唐人街",
    "我们谈论了他的波兰之",
    "我去了公园走了2个小时",
    "我在凌晨一点一分睡觉",
    "我现在没有时间学中文",
    "我要在超市买一瓶白酒",
    "我在咖啡厅喝拿铁咖啡",
    "谢谢你更正我所有的错",
    "我上星期日从中国回来",
    "他是一位理论物理学家",
    "我早饭时喝一瓶/杯水",
    "在家我喜欢喝威士忌",
    "我午饭时喝一罐啤酒",
    "天气虽然晴朗但有风",
    "我是Java 开发人员",
    "我喜欢学习新的东西",
    "我没有明白您的意思",
    "这个电影很没意思",
    "我直到午夜才睡觉",
    "我去走了十五公里",
    "我早上十点半起",
    "英国现在有大风暴",
    "我会留在家里休息",
    "我去了一家粤菜馆",
    "我在早上六点起床",
    "我在晚上去了酒吧",
    "我看见一些外国人",
    "我需要回去学中文",
    "我在晚饭吃了KFC",
    "喜欢的电影明星",
    "我晚饭喝一杯茶",
    "地铁站过于拥挤",
    "我没有周末计划",
    "我的办公室很冷",
    "天气冷和大风天",
    "昨天天气不好",
    "这个厕所很小",
    "我昨晚没睡好",
    "在村里吃火锅",
    "我不浪漫了",
    "这个菜好",
    "我病了。",
    "我有点感冒",
    "笔记本电脑在桌子上",
    "我在家里。",
    "“Capital Ring”是在伦敦一个行走的路线",
    "我不在办公",
    "字典不在书架上。",
    "毛巾不在浴室里",
    "我家有四口人：爸爸，妈妈，妹妹和我。",
    "我就从“Wembley Park“走 到 ”Victoria”",
    "我的电话号码是零七八九一二三四五六。",
    "我想要住在中",
    "我觉得中国是一个美丽的国家.",
    "我与我的妻子去餐",
    "我玩电脑游戏。",
    "我会在家主场35分钟.",
    "我不喜欢在家做饭。",
    "我要去酒楼",
    "我喜欢川菜",
    "去年我去过中国",
    "我们吃了很多好吃的菜",
    "我在中国做了最丑陋的饺",
    "该睡觉了。",
    "我有很多事情要做",
    "我没有足够的时间。",
    "我有些牙",
    "我已经来北京3天。",
    '我的最喜欢电影是"Last life in the universe".',
    "我在天津,明天回伦敦",
    "我结婚已经五年",
    "我们会去见了朋",
    " 我将从十月开始练习汉",
    "我结婚已经五年",
    "英国美食是世界上最糟糕的美食之",
    "我在写电子邮",
    "“Capital Ring”是在伦敦一个行走的路",
    "我就从“Wembley Park“走 到 ”Victoria",
    "我在天津,明天回伦敦。",
    "等一下",
    "我没有明白您的意思",
    "我去机场送你和我的儿子",
    "我没有妹妹 但是我觉得有妹妹一定很好 ，因为我哥哥有个妹",
    "狗年吉祥",
    "我得了流",
    "我感冒",
    "我牙",
    "我胃",
    "我头",
    "请系好安全",
    "我的护照丢",
    " 我的登机牌丢了",
    "天气很恶",
    "他歌唱的漂",
    "我舞跳的很",
    "我的电脑坏",
    "我要一杯咖啡",
    "好久不",
    "我读了书，喝了咖啡",
    "地铁在伦敦是很昂贵的",
    "'Costa coffee'的咖啡比‘Starbucks'的咖啡好",
    "他跑得非常快",
    "它是了我的最喜欢的饭馆",
    "火车被取消",
    "我晚上去参加派",
    '我（正）在读"Terry Pratchett - MORT"。',
    "你吃了",
    "你要茶",
    "你今天作乐什",
    "你叫什么名",
    "厕所在哪",
    "你说英语",
    "你多大",
    "你是哪国",
    "你养宠物",
    "你喜欢什么样的食",
    "你在做什",
    "你长什么",
    "谁放的",
    "你喜欢什么颜",
    "你的生日是什么时",
    "你今天做了什",
    "你的工作是什",
    "你好",
    "这是什",
    "你姓什",
    "你渴",
    "你有红茶",
    "你是素食主义",
    "你喜欢绿茶还是红茶",
    "你想吃西瓜还是苹",
    "那是什",
    "一瓶啤酒多少",
    "你喜欢什么样的音乐",
    "你最喜欢的体育是什",
    "你最喜欢的书是什",
    "你最喜欢的电影是什",
    "你最喜欢的颜色是什",
    "你最喜欢的点心是什",
    "你最喜欢的网址是什",
    "你业余时间做什",
    "你喜欢你的专业",
    "你喜欢你的工作",
    "你喜欢辛辣食物",
    "你的人生主要目标有哪些",
    "你喜欢跳舞",
    "你最喜欢哪种类型的电",
    "这个星期你打算做什",
    "你会考虑在国外生活吗？如果会，哪个国家",
    "你最近看的一部电影是什",
    "你有驾驶执照",
    "你有车",
    "你结婚了",
    "你有孩子",
    "你有男朋友",
    "你有女朋友",
    "你会说中文",
    "你会说英文吗",
    "你喜欢中国",
    "你习惯住在中国吗",
    "你住在哪",
    "你收信用",
    "你明白",
    "你最近忙",
    "你学什么专",
    "你的 周末有什么计",
    "你妹妹是做什么",
    "我可以试试",
    "你的电话号码是多",
    "今天天气怎么",
    "你昨天去哪儿",
    "你喜欢吃中餐还是西",
    "睡的怎么",
    "你明天有空",
    "你有驾驶执照",
    "这本词典是你的",
    "你们商店几点关",
    "你无聊的时候最喜欢以什么方式消",
    "你回家什么时",
    "你上周末过得怎么样",
    "你喜欢喝酒吗？ 如果喜欢，你喜欢哪种酒",
    "你有纹身",
    "你有什么特殊的才",
    "你现在读书什",
    "你想吃东西",
    "你去过什么国",
    "你去过波兰",
    "你会怎么做，当你无",
    "你要去哪",
    "你学习什",
    "你现在回到家了",
    "你买了",
    "你感觉怎么",
    "你生病了",
    "你吃早饭了",
    "最近怎么",
    "你通常在午饭时间做些什么",
    "你吃早饭了吗",
    "你今天（都）学了什",
    "你男朋友最近怎么",
    "你来中国工作过",
    "你有感冒了",
    "你今天工作会很忙",
    "你喜欢这部电影",
    "那是什么鬼东",
    "你有兄弟姐妹",
    "这/那个人是",
    "你喜欢的酒是什么类",
    "你最喜欢的喜剧演员是谁？为什",
    "你喜欢的酒是什么类",
    "你最喜欢的户外活动是什",
    "你是个喜欢浪漫的人",
    "你的理想的浪漫晚餐什",
    "你可以告诉我一个改变你生活的时刻",
    "你喜欢喝什",
    "如果你能去火星，你会在那里做什",
    "你最糟的假期是什么时候",
    "你最好的假期是什么时候",
    "你喜欢去哪里度假",
    "你喜欢什么样的节日",
    "你喜欢旅行吗？ 如果你喜欢，你想要去哪里",
    "更糟糕的电影，你见",
    "喜欢的电影明",
    "这本书是关于什么",
    "你上次吃火锅是什么时",
    "你上次吃火锅是什么时",
    "你是哪一年生的",
    "你妈妈做什么工",
    "你的电话号码是多少？",
    "你的妻子有兄弟姐妹",
    "你会考虑在国外生活吗? 如果会，哪个国家？",
    "她是你的妹妹吗",
    "你喜欢去酒楼或在家做饭？",
    "你喜欢什么样的食物？",
    "你来北京多长时间了？",
    "你常吃什么菜？",
    "你明天有空吗？",
    "今天晚上你去哪儿？",
    "你现在回到家了吗",
    "你的假期怎么样",
    "你能在火车站接我",
    "这里常常下雨吗",
    "你觉得怎么样",
    "你最喜欢的餐厅是哪一间",
    "你永远不会放弃的食物是什么",
    "您第一次来天津",
    "你有中文书",
    "请问，餐厅怎么",
    "你的妻子已经在中国",
    "你觉得她怎么样",
    "你想去到公园",
    "你在北京有多久",
    "你经常做梦吗",
    "你梦见什么",
    "你的最好的放松方式是什么",
    "你最喜欢的运动形式是什么",
    "最好的放松方式是什么",
    "您更喜欢线上购物还是线下购物",
    "你购买过最愚蠢的东西是什",
    "你去北京还是青岛",
    "可以用信用卡",
    "我舞跳的很好",
    "他歌唱的漂亮",
    "你喜欢做饭",
    "你现在读什么书?",
    "你看的最后一部电影是什么？",
    "你希望你有超级大国什",
    "你小时候最喜欢的食物是什么",
    "能帮我照张相吗",
    "如果你能学会做任何事情，它会是什么",
    "你几点起",
    "你几点吃早",
    "我晚上去参加派对",
    "你是软件工程师吗",

]
