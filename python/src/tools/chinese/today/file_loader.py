import json


def config() -> dict:
    path = 'cfg.json'
    with open(path, 'r') as email_config:
        return json.load(email_config)
