import json

with open('../../resources/chinese.json') as json_file:
    data = json.loads(json_file.read())
    # print all json
    print(json.dumps(data, indent=2))

    # print field in json
    print(data['weather_rating'])
