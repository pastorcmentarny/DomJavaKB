type = [
    'lager', 'pilsner', 'ale',
]
config = {
    'number': 22,
    'type': type[0],
    'country': 'Poland',
    'alk': 5.2,
    'location': 'Wroclaw',
    'recommended': True,
    'taste': 'light and refreshing',
    'package': 'ordinary',
    'price': 1.4,  # Expensive, cheap
}


def get_cost_opinion(price: float) -> str:
    if price > 6.0:
        return 'very expensive'
    elif price > 4.0:
        return 'expensive'
    elif price > 3.0:
        return 'not expensive'
    else:
        return ' quite cheap'


def generate() -> str:
    entry = "#beerexplorer no. {}. It is a #{} #beer from #{}. It has {}%. I tried this beer in #{}. ".format(
        config['number'], config['type'], config['country'], config['alk'], config['location'])
    entry += "It tastes {}. It costs {:.2f}, so it is {}. ".format(config['taste'], config['price'],
                                                                   get_cost_opinion(config['price']))
    entry += "The package looks {}. ".format(config['package'])
    if config['recommended']:
        entry += 'It is worth to try it. '
    else:
        entry += "I will not buy this beer again. "
    entry += '#beers #dombeerexplorer. '
    return entry


if __name__ == '__main__':
    print(generate())
