from datetime import date

TITLE_TASK_DONE = 'How many task have I done?'
TITLE_RUN_DISTANCE = 'How much I ran ?[0. no] [1. 2km] [2. 2.5-4.99km] [3. 5km-8.5km] 4. More than 8.5km]?'
TITLE_J_PL = 'Is J practice Polish?'
TITLE_10_MATH = 'Is J answered 10 math question?'
TITLE_TIME_X = 'Spend enough time with X?'
TITLE_TIME_J = 'Spend enough time with J?'
TITLE_16K = '16k steps?'
TITLE_10K = '10k steps?'
TITLE_CODING = 'Coding 1 hour?'
TITLE_DRINK_ALCOHOL = 'Did you drink Alcohol?'
TITLE_HOW_MUCH_ALCOHOL = 'How much ? [1. (~1 beer)] [2. (~3 beers/1 glass)] [3. a lot] [4. too much?]'
TITLE_SLEEP_SEVEN_HOURS = 'Sleep 7 hours?'
TITLE_EAT_TOO_MUCH = 'Eat too much?'
TITLE_EAT_CARBS = 'Eat high carbs?'
TITLE_EAT_IN_WINDOW = 'Eat in 6hr window?'
TITLE_TOMORROW = 'What is my focus for tomorrow? 3 core things?'
TITLE_NOTES = 'What good have I done today? Did I learn anything?Anything else?'
TITLE_DOM_GOALS = 'Did I make progress towards goals (Dom90, Craftsmanship, Trading)?'
TITLE_TODAY_IN_ONE_WORD = "How you describe today in one world?"
TITLE_WORRIES = 'What worries me right now?'

QUESTION_WORK_TODO = 'Any work item to do'
QUESTION_GOALS = 'What goals/learning do I want to focus on?'
QUESTION_GREAT_DAY = 'What makes today a great day?'
QUESTION_THANKFULNESS = 'What am I grateful for today?'

# morning
# day report
# weekly report
# monthly report (including total points and performance .. best and worst day and summary)

points = 0
total = 0


def morning_questions():
    print('Morning aim and thankfulness ( visualize the day)')
    thankful = input(QUESTION_THANKFULNESS)
    great_day = input(QUESTION_GREAT_DAY)
    focus = input(QUESTION_GOALS)
    work_to_do = input(QUESTION_WORK_TODO)
    return f'Morning Plan:\n\n{QUESTION_THANKFULNESS}\n{thankful}\n\n{QUESTION_GREAT_DAY}\n{great_day}\n\n{QUESTION_GOALS}\n{focus}\n\n{QUESTION_WORK_TODO}\n{work_to_do}\n\n'


def add_points_for_yes_question(yes: str, multiplier: int = 1):
    global points
    global total
    if (yes.lower()) == 'y' or (yes.lower() == 'yes'):
        points += multiplier
        total += multiplier
    else:
        total += 1


def add_points_for_no_question(no: str, multiplier: int = 1):
    global points
    global total
    if (no.lower() == 'n') or (no.lower() == 'no'):
        points += multiplier
        total += multiplier
    else:
        total += 1


def add_points(multiplier: int = 1):
    global points
    global total
    points += multiplier
    total += multiplier


def get_score_with_grade():
    global points
    global total
    result = float(f'{(points / total * 100):0.2f}')
    if float(result) < 0:
        result = 0
    return f'Points: {points} of {total}. Grade: {grade(result)} ({result}%)'


def grade(final_score: float):
    if final_score >= 99:
        return "Perfect"
    if final_score > 95:
        return "Great"
    if final_score > 90:
        return "Very Good"
    if final_score > 84:
        return "Good"
    if final_score > 73:
        return "OK"
    if final_score > 62:
        return "Could be better"
    if final_score > 51:
        return "Poor"
    return "Unproductive :(("


def add_negative_points_for_alcohol(number):
    global points
    global total
    points -= number
    total += number * 2


