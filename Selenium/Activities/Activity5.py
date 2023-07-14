from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Open the link in browser
    driver.get("https://www.training-support.net/selenium/input-events")

    # Print page title
    print("Page Title is: " + driver.title)

    obj = driver.find_element(By.CLASS_NAME, "active")

    actions = webdriver.ActionChains(driver)

    # Left click
    actions.click(obj).pause(20).perform()
    obj = driver.find_element(By.CLASS_NAME, "active")
    print("Text: " + obj.text)

    # Left click
    actions.double_click(obj).perform()
    obj = driver.find_element(By.CLASS_NAME, "active")
    print("Text: " + obj.text)

    # Left click
    actions.context_click(obj).perform()
    obj = driver.find_element(By.CLASS_NAME, "active")
    print("Text: " + obj.text)

    driver.quit()