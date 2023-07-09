import pytest

def test_sum():
    num1 = 10
    num2 = 15
    assert num1 + num2 == 25

def test_diff():
    num1 = 7
    num2 = 14
    assert num2 - num1 == 7


@pytest.mark.activity
def test_product():
    num1 = 10
    num2 = 8
    assert num1 * num2 == 80

@pytest.mark.activity
def test_div():
    num1 = 25
    num2 = 5
    assert num1 / num2 == 5