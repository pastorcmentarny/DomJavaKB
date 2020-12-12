import unittest

from src.tools.lotto.euromillions import euromillions_analysis


class EuromillionsAnalysisTestCase(unittest.TestCase):
    twenty_draws = [['1379', '08-Dec-2020', '1', '4', '21', '24', '46', '2', '12'],
                    ['1378', '04-Dec-2020', '14', '20', '27', '34', '38', '1', '11'],
                    ['1377', '01-Dec-2020', '14', '20', '29', '47', '49', '4', '12'],
                    ['1376', '27-Nov-2020', '2', '5', '8', '14', '16', '8', '9'],
                    ['1375', '24-Nov-2020', '25', '33', '38', '42', '50', '8', '12'],
                    ['1374', '20-Nov-2020', '28', '29', '39', '48', '50', '5', '7'],
                    ['1373', '17-Nov-2020', '16', '19', '25', '30', '44', '2', '6'],
                    ['1372', '13-Nov-2020', '1', '5', '17', '28', '31', '1', '10'],
                    ['1371', '10-Nov-2020', '3', '19', '29', '32', '38', '5', '12'],
                    ['1370', '06-Nov-2020', '7', '12', '37', '40', '50', '1', '2'],
                    ['1369', '03-Nov-2020', '5', '7', '18', '20', '30', '6', '7'],
                    ['1368', '30-Oct-2020', '12', '16', '20', '21', '28', '3', '9'],
                    ['1367', '27-Oct-2020', '13', '15', '28', '32', '44', '3', '12'],
                    ['1366', '23-Oct-2020', '10', '15', '19', '21', '23', '3', '12'],
                    ['1365', '20-Oct-2020', '5', '6', '15', '37', '42', '3', '4'],
                    ['1364', '16-Oct-2020', '15', '33', '38', '40', '50', '3', '6'],
                    ['1363', '13-Oct-2020', '5', '14', '38', '41', '46', '1', '10'],
                    ['1362', '09-Oct-2020', '11', '15', '35', '41', '50', '5', '8'],
                    ['1361', '06-Oct-2020', '4', '21', '36', '41', '47', '9', '11'],
                    ['1360', '02-Oct-2020', '6', '12', '15', '40', '45', '3', '9']]

    def test_count_ball_played_in_games_acceptance_test(self):
        expected_result = {1: 2, 2: 1, 3: 1, 4: 1, 5: 2, 6: 0, 7: 1, 8: 1, 9: 0, 10: 0, 11: 0, 12: 1, 13: 0, 14: 3,
                           15: 0, 16: 2, 17: 1, 18: 0, 19: 2, 20: 2, 21: 1, 22: 0, 23: 0, 24: 1, 25: 2, 26: 0, 27: 1,
                           28: 2, 29: 3, 30: 1, 31: 1, 32: 1, 33: 1, 34: 1, 35: 0, 36: 0, 37: 1, 38: 3, 39: 1, 40: 1,
                           41: 0, 42: 1, 43: 0, 44: 1, 45: 0, 46: 1, 47: 1, 48: 1, 49: 1, 50: 3}

        # when
        result = euromillions_analysis.count_ball_played_in_games(self.twenty_draws[0:10])

        # debug
        print(result)

        # then
        self.assertEqual(expected_result.get(12), result.get(12))
        self.assertEqual(expected_result.get(50), result.get(50))
        self.assertEqual(expected_result.get(14), result.get(14))
        self.assertEqual(expected_result.get(1), result.get(1))
        self.assertEqual(expected_result, result)

    def test_count_ball_played_between_games_acceptance_test_with_single_hit(self):
        # given
        expected_result = {1: 1, 2: 1, 3: 0, 4: 1, 5: 1, 6: 1, 7: 0, 8: 0, 9: 0, 10: 0, 99: 0}

        # when
        result = euromillions_analysis.count_ball_played_between_games(50, self.twenty_draws)

        # debug
        print(result)

        # then
        self.assertEqual(expected_result, result)

    def test_count_ball_played_between_games_acceptance_test_with_first_and_99_hit(self):
        # given
        expected_result = {1: 1, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 0, 8: 0, 9: 0, 10: 0, 99: 1}

        # when
        result = euromillions_analysis.count_ball_played_between_games(4, self.twenty_draws)

        # debug
        print(result)

        # then
        self.assertEqual(expected_result, result)

    def test_count_ball_played_between_games_acceptance_test_with_multi_hit(self):
        # given
        expected_result = {1: 2, 2: 1, 3: 0, 4: 0, 5: 0, 6: 0, 7: 0, 8: 1, 9: 0, 10: 0, 99: 0}

        # when
        result = euromillions_analysis.count_ball_played_between_games(20, self.twenty_draws)

        # debug
        print(result)

        # then
        self.assertEqual(expected_result, result)
