# ##### SET THIS: ###### ########
part = 4
welcome = '#DomAncientTrips part {}'.format(part)
text = ':)'
train_class = 0
company = ''
aircraft = ''
country = ''
# ##### ######## ###### ########


DOT = '. '
hashtag = '#train #trains #railway #railways #trip #travel'
theme = '#Covid19 #Stayhome'


def generate():
    message = '#DomAncientTrips part {}'.format(part)
    message += text + DOT
    message += countries[country] + DOT
    if train_class > 0:
        message += generate_hashtag_for_british_class(train_class) + DOT
    if company != '':
        message += companies[company]
    message += hashtag + DOT
    message += theme + DOT
    message += 'Check my blog on https://dominiksymonowicz.com/' + DOT

    print(message)


places = {
    '': '',
    'wroclaw': '#wroclaw #wrocław'
}

countries = {
    '': '',
    'pl': '#poland #polska #europa #eu',
    'uk': '#uk #england #europe',
    'se': '#sweden #europe'
}

companies = {
    'ba': '#ba #brtishairways #speedbird',
    'gwr': '#gwr #first #greatwesternrailway'
}


def generate_hashtag_for_british_class(class_number: int) -> str:
    return '#britishrailclass{} #britishclass{} #class{} #{}'.format(class_number, class_number, class_number,
                                                                     class_number)


if __name__ == '__main__':
    generate()
