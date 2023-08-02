import os
from datetime import date
from pathlib import Path

LINE_LENGTH = 80

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
TITLE_ANYTHING_ELSE = ' Anything else on my mind?'
QUESTION_TASK_DONE = "Task Done?"
QUESTION_WORK_TODO = 'Any work item to do'
QUESTION_GOALS = 'What goals/learning do I want to focus on?'
QUESTION_GREAT_DAY = 'What makes today a great day?'
QUESTION_THANKFULNESS = 'What am I grateful for today?'
QUESTION_WEEKLY_TASK_DONE = 'Number of weekly tasks done?'
QUESTION_WEEKLY_TOTAL_TASK = 'Number of total weekly tasks ?'

hr = '=' * LINE_LENGTH + '\n'

points = 0
total = 0
diary = f'{hr}Today is {date.today().strftime("%d %b %Y")}\n'


def morning_questions():
    print('Morning aim and thankfulness ( visualize the day)')
    thankful = input(QUESTION_THANKFULNESS)
    great_day = input(QUESTION_GREAT_DAY)
    focus = input(QUESTION_GOALS)
    work_to_do = input(QUESTION_WORK_TODO)
    morning_routine_data = f'Morning Plan:\n\n' \
                           f'{QUESTION_THANKFULNESS}\n' \
                           f'{thankful}\n\n' \
                           f'{QUESTION_GREAT_DAY}\n' \
                           f'{great_day}\n\n' \
                           f'{QUESTION_GOALS}\n' \
                           f'{focus}\n\n' \
                           f'{QUESTION_WORK_TODO}\n' \
                           f'{work_to_do}\n\n'
    print(morning_routine_data)
    store_to_file(morning_routine_data, "morning")


def add_points_for_yes_question(yes_answer: str, multiplier: int = 1):
    global points
    global total
    if (yes_answer.lower()) == 'y' or (yes_answer.lower() == 'yes'):
        points += multiplier
        total += multiplier
    else:
        total += 1


def add_points_for_no_question(no_answer: str, multiplier: int = 1):
    global points
    global total
    if (no_answer.lower() == 'n') or (no_answer.lower() == 'no'):
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
    global diary
    result = float(f'{(points / total * 100):0.2f}')
    if float(result) < 0:
        result = 0
    diary += f'Points: {points} of {total}. Grade: {grade(result)} ({result}%)\n'


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


def grade_alcohol(alcohol_amount) -> str:
    if alcohol_amount == 1:
        return " ~1 beer"
    if alcohol_amount == 2:
        return " some (~3 beers/1 glass wine)"
    if alcohol_amount == 3:
        return "a lot :/"
    if alcohol_amount == 4:
        return "too much :("

    return "Can't grade alcohol consumption"


def process_daily_routine_tasks():
    carry_on = True
    daily_task_counter = 0

    while carry_on:
        daily_task_counter = input('Daily routine tasks?')
        try:
            daily_task_counter = int(daily_task_counter)
            carry_on = False
        except Exception as e:
            print(f'Error: {daily_task_counter} {e}')
            return

    daily_task_total = input('total daily routine tasks for today ?')
    carry_on = True
    while carry_on:
        try:
            number = int(daily_task_total)
            add_points(number)
            carry_on = False
        except Exception as e:
            print(f'Error: {daily_task_total} {e}')
            return
    add_points_and_total(daily_task_counter, daily_task_total)
    add_diary("daily routine tasks", f'{daily_task_counter} of {daily_task_total}')


def process_tasks_done():
    carry_on = True
    while carry_on:
        tasks_done = input(TITLE_TASK_DONE)
        try:
            number = int(tasks_done)
            add_points(number)
            carry_on = False
        except Exception as e:
            print(f'Error: {tasks_done} {e}')
            return
        add_diary("Tasks done", tasks_done)


def process_run_distance():
    global points
    global total
    ran_distance = input(TITLE_RUN_DISTANCE)
    result = 'Unknown'
    try:
        number = int(ran_distance)

        if number == 0:
            total += 2
            result = 'No run'
        elif number == 1:
            points += 1
            total += 2
            result = 'Run up to 2km'
        elif number == 2:
            points += 2
            total += 2
            result = 'Run up to 5km'
        elif number == 3:
            points += 3
            total += 3
            result = 'Run up to 8.5km'
        elif number == 3:
            points += 3
            total += 3
            result = 'Run more than 8,5km'
        else:
            print(f'ARE YOU DRUNK ? Value should be between 0-4. Why you typed {number}?')
            result = 'none'
    except Exception as e:
        print(f'Error: {ran_distance} {e}')
        result = 'exception'
    add_diary("Run", result)


