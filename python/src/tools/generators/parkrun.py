import json

distance = float(5)


def check_for_personal_best(result: dict) -> str:
    if result["personal_best"]:
        return "it is my new personal best."
    else:
        return "my personal best stays at {}".format(result["personal_best_time"])


def generate_for_instagram(data):
    result = """My {} #parkrun #run event number {} at #rickmansworth.
I was {} out of {} runners. 
My time was {} with an average pace of {}min/km and an average speed of {}km/h, and {}. 
My #running report can be found here: {{URL}}""" \
        .format(str(data['event']['my_run']), str(data['event']['number']),
                str(data['result']['place']), str(data['result']['all_runners']),
                str(data['result']['time']),
                calculate_pace(str(data['result']['time'])),
                calculate_average_speed(str(data['result']['time'])),
                check_for_personal_best(data['result']))

    print(result)


def calculate_pace(time) -> str:
    minutes, seconds = time.split('.')
    total_seconds = (int(minutes) * 60) + int(seconds)
    seconds_per_kilometer = float(total_seconds) / distance

    minutes_per_kilometer = int(seconds_per_kilometer / 60)
    seconds_remainder = int(seconds_per_kilometer - (minutes_per_kilometer * 60))
    return '{}:{:0=2d}'.format(minutes_per_kilometer, seconds_remainder)


def calculate_average_speed(time) -> str:
    minutes, seconds = time.split(".")
    result_in_second = int(minutes) * 60 + int(seconds)
    h = result_in_second / 3600
    result = distance / h
    return '{:.2f}'.format(result)


def generate_for_blog():
    """I ran in Rickmansworth Parkrun no.XXX on XXXX.2019.
Pictures from the race can be found on my Instagram: {{URL}}
The weather was XXXX. It was XXXX and temperature around 18°C.

RESULTS:
My weight on that day was XXX.X kg.
My result was XX.XX, and I was XXXth out of XXX.
My personal best remains at XX.XX.
In my age category: I was XX out of XX runners in today's run.
In Top performances table in all Rickmansworth's parkrun runs, I am XXX out of XXX."""


def generate_data():
    data = config()
    if data['attend']:
        generate_for_instagram(data)
        generate_for_blog()
    else:
        print("I didn't run, so why I print this?")


def config() -> dict:
    path = 'cfg.json'
    with open(path, 'r') as email_config:
        return json.load(email_config)


if __name__ == '__main__':
    generate_data()
