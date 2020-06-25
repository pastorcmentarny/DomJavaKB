# ##### SET THIS: ###### ########
part = 9

text = ""
train_class = 0
company = ''
aircraft = ''
country = ''
transport_type = ''
# ##### ######## ###### ########

welcome = '#DomAncientTrips part {}'.format(part)
DOT = '. '

theme = '#Covid19 #Stayhome'


def generate():
    message = '#DomAncientTrips part {}'.format(part) + DOT
    message += text + DOT
    message += countries[country] + DOT
    if train_class > 0:
        message += generate_hashtag_for_british_class(train_class) + DOT
    if company != '':
        message += companies[company]
    message += transport_types[transport_type] + DOT
    message += aircrafts[aircraft] + DOT
    message += theme + DOT
    message += 'Check my blog on https://dominiksymonowicz.com/' + DOT

    print(message)


places = {
    'london': '#london',
    'wroclaw': '#wroclaw #wrocław #wroclove',
    'tianjin': '#tianjin #天津'
}

countries = {
    '': '',
    'pl': '#poland #polska #europa #eu #pkp #intercity #Polregio #KD #KolejeDolnośląskie #kolej #pociąg #pendolino',
    'uk': '#uk #england #europe',
    'se': '#sweden #europe #eu',
    'cn': '#china #中国 #asia'
}

companies = {
    'ba': '#ba #brtishairways #speedbird',
    'gwr': '#gwr #first #greatwesternrailway #britishrailways #FirstGreatWestern',
    '': ''
}

transport_types = {
    'train': '#train #trains #railway #railways #trip #travel #intercity',
    'airplane': '#airplane #flight #aviantion #airport',
    '': ''
}

aircrafts = {
    '737': '#Boeing #Boeing737 #Boeing737-800',
    '787': '#Boeing #Boeing787 #Boeing787-8 #Boeing787-9 #Boeing787-10 #dreamliner',
    '380': '#airbus #airbus380 #airbusa380 #380 #a380'
}


def generate_hashtag_for_british_class(class_number: int) -> str:
    return '#britishrailclass{} #britishclass{} #class{} #{}'.format(class_number, class_number, class_number,
                                                                     class_number)


if __name__ == '__main__':
    generate()
