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

    inputBox = driver.find_element(By.ID, "dynamicCheckbox")
    print(inputBox.is_displayed())

    driver.find_element(By.ID, "toggleCheckbox").click()

    inputBox = driver.find_element(By.ID, "dynamicCheckbox")
    print(inputBox.is_displayed())

    driver.quit()