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

    # check if input field is enabled
    text = driver.find_element(By.ID, "input-text")
    print(text.is_enabled())

    # Tap on enable input button
    driver.find_element(By.ID, "toggleInput").click()

    # check if input field is enabled
    text = driver.find_element(By.ID, "input-text")
    print(text.is_enabled())

    driver.quit()