def process_j_polish():
    j_polish = input(TITLE_J_PL)
    add_points_for_yes_question(j_polish)
    add_diary("Is J answered practice", yes(j_polish))


def process_j_10_math():
    j_10_math_questions = input(TITLE_10_MATH)
    add_points_for_yes_question(j_10_math_questions)
    add_diary("Is J answered 10 math question", yes(j_10_math_questions))


def process_spending_x():
    spend_time_with_x = input(TITLE_TIME_X)
    add_points_for_yes_question(spend_time_with_x)
    add_diary("Spend enough time with X", yes(spend_time_with_x))


def process_spending_time_j():
    spend_time_with_j = input(TITLE_TIME_J)
    add_points_for_yes_question(spend_time_with_j)
    add_diary("Spend enough time with J", yes(spend_time_with_j))


def process_10k_steps():
    steps = input(TITLE_10K)
    if steps == 'y':
        steps = input(TITLE_16K)
        add_points_for_yes_question(steps, 3)
        add_diary("16k Steps", yes(steps))
    else:
        add_points_for_yes_question(steps)
        add_diary("10k Steps", yes(steps))


def process_coding_one_hour():
    coding_one_hour = input(TITLE_CODING)
    add_points_for_yes_question(coding_one_hour)
    add_diary("Code for 1hour", yes(coding_one_hour))


def process_drink_alcohol():
    drink_alcohol = input(TITLE_DRINK_ALCOHOL)
    add_points_for_no_question(drink_alcohol)
    if (drink_alcohol.lower() == 'y') or (drink_alcohol.lower() == 'yes'):
        how_much_alcohol = input(TITLE_HOW_MUCH_ALCOHOL)
        carry_on = True
        while carry_on:
            try:
                number = int(how_much_alcohol)
                add_negative_points_for_alcohol(number)
                how_much_alcohol = number
                carry_on = False
            except Exception as exception:
                print(f'Error: {how_much_alcohol} {exception}')
                return

        alcohol_with_grade = f'{yes(drink_alcohol)}. {grade_alcohol(int(how_much_alcohol))}'
        add_diary("Drink Alcohol", alcohol_with_grade)


def process_seven_hours_sentence():
    sleep_seven_hours = input(TITLE_SLEEP_SEVEN_HOURS)
    add_points_for_yes_question(sleep_seven_hours)
    add_diary("Sleep 7 hours", yes(sleep_seven_hours))


def process_eat_too_much_sentence():
    eat_too_much = input(TITLE_EAT_TOO_MUCH)
    add_points_for_yes_question(eat_too_much)
    add_diary("Eat too much", no(eat_too_much))


def process_eat_high_carbs_sentence():
    eat_high_carbs = input(TITLE_EAT_CARBS)
    add_points_for_yes_question(eat_high_carbs)
    add_diary("Eat high carbs", yes(eat_high_carbs))


def process_eat_in_window_sentence():
    eat_in_window = input(TITLE_EAT_IN_WINDOW)
    add_points_for_yes_question(eat_in_window)
    add_diary("Eat in 6hr window", yes(eat_in_window))


def process_one_word_sentence():
    one_word = input(TITLE_TODAY_IN_ONE_WORD)
    add_diary("In one word", one_word)


def yes(result: str):
    if result.lower() == result:
        return "Yes"
    return "No"


def no(result: str):
    if result.lower() == result:
        return "No"
    return "Yes"


def add_diary(title: str, answer: str):
    global diary
    title += "?"
    diary += title.ljust(36, ' ') + ":" + str(answer).rjust(6, ' ') + '\n'


def add_line_break():
    global diary
    diary += hr


def display_diary():
    global diary
    print(diary)


def store_to_file(content, file_name):
    specified_data = date.today()
    year = specified_data.year
    month = specified_data.month
    day = specified_data.day

    path = Path(f"e:/Dropbox/diary/{year}/{month:02d}/{day:02d}/")
    if not os.path.exists(path):
        Path(f"e:/Dropbox/diary/{year}/{month:02d}/{day:02d}/").mkdir(parents=True, exist_ok=True)
    file_path = str(path) + f"/{file_name}.txt"
    try:
        with open(file_path, 'w+', encoding='utf-8') as diary_file:
            diary_file.writelines(content)
    except Exception as exception:
        print(exception)


