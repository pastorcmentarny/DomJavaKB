import unittest

from src.exercises.win95key import win95_oem_key_validator as validator


class Win95OemKeyValidatorTestCase(unittest.TestCase):

    def test_is_leap_year_should_return_for_2000(self):
        # when
        result = validator.is_leap_year_for_years_between_1982_2040(0)

        # then
        self.assertTrue(result)

    def test_is_leap_year_should_return_for_2019(self):
        # when
        result = validator.is_leap_year_for_years_between_1982_2040(19)

        # then
        self.assertFalse(result)

    def test_is_leap_year_should_return_for_2020(self):
        # when
        result = validator.is_leap_year_for_years_between_1982_2040(20)

        # then
        self.assertTrue(result)

    def test_valid_key(self):
        # given
        scale_params_list = [['15706-OEM-0199736-84265', 'valid day'],
                             ['36620-OEM-0199736-84265', 'valid day in leap year'],
                             ['36620-OEM-0199736-84265', 'valid day in year 2000']
                             ]

        for invalid_key, invalid_reason in scale_params_list:
            with self.subTest(msg="Checking to valid key {}  for case: {} ".format(invalid_key, invalid_reason)):
                # when
                result = validator.is_key_valid(invalid_key)

                # then
                self.assertTrue(result)

    def test_invalid_key(self):
        # given
        scale_params_list = [['36706-OEM-0199736-84265', 'invalid day'],
                             ['15721-OEM-0199736-84265', 'invalid year'],
                             ['15A06-OEM-0199736-8426A', 'non numeric character in day section'],
                             ['157A6-OEM-0199736-8426A', 'non numeric character in year section'],
                             ['157006-OEM-0199736-84265', 'too many characters in day-year section'],
                             ['5706-OEM-0199736-84265', 'not enough characters in day-year section'],
                             ['36619-OEM-0199736-84265', 'invalid day for non leap year'],
                             ['15721-OEM-1099736-84265', 'do not start with zero'],
                             ['15721-OEM-0099737-84265', 'end with seven'],
                             ['15706-OEM-0A99746-84265', 'non numeric character in 3rd section (division by 7)'],
                             ['15706-OEM-0199736-842651', 'too many characters in last section'],
                             ['15706-OEM-0199736-8426', 'not enough characters in last section'],
                             ['15706-OEM-0199736-8426A', 'non numeric character in last section'],
                             ['15706-0199736-84265', 'too few sections'],
                             ['15706-UFO-0199736-84265', 'not a OEM'],
                             ['15706-0199736-OEM-84265', 'OEM in wrong place'],
                             ['15706-OEM-0199736-8426-100', 'too many sections'],
                             [None, 'key is None'],
                             ['', 'key is empty'],
                             ]

        for invalid_key, invalid_reason in scale_params_list:
            with self.subTest(msg="Checking to invalid key {}  for case: {} ".format(invalid_key, invalid_reason)):
                # when
                result = validator.is_key_valid(invalid_key)

                # then
                self.assertFalse(result)
