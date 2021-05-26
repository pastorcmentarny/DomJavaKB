import unittest

from src.tools.trading import calculate_daily_limit


class MyTestCase(unittest.TestCase):
    def test_test_trading_calculate_daily_limit_acceptance_test(self):
        # given
        expected_result = """With your balance £2000.0.
You aim is to get profit of £22.00 and dont play more if you reach £60.00. Your weekly profit should be between £22.00 abd £112.00.  
Your max total stop lose must be £50.00.Your monthly lost allowance is £250.
In year if you stick to 1% gain per day it should be: £23826.05"""

        calculate_daily_limit.balance_today = 200000
        calculate_daily_limit.balance_monday = 200000

        # when
        result = calculate_daily_limit.calculate_all()

        # then
        self.assertEqual(expected_result, result)


if __name__ == '__main__':
    unittest.main()
