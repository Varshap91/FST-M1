from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Open the link in browser
    driver.get("https://training-support.net/selenium/tables")

    # Print page title
    print("Page Title is: " + driver.title)

    # number of rows and columns
    cols = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[1]/td")
    print(len(cols))

    rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr")
    print(len(rows))

    # cell values in the third row of the table
    thirdRow = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[3]/td")
    print("Third row cell values: ")
    for row in thirdRow:
        print(row.text)

    # cell value at the second row second column
    secondRow = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]")
    print("second row second column value: ")
    for row in secondRow:
        print(row.text)

    driver.quit()
