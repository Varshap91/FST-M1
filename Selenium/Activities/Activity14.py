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

    # Listing rows and column count
    rows = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr")
    cols = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/thead/tr/th")
    print(len(rows))
    print(len(cols))

    # cell value at the second row second column
    row2col2 = driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]")
    print(row2col2.text)

    driver.find_element(By.XPATH, "//table[@id='sortableTable']/thead/tr/th[1]").click()

    row2col2 = driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]")
    print(row2col2.text)

    # Print the cell values of the footer
    footer = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tfoot/tr/th")
    print("Cell values of the footer: ");
    for cell in footer:
        print(cell.text);

    driver.quit()

