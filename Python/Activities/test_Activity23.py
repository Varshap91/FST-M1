import pytest


@pytest.fixture
def mylist():
    list1 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return list1


def test_arraySum(mylist):
    sum = 0
    for number in mylist:
        sum += int(number)
    assert sum == 55
