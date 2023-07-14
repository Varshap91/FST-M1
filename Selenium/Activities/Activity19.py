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
    driver.get("https://training-support.net/selenium/javascript-alerts")

    wait = WebDriverWait(driver, 10)

    # Print page title
    print("Page Title is: " + driver.title)

    driver.find_element(By.ID, "confirm").click()
    wait.until(expected_conditions.alert_is_present())

    confirm_alert = driver.switch_to.alert

    # alert text
    print("Text in alert: " + confirm_alert.text)

    # Tap on OK
    confirm_alert.accept()
    print("OK button tapped")

    # Tap on Cancel
    driver.find_element(By.ID, "confirm").click()
    wait.until(expected_conditions.alert_is_present())
    confirm_alert.dismiss()
    print("Cancel button tapped")

    driver.quit();