def add_points_and_total(daily_task_counter, daily_task_total):
    global points
    global total
    daily_task_counter = int(daily_task_counter)
    daily_task_total = int(daily_task_total)

    if daily_task_counter > daily_task_total:
        print(
            f'YOU MESSED UP add_points_and_total total task {daily_task_total} is bigger than daily task {daily_task_counter}')
    else:
        points += daily_task_counter
        total += daily_task_total


def grade_alcohol(amount: int) ->str:
    if amount == 1:
        return " ~1 beer"
    if amount == 2:
        return " some (~3 beers/1 glass wine)"
    if amount == 3:
        return "a lot :/"
    if amount == 4:
        return "too much :("

    return "Can't grade alcohol consumption"


def process_daily_routine_tasks():
    daily_task_counter = input('Daily routine tasks?')
    try:
        daily_task_counter = int(daily_task_counter)
    except Exception as e:
        print(f'Error: {daily_task_counter} {e}')
        return

    daily_task_total = input('total daily routine tasks for today ?')
    try:
        number = int(daily_task_total)
        add_points(number)
    except Exception as e:
        print(f'Error: {daily_task_total} {e}')
        return
    add_points_and_total(daily_task_counter, daily_task_total)
    return f'{daily_task_counter} of {daily_task_total}'


def process_tasks_done():
    tasks_done = input(TITLE_TASK_DONE)
    try:
        number = int(tasks_done)
        add_points(number)
    except Exception as e:
        print(f'Error: {tasks_done} {e}')
        return
    return tasks_done


def process_run_distance():
    global points
    global total
    ran_distance = input(TITLE_RUN_DISTANCE)
    try:
        number = int(ran_distance)

        if number == 0:
            total += 2
            return 'No run'
        elif number == 1:
            points += 1
            total += 2
            return 'Run up to 2km'
        elif number == 2:
            points += 2
            total += 2
            return 'Run up to 5km'
        elif number == 3:
            points += 3
            total += 3
            return 'Run up to 8.5km'
        elif number == 3:
            points += 3
            total += 3
            return 'Run more than 8,5km'
        elif number > 4:
            print(f'ARE YOU DRUNK ? Value should be between 0-4. Why you typed {number}?')
        else:
            points += number
            total += number
        # r
    except Exception as e:
        print(f'Error: {ran_distance} {e}')
        return 'error'


def process_j_polish():
    j_polish = input(TITLE_J_PL)
    add_points_for_yes_question(j_polish)
    return j_polish


def process_j_10_math():
    j_10_math_questions = input(TITLE_10_MATH)
    add_points_for_yes_question(j_10_math_questions)
    return j_10_math_questions


def process_spending_x():
    spend_time_with_x = input(TITLE_TIME_X)
    add_points_for_yes_question(spend_time_with_x)
    return spend_time_with_x


def process_spending_time_j():
    spend_time_with_j = input(TITLE_TIME_J)
    add_points_for_yes_question(spend_time_with_j)
    return spend_time_with_j


def process_10k_steps():
    ten_thousand_steps = input(TITLE_10K)
    if ten_thousand_steps == 'y':
        ten_thousand_steps = input(TITLE_16K)
        add_points_for_yes_question(ten_thousand_steps, 3)
    else:
        add_points_for_yes_question(ten_thousand_steps)
    return ten_thousand_steps


def process_coding_one_hour():
    coding_one_hour = input(TITLE_CODING)
    add_points_for_yes_question(coding_one_hour)
    return coding_one_hour


def process_drink_alcohol():
    drink_alcohol = input(TITLE_DRINK_ALCOHOL)
    add_points_for_no_question(drink_alcohol)

    how_much_alcohol = input(TITLE_HOW_MUCH_ALCOHOL)
    try:
        # TODO improve it
        number = int(how_much_alcohol)
        add_negative_points_for_alcohol(number)
        how_much_alcohol = number
    except Exception as e:
        print(f'Error: {how_much_alcohol} {e}')
        return
    return f'{yes(drink_alcohol)}. {grade_alcohol(int(how_much_alcohol))}'


