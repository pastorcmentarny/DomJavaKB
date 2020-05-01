import json


def config() -> dict:
    path = 'D:/GitHub/DomJavaKB/python/src/tools/chinese/today/cfg.json'  # TODO
    with open(path, 'r') as email_config:
        return json.load(email_config)
