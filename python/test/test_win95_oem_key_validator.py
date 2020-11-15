import unittest

from src.exercises.win95key import win95_oem_key_validator as validator


class Win95OemKeyValidatorTestCase(unittest.TestCase):
    def test_key_is_valid(self):
        # given
        valid_key = '15706-OEM-0199736-84265'

        # when
        result = validator.is_key_valid(valid_key)

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
                             ['36620-OEM-0199736-84265', 'invalid day for non leap year'],
                             ['15721-OEM-1099736-84265', 'do not start with zero'],
                             ['15721-OEM-0099737-84265', 'end with seven'],
                             ['15706-OEM-0A99746-84265', 'non numeric character in div by 7 section'],
                             ['15706-OEM-0199736-842651', 'too many characters in last section'],
                             ['15706-OEM-0199736-8426', 'not enough characters in last section'],
                             ['15706-OEM-0199736-8426A', 'non numeric character in last section'],
                             ['15706-0199736-84265', 'lack of OEM'],
                             ['15706-UFO-0199736-84265', 'not a OEM'],
                             ['15706-0199736-OEM-84265', 'OEM in wrong place'],
                             ['15706-OEM-0199736-8426-100', 'extra section'],
                             [None, 'key is None'],
                             ['', 'key is empty'],
                             ]

        for invalid_key, invalid_reason in scale_params_list:
            with self.subTest(msg="Checking to invalid key {}  for case: {} ".format(invalid_key, invalid_reason)):
                # when
                result = validator.is_key_valid(invalid_key)

                # then
                self.assertFalse(result)
