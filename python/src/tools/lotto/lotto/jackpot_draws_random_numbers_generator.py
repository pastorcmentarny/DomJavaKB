import random

from src.tools.lotto import config
from src.tools.lotto.tools import draws_manager
from src.tools.lotto.utils import lotto_utils
from src.tools.lotto.utils.output import draw_title

# ======== settings ========
debug_mode = config.settings['debug_mode']
excluded_custom_numbers = []
# ======== -------- ========

recent_draws_data = draws_manager.get_recent_draws_for_lotto_and_hotpicks()
all_draws_list = draws_manager.get_all_draws_for_lotto()


def generate_random_draws_for_jackpot():
    numbers = []
    excluded = []

    # exclude some numbers
    for line in recent_draws_data[0: 2]:
        for number in range(1, lotto_utils.get_last(6)):
            excluded.append(int(line[number]))
    for excluded_custom_number in excluded_custom_numbers:
        excluded.append(excluded_custom_number)
    excluded = list(set(excluded))  # clean duplicated numbers

    print_numbers(excluded, "Excluded numbers")

    # shuffle numbers
    for number in range(1, 60):
        if number not in excluded:
            numbers.append(number)

    for number in range(1, 1770):
        random.shuffle(numbers)
    print_numbers(excluded, "Shuffled numbers")

    # display draws
    count = 1
    draw = []
    draw_title('Draws')
    for number in numbers:
        draw.append(number)
        count += 1
        if count == 7:
            count = 1
            print(sorted(draw))
            lotto_utils.check_wins_in_the_past_for_lotto(draw, all_draws_list)
            draw.clear()


def print_numbers(excluded: list, title: str):
    if debug_mode:
        draw_title(title)
        print(excluded)


def is_photo_mostly_black(file, with_summary: bool = True):
    global deleted
    global ignored
    global errors
    if os.path.splitext(file)[-1].lower() != ".jpg":
        logger.warning('{} is not a photo. Ignore it.'.format(file))
        ignored += 1
        return

    im = Image.open(file)  # Can be many different formats.
    total_pixels = im.width * im.height
    pix = im.load()

    counter = []

    for x in range(0, im.width):
        for y in range(0, im.height):
            counter.append(pix[x, y])

    result = Counter(counter)
    dark_pixels = 0
    for d in result.items():
        if check_is_pixel_too_dark(d[0]):
            dark_pixels += d[1]
    too_dark = dark_pixels / total_pixels * 100
    if too_dark > 95:
        logger.info(file + 'is too dark and need to be deleted.')
        try:
            os.remove(file)
            if os.path.exists(file):
                logger.warning('{} NOT deleted.'.format(file))
            else:
                logger.info("{} deleted.".format(file))
                deleted += 1
        except Exception as e:
            logger.error('Unable to process {} file due to {}'.format(file, e))
            errors += 1
    if with_summary:
        logger.info(str(dark_pixels) + ' out of ' + str(total_pixels) + ' is dark. (' + str(too_dark) + '%)')


def check_is_pixel_too_dark(pixel) -> bool:
    dark = 6
    x, y, z = pixel
    return x <= dark and y <= dark and z <= dark


if __name__ == '__main__':
    generate_random_draws_for_jackpot()