def process_seven_hours_sentence():
    sleep_seven_hours = input(TITLE_SLEEP_SEVEN_HOURS)
    add_points_for_yes_question(sleep_seven_hours)
    return sleep_seven_hours


def process_eat_too_much_sentence():
    eat_too_much = input(TITLE_EAT_TOO_MUCH)
    add_points_for_yes_question(eat_too_much)
    return eat_too_much


def process_eat_high_carbs_sentence():
    eat_high_carbs = input(TITLE_EAT_CARBS)
    add_points_for_yes_question(eat_high_carbs)
    return eat_high_carbs


def process_eat_in_window_sentence():
    eat_in_window = add_eat_in_window_sentence()
    return eat_in_window


def process_one_word_sentence():
    return input(TITLE_TODAY_IN_ONE_WORD)


def add_eat_in_window_sentence():
    eat_in_window = input(TITLE_EAT_IN_WINDOW)
    add_points_for_yes_question(eat_in_window)
    return eat_in_window


def yes(result: str):
    if result.lower() == result:
        return "Yes"
    return "No"


def no(result: str):
    if result.lower() == result:
        return "No"
    return "Yes"


def display_line(title: str, answer: str):
    title += "?"
    return title.ljust(32, ' ') + ":" + str(answer).rjust(6, ' ') + '\n'


def generate_daily_diary():
    diary = ""
    date_sentence = f'Today is {date.today().strftime("%d %b %Y")}\n'
    diary += date_sentence

    one_word = process_one_word_sentence()
    eat_in_window = process_eat_in_window_sentence()
    eat_high_carbs = process_eat_high_carbs_sentence()
    eat_too_much = process_eat_too_much_sentence()
    sleep_seven_hours = process_seven_hours_sentence()
    alcohol_with_grade = process_drink_alcohol()
    coding_one_hour = process_coding_one_hour()
    ten_thousand_steps = process_10k_steps()
    spend_time_with_j = process_spending_time_j()
    spend_time_with_x = process_spending_x()
    j_10_math_questions = process_j_10_math()
    j_polish = process_j_polish()
    ran_distance = process_run_distance()
    tasks_done = process_tasks_done()
    daily_counter_and_total = process_daily_routine_tasks()

    dom_goals = input(TITLE_DOM_GOALS)
    notes = input(TITLE_NOTES)
    worries = input(TITLE_WORRIES)
    tomorrow = input(TITLE_TOMORROW)
    hr = '=' * 50 + '\n'

    diary += f'{hr}' \
             f'{display_line("In one word", one_word)}' \
             f'{display_line("Daily routine tasks", daily_counter_and_total)}' \
             f'{display_line("Tasks done", tasks_done)}' \
             f'{display_line("Sleep 7 hours", yes(sleep_seven_hours))}' \
             f'{display_line("Eat in 6hr window", yes(eat_in_window))}' \
             f'{display_line("Eat high carbs", yes(eat_high_carbs))}' \
             f'{display_line("Eat too much", no(eat_too_much))}' \
             f'{display_line("Drink Alcohol", alcohol_with_grade)}' \
             f'{display_line("Code for 1hour", yes(coding_one_hour))}' \
             f'{display_line("10k Steps", yes(ten_thousand_steps))}' \
             f'{display_line("Run", ran_distance)}' \
             f'{display_line("Spend enough time with J", yes(spend_time_with_j))}' \
             f'{display_line("Spend enough time with X", yes(spend_time_with_x))}' \
             f'{display_line("Is J answered 10 math question", yes(j_10_math_questions))}' \
             f'{display_line("Is J answered practice", yes(j_polish))}' \
             f'{display_line("Progres on goals", dom_goals)}' \
             f'{display_line("Other(learnt,good things)", notes)}' \
             f'{display_line("Things that worries me", worries)}' \
             f'{display_line("3 action items for tomorrow are", tomorrow)}' \
             f'{get_score_with_grade()}\n' \
             f'{hr}'
    print(diary)


if __name__ == '__main__':
    generate_daily_diary()
