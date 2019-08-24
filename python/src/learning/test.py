def count_warnings(warnings) -> dict:
    warning_counter = {
        'the': 0,
        'thw': 0,
        'tle': 0,
        'tlw': 0,
        'hhe': 0,
        'hhw': 0,
        'hle': 0,
        'hlw': 0,
        'cthf': 0,
        'cthe': 0,
        'cthw': 0,
        'uvaw': 0,
        'uvbw': 0,
        'fsl': 0,
        'dsl': 0
    }

    for warning in warnings:
        if '[cthf]' in warning:
            warning_counter['cthf'] += 1

        elif '[cthe]' in warning:
            warning_counter['cthe'] += 1

        elif '[cthw]' in warning:
            warning_counter['cthw'] += 1

        elif '[the]' in warning:
            warning_counter['the'] += 1

        elif '[thw]' in warning:
            warning_counter['thw'] += 1

        elif '[tlw]' in warning:
            warning_counter['tlw'] += 1

        elif '[tle]' in warning:
            warning_counter['tle'] += 1

        elif '[hhe]' in warning:
            warning_counter['hhe'] += 1

        elif '[hhw]' in warning:
            warning_counter['hhw'] += 1

        elif '[hlw]' in warning:
            warning_counter['hlw'] += 1

        elif '[hle]' in warning:
            warning_counter['hle'] += 1

        elif '[uvaw]' in warning:
            warning_counter['uvaw'] += 1

        elif '[uvbw]' in warning:
            warning_counter['uvbw'] += 1

        elif '[fsl]' in warning:
            warning_counter['fsl'] += 1

        elif '[dsl]' in warning:
            warning_counter['dsl'] += 1

    return warning_counter


def count_warnings(warnings) -> dict:
    warning_counter = {
        'dsxthe': 0,
        'dsxthw': 0,
        'dsxtle': 0,
        'dsxtlw': 0,
        'dsxhhe': 0,
        'dsxhhw': 0,
        'dsxhle': 0,
        'dsxhlw': 0,
        'dsxchf': 0,
        'dsxche': 0,
        'dsxchw': 0,
        'dsxuaw': 0,
        'dsxubw': 0,
        'dsxfsl': 0,
        'dsxdsl': 0
    }

    for warning in warnings:
        if warning.find('[cthf]'):
            warning_counter['cthf'] += 1
            break
        elif warning.find('[cthe]'):
            warning_counter['cthe'] += 1
        elif warning.find('[cthw]'):
            warning_counter['cthw'] += 1
        elif warning.find('[the]'):
            warning_counter['the'] += 1
        elif warning.find('[thw]'):
            warning_counter['thw'] += 1
        elif warning.find('[tlw]'):
            warning_counter['tlw'] += 1
        elif warning.find('[tle]'):
            warning_counter['tle'] += 1
        elif warning.find('[hhe]'):
            warning_counter['hhe'] += 1
        elif warning.find('[hhw]'):
            warning_counter['hhw'] += 1
        elif warning.find('[hlw]'):
            warning_counter['hlw'] += 1
        elif warning.find('[hle]'):
            warning_counter['hle'] += 1
        elif warning.find('[uvaw]'):
            warning_counter['uvaw'] += 1
        elif warning.find('[uvbw]'):
            warning_counter['uvbw'] += 1
        elif warning.find('[fsl]'):
            warning_counter['fsl'] += 1
        elif warning.find('[dsl]'):
            warning_counter['dsl'] += 1

    return warning_counter


example = [
    '[uvbw] lol',
    '[fsl] llll',
    '[cthw] it is hot'
]

print(count_warnings(example))
