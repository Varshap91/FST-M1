from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Open the link in browser
    driver.get("https://training-support.net/selenium/dynamic-controls")

    # Print page title
    print("Page Title is: " + driver.title)

    checkbox = driver.find_element(By.ID, "toggleCheckbox")
    dyncheck = driver.find_element(By.ID, "dynamicCheckbox")
    wait = WebDriverWait(driver, 10)

    checkbox.click()

    wait.until(expected_conditions.invisibility_of_element_located(dyncheck))
    print(checkbox.is_displayed())

    checkbox.click()
    print("Checkbox visible")
    dyncheck.click()
    print("Checkbox selected")

    driver.quit()

