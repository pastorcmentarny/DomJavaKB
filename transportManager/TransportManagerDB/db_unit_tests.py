import unittest

import storage_service
import tube_service


# normally I will split class by class bases but this is temporary database so I dump all unit tests here.
class DBUnitTests(unittest.TestCase):

    def test_get_station_data_for_none_return_empty_dict(self):
        # given
        expected_result = {}
        # when
        result = tube_service.get_station_data_for_(None)

        # then
        self.assertEqual(expected_result, result)

    def test_get_station_data_for_empty_return_empty_dict(self):
        # given
        expected_result = {}

        # when
        result = tube_service.get_station_data_for_('')

        # then
        self.assertEqual(expected_result, result)

    def test_get_station_data_for_wrong_name_return_empty_dict(self):
        # given
        expected_result = {}

        # when
        result = tube_service.get_station_data_for_('Aberystywyth')

        # then
        self.assertEqual(expected_result, result)

    def test_get_station_data_for_uxbridge_return_uxbridge_station_data(self):
        # given
        uxbridge_station_name = "Uxbridge"

        # when
        result = tube_service.get_station_data_for_(uxbridge_station_name)

        # then
        self.assertEqual(uxbridge_station_name, result["name"])

    def test_convert_to_none_if_none_as_string(self):
        # given
        expected_result = None

        # when
        result = storage_service.convert_to_none_if_none_or_null("none")

        # then
        self.assertEqual(expected_result, result)

    def test_convert_to_none_if_null_as_string(self):
        # given
        expected_result = None

        # when
        result = storage_service.convert_to_none_if_none_or_null("null")

        # then
        self.assertEqual(expected_result, result)

    def test_convert_to_none_if_none(self):
        # given
        expected_result = None

        # when
        result = storage_service.convert_to_none_if_none_or_null(None)

        # then
        self.assertEqual(expected_result, result)

    def test_convert_line_to_dict_acceptance_test(self):
        # given
        expected_result = {'name': "St. James's Park", 'status': 'V', 'passedDate': '2017-02-02',
                           'visitedDate': '2018-06-01', 'visitedThisYearDate': '2021-10-03'}

        # when
        result = storage_service.convert_line_to_dict("St. James's Park;;V;;2017-02-02;;2018-06-01;;2021-10-03")

        # then
        self.assertEqual(expected_result, result)

    def test_convert_dict_to_line_acceptance_test(self):
        # given
        expected_result = "St. James's Park;;V;;2017-02-02;;2018-06-01;;2021-10-03"
        input = {'name': "St. James's Park", 'status': 'V', 'passedDate': '2017-02-02', 'visitedDate': '2018-06-01',
                 'visitedThisYearDate': '2021-10-03'}

        # when
        result = storage_service.convert_dict_to_line(input)

        # then
        self.assertEqual(expected_result, result)

    def test_update_station_info_return_false_if_station_does_not_exits(self):
        # when
        station = {
            "name": "Wroclaw",
            "status": "V",
            "passedDate": "2999-99-99",
            "visitedDate": "2999-99-99",
            "visitedThisYearDate": "2999-99-99"
        }
        result = tube_service.update_station_info(station)

        # then
        self.assertFalse(result)

    def test_update_station_to_passed_return_false_if_station_does_not_exits(self):
        # when
        result = tube_service.update_station_to_passed("Wroclaw", "2999-99-99")

        # then
        self.assertFalse(result)


if __name__ == '__main__':
    unittest.main()
