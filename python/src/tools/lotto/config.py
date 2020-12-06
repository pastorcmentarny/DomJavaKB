import platform

# SETTINGS
settings = {
    'debug_mode': False,
    'detailed_mode' : False,
    'open_page': False
}


def display_warning_message(path):
    print(
        "\n\n WARNING! \n\n If you see all result are 0s then format all results in: \n\t " + path +
        ".\n\t\t I need improve this in the future.Apologize from Dominik in the past. \n\n")


def get_project_path(file: str):
    device = {
        'DomL5': 'D:/Projects/DomJavaKB/data/lotto/',
        'DOM-DESKTOP': 'B:/GitHub/DomJavaKB/data/lotto/',
    }
    return f'{device[platform.node()]}{file}'
