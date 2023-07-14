from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Open the link in browser
    driver.get("https://training-support.net/selenium/dynamic-controls")

    # Print page title
    print("Page Title is: " + driver.title)

    # Validate if checkbox is selected
    checkBox = driver.find_element(By.XPATH, "//input[@type='checkbox']")
    print(checkBox.is_selected())

    # select the checkbox
    checkBox.click();

    # Validate if checkbox is selected
    checkBox = driver.find_element(By.XPATH, "//input[@type='checkbox']")
    print(checkBox.is_selected())

    driver.quit();