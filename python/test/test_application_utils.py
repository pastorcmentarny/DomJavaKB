import unittest

from tools.chinese.today import application_utils as app_utils


class ApplicationUtilsTests(unittest.TestCase):

    def test_get_year_in_chinese(self):
        self.assertEqual(app_utils.get_year_in_chinese(), '二零二零')

    def test_get_chinese_number_for_0(self):
        self.assertEqual(app_utils.get_distance_from_steps(0), '0.0')

    def test_get_temp_from_internet(self):
        # when
        result = app_utils.get_temp_from_internet()

        # debug
        print(result)

        # then
        self.assertIsNot('', result)
