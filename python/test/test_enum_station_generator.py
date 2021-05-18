import unittest

from src.tools.text import enum_station_generator


class EnumStationGeneratorTests(unittest.TestCase):

    def test_generator_for_and(self):
        # given
        station = "Caledonian Road & Barnsbury"
        expected_result = '''CALEDONIAN_ROAD_AND_BARNSBURY("Caledonian Road & Barnsbury",OVERGROUND),'''

        # when
        result = enum_station_generator.convert_to_enum(station)

        # then
        self.assertEqual(result, expected_result)

    def test_generator_for_bracket(self):
        # given
        station = "Kensington (Olympia)"
        expected_result = '''KENSINGTON__OLYMPIA_("Kensington (Olympia)",OVERGROUND),'''

        # when
        result = enum_station_generator.convert_to_enum(station)

        # then
        self.assertEqual(result, expected_result)

    def test_generator_for_apostrophe(self):
        # given
        station = "Walthamstow Queen's Road"
        expected_result = '''WALTHAMSTOW_QUEENS_ROAD("Walthamstow Queen's Road",OVERGROUND),'''

        # when
        result = enum_station_generator.convert_to_enum(station)

        # then
        self.assertEqual(result, expected_result)

if __name__ == '__main__':
    unittest.main()