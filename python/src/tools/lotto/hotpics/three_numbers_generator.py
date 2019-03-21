# collect all possible triple combination from all games
# find out which numbers didn't play in last 10 draws
# pickup triple that haven't been played yet,
# discard most and least drawn number pick .. 2 second most/least played number and 1 random number from pool  has max number bigger than 49
# display all result
import logging
import requests
import sys

from src.tools.lotto import config

sys.path.insert(0, '../utils')

import draws_downloader

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.path["base"] + 'log.txt')

lotto_hotpicks_url = 'https://www.national-lottery.co.uk/results/lotto-hotpicks/draw-history/csv'
path = config.path["base"] + 'lotto-hotpicks-draws.csv'
all_draws = config.path["base"] + 'lotto-hotpicks-all-draws.csv'
logging.debug('downloading  data from ' + lotto_hotpicks_url)
response = requests.get(lotto_hotpicks_url)
logging.debug('download complete with response ' + str(response.status_code))

data = draws_downloader.get_draws_for(lotto_hotpicks_url, path)
draws_downloader.update_all_draws_v2(data, all_draws)
