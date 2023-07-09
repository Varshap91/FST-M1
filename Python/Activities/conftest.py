import pytest

@pytest.fixture
def input_value():
    input_number = 100
    return input_number

@pytest.fixture
def mylist():
    list1 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return list1