def generate_daily_diary():
    global diary
    process_one_word_sentence()
    process_tasks_done()
    process_daily_routine_tasks()
    add_line_break()
    process_eat_in_window_sentence()
    process_eat_high_carbs_sentence()
    process_eat_too_much_sentence()
    process_seven_hours_sentence()
    process_drink_alcohol()
    process_coding_one_hour()
    process_10k_steps()
    process_spending_time_j()
    process_spending_x()
    process_j_10_math()
    process_j_polish()
    process_run_distance()
    add_diary("Progres on goals", input(TITLE_DOM_GOALS))
    add_diary("Other(learnt,good things)", input(TITLE_NOTES))
    add_diary("Things that worries me", input(TITLE_WORRIES))
    add_diary("3 action items for tomorrow are", input(TITLE_TOMORROW))
    get_score_with_grade()
    add_line_break()
    add_diary("Anything else on my mind?", input(TITLE_ANYTHING_ELSE))
    add_line_break()
    display_diary()
    store_to_file(diary, "diary")


def process_simple_question(title: str):
    return f'{title}?\n\t {input(f"{title}?  ")}\n\n'


def process_weekly_points_from_tasks():
    not_completed = True
    while not_completed:
        try:
            task_done = int(input(QUESTION_TASK_DONE))
            weekly_point = int(input(QUESTION_WEEKLY_TASK_DONE))
            weekly_total = int(input(QUESTION_WEEKLY_TOTAL_TASK))
            final_score = float(f'{(weekly_point + task_done) / (weekly_total + task_done) * 100:0.2f}')
            weekly_grade = grade(final_score)
            not_completed = False
            return f'I did {weekly_point} of {weekly_total} weekly tasks and I have done {task_done} of other tasks. It gives {final_score}% ({weekly_grade}).\n'
        except Exception as exception:
            print(f'Invalid input due to {exception}')


def generate_weekly_diary():
    weekly = f'{hr}\nWeekly report generated at {date.today().strftime("%d %b %Y")}\n{hr}\n'
    weekly += process_weekly_points_from_tasks()
    weekly += process_simple_question("What goals do I work on")
    weekly += process_simple_question("What went well")
    weekly += process_simple_question("What can I do next week better to achieve my goals and make the future better")
    weekly += process_simple_question("Did I do best to keep my body and brain in best possible condition")
    weekly += process_simple_question(
        "What worries me and makes me unhappy? How can I eliminate habits that do not help me that I should remove")
    weekly += process_simple_question("What worked well and what didn’t work well in our family this weekend")
    weekly += process_simple_question("What is my focus NEXT WEEK ? 3 core things")
    weekly += process_simple_question("(T) One thing, have you done that has worked well?")
    weekly += process_simple_question("(T) One thing, that you are going to work?")
    weekly += hr
    print(weekly)
    store_to_file(weekly, "weekly")


def generate_monthly_summary():
    monthly = f'{hr}\nWeekly report generated at {date.today().strftime("%B %Y")}\n{hr}\n'
    monthly += process_simple_question("In one word summary for Health")
    monthly += process_simple_question("In one word summary for Family")
    monthly += process_simple_question("In one word summary for Work")
    monthly += process_simple_question("In one word summary for Walk/Run")
    monthly += process_simple_question("In one word summary for Hobby ")
    monthly += process_simple_question("What goals did I finish")
    monthly += process_simple_question("What goals do I work on")
    monthly += process_simple_question("What can I do next week better to achieve my goals and make the future better")
    monthly += process_simple_question("What problems do I encounter? How many I solve")
    monthly += process_simple_question("Did I learn enough new things")
    monthly += process_simple_question("Did I develop new friendships and deepen old ones")
    monthly += process_simple_question("On what day I did most of my daily tasks")
    monthly += process_simple_question("On what day I did most tasks")
    monthly += process_simple_question("Any other comments")
    monthly += hr
    print(monthly)
    store_to_file(monthly, "monthly")


def menu():

    running = True
    while running:
        try:
            choice = int(input("Select:\n"
                               "[1. Morning plans]\n"
                               "[2.Generate daily diary]\n"
                               "[3. Weekly report]\n"
                               "[4.Monthly report]\n"
                               "[0. Exit]\n"))
            if choice == 0:
                print("Goodbye!")
            elif choice == 1:
                print('Go to Morning plans..')
                morning_questions()
            elif choice == 2:
                print('Go to daily diary..')
                generate_daily_diary()
            elif choice == 3:
                print('Go to weekly diary..')
                generate_weekly_diary()
            elif choice == 4:
                print('Go to monthly summary diary..')
                generate_monthly_summary()
            else:
                print("Invalid number")
                raise Exception("Invalid number")
            running = False
        except Exception as exception:
            print(f"Error:{exception}")


if __name__ == '__main__':
    menu()
